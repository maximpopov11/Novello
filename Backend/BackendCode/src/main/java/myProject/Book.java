package myProject;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.Api;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;

@Entity
@Api(value = "BookClass")
class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer bookID;

    @Column
    String isbn;

    @Column
    String title;

    @Column
    String author;

    @Column
    Integer publicationYear;

    @Min(value = 0, message = "Rating should not be less than 0")
    @Max(value = 10, message = "Rating should not be greater than 10")
    @Column
    Double overallRating;

    @Column
    Double msrp;

    @Column
    String genre;

    @Column(columnDefinition = "TEXT")
    String description;

    @Column
    String readingUrl;

    @Column
    String imageUrl;

    @JsonIgnore
    @OneToMany(mappedBy = "book")
    Set<BookData> bookData;

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getReadingUrl() {
        return readingUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getISBN() {
        return isbn;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setMsrp(Double msrp) {
        this.msrp = msrp;
    }

    public Double getMSRP() {
        return msrp;
    }

    public double getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(double rating) {
        this.overallRating = rating;
    }

    @JsonIgnore
    public Set<BookData> getBookData() {
        return bookData;
    }

}
