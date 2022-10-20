package zopa.technical.test.model

import zopa.technical.test.model.base.BaseModel
import java.math.BigDecimal

class Loan : BaseModel() {

    var requestedAmount: BigDecimal? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Loan

        if (requestedAmount != other.requestedAmount) return false

        return true
    }

    override fun hashCode(): Int {
        return requestedAmount?.hashCode() ?: 0
    }
}