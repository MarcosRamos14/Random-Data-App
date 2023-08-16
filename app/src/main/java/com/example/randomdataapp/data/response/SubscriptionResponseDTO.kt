package com.example.randomdataapp.data.response

import androidx.annotation.Keep
import com.example.randomdataapp.domain.models.SubscriptionDTO
import com.google.gson.annotations.SerializedName

@Keep
data class SubscriptionResponseDTO(
    val plan: String?,
    val status: String?,
    @SerializedName("payment_method")
    val paymentMethod: String,
    val term: String?
)

fun SubscriptionResponseDTO.toSubscriptionModel() : SubscriptionDTO {
    return SubscriptionDTO(
        plan = plan,
        status = status,
        paymentMethod = paymentMethod,
        term = term
    )
}