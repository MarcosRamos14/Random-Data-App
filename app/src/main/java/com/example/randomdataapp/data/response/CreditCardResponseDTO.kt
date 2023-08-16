package com.example.randomdataapp.data.response

import androidx.annotation.Keep
import com.example.randomdataapp.domain.models.CreditCardDTO
import com.google.gson.annotations.SerializedName

@Keep
data class CreditCardResponseDTO(
    @SerializedName("cc_number")
    val number: String?
)

fun CreditCardResponseDTO.toCreditCardModel() : CreditCardDTO {
    return CreditCardDTO(
        number = number
    )
}