# 졸업작품 건강

개인화 맞춤형 건강한 식단, 영양제 추천을 할 수 있는 웹서비스입니다.

- Java 8
- Spring Boot
- naver cloud db for mysql
    <https://guide.ncloud-docs.com/docs/clouddbformysql-overviews><br>
    <https://velog.io/@devmizz/DevOps-%EB%84%A4%EC%9D%B4%EB%B2%84-%ED%81%B4%EB%9D%BC%EC%9A%B0%EB%93%9C-DB-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0>
- 

<br>

## WBS
[WBS_Health.xlsx](https://github.com/MungJeoNyeon/openAiApi_spring/files/14785493/WBS_Health.xlsx)




<br>

## WEB 이용 방법
1. 사용자가 서비스를 이용하기 위해서는 회원가입을 통해 아이디를 생성하고 로그인을 해야한다.
    - 로그인 생성 : (어디에 위치할 것인가...) 'login' 버튼
    - 회원가입 : (어디에 위치할 것인가...) 'sign-up' 버튼

2. 로그인을 하면 메인 페이지로 이동한다.
    - 메인 페이지에는 커뮤니티 페이지, 메뉴 페이지, ai_chat 페이지로 이동할 수 있는 아이콘이 존재한다.

3. 사용자가 개인화 맞춤형 건강한 식단을 제공 받기위해 ai_chat 페이지로 이동한다.
    - ai_chat 페이지에는 식단, 운동, 영양제 추천을 질문할 수 있는 메시지 박스가 존재한다.
    - 메시지 박스 클릭시 사용자 정보를 불러와 자동으로 질문을 입력할 수 있는 텍스트박스가 표시된다.
    - 답변을 받은 정보를 가지고 3가지 카테고리인 추천 식단, 운동, 영양제 메뉴 버튼이 표시된다.

<br>

## Entity 매핑

<br>

# openai api test
## api properties
    openai.model=gpt-3.5-turbo
    openai.api.key=YOUR-KEY
    openai.api.url=https://api.openai.com/v1/chat/completions

## Reference materials
<https://platform.openai.com/docs/api-reference/chat>
    
<https://cookbook.openai.com/>

    playground 를 활용하면 좋다.

## postman api test
<img width="807" alt="image" src="https://github.com/MungJeoNyeon/openAiApi_spring/assets/113886994/9ca49348-0943-4cbd-b484-9fe2c982f1c4">

## prompt 값 
        질문: 사용자마다 가지는 특정 조건을 제시, 몸무게 키 성별 목적(근육량 증가, 다이어트 등등)
        


