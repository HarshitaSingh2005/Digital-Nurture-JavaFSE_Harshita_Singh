//Setter injection implementation

package com.library.service;

import com.library.repository.BookRepository;
public class BookService {

    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook() {
        System.out.println("Book service is working.");

        bookRepository.displayBook();
    }
}