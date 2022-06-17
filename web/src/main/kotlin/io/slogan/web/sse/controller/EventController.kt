package io.slogan.web.sse.controller

import io.slogan.web.sse.constant.EventConstant
import lombok.extern.slf4j.Slf4j
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter

@Slf4j
@RestController
class EventController {

    @CrossOrigin
    @GetMapping("/connect")
    fun connect(@RequestParam id: String): SseEmitter {
        val sseEmitter = SseEmitter(10 * 60 * 1000)
        sseEmitter.send(hashMapOf("status" to "connected"))

        EventConstant.session[id] = sseEmitter
        return sseEmitter
    }
}