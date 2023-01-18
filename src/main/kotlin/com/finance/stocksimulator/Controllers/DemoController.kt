package com.finance.stocksimulator.Controllers

import com.finance.stocksimulator.Services.KeyService
import com.finance.stocksimulator.alphaVantageAPI.FetchAlphaVantageDataAPI
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class DemoController(private val keyService: KeyService,
                     private val fetchData: FetchAlphaVantageDataAPI) {

    @GetMapping("/pe")
    fun stockKeyData(): String {

        val demoData = fetchData.fetchSingleWithJackson("IBM", "OVERVIEW")

        return demoData.toString()

    }
}