package zopa.technical.test.exception

class InsufficientOfferException : RuntimeException() {

    override val message: String
        get() = "Insufficient offers from lenders"
}