package ro.tibtof.playground.spock.tutorial.service;

import ro.tibtof.playground.spock.tutorial.model.Book;

public interface BookService {

	Book retrieveBookDetails(Integer bookId);

}
