package sigit.springframework.spring5webapp.Bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import sigit.springframework.spring5webapp.model.Author;
import sigit.springframework.spring5webapp.model.Book;
import sigit.springframework.spring5webapp.repositories.AuthorRepository;
import sigit.springframework.spring5webapp.repositories.BookRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        //Eric
        Author author1 = new Author("Mark", "Manson");
        Book book1 = new Book("The Subtle Art of Not Giving A Fuck", "978-602-452-698-6", "HarperOne");
        author1.getBooks().add(book1);
        book1.getAuthors().add(author1);

        authorRepository.save(author1);
        bookRepository.save(book1);

        //Rod
        Author author2 = new Author("Sigit", "Saputro");
        Book book2 = new Book("Bodo Amat", "123456789", "Kaga Ada");
        author2.getBooks().add(book2);
        book2.getAuthors().add(author2);

        authorRepository.save(author2);
        bookRepository.save(book2);
    }
}
