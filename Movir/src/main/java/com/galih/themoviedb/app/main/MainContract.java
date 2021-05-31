package com.galih.themoviedb.app.main;

import com.galih.themoviedb.api.model.Images;
import com.galih.themoviedb.api.model.Movie;

import java.util.List;

/**
 * Created by galih  .
 */

public interface MainContract {

    interface View {

        void showLoading(boolean isRefresh);

        void showContent(List<Movie> movies, boolean isRefresh);

        void showError();

        void onConfigurationSet(Images images);

    }

    interface Presenter {

        void start();

        void onPullToRefresh();

        void onScrollToBottom();

        void finish();

    }

}
