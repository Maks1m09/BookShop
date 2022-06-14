package by.tms.bookshop.controller;

import by.tms.bookshop.entity.Book;
import by.tms.bookshop.entity.User;
import by.tms.bookshop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class BookServlet {

    @Autowired
    private BookService bookService;

    @GetMapping ("/")

    public String seeAllBooks (Model model) {
        Iterable<Book> books = bookService.findAllBooks();
        model.addAttribute("books", books);
        return "home";
    }

    @GetMapping ("/book/add")
    public String addBooks (Model model) {
        return "addBook";
    }


     @PostMapping ("/book/add")
    public String bookPostAdd(@RequestParam String name, @RequestParam double cost, @RequestParam int amount,  Model model){
        Book book = new Book(name, cost, amount);
        bookService.addBook(book);
         return "redirect:/";
     }

    @GetMapping ("/book/{id}")
    public String bookDetails (@PathVariable (value = "id") long id, Model model) {
        if (!bookService.existBookById(id)){
            return "redirect:/allBooks";
        }
       Optional <Book> book = bookService.findBookById(id);
        ArrayList<Book> res = new ArrayList<>();
        book.ifPresent(res::add);
        model.addAttribute("book", res);
        return "book_details";
    }

    @GetMapping ("/book/{id}/edit")
    public String bookEdit (@PathVariable (value = "id") long id, Model model) {
        if (!bookService.existBookById(id)){
            return "redirect:/allBooks";
        }
        Optional <Book> book = bookService.findBookById(id);
        ArrayList<Book> res = new ArrayList<>();
        book.ifPresent(res::add);
        model.addAttribute("book", res);
        return "book_edit";
    }

    @PostMapping ("/book/{id}/edit")
    public String bookPostEdit(@PathVariable (value = "id") long id , @RequestParam String name, @RequestParam double cost, @RequestParam int amount,  Model model){
        Book book = bookService.findBookById(id).orElseThrow();
         book.setBookName(name);
         book.setCost(cost);
         book.setAmount(amount);
         bookService.addBook(book);
        return "redirect:/";
    }

    @PostMapping ("/book/{id}/remove")
    public String bookPostDelete(@PathVariable (value = "id") long id , Model model){
        Book book = bookService.findBookById(id).orElseThrow();

        bookService.deleteBook(book);
        return "redirect:/";
    }




}
