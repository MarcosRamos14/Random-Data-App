package com.example.randomdataapp.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CreditCardDTO(
    val number: String?
) : Parcelable