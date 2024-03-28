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
    public String chat(@RequestParam(value = "prompt", required = false) String prompt) {
        // front 에서 사용자가 입력한 request prompt를 백엔드로 가져옴.
        // request prompt를 ChatGptRequest 의 request 에 보낸다.

        //

        prompt = "20살, 키 170cm, 남성, 목적은 근육량 증가. 도움이 될 만한 식단을 만들어줘, 운동도 알려줘. 영양제도 추천해줘.";

        logger.info("Received request URL: /chat?prompt={}", prompt);

        // ChatGptRequest request 하기 전에 front에서 prompt 값을 요청받으면 된다.
        ChatGptRequest request = new ChatGptRequest(model, prompt);
        ChatGptResponse chatGptResponse = template.postForObject(apiURL, request, ChatGptResponse.class);

        String responseContent = chatGptResponse.getChoices().get(0).getMessage().getContent();

        logger.info("Response : {}", responseContent);

        return responseContent;
    }
}
