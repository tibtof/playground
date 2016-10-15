package ro.tibtof.playground.spock.tutorial.repository;

import ro.tibtof.playground.spock.tutorial.model.Book;

public interface BookRepository {

	Book getBook(Integer bookId);

}
