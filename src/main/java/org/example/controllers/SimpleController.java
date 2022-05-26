package org.example.controllers;

import org.example.DAO.SimpleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/simple")
public class SimpleController {

    private final SimpleDAO simpleDAO;

    @Autowired
    public SimpleController(SimpleDAO simpleDAO){
        this.simpleDAO = simpleDAO;
    }

    @GetMapping()
    public String helloPage(Model model){

        for(int i = 0; i < 5; ++i){
            System.out.println("What the fuck???");
        }

        model.addAttribute("simpleList", simpleDAO.list());

        return "simple/simplePage";
    }

}
