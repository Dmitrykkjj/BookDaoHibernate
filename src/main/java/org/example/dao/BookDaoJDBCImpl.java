package org.example.dao;

import org.example.model.Book;
import org.example.util.UtilJDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDaoJDBCImpl implements BookDao {
    private static final Connection connection;
    private static final String createTableSQL = "CREATE TABLE IF NOT EXISTS Books (" +
            "id BIGINT PRIMARY KEY AUTO_INCREMENT," +
            "authorName VARCHAR(255)," +
            "title VARCHAR(255)," +
            "year BIGINT)";
    private static final String dropTableSQL = "DROP TABLE IF EXISTS Books";
    private static final String insertBookSQL = "INSERT INTO Books (authorName, title, year) VALUES(?, ?, ?)";
    private static final String removeBookSQL = "DELETE FROM Books WHERE id = ?";
    private static final String getAllBooksSQL = "SELECT * FROM Books";
    private static final String cleanBookSQL = "TRUNCATE TABLE Books";

    static {
        connection = UtilJDBC.getConnection();
    }

    public BookDaoJDBCImpl() {

    }

    @Override
    public void createBookTable() {
        try (Statement statement = connection.createStatement()) {
            statement.execute(createTableSQL);
            System.out.println("Table Books created");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dropBookTable() {
        try (Statement statement = connection.createStatement()) {
            statement.execute(dropTableSQL);
            System.out.println("Table Books dropped");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveBook(String authorName, String title, int year) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertBookSQL)) {
            preparedStatement.setString(1, authorName);
            preparedStatement.setString(2, title);
            preparedStatement.setInt(3, year);

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeBook(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(removeBookSQL)) {
            preparedStatement.setLong(1, id);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Book with id " + id + " removed");
            } else {
                System.out.println("Book with id " + id + " not removed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Book> getBooks() {
        List<Book> booksList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(getAllBooksSQL);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String authorName = resultSet.getString("authorName");
                String title = resultSet.getString("title");
                int year = resultSet.getInt("year");

                Book book = new Book(id, authorName, title, year);
                booksList.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return booksList;
    }

    @Override
    public void cleanBookTable() {
        try (PreparedStatement preparedStatement = connection.prepareStatement(cleanBookSQL)) {
            preparedStatement.executeUpdate();
            System.out.println("Table cleaned");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
