package com.example.randomdataapp.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class EmploymentDTO(
    val title: String?,
    val keySkill: String?
) : Parcelable