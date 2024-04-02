package com.moon.demo.controller;


import com.moon.demo.dto.ChatGptRequest;
import com.moon.demo.dto.ChatGptResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/bot")
public class CustomBotController {

    private static final Logger logger = LoggerFactory.getLogger(CustomBotController.class);

    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.url}")
    private String apiURL;

    @Autowired
    private RestTemplate template;

    @GetMapping("/chat")
    public ChatGptResponse chat(@RequestParam(value = "prompt", required = false) String prompt) {
        logger.info("Received request URL: /chat?prompt={}", prompt);

        ChatGptRequest request = new ChatGptRequest(model, prompt);
        ChatGptResponse chatGptResponse = template.postForObject(apiURL, request, ChatGptResponse.class);

        logger.info("Response from GPT: {}", chatGptResponse);

        // Directly return the response object
        return chatGptResponse;
    }
}
