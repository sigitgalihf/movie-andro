package com.galih.themoviedb.app.detail;

import com.galih.themoviedb.api.ApiService;
import com.galih.themoviedb.api.model.Configuration;
import com.galih.themoviedb.api.model.Images;
import com.galih.themoviedb.api.model.Movie;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by galih  .
 */

public class DetailPresenter implements DetailContract.Presenter {
    private DetailContract.View view;
    private ApiService apiService;

    private Images images;

    @Inject
    DetailPresenter(DetailContract.View view, ApiService apiService) {
        this.view = view;
        this.apiService = apiService;
    }

    @Override
    public void start(int movieId) {
        view.showLoading();

        if (images == null) {
            getConfiguration(movieId);
        } else {
            view.onConfigurationSet(images);
            getMovie(movieId);
        }
    }

    private void getConfiguration(final int movieId) {
        Call<Configuration> call = apiService.getConfiguration();
        call.enqueue(new Callback<Configuration>() {
            @Override
            public void onResponse(Call<Configuration> call, Response<Configuration> response) {
                if (response.isSuccessful()) {
                    images = response.body().images;
                    view.onConfigurationSet(images);
                    getMovie(movieId);
                }
            }

            @Override
            public void onFailure(Call<Configuration> call, Throwable t) {
            }
        });
    }

    private void getMovie(int movieId) {
        Call<Movie> call = apiService.getMovie(movieId);
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                if (response.isSuccessful()) {
                    view.showContent(response.body());
                } else {
                    view.showError();
                }
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                view.showError();
            }
        });
    }

    @Override
    public void finish() {

    }

}
