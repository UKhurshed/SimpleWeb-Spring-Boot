package simpleweb.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simpleweb.Entity.BookNote;
import simpleweb.Repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImplement{

    private final BookRepository repository;

    public BookServiceImplement(BookRepository repository){
        this.repository = repository;
    }


    public Optional<BookNote> getBookId(Long id) {
        return repository.findById(id);
    }

    public void updateBook(Long id, String name, String description, String author, boolean done){
        BookNote book = repository.findById(id).orElse(new BookNote());
        book.setName(name);
        book.setDescription(description);
        book.setAuthor(author);
        book.setDone(done);
        repository.save(book);
    }

    public void deleteBook(Long id) {
        repository.deleteById(id);
    }


    public void saveBook(BookNote book) {
        repository.save(book);
    }

    public List<BookNote> getAllBooks(){
        return repository.findAll();
    }
}
