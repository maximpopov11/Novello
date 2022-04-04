package myProject;

import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@Entity
public class Library {
    @EmbeddedId
    LibraryKey id;

    @ManyToOne
    @MapsId("personId")
    @JoinColumn(name = "Person_id")
    Person person;


    @ManyToOne
    @MapsId("bookId")
    @JoinColumn(name = "Book_id")
    Books book;

    int category;

    int page;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }


    public Books getBook() {
        return book;
    }

    public void setBook(Books book) {
        this.book = book;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int catagory) {
        this.category = catagory;
    }

    public Person getPerson() {
        return person;
    }

    public void setId(LibraryKey id) {
        this.id = id;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public LibraryKey getId() {
        return id;
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
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
}}
