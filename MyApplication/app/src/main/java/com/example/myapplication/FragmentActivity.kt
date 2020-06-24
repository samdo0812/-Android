package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_fragment.*

class FragmentActivity : AppCompatActivity(), FragmentOne.onDataPassListener {

    override fun onDataPass(data: String?) {
        Log.d("pass", "fragment -> activity 데이터 전달 ; "+data)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        Log.d("life_cycle","onCreate")

        val fragmentOne : FragmentOne = FragmentOne()

        // 프라그먼트에 data를 넣어주는 방법
        val bundle: Bundle = Bundle()
        bundle.putString("hello", "fragment에서 Activity로 데이터 보낸다")
        fragmentOne.arguments = bundle


        button.setOnClickListener {
            //fragment를 동적으로 작동하는 방법
            //fragment를 붙히는 방법 replace/add
            //val fragmentOne : FragmentOne = FragmentOne() -> buttion2.setOnClickLinstener에서도 프래그먼트 객체를 또 생성 하지말고 16줄로 한개 객체를 참
            val fragmentManager : FragmentManager = supportFragmentManager
            //Transaction
            //작업의 단위 -> 시작과 끝이 있다
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.container, fragmentOne)
            fragmentTransaction.commit()

            //끝을내는 방법
            //commit -> 시간 될 때 해 (좀 더 안정적임)
            //commitnow -> 지금 당장해
        }

        button2.setOnClickListener {
            // 프라그먼트 remove/detach 하는 방법
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.remove(fragmentOne)
            fragmentTransaction.commit()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("life_cycle","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("life_cycle","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("life_cycle","onPause")
    }

    override fun onStop() {
        Log.d("life_cycle","onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d("life_cycle","onDestroy")
        super.onDestroy()
    }


}
