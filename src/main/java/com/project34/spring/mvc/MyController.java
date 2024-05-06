package com.project34.spring.mvc;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class MyController {

    @RequestMapping("/")
    private String showFirstView() {
        return "first-view";
    }

    @RequestMapping("/askDetails")
    private String askEmpDetails(Model model) {

        model.addAttribute("employee", new Employee());

        return "ask-emp-details-view";
    }

    @RequestMapping("/showDetails")
    private String showEmpDetails(@Valid
                                  @ModelAttribute("employee") Employee employee,
                                  BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "ask-emp-details-view";
        }
        else {
            return "show-emp-details-view";
        }
    }
}
