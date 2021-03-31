package com.hutech.grocery.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hutech.grocery.BASE_URL
import com.hutech.grocery.R
import com.hutech.grocery.models.CategoryData
import com.hutech.grocery.setImage
import kotlinx.android.synthetic.main.layout_category.view.*
import kotlinx.android.synthetic.main.layout_common_horizontal_view.view.*

class CategoryAdapter(val context:Context): RecyclerView.Adapter<CategoryAdapter.CategoryViewholder>() {


   private var categoryList:List<CategoryData>?= arrayListOf()

    class CategoryViewholder(itemView:View):RecyclerView.ViewHolder(itemView){

        fun onBind(categoryData: CategoryData){
            itemView.tv_category_name.setText(categoryData.category_name)
            itemView.iv_category.setImage(BASE_URL+categoryData.category_picture)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewholder {
        val view = LayoutInflater.from(context).inflate(R.layout.layout_category, parent, false)
        return CategoryViewholder(view)
    }

    override fun getItemCount(): Int {
        return categoryList!!.size
    }

    override fun onBindViewHolder(holder: CategoryViewholder, position: Int) {
         holder.onBind(categoryList!![position])
    }

    fun setCategoryDataList(categoryData: List<CategoryData>) {
        this.categoryList=categoryData
        notifyDataSetChanged()

    }

}