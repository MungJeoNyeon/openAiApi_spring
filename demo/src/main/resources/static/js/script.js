document.addEventListener('DOMContentLoaded', function () {
    document.getElementById('send-btn').addEventListener('click', sendMessage);
    document.getElementById('user-input').addEventListener('keypress', function (event) {
        if (event.key === 'Enter') {
            event.preventDefault();
            sendMessage();
        }
    });
});

let lastUserPrompt = ''; // 사용자의 마지막 프롬프트를 저장할 전역 변수

function sendMessage() {
    const userInput = document.getElementById('user-input');
    //const message = userInput.value.trim();
    const message = "오늘 저녁 식사 추천해줘.";

    if (!message) {
        alert('Please enter a message.');
        return;
    }

    // This should be updated before the fetch call
    //lastUserPrompt = "오늘 저녁 식사 추천해줘.";
    lastUserPrompt = message;

    const encodedPrompt = encodeURIComponent(message);

    console.log(`Sending prompt: '${message}'`);

    fetch(`http://localhost:8080/bot/chat?prompt=${encodedPrompt}`, { method: 'GET' })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok.');
            }
            return response.text();
        })
        .then(displayResponse)
        .catch(error => console.error('Error:', error));


    userInput.value = ''; // Clear the input field after sending the message.
}


function displayResponse(text) {
    const chatBox = document.getElementById('chat-box');
    // 사용자 프롬프트를 채팅 박스에 표시
    appendMessage(`You: ${lastUserPrompt}`, 'user', chatBox);
    // 서버로부터 받은 응답을 채팅 박스에 추가
    appendMessage(`Bot: ${text}`, 'bot', chatBox);
}

function appendMessage(message, className, chatBox) {
    const messageDiv = document.createElement('div');
    messageDiv.textContent = message; // 메시지 내용 설정
    messageDiv.classList.add('message', className); // 메시지 스타일 적용
    chatBox.appendChild(messageDiv); // 채팅 박스에 메시지 추가
    chatBox.scrollTop = chatBox.scrollHeight; // 스크롤을 가장 아래로 이동하여 최신 메시지 표시
}


// 공유한 내용 외에 예기치 않게 sendMessage 기능을 트리거할 수 있는 추가 코드가 없는지 확인하십시오.
// 함수가 빈 값 또는 null 값으로 호출되고 있음을 나타내는 로그("Sending prompt: ")가 표시되는 경우 요청 로직 자체가 아니라
// 이벤트 수신자가 트리거되는 방법 또는 시점에 문제가 발생할 수 있음을 나타냅니다.
