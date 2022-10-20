package zopa.technical.test.model

import java.math.BigDecimal

class Offer : Comparable<Offer> {

    val lender: String? = null
    val rate = 0.0
    val available: BigDecimal? = null
    var neededAmount = BigDecimal.ZERO
    var monthlyPayment = BigDecimal.ZERO

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Offer

        if (lender != other.lender) return false
        if (rate != other.rate) return false
        if (available != other.available) return false
        if (neededAmount != other.neededAmount) return false
        if (monthlyPayment != other.monthlyPayment) return false

        return true
    }

    override fun hashCode(): Int {
        var result = lender?.hashCode() ?: 0
        result = 31 * result + rate.hashCode()
        result = 31 * result + available.hashCode()
        result = 31 * result + neededAmount.hashCode()
        result = 31 * result + monthlyPayment.hashCode()
        return result
    }

    override fun compareTo(other: Offer): Int {
        return if (this.rate == other.rate) 0 else if (this.rate > other.rate) 1 else -1
    }
}