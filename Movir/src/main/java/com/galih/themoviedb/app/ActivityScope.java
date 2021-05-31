package com.galih.themoviedb.app;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by galih  .
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityScope {
}

