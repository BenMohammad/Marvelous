package com.benmohammad.marvelous.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.benmohammad.marvelous.R
import com.benmohammad.marvelous.databinding.ItemPosterBinding
import com.benmohammad.marvelous.databinding.ItemPosterSeriesBinding
import com.benmohammad.marvelous.databinding.LayoutPlotBinding
import com.benmohammad.marvelous.model.PosterDetails

class PosterSeriesAdapter(
    private val layoutPLotBinding: LayoutPlotBinding
): RecyclerView.Adapter<PosterSeriesAdapter.PosterSeriesViewHolder>() {

    private val items = mutableListOf<PosterDetails>()
    private var selectable = true



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PosterSeriesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemPosterSeriesBinding>(inflater, R.layout.item_poster_series, parent, false)
        return PosterSeriesViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    fun updatePosterDetailsList(posterDetails: List<PosterDetails>) {
        items.clear()
        items.addAll(posterDetails)
        notifyDataSetChanged()

    }
    override fun onBindViewHolder(holder: PosterSeriesViewHolder, position: Int) {
        val item = items[position]
        holder.binding.apply {
            details = item
            executePendingBindings()
            root.setOnClickListener {
                if(selectable) {
                    selectable = false
                    layoutPLotBinding.details = item
                    layoutPLotBinding.root.setOnClickListener {
                        holder.binding.transformationLayout.finishTransform()
                        selectable = true
                    }
                    layoutPLotBinding.executePendingBindings()
                    holder.binding.transformationLayout.bindTargetView(layoutPLotBinding.root)
                    holder.binding.transformationLayout.startTransform()

                }            }
        }
    }

    class PosterSeriesViewHolder(val binding: ItemPosterSeriesBinding) : RecyclerView.ViewHolder(binding.root)
}