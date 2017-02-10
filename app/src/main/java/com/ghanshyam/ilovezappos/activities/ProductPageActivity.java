package com.ghanshyam.ilovezappos.activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ghanshyam.ilovezappos.R;
import com.ghanshyam.ilovezappos.adapters.ProductAdapter;
import com.ghanshyam.ilovezappos.global.GlobalData;
import com.ghanshyam.ilovezappos.models.Result;
import com.ghanshyam.ilovezappos.presenters.ProductPagePresenter;
import com.ghanshyam.ilovezappos.views.ListingsView;

import org.w3c.dom.Text;

public class ProductPageActivity extends AppCompatActivity implements ListingsView<Result>
{
    TextView cartBadge;
    ProductPagePresenter presenter;
    ProductAdapter adapter;
    String query;
    ProgressBar progressBar;

    int cartsize;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        presenter=ProductPagePresenter.create(this);
        progressBar= (ProgressBar) findViewById(R.id.progressBar);
        adapter = new ProductAdapter(findViewById(R.id.progressBar));
        query=getIntent().getStringExtra("query");
        final RecyclerView recycler= (RecyclerView) findViewById(R.id.results);
        recycler.setAdapter(this.adapter);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        this.presenter.getProducts(query);
        cartsize=0;

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(GlobalData.isResponseOkay()) {
                    fab.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_done));
                    GlobalData.updateCart();
                    cartBadge.setText(GlobalData.getGlobalCartSize() + "");
                    Snackbar.make(view, "Item added to cart!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
                //GlobalData.updateCart();

            }
        });
    }

    public void openBrowser(View v)
    {
        Intent i= new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(v.getTag()+""));
        startActivity(i);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);


        MenuItem item=menu.findItem(R.id.action_cart);

        MenuItemCompat.setActionView(item,R.layout.badge_layout);
        RelativeLayout badgeLayout= (RelativeLayout) menu.findItem(R.id.action_cart).getActionView();
        cartBadge= (TextView) badgeLayout.findViewById(R.id.actionbar_notifcation_textview);
       // ((TextView)((Activity)GlobalData.getContext()).findViewById(R.id.actionbar_notifcation_textview)).setText(GlobalData.getGlobalCartSize()+"");
        //GlobalData.setCartBadge(cartBadge);
        //GlobalData.updateCart();
        cartBadge.setText(GlobalData.getGlobalCartSize()+"");
        return true;
    }

    @Override
    public void addItem(Result item)
    {
        this.adapter.addItem(item);
    }

    @Override
    public void addItems(Result[] items)
    {
        this.adapter.addItems(items);
        Log.d("data",items[0].getBrandName());
    }

    @Override
    public void clearItems()
    {
        this.adapter.clearItems();
    }
}
