package net.omrryldrm.library.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "publisher")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long publisherId;

    @Column(name = "publisher_name")
    private String publisherName;

    @Column(name = "description")
    private String publisherDesc;


    @OneToMany(mappedBy = "publisher", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<Book> books = new HashSet<>();

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(long publisherId) {
        this.publisherId = publisherId;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getPublisherDesc() {
        return publisherDesc;
    }

    public void setPublisherDesc(String publisherDesc) {
        this.publisherDesc = publisherDesc;
    }

}
