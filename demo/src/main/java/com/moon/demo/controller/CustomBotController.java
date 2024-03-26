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

        prompt = "15살, 남성, 160cm, 목적은 근육량 증가 그리고 키가 크는거야. " +
                "자세하게 식단과 운동 방법을 설명해줘. " +
                "그리고 목적에 도움이 되는 영양제를 추천해줘." +
                "보기 쉽게 알려줘.";

        logger.info("Received request URL: /chat?prompt={}", prompt);

        // ChatGptRequest request 하기 전에 front에서 prompt 값을 요청받으면 된다.
        ChatGptRequest request = new ChatGptRequest(model, prompt);
        ChatGptResponse chatGptResponse = template.postForObject(apiURL, request, ChatGptResponse.class);

        String responseContent = chatGptResponse.getChoices().get(0).getMessage().getContent();

        logger.info("Response : {}", responseContent);

        return responseContent;
    }
}
