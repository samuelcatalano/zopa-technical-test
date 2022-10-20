package zopa.technical.test.service.impl

import zopa.technical.test.constant.Constants.TERM_MONTHS
import zopa.technical.test.model.Offer
import zopa.technical.test.service.CalculationService
import java.math.BigDecimal
import java.math.MathContext
import java.math.RoundingMode
import java.util.function.Consumer
import kotlin.math.pow
import kotlin.math.roundToLong

class CalculationServiceImpl(private var offers: List<Offer>) : CalculationService {

    override fun getMonthlyPayment(): BigDecimal {
        val mc = MathContext(2, RoundingMode.HALF_DOWN)

        offers.forEach(Consumer { offer: Offer ->
            val offerMonthlyRate = offer.rate / 12
            val offerMonthlyPayment = offer.neededAmount.multiply(BigDecimal.valueOf(offerMonthlyRate))
                .divide(BigDecimal.valueOf(1 - (1 + offerMonthlyRate).pow((-TERM_MONTHS).toDouble())), mc)
            offer.monthlyPayment = offerMonthlyPayment
        })

        var totalMonthly = BigDecimal.valueOf(0)
        for (offer in offers) {
            totalMonthly = totalMonthly.add(offer.monthlyPayment)
        }

        return totalMonthly.setScale(2, RoundingMode.UNNECESSARY)
    }

    override fun getAverageRate(): Double {
        val averageRate = offers.stream().mapToDouble { t: Offer -> t.rate }.average().asDouble
        return (averageRate * 1000.0).roundToLong() / 1000.0
    }

    override fun getTotalPayment(): BigDecimal {
        return this.getMonthlyPayment().multiply(BigDecimal.valueOf(TERM_MONTHS.toLong()))
                   .setScale(2, RoundingMode.UNNECESSARY)
    }
}