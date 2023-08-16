package com.example.randomdataapp.data.response

import androidx.annotation.Keep
import com.example.randomdataapp.domain.models.CreditCardDTO
import com.example.randomdataapp.domain.models.EmploymentDTO
import com.google.gson.annotations.SerializedName

@Keep
data class EmploymentResponseDTO(
    val title: String?,
    @SerializedName("key_skill")
    val keySkill: String?
)

fun EmploymentResponseDTO.toEmploymentModel() : EmploymentDTO {
    return EmploymentDTO(
        title = title,
        keySkill = keySkill
    )
}