package com.example.randomdataapp.ui.details

import androidx.recyclerview.widget.DiffUtil
import com.example.randomdataapp.domain.models.CreditCardDTO
import com.example.randomdataapp.domain.models.SubscriptionDTO
import com.example.randomdataapp.domain.models.UsersDTO

sealed class DetailsAdapterItem {

    abstract val diffId: String
    abstract val viewType: Int

    data class CardDetails(
        val creditCard: CreditCardDTO?,
        val subscription: SubscriptionDTO?
    ) : DetailsAdapterItem() {
        override val diffId: String get() = creditCard?.number.toString()
        override val viewType: Int get() = CARD_TYPE
    }

    data class RegisterDetails(
        val userInfo: String
    ) : DetailsAdapterItem() {
        override val diffId: String get() = userInfo
        override val viewType: Int get() = REGISTER_TYPE
    }

    companion object {
        const val CARD_TYPE = 1
        const val REGISTER_TYPE = 2

        val diff = object : DiffUtil.ItemCallback<DetailsAdapterItem>() {
            override fun areItemsTheSame(
                oldItem: DetailsAdapterItem,
                newItem: DetailsAdapterItem
            ): Boolean {
                return oldItem.diffId == newItem.diffId
            }
            override fun areContentsTheSame(
                oldItem: DetailsAdapterItem,
                newItem: DetailsAdapterItem
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}