package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.model.BookEntity
import com.example.myapplication.service.implementation.BookServiceImpl
import com.example.myapplication.util.adapter.BookAdapter
import com.example.myapplication.util.other.UtilModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private var listBook: List<BookEntity> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        onInit()
    }

    private fun onInit() {
        recyclerView = findViewById(R.id.recyclerViewBooks)
        recyclerView.layoutManager = LinearLayoutManager(this)

        lifecycleScope.launch {
            listBook = BookServiceImpl.instance.list() ?: listOf()
            recyclerView.adapter = BookAdapter(listBook)
        }
    }


    fun testBook(){
        lifecycleScope.launch {
            val book = BookServiceImpl.instance.list();
            println("###########2##########")
            book?.forEach { t-> println(t) }
            println("###########2##########")
        }
    }

    fun newBook(view: View) {
        val intent = Intent(this, SaveBookActivity::class.java)
        startActivity(intent)
    }


}