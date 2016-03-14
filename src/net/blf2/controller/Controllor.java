package net.blf2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by blf2 on 16-2-28.
 */
@Controller
public class Controllor {
    @RequestMapping("toIndex")
    public String toIndex(){
        return "front/index";
    }
}
