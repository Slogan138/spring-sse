package io.slogan.web.sse.scheduler

import io.slogan.web.sse.constant.EventConstant
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.time.Instant

@Component
class DataSendScheduler {

    @Scheduled(fixedDelay = 10000)
    fun sendMessage() {
        EventConstant.session.forEach { (id, emitter) ->
            emitter.send(id + Instant.now().epochSecond)
        }
    }
}