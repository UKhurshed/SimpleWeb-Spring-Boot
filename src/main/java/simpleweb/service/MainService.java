package simpleweb.service;


import java.util.List;
import com.google.common.base.Strings;
import org.springframework.stereotype.Service;
import simpleweb.controller.dto.BookDto;
import simpleweb.repository.BookRepository;
import simpleweb.repository.entity.Book;

@Service
public class MainService {

    public MainService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    private final BookRepository bookRepository;

    public void validateLength(BookDto bookDto) {

        if (Strings.isNullOrEmpty(bookDto.getName())) {
            throw new IllegalStateException("Name is empty");
        }
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
