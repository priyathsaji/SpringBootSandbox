package com.preact.SpringBootSandbox.unittesting.controller;


import com.preact.SpringBootSandbox.unittesting.modal.Item;
import com.preact.SpringBootSandbox.unittesting.service.UnitTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("unitTesting")
public class UnitTestingController{

    private final UnitTestService unitTestService;

    @Autowired
    public UnitTestingController(UnitTestService unitTestService) {
        this.unitTestService = unitTestService;
    }

    @GetMapping("/helloWorld")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping("/getValue2N/{limit}")
    public List<Integer> getValue2N(@PathVariable("limit") int n){
        return unitTestService.getValue2N(n);
    }

    @GetMapping("/getItemsFromDb")
    public List<Item> getItemFromDb(){
        return unitTestService.getItemsFromDb();
    }


}