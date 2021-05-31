package com.galih.themoviedb.app.detail;

import com.galih.themoviedb.app.ActivityScope;
import com.galih.themoviedb.app.AppComponent;

import dagger.Component;

/**
 * Created by galih  .
 */

@ActivityScope
@Component(
        dependencies = AppComponent.class,
        modules = DetailModule.class
)
interface DetailComponent {

    void inject(DetailActivity DetailActivity);

}

