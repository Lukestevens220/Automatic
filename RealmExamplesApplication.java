package com.example.luke.myproject;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by TheAppExperts on 10/10/2016.
 */

public class RealmExamplesApplication extends Application {
    @Override
    public void onCreate(){
        super.onCreate();

        //Configurure Realm for the application
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this)
                .name(Realm.DEFAULT_REALM_NAME)
                .schemaVersion(0)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);


    }
}
