package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import kotlinx.android.synthetic.main.activity_tab_pager.*

class  TabPagerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_pager)

        tab_layout.addTab(tab_layout.newTab().setText("one"))
        tab_layout.addTab(tab_layout.newTab().setText("two"))
        tab_layout.addTab(tab_layout.newTab().setText("three"))
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
