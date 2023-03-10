package com.finance.stocksimulator.financials.calculations

import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class KeyFiguresCalcs() {

    companion object KeyCalcs {

//        EPS
        fun earningsPerShare(amountShares: String, profit: String): Double?{

            return try {
                val amountSharesNum = amountShares.toDouble()
                val profitNum = profit.toLong()
                profitNum.div(amountSharesNum)
            }catch (e: Exception){
                return null
            }

        }

//        pe-ratio
        fun priceEarningsRatio(stockPrice: String, profitLoss: String, amountShares: String): Double? {

            return try{
                stockPrice.toDouble().div(profitLoss.toLong().div(amountShares.toLong()))
            }catch (e: Exception){
                return null
            }
        }

//      revenue growth
        fun revenueGrowthPercentage(latestYearEarnings: String, yearBeforeEarnings: String): Double?{

            return try{
                (latestYearEarnings.toDouble().minus(yearBeforeEarnings.toLong()).div(yearBeforeEarnings.toLong()))
                    .times(100)
            }catch (e: Exception){
                return null
            }
        }

//      ratio debt to equity
        fun deptToEquity(totalDebt: String, shareholderEquity: String): Double? {

            return try{
                totalDebt.toDouble().div(shareholderEquity.toLong())
            }catch (e: Exception){
                return null
            }
        }

//        return on equity basic(ROE)
        fun returnOnEquityBasic(netIncome: String, shareholderEquity: String): Double?{

            return try {
                netIncome.toDouble().div(shareholderEquity.toDouble()).times(100)
            }catch (e: Exception){
                return null
            }
        }

//        return on equity dupont model
        fun returnOnEquityDupont(netIncome: String, totalAssets: String,
                                 totalEquity: String): Int?{

            return try {
                val netProfitMarginPercentage = (netIncome.toDouble().div(totalEquity.toDouble()))

                val assetTurnoverPercentage = netIncome.toDouble().div(totalAssets.toLong())

                val financialLeverage = totalAssets.toLong().div(totalEquity.toDouble())

                (netProfitMarginPercentage * assetTurnoverPercentage * financialLeverage).times(100).toInt()
            }catch (e: Exception){
                return null
            }
        }

        //        gross margin
        fun grossMarginPercentage(revenue: String, costGoodsSold: String): Double? {

            return try {
                val step1 = revenue.toDouble().minus(costGoodsSold.toLong())
                val step2 = step1.div(revenue.toDouble())
                step2.times(100)
            }catch (e: Exception){
                return null
            }

        }

//        operation margin
        fun operationMarginPercentage(grossProfit: String, operatingExpenses: String, revenue: String): Double?{
            return try {
                (grossProfit.toDouble().minus(operatingExpenses.toLong())).div(revenue.toLong()).times(100)
            }catch (e: Exception){
                return null
            }
        }

//        market capitalization
        fun marketCapitalization(stockPrice: String, sharesAmount: String): Long?{

            return try {
                stockPrice.toDouble().times(sharesAmount.toLong()).toLong()
            }catch (e: Exception){
                return null
            }

        }

       fun betaValue(betaValue: String): Double?{
           return try{
               betaValue.toDouble()
           }catch (e: Exception){
               return null
           }
       }

//        volatility calculation
        fun volatility(){
            TODO("need to access stock price to calculate")
        }

//      profit margin
        fun profitMargin(netIncome: String, revenue: String): Double?{
            return try{
                (netIncome.toDouble()
                    .div(revenue.toDouble())
                ).times(100)
            }catch (e: Exception){
                return null
            }
        }

//      operting margin
        fun operatingMargin(operatingIncome: String, revenue: String): Double?{

            return try{
                (operatingIncome.toDouble().div(revenue.toDouble())).times(100)
            }catch (e: Exception){
                return null
            }
        }

//      net margin
        fun netMargin(netIncome: String, revenue: String): Double?{
            return try{
                (netIncome.toDouble().div(revenue.toDouble())).times(100)
            }catch (e: Exception){
                return null
            }
        }

//      ebitda
        fun ebitda(revenue: String, costGoodsSold: String, operatingExpenses: String,
                   depreciation: String, amortization: String): Double?{

            return try {
                revenue.toDouble().minus(costGoodsSold.toDouble())
                    .minus(operatingExpenses.toDouble())
                    .plus(depreciation.toDouble())
                    .plus(amortization.toDouble())
            }catch (e: Exception){
                return null
            }
        }

//        pre tax margin
        fun preTaxMargin(incomeBeforeTax: String, revenue: String): Double?{
            return try {
                (incomeBeforeTax.toDouble().div(revenue.toDouble())).times(100)
            }catch (e: Exception){
                return null
            }
        }

//        dividend yield
        fun dividendYieldPercentage(annualDividendPerShare: String, stockPrice: String): Double?{
            return try {
                annualDividendPerShare.toDouble().div(stockPrice.toDouble()).times(100)
            }catch (e: Exception){
                return null
            }
        }

    }

}
