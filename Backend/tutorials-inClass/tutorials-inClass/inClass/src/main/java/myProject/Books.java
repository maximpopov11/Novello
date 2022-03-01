package myProject;

import javax.persistence.*;

@Entity
class Books {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Integer bookID;

        @Column
        Integer ISBN;

        @Column
        String title;

        @Column
        String author;

        @Column
        Integer publicationYear;

        @Column
        Integer rating;

        @Column
        Double MSRP;

        @Column
        String genre;



    public Integer getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor(){ return author;}

    public Integer getPublicationYear(){ return publicationYear;}

    public Integer getISBN() {
        return ISBN;
    }

    public String getGenre() {
        return genre;
    }

    public Double getMSRP() {
        return MSRP;
    }

    public Integer getRating(){return rating;}


}
