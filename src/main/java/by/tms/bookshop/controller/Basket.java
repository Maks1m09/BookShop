package by.tms.bookshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Basket {
    @GetMapping("/basket")
    public String bookEdit ( Model model) {
        return "basket";
    }
}
