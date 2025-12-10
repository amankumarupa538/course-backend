package com.pragyan.controller;

import com.pragyan.service.MatrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/matrix")
public class MatrixController {
    @Autowired
    MatrixService matrixService;

    @GetMapping("/count/user")
    public Map<String,Long> getCounts(){
        Map<String,Long> map=matrixService.count();
        //return matrixService.count();
        return map;

    }

}
