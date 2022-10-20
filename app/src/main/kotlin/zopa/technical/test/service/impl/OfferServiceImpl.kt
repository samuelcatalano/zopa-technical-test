package zopa.technical.test.service.impl

import zopa.technical.test.exception.InsufficientOfferException
import zopa.technical.test.model.Loan
import zopa.technical.test.model.Offer
import zopa.technical.test.repository.OfferRepository
import zopa.technical.test.service.OfferService
import java.math.BigDecimal
import java.util.stream.Collectors

class OfferServiceImpl : OfferService {

    private val repository = OfferRepository()
    private var offers = repository.listAll()

    override fun getLoanOffers(loan: Loan): ArrayList<Offer> {
        val offerList = getAvailableOffers()

        val sumAvailableAmount = offers.stream().map { t: Offer -> t.available }.reduce(
            BigDecimal.valueOf(0)
        ) { a: BigDecimal?, b: BigDecimal? -> a!!.add(b) }

        if (sumAvailableAmount!! < loan.requestedAmount) {
            throw InsufficientOfferException()
        }

        var limit = BigDecimal(0)
        val applicableOffers = ArrayList<Offer>()

        for (offer in offerList) {
            limit = limit.add(offer.available)
            if (limit.compareTo(loan.requestedAmount) >= 0) {
                offer.neededAmount = offer.available!!.subtract(limit.subtract(loan.requestedAmount))
                applicableOffers.add(offer)
                break
            } else {
                offer.neededAmount = (offer.available)
                applicableOffers.add(offer)
            }
        }
        return applicableOffers
    }

    override fun getAvailableOffers(): ArrayList<Offer> {
        return offers.stream().sorted().collect(Collectors.toList()) as ArrayList<Offer>
    }
}