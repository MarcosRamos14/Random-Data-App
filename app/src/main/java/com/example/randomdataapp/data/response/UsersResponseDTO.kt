package com.example.randomdataapp.data.response

import androidx.annotation.Keep
import com.example.randomdataapp.domain.models.UsersDTO
import com.google.gson.annotations.SerializedName

@Keep
data class UsersResponseDTO(
    val id: Int?,
    @SerializedName("first_name")
    val firstName: String?,
    @SerializedName("last_name")
    val lastName: String?,
    @SerializedName("username")
    val userName: String?,
    val email: String?,
    @SerializedName("avatar")
    val imageUrl: String?,
    @SerializedName("phone_number")
    val phoneNumber: String?,
    @SerializedName("date_of_birth")
    val dateOfBirth: String?,
    @SerializedName("credit_card")
    val creditCard: CreditCardResponseDTO?,
    val subscription: SubscriptionResponseDTO?,
    val employment: EmploymentResponseDTO?
)

fun UsersResponseDTO.toUsersModel() : UsersDTO {
    return UsersDTO(
        id = id,
        firstName = firstName,
        lastName = lastName,
        userName = userName,
        email = email,
        imageUrl = imageUrl,
        phoneNumber = phoneNumber,
        dateOfBirth = dateOfBirth,
        creditCard = creditCard?.toCreditCardModel(),
        subscription = subscription?.toSubscriptionModel(),
        employment = employment?.toEmploymentModel()
    )
}