package io.slogan.webmvc.sse.controller

import io.slogan.webmvc.sse.constant.EventConstant
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter

@RestController
class EventController {

    @CrossOrigin
    @GetMapping("/connect")
    fun connect(@RequestParam id: String): SseEmitter {
        val sseEmitter = SseEmitter(15 * 1000)
        sseEmitter.send(SseEmitter.event().name("connection").data("connected"))

        EventConstant.session[id] = sseEmitter
        return sseEmitter
    }
}