package com.r3.corda.finance.ripple.utilities

import com.r3.corda.finance.obligation.types.DigitalCurrency
import com.r3.corda.finance.ripple.types.TransactionInfoResponse
import com.ripple.core.coretypes.hash.Hash256
import net.corda.core.contracts.Amount
import net.corda.core.crypto.SecureHash
import net.corda.finance.AMOUNT
import com.ripple.core.coretypes.Amount as XRPAmount

fun TransactionInfoResponse.hasSucceeded() = status == "success" && validated

fun Amount<*>.toXRPAmount(): XRPAmount = XRPAmount.fromString(quantity.toString())

fun Int.toXRPAmount(): XRPAmount = XRPAmount.fromString(toString())

fun SecureHash.toXRPHash(): Hash256 = Hash256.fromHex(toString())

val DEFAULT_XRP_FEE = XRPAmount.fromString("1000")

@JvmField
val XRP: DigitalCurrency = DigitalCurrency.getInstance("XRP")

fun RIPPLES(amount: Int): Amount<DigitalCurrency> = AMOUNT(amount, XRP)
fun RIPPLES(amount: Long): Amount<DigitalCurrency> = AMOUNT(amount, XRP)
fun RIPPLES(amount: Double): Amount<DigitalCurrency> = AMOUNT(amount, XRP)

val Int.XRP: Amount<DigitalCurrency> get() = RIPPLES(this)
val Long.XRP: Amount<DigitalCurrency> get() = RIPPLES(this)
val Double.XRP: Amount<DigitalCurrency> get() = RIPPLES(this)