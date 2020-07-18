package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        val carList = ArrayList<CarForList>()
        for (i in 0 until 10) {
            carList.add(CarForList("" + i + " 번째 자동차", "" + i + "순위 엔진"))
        }

        val adapter = ListViewAdapter(carList, LayoutInflater.from(this))
        listVIew.adapter = adapter
    }
}

class ListViewAdapter(val carForList: ArrayList<CarForList>, val layoutInflater: LayoutInflater ) : BaseAdapter(){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        //val layoutInflater =  LayoutInflater.from(layoutInflater)
        val view = layoutInflater.inflate(R.layout.item_view,null)
        val carNameTextview = view.findViewById<TextView>(R.id.car_name)
        val carEngineTextView = view.findViewById<TextView>(R.id.car_engine)

        carNameTextview.setText(carForList.get(position).name)
        carEngineTextView.setText(carForList.get(position).engine)

        return view
    }

    override fun getItem(position: Int): Any {
        //그리고자 하는 아이 리스트의 하나 (포지션에 해당하)
        return carForList.get(position)
    }

    override fun getItemId(position: Int): Long {
        //해당 포지션에 위치해있는 아이템뷰의 아이디 설정
        return position.toLong()
    }

    override fun getCount(): Int {
        //그리고자 하는 아이템 리스트의 전체 개
        return carForList.size
    }
}
