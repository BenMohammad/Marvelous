package com.benmohammad.marvelous

import android.os.Bundle
import com.benmohammad.marvelous.base.DatabindingActivity
import com.benmohammad.marvelous.databinding.ActivityMainBinding
import com.benmohammad.marvelous.view.adapter.PosterAdapter
import com.benmohammad.marvelous.view.ui.main.MainViewModel
import com.skydoves.transformationlayout.onTransformationStartContainer
import org.koin.android.viewmodel.ext.android.getViewModel


class MainActivity : DatabindingActivity(){

    private val binding: ActivityMainBinding by binding(R.layout.activity_main)

    override fun onCreate(savedInstanceState: Bundle?) {
        onTransformationStartContainer()
        super.onCreate(savedInstanceState)
        binding.apply {
            lifecycleOwner = this@MainActivity
            vm = getViewModel<MainViewModel>().apply { fetchMarvelPosterList() }
            adapter = PosterAdapter()
        }
    }
}
