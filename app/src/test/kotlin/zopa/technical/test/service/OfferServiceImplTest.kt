package zopa.technical.test.service

import junit.framework.Assert.assertEquals
import org.junit.Test
import zopa.technical.test.exception.InsufficientOfferException
import zopa.technical.test.model.Loan
import zopa.technical.test.model.Offer
import zopa.technical.test.service.impl.OfferServiceImpl
import java.io.IOException
import java.math.BigDecimal

class OfferServiceImplTest {

    private val service = OfferServiceImpl()

    companion object {
        const val JANE = "Jane"
        const val MARY = "Mary"
        const val OFFERS_SIZE = 7
    }

    @Test
    @Throws(Exception::class)
    fun get_available_offers_sorted_by_first() {
        val offers: List<Offer> = service.getAvailableOffers()
        assertEquals(JANE, offers[0].lender)
    }

    @Test
    @Throws(Exception::class)
    fun get_available_offers_sorted_by_last() {
        val offers: List<Offer> = service.getAvailableOffers()
        assertEquals(MARY, offers[6].lender)
    }

    @Test
    fun validate_number_offers_available() {
        val offers: List<Offer> = service.getAvailableOffers()
        assertEquals(OFFERS_SIZE, offers.size)
    }

    @Test(expected = InsufficientOfferException::class)
    @Throws(Exception::class)
    fun validate_insufficient_available_amount() {
        val loan = Loan()
        loan.requestedAmount = BigDecimal.valueOf(5000)
        val offers: List<Offer> = service.getLoanOffers(loan)
    }
}