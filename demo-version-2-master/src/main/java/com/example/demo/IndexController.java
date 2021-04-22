package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class IndexController {

    final
    GreetingRepository greetingRepository;

    public IndexController(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @GetMapping("/")
    public String gree(Model model) {
        return "index";
    }


    @GetMapping("/index")
    public String greetingForm(Model model) {
        Greeting greeting = new Greeting();
        greeting.setContent(greeting.getContent());
        model.addAttribute("greeting", greeting);
        return "index";
    }

    @PostMapping("/index")
    public String greetingSubmit(@ModelAttribute(value="greeting") Greeting greeting) {
        String word = greeting.getContent();
        System.out.println("word: " + word);
        ArrayList<String> lit = greetingRepository.findContent(word);
        if (lit.size() != 0) {
            System.out.println(lit.get(0));
            greeting.setContent(lit.get(0));
        } else {
            System.out.println("Пустой массив!");
            greeting.setContent("Ничего не найдено!");
        }
        return "index";
    }
}
