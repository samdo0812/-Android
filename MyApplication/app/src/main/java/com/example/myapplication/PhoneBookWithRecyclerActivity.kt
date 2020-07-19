package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_phone_book_with_recycler.*

class PhoneBookWithRecyclerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_book_with_recycler)


        val phoneBook = createFakePhoneBook(faskeNumber = 30)
        val phoneBookRecyclerAdapter = PhoneBookRecyclerAdapter(phoneBook, LayoutInflater.from(this))
        phonebook_recycler_view.adapter = phoneBookRecyclerAdapter
        phonebook_recycler_view.layoutManager = LinearLayoutManager(this)

    }
    fun createFakePhoneBook(faskeNumber: Int = 10, phoneBook: PhoneBook = PhoneBook()): PhoneBook {
        for (i in 0 until faskeNumber) {
            phoneBook.addPerson(
                Person(name = "" + i + "번째 사람", number = "" + i + "번째 사람의 전화 번호")
            )
        }
        return phoneBook
    }
}

class PhoneBookRecyclerAdapter(
    val phonebookList : PhoneBook,
    val inflater: LayoutInflater
): RecyclerView.Adapter<PhoneBookRecyclerAdapter.ViewHolder>(){

    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val personName : TextView
        init {
            personName = itemView.findViewById(R.id.person_name)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.phonebook_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return phonebookList.personList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.personName.setText(phonebookList.personList.get(position).name)
    }

}