# 졸업작품 건강
Ai를 이용해 개인화 맞춤형 건강한 식단, 운동, 영양제 추천을 할 수 있는 웹서비스입니다.

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

4. 메뉴 페이지에는 3가지 카테고리를 통해 식단, 운동, 영양제 정보를 얻을 수 있다.
    - 카테고리 식단 페이지에는...식단 이미지와 식단 이름이 존재한다.
    - 카테고리 운동 페이지에는...운동 이미지와 운동 이름이 존재한다.
    - 카테고리 영양제 페이지에는...영양제 이미지와 영양제 이름이 존재한다.

5. 메뉴 페이지에서 이미지 그리고 이름을 클릭하면 메뉴 상세 페이지로 이동한다.
    - 상세 페이지에는 자세한 정보를 제공하는 텍스트와 이미지가 존재한다.
    - 영양제 상세 페이지에는 주문하기 버튼, 장바구니에 담기 버튼 및 아이콘이 존재한다.

3. 장바구니에 담은 모든 영양제 메뉴를 장바구니 페이지에서 주문 가능하며...
    - 장바구니에 담은 영양제 메뉴 수량을 수정할 수 있는 버튼이 존재한다.
    - 장바구니 페이지에는 결제 버튼이 존재하며, 클릭 시 결제 페이지로 이동한다.

4. 결제 페이지에는 주문자 정보를 입력하고, 결제 방식을 선택한다.
    - 포트원 맞춤형 결제 api를 이용하여 주문자에게 결제 서비스를 제공할 예정...

5. 주문 내역 페이지에서 주문 상세 정보 및 주문 완료 문구가 띄워지며, 주문 취소 및, 주문 내역 삭제가 가능하다.
    - 주문 상세 정보는 주문 메뉴, 총 결제금액, 문의사항이 표기된다.
    - 주문 취소 버튼 및 주문 내역 삭제 버튼이 존재한다.

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

## run response 값 
        질문: 사용자마다 가지는 특정 조건을 제시, 몸무게 키 성별 목적(근육량 증가, 다이어트 등등)
        
<img width="1747" alt="image" src="https://github.com/MungJeoNyeon/openAiApi_spring/assets/113886994/84059dc4-c42f-487e-ba07-9583959eea07">

