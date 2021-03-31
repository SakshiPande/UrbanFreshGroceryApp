package com.hutech.grocery.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hutech.grocery.R
import com.hutech.grocery.setImage
import kotlinx.android.synthetic.main.layout_common_horizontal_view.view.*

class RecylerviewAdapter(val context:Context,val isNewArrival:Boolean): RecyclerView.Adapter<RecylerviewAdapter.RecylerViewHolder>() {

    private val vegetableImages= listOf<Int>(R.drawable.brinjal,R.drawable.lady_finger,R.drawable.potato,R.drawable.tomato,R.drawable.capcicum)
    private val vegetables= listOf<String>("Brinjal","Lady Finger","Potato","Tomato","Capcicum")

    private val vegetableImagesNew= listOf<Int>(R.drawable.potato,R.drawable.tomato,R.drawable.capcicum,R.drawable.brinjal,R.drawable.lady_finger)
    private val vegetablesNew= listOf<String>("Potato","Tomato","Capcicum","Brinjal","Lady Finger")

    class RecylerViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

        fun onBind(vegetable:String,vegetableImage:Int){
            itemView.tv_veg_name.setText(vegetable)
            itemView.iv_veg.setImageResource(vegetableImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecylerViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.layout_common_horizontal_view, parent, false)
        return RecylerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return vegetableImages.size
    }

    override fun onBindViewHolder(holder: RecylerViewHolder, position: Int) {
        if(isNewArrival)
            holder.onBind(vegetablesNew[position],vegetableImagesNew[position])
        else
            holder.onBind(vegetables[position],vegetableImages[position])



    }

}