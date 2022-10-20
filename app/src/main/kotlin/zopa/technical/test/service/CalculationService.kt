package zopa.technical.test.service

import java.math.BigDecimal

interface CalculationService {

    fun getMonthlyPayment(): BigDecimal

    fun getTotalPayment(): BigDecimal

    fun getAverageRate(): Double
}