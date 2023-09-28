package com.example.ex01.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Ex01Application")
public class Ex01applicationController {
    @GetMapping
    public String helloworld(){
        return  "Hello World";
    }

    @GetMapping("/bsms")
    public String bsms(){
        return  "Persistência\n" +
                "Mentalidade de Crescimento\n" +
                "Orientação ao Futuro\n" +
                "Responsabilidade Pessoal\n" +
                "Trabalho em Equipe\n" +
                "Comunicação\n" +
                "Orientação aos Detalhes\n" +
                "Proatividade";
    }

    @GetMapping("/listOf")
    public List<String> listof(){
        List<String> list = new ArrayList<>();
        list.add("Aprender Spring \n");
        list.add("Aprender a integrar db com spring");
        return  list;
    }




}
