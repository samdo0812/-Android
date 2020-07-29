package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class fragment1: Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.d("life_cycle","F onCreateView")
        //fragment가 인터페이스를 처음으로 그릴 때 호출된다
        //inflater ->  뷰를 그려주는 애
        //container -> 부모뷰(내가, 프래그먼트가 붙을 곳)
        return inflater.inflate(R.layout.fragment_one, container, false)

        //return super.onCreateView(inflater, container, savedInstanceState)
    }

}