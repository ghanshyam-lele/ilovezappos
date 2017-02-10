package com.ghanshyam.ilovezappos.services;

import com.ghanshyam.ilovezappos.models.APIResponse;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by GHANSHYAM on 06-Feb-17.
 */

public interface Zappos
{
    @GET("/Search?")
    Observable<APIResponse> getResults(@Query("term") final String term, @Query("key") final String key);


    /*@GET("/Search?={term}")
    Observable<Result[]> getResults(@Query("term") final String term,@Query("key") final String key);*/
}
