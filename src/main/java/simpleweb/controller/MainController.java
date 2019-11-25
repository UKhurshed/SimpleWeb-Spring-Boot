package simpleweb.controller;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import simpleweb.controller.dto.BookDto;
import simpleweb.repository.entity.Book;
import simpleweb.service.MainService;

@Controller("/")
public class MainController {

    @Resource
    private MainService mainService;

    @GetMapping
    public String mainPage(Model model) {
        List<Book> books = mainService.getAllBooks();
        model.addAttribute("books", books);

        return "view/index";
    }

    @PostMapping("/create")
    @ResponseBody
    public BookDto createObject(@RequestBody BookDto bookDto) {

        mainService.validateLength(bookDto);

        return bookDto;
    }

    @GetMapping("/loadBooks")
    @ResponseBody
    public List<Book> loadBooks() {
        return mainService.getAllBooks();
    }

}
