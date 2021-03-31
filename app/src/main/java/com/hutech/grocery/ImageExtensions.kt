package com.hutech.grocery

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.target.Target
import com.bumptech.glide.request.transition.Transition


/** Loads an image into the ImageView **/

fun ImageView.setImage(
    imageUrl: String,
    scaleType: ScaleType = ScaleType.FIT_CENTER,

    onSuccess: (drawable: Drawable) -> Unit = {},
    onFailure: () -> Unit = {}

) {

    if (imageUrl.isEmpty()) {
        onFailure()
        return
    }

    Glide.with(context)
        .load(imageUrl)
        .centerInside()
        .apply(
            when (scaleType) {
                ScaleType.FIT_CENTER -> RequestOptions.fitCenterTransform()
                ScaleType.CENTER_CROP -> RequestOptions.centerCropTransform()
            }
        )

        .addListener(object : RequestListener<Drawable> {

            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean
            ) = true

            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: Target<Drawable>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                resource?.let { onSuccess(it) }
                return false
            }

        })
        .into(this)
}

fun Context.getBitmapDrawable(imageUrl: String, onSuccess: (drawable: Bitmap) -> Unit = {}) {
    Glide.with(this)
        .asBitmap()
        .load(imageUrl)
        .into(object : CustomTarget<Bitmap>() {

            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                onSuccess(resource)
            }

            override fun onLoadCleared(placeholder: Drawable?) {
                // NO-OP
            }
        })
}


enum class ScaleType {
    CENTER_CROP,
    FIT_CENTER

}
