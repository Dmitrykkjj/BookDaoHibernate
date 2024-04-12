package org.example.dao;

import org.example.model.Book;
import java.util.List;

public interface BookDao {
    void createBookTable();

    void dropBookTable();

    void saveBook(String authorName, String title, int year);

    void removeBook(int id);

    List<Book> getBooks();

    void cleanBookTable();
}
