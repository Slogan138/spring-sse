package io.slogan.web.sse.service

import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class EventDataService: IEventDateService {

    val connectedSession = mutableListOf<String>()

    @Cacheable(cacheNames = ["event"], key = "#type")
    override fun create(type: String): List<String> {
        connectedSession.plus(type)
        return connectedSession
    }

    @CacheEvict(cacheNames = ["event"], key = "#type")
    override fun delete(type: String) {
        connectedSession.clear()
    }
}