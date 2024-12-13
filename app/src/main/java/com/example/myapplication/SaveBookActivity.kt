package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.model.BookEntity
import com.example.myapplication.service.implementation.BookServiceImpl
import kotlinx.coroutines.launch

class SaveBookActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_save_book)

        OnInit()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun OnInit(){
        val editTextTitle = findViewById<EditText>(R.id.editTextTitle)
        val editTextIsbn = findViewById<EditText>(R.id.editTextIsbn)
        val editTextDescription = findViewById<EditText>(R.id.editTextDescription)
        val editTextEditorial = findViewById<EditText>(R.id.editTextEditorial)
        val editTextAuthor = findViewById<EditText>(R.id.editTextAuthor)
        val editTextUrlImage = findViewById<EditText>(R.id.editTextUrlImage)
        val editTextUrlBook = findViewById<EditText>(R.id.editTextUrlBook)
        val editTextGender = findViewById<EditText>(R.id.editTextGender)

        val registerButton = findViewById<Button>(R.id.buttonRegister)

        registerButton.setOnClickListener {
            val title = editTextTitle.text.toString()
            val isbn = editTextIsbn.text.toString()
            val description = editTextDescription.text.toString()
            val editorial = editTextEditorial.text.toString()
            val author = editTextAuthor.text.toString()
            val urlImage = editTextUrlImage.text.toString()
            val urlBook = editTextUrlBook.text.toString()
            val gender = editTextGender.text.toString()

            if (title.isNotEmpty() && isbn.isNotEmpty() && description.isNotEmpty()) {
                val newBook = BookEntity(
                    idBook = "",
                    title = title,
                    isbn = isbn,
                    description = description,
                    editorial = editorial,
                    author = author,
                    urlImage = urlImage,
                    urlBook = urlBook,
                    gender = gender
                )
                registerBook(newBook)
            } else {
                Toast.makeText(this, "Por favor complete todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun registerBook(book: BookEntity) {
        lifecycleScope.launch {
            try {
                val result = BookServiceImpl.instance.create(book)
                if (result != null) {
                    Toast.makeText(this@SaveBookActivity, "Libro registrado con éxito", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@SaveBookActivity, "Error al registrar el libro", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                Toast.makeText(this@SaveBookActivity, "Ocurrió un error: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun Principal(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}