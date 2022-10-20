package zopa.technical.test.exception

import java.lang.Exception

open class InvalidRequestAmountException : Exception {

    constructor(message: String?) : super(message)
    protected constructor(
        message: String?,
        cause: Throwable?,
        enableSuppression: Boolean,
        writableStackTrace: Boolean
    ) : super(message, cause, enableSuppression, writableStackTrace)
}