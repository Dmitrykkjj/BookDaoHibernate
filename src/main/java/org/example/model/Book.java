package org.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Books")
public class Book {
    @Id
    private long id;

    @Column
    private String authorName;

    @Column
    private String title;

    @Column
    private int year;

    public Book() {

    }

    public Book(String authorName, String title, int year) {
        this.authorName = authorName;
        this.title = title;
        this.year = year;
    }

    public Book(long id, String authorName, String title, int year) {
        this(authorName, title, year);
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("id=").append(id);
        sb.append(", authorName='").append(authorName).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", year=").append(year);
        sb.append('}');
        return sb.toString();
    }
}
