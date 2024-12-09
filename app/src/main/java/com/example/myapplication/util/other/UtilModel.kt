package com.example.myapplication.util.other

import com.example.myapplication.model.BookEntity

class UtilModel private constructor(){
    companion object {
        val instance: UtilModel by lazy { UtilModel() }
    }

    fun listBook(): List<BookEntity> {
        val bookList = listOf(
            BookEntity(
                idBook = "1",
                title = "Cien años de soledad",
                isbn = "978-0-06-088328-7",
                description = "Una obra maestra que narra la historia de la familia Buendía en el pueblo ficticio de Macondo.",
                editorial = "Harper & Row",
                author = "Gabriel García Márquez",
                urlImage = "https://example.com/cien_anos.jpg",
                urlBook = "https://example.com/cien_anos.pdf",
                gender = "Realismo mágico"
            ),
            BookEntity(
                idBook = "2",
                title = "1984",
                isbn = "978-0-452-28423-4",
                description = "Una novela distópica que explora los peligros del totalitarismo.",
                editorial = "Secker & Warburg",
                author = "George Orwell",
                urlImage = "https://example.com/1984.jpg",
                urlBook = "https://example.com/1984.pdf",
                gender = "Ciencia ficción"
            ),
            BookEntity(
                idBook = "3",
                title = "El Principito",
                isbn = "978-0-15-601219-5",
                description = "Una historia encantadora que explora temas de amor, amistad y pérdida.",
                editorial = "Reynal & Hitchcock",
                author = "Antoine de Saint-Exupéry",
                urlImage = "https://example.com/el_principito.jpg",
                urlBook = "https://example.com/el_principito.pdf",
                gender = "Fábula"
            ),
            BookEntity(
                idBook = "4",
                title = "Don Quijote de la Mancha",
                isbn = "978-84-376-0494-7",
                description = "Una de las obras literarias más importantes de la literatura española.",
                editorial = "Francisco de Robles",
                author = "Miguel de Cervantes",
                urlImage = "https://example.com/don_quijote.jpg",
                urlBook = "https://example.com/don_quijote.pdf",
                gender = "Novela"
            ),
            BookEntity(
                idBook = "5",
                title = "La Odisea",
                isbn = "978-0-14-026886-7",
                description = "Un épico poema que narra las aventuras de Ulises en su regreso a Ítaca.",
                editorial = "Penguin Classics",
                author = "Homero",
                urlImage = "https://example.com/la_odisea.jpg",
                urlBook = "https://example.com/la_odisea.pdf",
                gender = "Épica"
            )
        )

        return bookList;
    }
}