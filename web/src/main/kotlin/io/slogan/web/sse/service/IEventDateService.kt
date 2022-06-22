package io.slogan.web.sse.service

interface IEventDateService {

    fun create(type: String): List<String>

    fun delete(type: String)
}