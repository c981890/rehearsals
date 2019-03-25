package com.example.demo.Entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class Book {

    @Id
    @GeneratedValue
    private int id;
    private String isbn;
    private String bookTitle;
    private String bookAuthor;
    private int year;
    private String publisher;
    private String imageUrlS;
    private String imageUrlM;
    private String imageUrlL;

    public Book() {

    }

    public Book(String isbn, String bookTitle, String bookAuthor, int year, String publisher, String imageUrlS, String imageUrlM, String imageUrlL) {
        this.isbn = isbn;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.year = year;
        this.publisher = publisher;
        this.imageUrlS = imageUrlS;
        this.imageUrlM = imageUrlM;
        this.imageUrlL = imageUrlL;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getImageUrlS() {
        return imageUrlS;
    }

    public void setImageUrlS(String imageUrlS) {
        this.imageUrlS = imageUrlS;
    }

    public String getImageUrlM() {
        return imageUrlM;
    }

    public void setImageUrlM(String imageUrlM) {
        this.imageUrlM = imageUrlM;
    }

    public String getImageUrlL() {
        return imageUrlL;
    }

    public void setImageUrlL(String imageUrlL) {
        this.imageUrlL = imageUrlL;
    }
}
