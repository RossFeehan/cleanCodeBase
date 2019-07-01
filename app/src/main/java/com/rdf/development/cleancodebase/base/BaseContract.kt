package com.rdf.development.cleancodebase.base

import io.reactivex.disposables.CompositeDisposable


interface BaseContract {

    interface BaseView {
        /**
         * Add specific handling of displaying a loading progress and message to the user
         * @param loadingMessageId the message to display to the user to explain what the app is loading
         */
        fun displayLoading(loadingMessageId: Int)

        /**
         * Add specific handling of hiding a loading progress and message to the user
         */
        fun hideLoading()

        /**
         * Add specific handling of displaying a message to the user regarding no internet connection
         */
        fun displayNoInternetConnectionMessage()

        /**
         * Add specific handling of displaying an error message to the user
         * @param errorMessage the error message of type String to display to the user
         */
        fun displayErrorMessage(errorMessage: String)

        /**
         * Add specific handling of displaying an error message to the user
         * @param errorMessageId the error message of type Int to display to the user
         */
        fun displayErrorMessage(errorMessageId: Int)
    }

    interface BasePresenter<V> {

        var view: V?
        var compositeDisposable: CompositeDisposable?

        /**
         * Binds presenter with a view when resumed. The Presenter will perform initialization here.
         * @param view the view associated with this presenter
         */
        fun takeView(view: V) {
            if (this.view != null) {
                throw IllegalStateException("Presenter already has the view or the dropView isn't called")
            }

            if (this.compositeDisposable != null) {
                throw IllegalStateException("Presenter already allocated a CompositeDisposable. This is probably leaking.")
            }

            compositeDisposable = CompositeDisposable()
            this.view = view
            onTakeView()

        }

        /**
         * Drops the reference to the view when destroyed
         */
        fun dropView() {
            view = null
            compositeDisposable?.dispose()
            compositeDisposable = null
            onDropView()
        }

        /**
         * Override this to add specific handling when taking a view
         */
        fun onTakeView() {}

        /**
         * Override this to add specific handling when dropping a view
         */
        fun onDropView() {}
    }
}
