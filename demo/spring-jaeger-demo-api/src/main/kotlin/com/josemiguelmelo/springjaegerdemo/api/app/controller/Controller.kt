package com.josemiguelmelo.springjaegerdemo.api.app.controller

import com.josemiguelmelo.springjaegerdemo.api.app.service.QuoteService
import com.josemiguelmelo.springjaegerdemo.api.common.model.Quote
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api/v1")
class Controller(
    private val quoteService: QuoteService
) {
    private val logger = LoggerFactory.getLogger(Controller::class.java)

    @GetMapping("/quote")
    fun quotes(): Mono<Quote> {
        logger.info("Getting quote")
        return quoteService.getRandomQuote()
    }

    @GetMapping("/quote/generate/{numberOfQuotes}")
    fun generateQuote(@PathVariable numberOfQuotes: Int): Flux<Quote> {
        logger.info("Getting $numberOfQuotes quotes")
        return quoteService.generate(numberOfQuotes)
    }
}