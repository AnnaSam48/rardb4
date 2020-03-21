package lv.accenture.bootcamp.rardb4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {

   @GetMapping("/") //link to index page
   public String toIndex() {
       return "index";
   }


}
