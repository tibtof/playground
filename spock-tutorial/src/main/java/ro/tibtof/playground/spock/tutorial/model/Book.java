package ro.tibtof.playground.spock.tutorial.model;

public class Book {

	private final Integer bookId;
	private final String title;
	private final String author;

	public Book(Integer bookId, String title, String author) {
		this.bookId = bookId;
		this.title = title;
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book{" +
				"bookId=" + bookId +
				", title='" + title + '\'' +
				", author='" + author + '\'' +
				'}';
	}

}
