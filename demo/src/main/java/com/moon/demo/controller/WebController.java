package com.moon.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/chat")
    public String chatPage() {
        return "chat"; // src/main/resources/templates/chat.html을 가리킵니다.
    }
}