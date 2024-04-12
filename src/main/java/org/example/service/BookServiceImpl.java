package org.example.service;

import org.example.dao.BookDao;
import org.example.dao.BookDaoHibernateImpl;
import org.example.model.Book;
import java.util.List;

public class BookServiceImpl implements BookService {
    BookDao bookDao = new BookDaoHibernateImpl();

    @Override
    public void createBookTable() {
        bookDao.createBookTable();
    }

    @Override
    public void dropBookTable() {
        bookDao.dropBookTable();
    }

    @Override
    public void saveBook(String authorName, String title, int year) {
        bookDao.saveBook(authorName, title, year);
    }

    @Override
    public void removeBook(int id) {
        bookDao.removeBook(id);
    }

    @Override
    public List<Book> getBooks() {
        return bookDao.getBooks();
    }

    @Override
    public void cleanBookTable() {
        bookDao.cleanBookTable();
    }
}
