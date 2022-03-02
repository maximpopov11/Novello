package myProject;

import javax.persistence.*;

@Entity
class Books {

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

        @Column
        Integer rating;

        @Column
        Double msrp;

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

    public String getISBN() {
        return isbn;
    }

    public String getGenre() {
        return genre;
    }

    public Double getMSRP() {
        return msrp;
    }

    public Integer getRating(){return rating;}


}
