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
        Double MSRP;

        @Column
        String genre;

    public Integer getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public Integer getISBN() {
        return ISBN;
    }

    public String getGenre() {
        return genre;
    }

    public Double getMSRP() {
        return MSRP;
    }
//    public void setID(int id)
//    {
//        bookID = id;
//    }

}
