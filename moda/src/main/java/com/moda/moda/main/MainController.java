package com.moda.moda.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/main")
    public String show() {
        return "html/moda/main/main";
    }

//    @GetMapping("/product")
//    public String product() {
//        return "product";
//    }
}
