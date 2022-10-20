package zopa.technical.test.service

import zopa.technical.test.exception.InsufficientOfferException
import zopa.technical.test.model.Loan
import zopa.technical.test.model.Offer
import java.io.IOException
import java.io.Serializable

interface OfferService : Serializable {

    @Throws(InsufficientOfferException::class, IOException::class)
    fun getLoanOffers(loan: Loan): ArrayList<Offer>

    @Throws(InsufficientOfferException::class, IOException::class)
    fun getAvailableOffers(): ArrayList<Offer>
}