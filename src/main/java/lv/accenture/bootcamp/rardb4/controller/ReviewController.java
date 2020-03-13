package lv.accenture.bootcamp.rardb4.controller;

import lv.accenture.bootcamp.rardb4.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;
}
