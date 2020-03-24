package lv.accenture.bootcamp.rardb4.controller;

import lv.accenture.bootcamp.rardb4.repository.UserRepositoryOld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserControllerOld {

    @Autowired
    private UserRepositoryOld userRepository;



}
