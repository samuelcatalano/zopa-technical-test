package zopa.technical.test.repository

import zopa.technical.test.model.Offer
import zopa.technical.test.util.CSVInMemory
import java.io.FileNotFoundException
import java.io.Serializable

class OfferRepository : Serializable {

    private val csvInMemory = CSVInMemory()

    @Throws(FileNotFoundException::class)
    fun listAll(): ArrayList<Offer> {
        return csvInMemory.readAndConvertLoansFromCSVFile()
    }
}