package com.galih.themoviedb.api;

import com.galih.themoviedb.api.model.Configuration;
import com.galih.themoviedb.api.model.Movies;
import com.galih.themoviedb.api.model.Movie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by galih.
 */

public interface ApiService {

    enum SortBy {
        RELEASE_DATE_ASCENDING("release_date.asc"),
        RELEASE_DATE_DESCENDING("release_date.desc");

        String value;

        SortBy(String value) {
            this.value = value;
        }


        @Override
        public String toString() {
            return this.value;
        }
    }

    @GET("/3/discover/movie")
    Call<Movies> getMovies(@Query("primary_release_date.lte") String releaseDate,
                           @Query("sort_by") SortBy sortBy, @Query("page") int page);

    @GET("/3/movie/{id}")
    Call<Movie> getMovie(@Path("id") int id);


    @Headers("Cache-Control: public, max-stale=2419200") // 4 weeks
    @GET("/3/configuration")
    Call<Configuration> getConfiguration();

}
