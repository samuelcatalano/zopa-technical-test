package zopa.technical.test.helper

import zopa.technical.test.constant.Constants.INCREMENT_AMOUNT
import zopa.technical.test.constant.Constants.LOWER_RANGE
import zopa.technical.test.constant.Constants.UPPER_RANGE
import zopa.technical.test.exception.InvalidRequestAmountException
import zopa.technical.test.model.Loan

object ValidationHelper {

    @Throws(InvalidRequestAmountException::class)
    fun validateLoan(loan: Loan): Boolean {
        if (loan.requestedAmount!! < LOWER_RANGE || loan.requestedAmount!! > UPPER_RANGE) {
            throw InvalidRequestAmountException("The requested amount is out of range 1000 and 15000")
        }
        val remainder = loan.requestedAmount!!.remainder(INCREMENT_AMOUNT)
        if (remainder.intValueExact() > 0) {
            throw InvalidRequestAmountException("The requested amount is not incremental of 100")
        }
        return true
    }
}