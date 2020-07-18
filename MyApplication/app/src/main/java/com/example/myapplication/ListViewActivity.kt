package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
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

        listVIew.setOnItemClickListener{
                parent, view, posion, id ->
            val carName = (adapter.getItem(posion) as CarForList).name
            val carEngine = (adapter.getItem(posion) as CarForList).engine

            Toast.makeText(this,carName+""+carEngine,Toast.LENGTH_SHORT).show()
        }

    }
}

class ListViewAdapter(val carForList: ArrayList<CarForList>, val layoutInflater: LayoutInflater ) : BaseAdapter(){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        //val layoutInflater =  LayoutInflater.from(layoutInflater)
        val view: View
        val holder: viewHolder

        if(convertView == null){
            view = layoutInflater.inflate(R.layout.item_view,null)
            holder = viewHolder()

            holder.carName = view.findViewById(R.id.car_name)
            holder.carEngine = view.findViewById(R.id.car_engine)

            view.tag = holder
        }
        else{
            holder = convertView.tag as viewHolder
            view = convertView
        }

        holder.carName?.setText(carForList.get(position).name)
        holder.carEngine?.setText(carForList.get(position).engine)

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

class viewHolder{
    var carName:TextView? = null
    var carEngine:TextView? = null
}
