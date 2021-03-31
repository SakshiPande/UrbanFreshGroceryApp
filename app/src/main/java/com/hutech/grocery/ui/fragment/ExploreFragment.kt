package com.hutech.grocery.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hutech.grocery.BASE_URL
import com.hutech.grocery.R
import com.hutech.grocery.ScaleType
import com.hutech.grocery.models.Banner
import com.hutech.grocery.models.CategoryData
import com.hutech.grocery.setImage
import com.hutech.grocery.ui.adapters.CategoryAdapter
import com.hutech.grocery.ui.adapters.RecylerviewAdapter
import com.hutech.grocery.viewmodels.DashboardViewModel
import kotlinx.android.synthetic.main.fragment_explore.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class ExploreFragment : Fragment() {

    private val dashboardViewModel: DashboardViewModel by viewModel()
    private var recylerviewAdapter:RecylerviewAdapter?=null
    private var categoryAdapter:CategoryAdapter?=null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_explore, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dashboardViewModel.getCategories()
        setObservers()
        setRecylerView()


    }
    private fun setRecylerView() {
        val layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        recylerviewAdapter = RecylerviewAdapter(requireContext(),false)
        rv_daily_needs.layoutManager = layoutManager
        rv_daily_needs.adapter = recylerviewAdapter

        val layoutManagerNewArrival = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        recylerviewAdapter = RecylerviewAdapter(requireContext(),true)
        rv_new_arrivals.layoutManager = layoutManagerNewArrival
        rv_new_arrivals.adapter = recylerviewAdapter

        val categoryLayoutManager = GridLayoutManager(requireContext(),3)
        categoryAdapter = CategoryAdapter(requireContext())
        rv_categories.layoutManager = categoryLayoutManager
        rv_categories.adapter = categoryAdapter


    }
    private fun setObservers() {
        dashboardViewModel.getCategories().observe(viewLifecycleOwner, Observer {
            if(it.success) {
                it.let {
                    if (it.components[0].name.equals("StaticBanner", true)) {
                        setStaticBanner(it.components[0].staticBanner[0])
                    }
                    if (it.components[2].name.equals("AdsBanner", true)) {
                        setAdsBanner((it.components[2].adsBanner[0]))
                    }
                    if (it.components[1].name.equals("MainCategories", true)) {

                          categoryAdapter?.setCategoryDataList(it.components[1].categoryData)
                    }

                }
            }
        })


    }

    private fun setAdsBanner(adsBanner: Banner) {

        iv_ads_banner.setImage(BASE_URL+adsBanner.banner_image)

    }

    private fun setStaticBanner(banner: Banner) {
        iv_static_banner.setImage(BASE_URL+banner.banner_image)
        iv_static_banner2.setImage(BASE_URL+banner.banner_image)


    }


}