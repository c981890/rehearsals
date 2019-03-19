package eu.trumm.ImportCSV;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Books {

    @Id
    private String isbn;
    private String bookTitle;
    private String bookAuthor;
    private int yearOfPublication;
    private String publisher;
    private String imageUrlS;
    private String imageUrlM;
    private String getImageUrlL;

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

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
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

    public String getGetImageUrlL() {
        return getImageUrlL;
    }

    public void setGetImageUrlL(String getImageUrlL) {
        this.getImageUrlL = getImageUrlL;
    }
}
