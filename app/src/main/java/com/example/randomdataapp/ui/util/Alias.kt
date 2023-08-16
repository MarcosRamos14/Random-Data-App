package com.example.randomdataapp.ui.util

import android.view.View
import com.example.randomdataapp.domain.models.UsersDTO

typealias OnItemClick = (person: UsersDTO, view: View) -> Unit