package org.example.service;

import java.awt.print.Book;
import java.util.List;

public interface BookService {
    public void createBookTable();

    public void dropBookTable();

    public void saveBook(String authorName, String title, int year);

    public Book getBook(int id);

    public void removeBook(int id);

    public List<Book> getBooks();

    public void cleanBookTable();
}
