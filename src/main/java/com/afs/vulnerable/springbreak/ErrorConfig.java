package com.afs.vulnerable.springbreak;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorConfig implements ErrorController {

    @RequestMapping("/error")
    public String handleError() {
        //do something like logging
        return "404";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
