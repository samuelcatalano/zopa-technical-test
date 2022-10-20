package zopa.technical.test

import zopa.technical.test.helper.ValidationHelper
import zopa.technical.test.model.Loan
import zopa.technical.test.model.Offer
import zopa.technical.test.service.impl.CalculationServiceImpl
import zopa.technical.test.service.impl.OfferServiceImpl
import java.math.BigDecimal

class App {

    private val offerService = OfferServiceImpl()
    private val helper = ValidationHelper
    private val loan = Loan()

    fun run(args: Array<String>) {
        loan.requestedAmount = BigDecimal.valueOf(args[0].toDouble())
        val offers: List<Offer> = offerService.getLoanOffers(loan)

        if (helper.validateLoan(loan)) {
            val calculationService = CalculationServiceImpl(offers)

            // print the result
            println("")
            println("Request Amount: £" + String.format("%.0f", loan.requestedAmount))
            println("Rate: " + String.format("%.1f", calculationService.getAverageRate() * 100) + "%")
            println("Monthly repayment £" + String.format("%.2f", calculationService.getMonthlyPayment()))
            println("Total repayment: £" + String.format("%.2f", calculationService.getTotalPayment()))
            println("")
        }
    }
}

fun main(args: Array<String>) {
    if (!isNumericValue(args[0])) {
        print("Please, insert a numeric value!")
        return
    }

    println(App().run(args))
}

fun isNumericValue(arg: String): Boolean {
    return arg.chars().allMatch(Character::isDigit)
}