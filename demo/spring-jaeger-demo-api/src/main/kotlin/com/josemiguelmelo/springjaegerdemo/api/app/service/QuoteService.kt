package com.josemiguelmelo.springjaegerdemo.api.app.service

import com.josemiguelmelo.springjaegerdemo.api.app.repository.QuoteRepository
import com.josemiguelmelo.springjaegerdemo.api.common.client.QuotesApiClient
import com.josemiguelmelo.springjaegerdemo.api.common.model.Quote
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class QuoteService(
    private val quoteRepository: QuoteRepository,
    private val quotesApiClient: QuotesApiClient,
) {
    private val logger = LoggerFactory.getLogger(QuoteService::class.java)

    fun getRandomQuote(): Mono<Quote> {
        val quote = quoteRepository.findAll().randomOrNull() ?: return Mono.empty()
        return Mono.just(quote)
    }

    fun generate(numberOfQuotes: Int): Flux<Quote> {
        val quotes = (0..numberOfQuotes).map {
            generateQuote()
        }
        return Flux.fromIterable(quotes)
    }

    fun generateQuote(): Quote {
        val quoteFromApi = quotesApiClient.getRandomQuote()?.also {
            logger.info("Fetched the following quote: $it")
        } ?: throw Exception("Failed to generate quote")

        val quote = Quote(
            quote = quoteFromApi.content,
            author = quoteFromApi.author
        )
        return quoteRepository.save(quote)
    }
}