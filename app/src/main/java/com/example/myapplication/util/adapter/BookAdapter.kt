package com.example.myapplication.util.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.model.BookEntity
import com.example.myapplication.R

class BookAdapter(private val listBook: List<BookEntity>) : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        return BookViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = listBook[position]
        holder.bind(book)
    }

    override fun getItemCount(): Int = listBook.size

    inner class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageBook: ImageView = itemView.findViewById(R.id.imageBook)
        private val textTitle: TextView = itemView.findViewById(R.id.textTitle)
        private val textAuthor: TextView = itemView.findViewById(R.id.textAuthor)
        private val buttonIr: Button = itemView.findViewById(R.id.buttonIr)

        fun bind(book: BookEntity) {
            textTitle.text = book.title
            textAuthor.text = book.author

            Glide.with(itemView.context)
                .load(book.urlImage)
                .placeholder(R.drawable.error_image)
                .error(R.drawable.error_image)
                .into(imageBook)

            buttonIr.setOnClickListener {
                println("Nombre del libro: ${book.urlBook}")
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(book.urlBook))
                itemView.context.startActivity(intent)
            }
        }
    }
}
