package org.example;

import org.example.dao.BookDao;
import org.example.dao.BookDaoJDBCImpl;
import org.example.model.Book;
import org.example.service.BookService;
import org.example.service.BookServiceImpl;


import java.util.List;

public class Main {
    public static void main(String... arguments) {
//        BookService bookService = new BookServiceImpl();
//        bookService.dropBookTable();
//        bookService.createBookTable();
//        bookService.saveBook("Ernest Miller Hemingway",
//                "The Old Man and the Sea",
//                1952);
//        bookService.saveBook("Ernest Miller Hemingway",
//                "The Snows of Kilimanjaro",
//                1936);
//        bookService.saveBook("Ernest Miller Hemingway",
//                "Green Hills of Africa",
//                1935);
//        bookService.removeBook(2);
//        bookService.saveBook("Ernest Miller Hemingway",
//                "A Moveable Feast",
//                1964);
//
//        List<Book> books = bookService.getBooks();
//        for (Book book : books) {
//            System.out.println(book);
//        }

        BookDao bookDao = new BookDaoJDBCImpl();
        bookDao.dropBookTable();
        bookDao.createBookTable();
        bookDao.saveBook("Ernest Miller Hemingway",
                "The Old Man and the Sea",
                1952);
        bookDao.saveBook("Ernest Miller Hemingway",
                "The Snows of Kilimanjaro",
                1936);
        bookDao.saveBook("Ernest Miller Hemingway",
                "Green Hills of Africa",
                1935);
        bookDao.saveBook("Ernest Miller Hemingway",
                "A Moveable Feast",
                1964);
        List<Book> books = bookDao.getBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }
}