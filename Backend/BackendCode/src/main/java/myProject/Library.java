package myProject;

import javax.persistence.*;

@Entity
public class Library {
    @EmbeddedId
    LibraryKey id;

    @ManyToOne
    @MapsId("personId")
    @JoinColumn(name = "Person_id")
    User user;


    @ManyToOne
    @MapsId("bookId")
    @JoinColumn(name = "Book_id")
    Book book;

    int category;

    int page;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public User getPerson() {
        return user;
    }

    public void setPerson(User user) {
        this.user = user;
    }

    public LibraryKey getId() {
        return id;
    }

    public void setId(LibraryKey id) {
        this.id = id;
    }

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
        Library other = (Library) obj;
        if (id == null) {
            return other.id == null;
        } else return id.equals(other.id);
    }
}
