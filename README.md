# Spring Boot SSE 구현하기

## SSE란?
Server Sent Event의 줄임말로 문자 그대로 해석하자면 서버에서 보내준 이벤트라는 의미이다.   
전통적인 HTTP Request의 경우 Client에서 Server로 요청을 보냈을 때 Server에서 Client로 응답을 주는 1회성 통신이다.   
하지만 SSE의 경우 Client에서 Server로 event stream 생성 요청을 보내고 생성된 stream을 통신 통로로 사용하게 된다. 이렇게 생성된 통로를 이용하여 Client의 요청 없이 Server에서 데이터를 넘겨줄 수 있게 된다.

## SSE의 필요성
Client(Browser)에서 주기적으로 데이터를 가져와야 한다면 여러가지 방법을 선택할 수 있다.

1. API Polling, Long Polling
2. HTTP Streaming
3. WebSocket
4. Server Sent Event

위에 나열한 4가지의 기술로 이를 해결할 수 있다.

## Servlet Stack
Servlet Stack 은 SSE를 위한 클래스인 SseEmitter를 Spring Framework 4.2부터 지원하기 시작하였다. 때문에 이를 이용하면 손쉽게 SSE를 구현할 수 있다.

## Reactive Stack
Reactive Stack 은 reactore에서 제공해 주는 클래스인 Flux를 이용하면 손쉽게 SSE를 구현할 수 있다.

---
### Reference.
https://www.baeldung.com/spring-server-sent-events   
https://dongdd.tistory.com/181   
