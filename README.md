# Spring으로 SSE 구현하기

## SSE란?
![WebSocket_Data_Flow](/readme_image/sse-diagram.jpeg)   
Server Sent Event의 줄임말로 문자 그대로 해석하자면 서버에서 보내준 이벤트라는 의미이다.   
전통적인 HTTP Request의 경우 Client에서 Server로 요청을 보냈을 때 Server에서 Client로 응답을 주는 1회성 통신이다.   
하지만 SSE의 경우 Client에서 Server로 event stream 생성 요청을 보내고 생성된 stream을 통신 통로로 사용하게 된다. 이렇게 생성된 통로를 이용하여 Client의 요청 없이 Server에서 데이터를 넘겨줄 수 있게 된다.

## SSE의 필요성
Client(Browser)에서 주기적으로 데이터를 가져와야 한다면 여러가지 방법을 선택할 수 있다.

1. Polling(Short, Long)
2. HTTP Streaming
3. WebSocket
4. Server Sent Event

위에 나열한 4가지의 기술로 이를 해결할 수 있다. 다만 각 기술마다의 장단점은 있으니 상황에 맞는 적절한 방법을 택해야 한다.

## Feature
- WebSocket과 달리 별도의 Protocol을 사용하지 않고 HTTP Protocol을 이용한다.
- HTTP/1.1 은 브라우저에서 도메인당 EventStream 최대 6개이다. HTTP/2 는 최대 100개까지 가능하다.
- 접속에 문제가 생겼을 경우 자동으로 재접속 요청을 보내어 다시 데이터를 받을 수 있게 한다.

## Websocket과 비교
![websocket_vs_sse](/readme_image/websocket_vs_sse.jpeg)   
Server와 Client간의 Real Time Notification 구현을 위해서 Websocket과 SSE를 많이 채택한다.   

### Websocket Feature
- Websocket Protocol을 이용하여 데이터를 주고 받을 수 있는 통로를 연결하여 매번 요청과 응답을 반복하지 않고 통신을 한다.
- SSE는 Server에서 Client로 보내주는 단방향 통신이지만 Websocket은 Server와 Client간 양방향 통신이 가능하다.

다만 Server, Client간의 양방향 통신이 필요 없다면 SSE를 사용하는것 보다 오버헤드가 크기때문에 상황에 맞게 Websocket과 SSE를 선택하여 사용하여야 한다.

## Servlet Stack
Web MVC(Servlet Stack)을 사용한다면 SSE를 위한 클래스인 SseEmitter를 Spring Framework 4.2부터 지원하기 시작하였다. 때문에 이를 이용하면 손쉽게 SSE를 구현할 수 있다.   

[예제코드](/web/src/main/kotlin/io/slogan/web/sse/controller/EventController.kt)

## Reactive Stack
WebFlux(Reactive Stack)를 사용한다면 reactor의 Flux 객체를 이용하여 구현할 수 있다.

[예제코드](/webflux/src/main/kotlin/io/slogan/sse/webflux/controller/ConnectionController.kt)

---
### Reference.
https://www.baeldung.com/spring-server-sent-events   
https://dongdd.tistory.com/181   
