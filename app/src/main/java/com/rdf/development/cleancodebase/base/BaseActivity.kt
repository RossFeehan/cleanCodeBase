package com.rdf.development.cleancodebase.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.android.AndroidInjection


class BaseActivity: AppCompatActivity(), BaseContract.BaseView {

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun displayLoading(loadingMessageId: Int) {
       //TODO DISPLAY LOADING THROUGHOUT THE APP HERE
    }

    override fun hideLoading() {
        //TODO HIDE LOADING THROUGHOUT THE APP HERE
    }

    override fun displayNoInternetConnectionMessage() {
        //TODO DISPLAY NO INTERNET MESSAGE THROUGHOUT THE APP HERE
    }

    override fun displayErrorMessage(errorMessage: String) {
        //TODO DISPLAY ERROR MESSAGE THROUGHOUT THE APP HERE
    }

    override fun displayErrorMessage(errorMessageId: Int) {
        //TODO DISPLAY ERROR MESSAGE THROUGHOUT THE APP HERE
    }
}