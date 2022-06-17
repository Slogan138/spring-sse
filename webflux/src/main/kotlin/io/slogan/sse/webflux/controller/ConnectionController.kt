package io.slogan.sse.webflux.controller

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import java.time.Duration
import java.time.LocalTime

@RestController
class ConnectionController {

    @CrossOrigin
    @GetMapping(path = ["/connect"], produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun connect(): Flux<String>? {
        return Flux.interval(Duration.ofSeconds(2)).map { "Hello World!! " + LocalTime.now().toString() }
    }
}