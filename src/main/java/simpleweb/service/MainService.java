package simpleweb.service;


import com.google.common.base.Strings;
import org.springframework.stereotype.Service;
import simpleweb.controller.dto.Book;

@Service
public class MainService {

    public void validateLength(Book book) {

        if (Strings.isNullOrEmpty(book.getName())) {
            throw new IllegalStateException("Name is empty");
        }
    }
}
