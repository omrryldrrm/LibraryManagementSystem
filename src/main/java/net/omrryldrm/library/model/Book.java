package net.omrryldrm.library.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bookId;

	@Column(name = "book_name")
	private String bookName;

	@Column(name = "book_subname")
	private String bookSubName;

	@Column(name = "book_seriesName")
	private String bookSeriesName;

	@Column(name = "isbn_no")
	private String bookIsbnNo;

	@Column(name = "description")
	private String bookDesc;


	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "author_id")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Author author;


	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "publisher_id")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Publisher publisher;


	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookSubName() {
		return bookSubName;
	}

	public void setBookSubName(String bookSubName) {
		this.bookSubName = bookSubName;
	}

	public String getBookSeriesName() {
		return bookSeriesName;
	}

	public void setBookSeriesName(String bookSeriesName) {
		this.bookSeriesName = bookSeriesName;
	}


	public String getBookIsbnNo() {
		return bookIsbnNo;
	}

	public void setBookIsbnNo(String bookIsbnNo) {
		this.bookIsbnNo = bookIsbnNo;
	}

	public String getBookDesc() {
		return bookDesc;
	}

	public void setBookDesc(String bookDesc) {
		this.bookDesc = bookDesc;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
}
