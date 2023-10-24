package com.moda.moda.join.controller;

import com.moda.moda.join.dto.JoinDTO;
import com.moda.moda.join.service.JoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLOutput;

@Controller
@RequiredArgsConstructor
public class JoinController {
    private final JoinService joinService;
    @GetMapping("/users/save")
    public String saveForm(){
        return "save";
    }
    @PostMapping("/users/save")
    public String save(@ModelAttribute JoinDTO joinDTO){
        System.out.println("joinDTO = " + joinDTO);
        joinService.save(joinDTO);
        return "index";
    }
}
