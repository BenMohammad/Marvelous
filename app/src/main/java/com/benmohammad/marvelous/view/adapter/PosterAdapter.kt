package com.benmohammad.marvelous.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.benmohammad.marvelous.R
import com.benmohammad.marvelous.databinding.ItemPosterBinding
import com.benmohammad.marvelous.model.Poster
import com.benmohammad.marvelous.view.ui.details.PosterDetailActivity

class PosterAdapter : RecyclerView.Adapter<PosterAdapter.PosterViewHolder>() {

    private val items = mutableListOf<Poster>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PosterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemPosterBinding>(
            inflater, R.layout.item_poster, parent, false)
        return PosterViewHolder(binding)
    }

    override fun getItemCount(): Int  = items.size

    fun updatePosterList(posters: List<Poster>) {
        items.clear()
        items.addAll(posters)
        notifyDataSetChanged()

    }
    override fun onBindViewHolder(holder: PosterViewHolder, position: Int) {
        val item = items[position]
        holder.binding.apply {
            poster = item
            veil = itemVeilLayout
            executePendingBindings()
            root.setOnClickListener{
                PosterDetailActivity.startActivity(it.context, transformationLayout, item)
            }
        }
    }

    fun getPoster(index: Int): Poster = items[index]

    class PosterViewHolder(val binding: ItemPosterBinding) : RecyclerView.ViewHolder(binding.root)
}