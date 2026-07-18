package com.library;

import com.library.service.BookService;
import com.library.service.ConstructorBookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService setterService =
                context.getBean("bookService", BookService.class);

        ConstructorBookService constructorService =
                context.getBean(
                        "constructorBookService",
                        ConstructorBookService.class
                );

        setterService.addBook();
        constructorService.addBook();
    }
}