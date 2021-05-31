package com.galih.themoviedb.app.main;

import com.galih.themoviedb.app.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by galih  .
 */

@Module
public class MainModule {
    private final MainContract.View mainView;

    MainModule(MainContract.View mainView) {
        this.mainView = mainView;
    }

    @Provides
    @ActivityScope
    MainContract.View provideMainView() {
        return mainView;
    }

}

