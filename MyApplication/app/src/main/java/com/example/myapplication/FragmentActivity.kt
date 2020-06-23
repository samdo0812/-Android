package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_fragment.*

class FragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        Log.d("life_cycle","onCreate")



        button.setOnClickListener {
            //fragment를 동적으로 작동하는 방법
            val fragmentOne : FragmentOne = FragmentOne()
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
