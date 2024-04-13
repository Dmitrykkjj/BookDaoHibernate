package org.example.dao;

import org.example.util.UtilHibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import org.example.model.Book;
import java.util.ArrayList;
import java.util.List;

public class BookDaoHibernateImpl implements BookDao {

    static final String createBookTable = "CREATE TABLE IF NOT EXISTS Books (" +
            "id BIGINT PRIMARY KEY AUTO_INCREMENT," +
            "authorName VARCHAR(255)," +
            "title VARCHAR(255)," +
            "year BIGINT)";

    static final String dropBookTable = "DROP TABLE IF EXISTS Books";

    static final String insertBook = "INSERT INTO Books (authorName, title, year) VALUES(:authorName, :title, :year)";

    static final String deleteBook = "DELETE FROM Books WHERE id = :id";

    public BookDaoHibernateImpl() {
    }

    @Override
    public void createBookTable() {
        Transaction transaction = null;
        Session session = UtilHibernate.openSession();
        try {
            transaction = session.beginTransaction();
            session.createSQLQuery(createBookTable).executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            UtilHibernate.closeSession(session);
        }
    }

    @Override
    public void dropBookTable() {
        Transaction transaction = null;
        Session session = UtilHibernate.openSession();
        try {
            transaction = session.beginTransaction();
            session.createSQLQuery(dropBookTable).executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            UtilHibernate.closeSession(session);
        }
    }

    @Override
    public void saveBook(String authorName, String title, int year) {
        Transaction transaction = null;
        Session session = UtilHibernate.openSession();
        try {
            transaction = session.beginTransaction();
            SQLQuery query = session.createSQLQuery(insertBook);
            query.setParameter("authorName", authorName);
            query.setParameter("title", title);
            query.setParameter("year", year);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            UtilHibernate.closeSession(session);
        }

    }

    @Override
    public void removeBook(int id) {
        Transaction transaction = null;
        Session session = UtilHibernate.openSession();
        try {
            transaction = session.beginTransaction();
            SQLQuery query = session.createSQLQuery(deleteBook);
            query.setParameter("id", id);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            UtilHibernate.closeSession(session);
        }
    }

    @Override
    public List<Book> getBooks() {
        Session session = UtilHibernate.openSession();
        Transaction transaction = null;
        List<Book> books = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            books = session.createQuery("FROM Book", Book.class).list();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            UtilHibernate.closeSession(session);
        }
        return books;
    }

    @Override
    public void cleanBookTable() {
        Transaction transaction = null;
        Session session = UtilHibernate.openSession();
        try {
            transaction = session.beginTransaction();
            SQLQuery query = session.createSQLQuery("TRUNCATE TABLE Books");
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            UtilHibernate.closeSession(session);
        }
    }
}
