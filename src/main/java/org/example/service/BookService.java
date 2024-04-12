package org.example.service;

import org.example.model.Book;
import java.util.List;

public interface BookService {
    public void createBookTable();

    public void dropBookTable();

    public void saveBook(String authorName, String title, int year);

    public void removeBook(int id);

    public List<Book> getBooks();

    public void cleanBookTable();
}
