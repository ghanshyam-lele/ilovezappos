package com.ghanshyam.ilovezappos.presenters;

import android.util.Log;
import android.widget.Toast;

import com.ghanshyam.ilovezappos.global.GlobalData;
import com.ghanshyam.ilovezappos.models.APIResponse;
import com.ghanshyam.ilovezappos.models.Result;
import com.ghanshyam.ilovezappos.services.Zappos;
import com.ghanshyam.ilovezappos.views.ListingsView;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by GHANSHYAM on 06-Feb-17.
 */

public class ProductPagePresenter implements Observer<APIResponse>
{
    private static final String ZAPPOS_API = "https://api.zappos.com/";
    private static final String API_KEY = "b743e26728e16b81da139182bb2094357c31d331";

    private final Zappos service;
    private final ListingsView<Result> view;

    public ProductPagePresenter(Zappos service, ListingsView<Result> view) {
        this.service = service;
        this.view = view;
    }

    public static ProductPagePresenter create(final ListingsView<Result> view)
    {
        final Zappos service= ProductPagePresenter.getRetrofit().create(Zappos.class);
        return new ProductPagePresenter(service,view);
    }

    private static Retrofit getRetrofit() {
        return new Retrofit.Builder()

                .baseUrl(ZAPPOS_API)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public void getProducts(final String user) {
        this.service.getResults(user,API_KEY)/*.enqueue(new Callback<APIResponse>() {
            @Override
            public void onResponse(Call<APIResponse> call, Response<APIResponse> response)
            {
                int statusCode=response.code();
                APIResponse APIResponse = response.body();
                Log.d("APIResponse", APIResponse.getResults().get(0).getBrandName());
            }

            @Override
            public void onFailure(Call<APIResponse> call, Throwable t) {

            }
        });*/
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this);
    }
    @Override
    public void onSubscribe(Disposable d) {
        
    }

    @Override
    public void onNext(APIResponse value)
    {
        this.view.clearItems();

       // this.view.addItems(value.getResults().toArray(new Result[value.getResults().size()]));
        if(value.getResults().size()>0) {
            GlobalData.setResponseOkay(true);
            this.view.addItem(value.getResults().get(0));
        }
        else {
            GlobalData.setResponseOkay(false);
            Toast.makeText(GlobalData.getContext(), "Something went wrong!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onError(Throwable e)
    {
        Log.d("error",e.getMessage());
    }

    @Override
    public void onComplete() {

    }
}
