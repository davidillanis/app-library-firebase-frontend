package com.example.myapplication

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.model.BookEntity
import com.example.myapplication.service.implementation.BookServiceImpl
import com.example.myapplication.util.other.UtilModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private var listBook:List<BookEntity>?=null

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
        listBook=UtilModel.instance.listBook()


    }

    fun testBook(){
        lifecycleScope.launch {
            val book = BookServiceImpl.instance.list();
            book?.forEach { t-> println(t) }
        }
    }

    fun test(view: View) {
        println("Hello World")
        testBook()
        println("Hello World")
    }
}