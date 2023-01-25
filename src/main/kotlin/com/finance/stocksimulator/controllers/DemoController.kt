package com.finance.stocksimulator.controllers

import com.finance.stocksimulator.alphaVantageAPI.service.AlphaStockApiService
import com.finance.stocksimulator.calculations.keyFigures.KeyFiguresCalcs
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class DemoController( private val alphaApiService: AlphaStockApiService,
    private val keyCalcs: KeyFiguresCalcs) {

    @GetMapping("/specific-data/{symbol}/{data}")
    fun stockData(@PathVariable symbol: String, @PathVariable data: String): String {
        return alphaApiService.fetchSingleAlphaData(symbol, data).toString()
    }

    @GetMapping("/all-data/{symbol}")
    fun stockAllData(@PathVariable symbol: String): String{
        val stockAllData = alphaApiService.fetchAllAlphaData(symbol)

        return keyCalcs.priceEarningsRatio(
            stockAllData.globalQuote?.previousclose?.toFloat()!!,
            stockAllData.earningsPerShare.toFloat())
            .toString()
    }

}