package com.example.inshortsclone.ui.main.views.adapter

import android.content.Context
import android.view.View
import androidx.viewpager.widget.PagerAdapter
import com.example.inshortsclone.data.model.latestModel.Result
import android.widget.LinearLayout
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.inshortsclone.R


class ViewPagerAdapter(var context:Context,var data:List<Result>):PagerAdapter() {
    override fun getCount(): Int {
        return data!!.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as LinearLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var inflater =
            context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var view: View = inflater.inflate(R.layout.item_container, null)
        var image = view.findViewById<View>(R.id.action_image) as ImageView
        var title=view.findViewById<View>(R.id.title) as TextView
        var desc=view.findViewById<View>(R.id.description) as TextView
        title.setText(data.get(position).title)
        if(data.get(position).description!=null)
        desc.setText(data.get(position).description.toString())
        Glide.with(context!!)
            .load(data!!.get(position).image_url)
            .placeholder(R.drawable.mark)
            .into(image);
        container.addView(view);
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as LinearLayout)
    }


}