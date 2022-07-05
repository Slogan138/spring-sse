package io.slogan.webmvc.sse.scheduler

import io.slogan.webmvc.sse.constant.EventConstant
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter
import java.io.IOException
import java.lang.IllegalStateException
import java.time.Instant
import java.util.concurrent.TimeoutException

@Component
class DataSendScheduler {
    val log: Logger = LoggerFactory.getLogger(this.javaClass)

    @Scheduled(fixedDelay = 10000)
    fun sendMessage() {
        EventConstant.session.forEach { (id, emitter) ->
            try {
                emitter.send(SseEmitter.event().name("data").data(Instant.now().epochSecond))
            } catch (ioException: IOException) {
                log.error(ioException.message)
            } catch (illegalStateException: IllegalStateException) {
                log.warn(illegalStateException.message)
                emitter.completeWithError(TimeoutException(""))
                EventConstant.session.remove(id)
            }
        }
    }
}