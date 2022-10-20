package zopa.technical.test.service

import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import zopa.technical.test.model.Loan
import zopa.technical.test.model.Offer
import zopa.technical.test.service.impl.CalculationServiceImpl
import zopa.technical.test.service.impl.OfferServiceImpl
import java.math.BigDecimal
import java.math.RoundingMode

class CalculationServiceImplTest {

    private val offerService = OfferServiceImpl()

    private var calculationService: CalculationServiceImpl? = null
    private var loan: Loan? = null
    private var offers: List<Offer>? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {
        loan = Loan()
        loan!!.requestedAmount = BigDecimal.valueOf(1000)
        offers = offerService.getLoanOffers(loan!!)
        calculationService  = CalculationServiceImpl(offers as ArrayList<Offer>)
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {
    }

    @Test
    @Throws(Exception::class)
    fun validate_average_rate() {
        assertEquals(0.07, calculationService!!.getAverageRate())
    }

    @Test
    @Throws(java.lang.Exception::class)
    fun validate_monthly_payment() {
        assertEquals(BigDecimal.valueOf(31).setScale(2, RoundingMode.CEILING),
                     calculationService!!.getMonthlyPayment())
    }

    @Test
    @Throws(java.lang.Exception::class)
    fun validate_total_payment() {
        assertEquals(BigDecimal.valueOf(1116).setScale(2, RoundingMode.CEILING),
                     calculationService!!.getTotalPayment()
        )
    }
}