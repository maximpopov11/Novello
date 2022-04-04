package myProject;

import javax.persistence.*;
import java.util.Optional;

@Entity
public class BookRating {
    @EmbeddedId
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    BookRatingKey id;
    @ManyToOne
    @MapsId("personId")
    @JoinColumn(name = "Person_id")
    Person person;

    @ManyToOne
    @MapsId("bookId")
    @JoinColumn(name = "Book_id")
    Books book;

    //@Column
    int rating;

    String review;

    public BookRatingKey getId() {
        return id;
    }

    public void setId(BookRatingKey id) {
        this.id = id;
    }

    public void setRating(int rating){
        this.rating = rating;
    }
    public void setBook(Books id){this.book = id;}

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getRating()
    {
        return rating;
    }
    public String getReview(){return review;}
    public void setReview(){this.review = review;}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BookRating other = (BookRating) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
