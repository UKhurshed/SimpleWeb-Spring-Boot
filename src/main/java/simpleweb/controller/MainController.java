package simpleweb.controller;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import simpleweb.controller.dto.Book;
import simpleweb.service.MainService;

@RestController("/")
public class MainController {

    @Resource
    private MainService mainService;

    @GetMapping
    public String mainPage() {
        return "<b>Hello</b> World";
    }

    @PostMapping("/create")
    @ResponseBody
    public Book createObject(@RequestBody Book book) {

        mainService.validateLength(book);

        return book;
    }

}
