package zopa.technical.test.util

import com.opencsv.bean.CsvToBean
import com.opencsv.bean.CsvToBeanBuilder
import zopa.technical.test.model.Loan
import zopa.technical.test.model.Offer
import java.io.*
import java.util.logging.Level
import java.util.logging.Logger

class CSVInMemory : Serializable {

    var PATH_TO_FILE = "src/main/resources/lenders_entry.csv"
    var logger: Logger = Logger.getLogger(CSVInMemory::class.java.name)

    @Throws(FileNotFoundException::class)
    fun readAndConvertLoansFromCSVFile(): ArrayList<Offer> {
        try {
            BufferedReader(InputStreamReader(FileInputStream(PATH_TO_FILE))).use { reader ->
                val csvToBean: CsvToBean<Offer> = CsvToBeanBuilder<Offer>(reader)
                    .withType(Offer::class.java)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build()
                return csvToBean.parse() as ArrayList<Offer>
            }
        } catch (e: IOException) {
            logger.log(Level.SEVERE, "Error parsing CSV file!")
            throw FileNotFoundException(e.message)
        }
    }
}