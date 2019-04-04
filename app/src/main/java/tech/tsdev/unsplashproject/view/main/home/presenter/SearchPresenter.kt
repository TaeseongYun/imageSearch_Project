package tech.tsdev.unsplashproject.view.main.home.presenter

import android.os.AsyncTask
import tech.tsdev.unsplashproject.data.source.image.ImageRepository
import tech.tsdev.unsplashproject.view.main.home.adapter.model.ImageRecyclerModel

class SearchPresenter(val view: SearchContract.View,
                      private val imageRepository: ImageRepository,
                      private val imageRecyclerModel: ImageRecyclerModel) : SearchContract.Presenter {


    var isLoading = false


    override fun loadImage() {
        ImageAsyncTask(this, view, imageRepository, imageRecyclerModel).execute()
    }
    class ImageAsyncTask(
        private val searchPresenter: SearchPresenter,
        val view: SearchContract.View,
        private val imageRepository: ImageRepository,
        private val imageRecyclerModel: ImageRecyclerModel) : AsyncTask<Unit, Unit, Unit>() {
        override fun doInBackground(vararg params: Unit?) {
            imageRepository.loadImageList({
                it.forEach {
                    imageRecyclerModel.addItem(it)
                }
            },10)
            Thread.sleep(1000)
        }

        override fun onPostExecute(result: Unit?) {
            super.onPostExecute(result)

            searchPresenter.isLoading = true
            view.hideProgressbar()
        }

        override fun onPreExecute() {
            super.onPreExecute()

            searchPresenter.isLoading = false
            view.showProgressbar()
        }
    }
}