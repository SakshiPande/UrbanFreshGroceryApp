package com.hutech.grocery.ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.hutech.grocery.R
import com.hutech.grocery.models.Banner
import com.hutech.grocery.viewmodels.DashboardViewModel
import kotlinx.android.synthetic.main.activity_dashboard.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class DashboardActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        setUpBottomNav()

    }



    private fun setUpBottomNav() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.dashboardNavHost) as NavHostFragment
        bottomNav.selectedItemId=R.id.explore
        bottomNav.setupWithNavController(navHostFragment.findNavController())


        }

}