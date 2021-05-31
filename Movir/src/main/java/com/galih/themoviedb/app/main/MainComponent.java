package com.galih.themoviedb.app.main;

import com.galih.themoviedb.app.ActivityScope;
import com.galih.themoviedb.app.AppComponent;

import dagger.Component;

/**
 * Created by galih  .
 */

@ActivityScope
@Component(
        dependencies = AppComponent.class,
        modules = MainModule.class
)
interface MainComponent {

    void inject (MainActivity mainActivity);

}

