package io.slogan.webmvc.sse.constant

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter
import java.util.concurrent.ConcurrentHashMap

object EventConstant {
    val session = ConcurrentHashMap<String, SseEmitter>()
}