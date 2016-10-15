package ro.tibtof.playground.spock.tutorial.service

import ro.tibtof.playground.spock.tutorial.model.Book
import ro.tibtof.playground.spock.tutorial.repository.BookRepository
import spock.lang.Specification
import spock.lang.Unroll

class BookServiceSpecification extends Specification {

    public static final Book BOOK_1 =
            new Book(1, 'Java Testing with Spock', 'Konstantinos Kapelonis')
    public static final Book BOOK_2 =
            new Book(2, 'JUnit in Action', 'Petar Tahchiev, Felipe Leme, Vincent Massol, and Gary Gregory')

    BookService bookService;
    BookRepository bookRepository;

    @SuppressWarnings("GroovyAssignabilityCheck")
    def setup() {
        bookRepository = Stub();
        bookRepository.getBook(_) >> { int id ->
            switch (id) {
                case Integer.MIN_VALUE..0:
                    throw new IllegalArgumentException("Invalid Book ID");
                case 1:
                    return BOOK_1
                case 2:
                    return BOOK_2
                default:
                    return null;
            }
        }

        bookService = new BookServiceImpl(bookRepository);
    }

    @Unroll
    def "book #id is #expectedBook"() {
        expect:
        bookService.retrieveBookDetails(id) == expectedBook

        where:
        id || expectedBook
        1  || BOOK_1
        2  || BOOK_2
    }

    @Unroll
    def "no book with id #id"() {
        expect:
        bookService.retrieveBookDetails(id) == null

        where:
        id = 3
    }

    def "book id must be greater than 0"() {
        when:
        bookService.retrieveBookDetails(id)

        then:
        def exception = thrown(IllegalArgumentException)
        exception.message == 'Invalid Book ID'

        where:
        id << [-100, 0]
    }

}