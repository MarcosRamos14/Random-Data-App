package com.example.randomdataapp.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UsersDTO(
    val id: Int?,
    val firstName: String?,
    val lastName: String?,
    val userName: String?,
    val email: String?,
    val imageUrl: String?,
    val phoneNumber: String?,
    val dateOfBirth: String?,
    val creditCard: CreditCardDTO?,
    val subscription: SubscriptionDTO?
) : Parcelable