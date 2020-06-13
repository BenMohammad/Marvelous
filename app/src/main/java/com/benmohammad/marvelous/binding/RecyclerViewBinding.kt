package com.benmohammad.marvelous.binding

import android.graphics.Color
import android.view.View
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.benmohammad.marvelous.extensions.circularRevealedAtCenter
import com.benmohammad.marvelous.model.Poster
import com.benmohammad.marvelous.model.PosterDetails
import com.benmohammad.marvelous.view.adapter.PosterAdapter
import com.benmohammad.marvelous.view.adapter.PosterSeriesAdapter
import com.skydoves.whatif.whatIfNotNull
import com.skydoves.whatif.whatIfNotNullOrEmpty
import com.yarolegovich.discretescrollview.DiscreteScrollView
import com.yarolegovich.discretescrollview.transform.ScaleTransformer

@BindingAdapter("adapter")
fun bindAdapter(view: RecyclerView, baseAdapter: RecyclerView.Adapter<*>) {
    view.adapter = baseAdapter
}

@BindingAdapter("toast")
fun bindToast(view: RecyclerView, text: LiveData<String>) {
    text.value.whatIfNotNull {
        Toast.makeText(view.context, it, Toast.LENGTH_SHORT).show()
    }
}

@BindingAdapter("adapterPosterList")
fun bindAdapterPosterList(view: DiscreteScrollView, posters: List<Poster>?) {
    posters.whatIfNotNullOrEmpty {
        (view.adapter as? PosterAdapter)?.updatePosterList(it)
    }
    view.setItemTransformer(ScaleTransformer.Builder()
        .setMaxScale(1.25f)
        .setMinScale(0.8f)
        .build())
}

@BindingAdapter("bindOnItemChanged", "bindOnItemChangedBackground")
fun bindOnItemChanged(view: DiscreteScrollView, adapter: PosterAdapter, pointView: View) {
    view.addOnItemChangedListener{
        viewHolder, _ -> viewHolder?.adapterPosition.whatIfNotNull {
        pointView.circularRevealedAtCenter(Color.parseColor(adapter.getPoster(it).color))
    }
    }
}

@BindingAdapter("adapterPosterSeries", "adapterPosterDetailsList")
fun bindAdapterPosterDetailsList(
    view: RecyclerView,
    adapter: PosterSeriesAdapter,
    posters: List<PosterDetails>?
) {
    posters.whatIfNotNullOrEmpty {
        view.adapter = adapter.apply { updatePosterDetailsList(it) }
    }
}