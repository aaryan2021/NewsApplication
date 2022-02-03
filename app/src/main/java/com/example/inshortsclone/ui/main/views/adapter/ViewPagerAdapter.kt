package com.example.inshortsclone.ui.main.views.adapter

import android.content.Context
import android.view.View
import androidx.viewpager.widget.PagerAdapter
import com.example.inshortsclone.data.model.latestModel.News
import android.widget.LinearLayout
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.inshortsclone.R
import kotlinx.android.synthetic.main.item_container.view.*


class ViewPagerAdapter(var context:Context,var data:List<News>):PagerAdapter() {
    override fun getCount()= data?.size

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as LinearLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var binding: View = inflater.inflate(R.layout.item_container, null)
        binding.title.setText(data.get(position).title)
        if(data.get(position).description!=null)
            binding.description.setText(data.get(position).description.toString())
        Glide.with(context!!)
            .load(data!!.get(position).image_url)
            .placeholder(R.drawable.mark)
            .into(binding.action_image);
        container.addView(binding);
        return binding
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as LinearLayout)
    }


}