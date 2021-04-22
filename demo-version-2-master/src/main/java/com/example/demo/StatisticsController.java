package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StatisticsController {

    final
    GreetingRepository greetingRepository;

    public StatisticsController(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @GetMapping("/statistics")
    public String greetingForm(Model model) {

        return "statistics";
    }
}
