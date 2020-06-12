package com.benmohammad.marvelous.view.ui.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.benmohammad.marvelous.R
import com.benmohammad.marvelous.base.DatabindingActivity
import com.benmohammad.marvelous.databinding.ActivityPosterDetailBinding
import com.benmohammad.marvelous.extensions.onTransformationEndContainerApplyParams
import com.benmohammad.marvelous.model.Poster
import com.benmohammad.marvelous.view.adapter.PosterSeriesAdapter
import com.skydoves.transformationlayout.TransformationCompat
import com.skydoves.transformationlayout.TransformationLayout
import com.skydoves.transformationlayout.onTransformationStartContainer
import org.koin.android.viewmodel.ext.android.getViewModel

class PosterDetailActivity : DatabindingActivity() {


    private val binding: ActivityPosterDetailBinding by binding (R.layout.activity_poster_detail)

    override fun onCreate(savedInstanceState: Bundle?) {
        onTransformationEndContainerApplyParams()
        super.onCreate(savedInstanceState)
        val poster = getViewModel<PosterDetailViewModel>().getPoster(intent.getLongExtra(posterId, 0))
        binding.apply {
            lifecycleOwner = this@PosterDetailActivity
            activity = this@PosterDetailActivity
            adapter = PosterSeriesAdapter(plot)
            veil = posterVeil
            this.poster = poster
        }
    }


    companion object {
        private const val posterId = "posterId"
        fun startActivity(
            context: Context,
            transformationLayout: TransformationLayout,
            poster: Poster
            ) {
            val intent = Intent(context, PosterDetailActivity::class.java)
            intent.putExtra(posterId, poster.id)
            TransformationCompat.startActivity(transformationLayout, intent)
        }
    }
}