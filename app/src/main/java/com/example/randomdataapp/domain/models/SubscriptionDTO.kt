package com.example.randomdataapp.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SubscriptionDTO(
    val plan: String?,
    val status: String?,
    val paymentMethod: String,
    val term: String?
) : Parcelable