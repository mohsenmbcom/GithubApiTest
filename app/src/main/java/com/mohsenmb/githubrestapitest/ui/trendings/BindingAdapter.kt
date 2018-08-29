package com.mohsenmb.githubrestapitest.ui.trendings

import android.net.Uri
import android.widget.ImageView
import com.squareup.picasso.Picasso
import android.databinding.BindingAdapter

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("android:src")
    fun setImageUrl(view: ImageView, url: String) {
        Picasso
                .get()
                .load(Uri.parse(url))
                .centerCrop()
                .fit()
                .into(view)
    }

}