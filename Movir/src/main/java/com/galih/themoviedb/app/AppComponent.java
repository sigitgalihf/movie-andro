package com.galih.themoviedb.app;

import android.app.Application;

import com.galih.themoviedb.api.ApiModule;
import com.galih.themoviedb.api.ApiService;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by galih  .
 */

@Singleton
@Component(
        modules = {
                AppModule.class,
                ApiModule.class
        }
)
public interface AppComponent {

    Application application();

    ApiService apiService();

    void inject(App app);

}

