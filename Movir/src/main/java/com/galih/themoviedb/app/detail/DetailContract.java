package com.galih.themoviedb.app.detail;

import com.galih.themoviedb.api.model.Images;
import com.galih.themoviedb.api.model.Movie;

/**
 * Created by galih  .
 */

public interface DetailContract {

    interface View {

        void showLoading();

        void showContent(Movie movie);

        void showError();

        void onConfigurationSet(Images images);

    }

    interface Presenter {

        void start(int movieId);

        void finish();

    }

}
