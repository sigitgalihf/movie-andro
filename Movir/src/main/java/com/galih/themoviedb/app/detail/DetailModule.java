package com.galih.themoviedb.app.detail;

import com.galih.themoviedb.app.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by galih  .
 */

@Module
public class DetailModule {
    private final DetailContract.View DetailView;

    DetailModule(DetailContract.View DetailView) {
        this.DetailView = DetailView;
    }

    @Provides
    @ActivityScope
    DetailContract.View provideDetailView() {
        return DetailView;
    }

}

