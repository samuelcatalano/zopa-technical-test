package zopa.technical.test.helper

import junit.framework.Assert.assertTrue
import org.junit.Test
import zopa.technical.test.exception.InvalidRequestAmountException
import zopa.technical.test.model.Loan
import java.math.BigDecimal

class ValidationHelperTest {

    private val helper = ValidationHelper

    @Test(expected = InvalidRequestAmountException::class)
    @Throws(InvalidRequestAmountException::class)
    fun validate_amount_value_over_the_range() {
        val loan = Loan()
        loan.requestedAmount = BigDecimal.valueOf(999)
        helper.validateLoan(loan)
    }

    @Test(expected = InvalidRequestAmountException::class)
    @Throws(InvalidRequestAmountException::class)
    fun validate_amount_value_below_the_range() {
        val loan = Loan()
        loan.requestedAmount = BigDecimal.valueOf(1501)
        helper.validateLoan(loan)
    }

    @Test(expected = InvalidRequestAmountException::class)
    @Throws(InvalidRequestAmountException::class)
    fun validate_amount_not_possible_to_increment() {
        val loan = Loan()
        loan.requestedAmount = BigDecimal.valueOf(1111)
        helper.validateLoan(loan)
    }

    @Test
    fun validate_requested_amount_isValid() {
        val loan = Loan()
        loan.requestedAmount = BigDecimal.valueOf(1200)
        assertTrue(helper.validateLoan(loan))
    }
}