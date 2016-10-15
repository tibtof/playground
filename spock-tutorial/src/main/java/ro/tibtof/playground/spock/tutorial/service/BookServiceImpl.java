package ro.tibtof.playground.spock.tutorial.service;

import ro.tibtof.playground.spock.tutorial.model.Book;
import ro.tibtof.playground.spock.tutorial.repository.BookRepository;

public class BookServiceImpl implements BookService {

	private final BookRepository bookRepository;

	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public Book retrieveBookDetails(Integer bookId) {
		return bookRepository.getBook(bookId);
	}

}
