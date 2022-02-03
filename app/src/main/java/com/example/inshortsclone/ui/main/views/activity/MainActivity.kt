package com.example.inshortsclone.ui.main.views.activity

import android.os.Bundle
import androidx.activity.viewModels
import com.example.inshortsclone.R
import com.example.inshortsclone.data.network.Status
import com.example.inshortsclone.ui.base.BaseActivity
import com.example.inshortsclone.ui.main.viewmodel.NewsViewModel
import com.example.inshortsclone.ui.main.views.adapter.ViewPagerAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*


@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private val viewModel by viewModels<NewsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fetchLatestNews()
    }

    /*-----------FETCHING DATA FROM DATA SOURCE------------*/
    private fun fetchLatestNews(){
        viewModel.getLatestNews().observe(this,
            {
                it?.let {
                        resource ->
                    when(resource.status){
                        Status.Success->{
                            it.data?.let {
                                    it1 -> vertical_only.setAdapter(ViewPagerAdapter(this@MainActivity, it1.results))
                            }
                            progress?.dismissSweet()

                        }
                        Status.Failure->{
                            progress?.dismissSweet()
                            it.message?.let { it1 -> alert?.showError(it1) }
                        }
                        Status.Loading->{
                            progress?.showSweetDialog()
                        }
                    }
                }
            })

    }
}