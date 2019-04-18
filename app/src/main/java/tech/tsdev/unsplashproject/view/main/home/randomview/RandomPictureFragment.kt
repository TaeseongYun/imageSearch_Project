package tech.tsdev.unsplashproject.view.main.home.randomview

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import tech.tsdev.unsplashproject.R
import tech.tsdev.unsplashproject.view.main.home.randomview.presenter.RandomPictureContract

class RandomPictureFragment : Fragment(), RandomPictureContract.View {
    override fun showProgressbar() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun dismissProgressbar() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showErrorMessage() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showErrorMessage(message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showBottomSheet(photoId: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
            = inflater.inflate(R.layout.fragment_picture, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}