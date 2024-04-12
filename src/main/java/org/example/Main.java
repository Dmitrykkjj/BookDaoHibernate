package org.example;

import org.example.dao.BookDao;
import org.example.dao.BookDaoHibernateImpl;
import org.example.model.Book;


import java.util.List;

public class Main {
    public static void main(String... arguments) {
        BookDao bookDao = new BookDaoHibernateImpl();
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
        bookDao.removeBook(2);
        bookDao.saveBook("Ernest Miller Hemingway",
                "A Moveable Feast",
                1964);

        List<Book> books = bookDao.getBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }
}