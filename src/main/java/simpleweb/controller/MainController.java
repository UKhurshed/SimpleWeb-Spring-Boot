package simpleweb.controller;

import java.security.PublicKey;
import java.util.List;
import java.util.Optional;
import javax.annotation.Resource;

import org.checkerframework.checker.index.qual.PolyUpperBound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import simpleweb.Entity.BookNote;
import simpleweb.Service.BookServiceImplement;


@Controller("/")
public class MainController {

    @Resource
    private BookServiceImplement serviceImplement;


    @GetMapping
    public String mainPage(Model model) {
        List<BookNote> book = serviceImplement.getAllBooks();
        model.addAttribute("book", book);
        return "view/index";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        Optional<BookNote> book = serviceImplement.getBookId(id);
        model.addAttribute("book", book);
        return "view/edit";
    }


    @PostMapping("/update")
    public String saveNote(@RequestParam Long id, @RequestParam String name, @RequestParam String description,
                           @RequestParam String author, @RequestParam(value = "done", required = false) boolean done){
        serviceImplement.updateBook(id, name, description, author, done);
        return "redirect:/";
    }


    @GetMapping("/new")
    public String newBook(){
        return "view/new";
    }

    @PostMapping("/save")
    public String updateNote(@RequestParam String name, @RequestParam String description, @RequestParam String author){
        serviceImplement.saveBook(new BookNote(name, description, author));
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        serviceImplement.deleteBook(id);
        return "redirect:/";
    }

    @GetMapping("/allBooks")
    @ResponseBody
    public List<BookNote> loadBooks() {
        return serviceImplement.getAllBooks();
    }

}
