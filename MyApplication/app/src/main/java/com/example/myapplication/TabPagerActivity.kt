package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_tab_pager.*

class  TabPagerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_pager)

        tab_layout.addTab(tab_layout.newTab().setText("one"))
        tab_layout.addTab(tab_layout.newTab().setText("two"))
        tab_layout.addTab(tab_layout.newTab().setText("three"))
        
        val pagerAdapter = PagerAdapter(supportFragmentManager,3)
        view_pager.adapter = pagerAdapter

        tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                view_pager.currentItem = tab!!.position
            }
        })
        //페이저가 이동했을 때 탭을 이동시킴
        view_pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))

    }
}

class PagerAdapter(fragmentManager: FragmentManager, val tabCount: Int):FragmentStatePagerAdapter(fragmentManager){

    override fun getItem(position: Int): Fragment {
        when(position){
            0 -> {
                return fragment1()
            }
            1 -> {
                return fragment2()
            }
            2 -> {
                return fragment3()
            }
            else -> return fragment1()
        }
    }
    override fun getCount(): Int {
        return tabCount
    }
}
