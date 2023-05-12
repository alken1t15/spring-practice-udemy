package kz.alken1t.alex.springapp5.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {

        model.addAttribute("message","Hello, " + name + " " + surname);
      //  System.out.println("Hello, " + name + " " + surname);
        return "first/hello";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "a" , required = false) Integer a,
                             @RequestParam(value ="b", required = false) Integer b,
                             @RequestParam(value ="action", required = false) String action,
                             Model model){
        double operation = 0;
        if(action==null){
            action="tt";
        }
        switch (action){
            case "multiplication" -> operation = a*b;
            case "addition" -> operation = a+b;
            case "subtraction" -> operation = a-b;
            case "division" -> operation = a/ (double) b;
        }

        model.addAttribute("answer",operation);

        return "first/calculator";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }
}
