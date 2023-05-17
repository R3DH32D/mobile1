package com.example.myapplication;

import android.app.Application;
import android.os.Bundle;

import okhttp3.OkHttpClient;

public class App extends Application {
    public static OkHttpClient clientApplication = new OkHttpClient();

    @Override
    public void onCreate() {
        super.onCreate();


    }


    public static void setClientApplication (OkHttpClient clientApplication){
        App.clientApplication = clientApplication;
    }



    public static OkHttpClient getClient () {
        return clientApplication;
    }



}
