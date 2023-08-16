package com.example.randomdataapp.ui.details.viewHolders

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.randomdataapp.databinding.ItemCardDetailsBinding
import com.example.randomdataapp.ui.details.DetailsAdapterItem

class DetailsCardViewHolder(
    itemBinding: ItemCardDetailsBinding
) : DetailsBaseViewHolder(itemBinding.root) {

    private val cardNumber = itemBinding.textCardNumber
    private val cardStatus = itemBinding.textCardStatus
    private val cardPlan = itemBinding.textCardPlan
    private val cardTerm = itemBinding.textCardTerm
    private val cardPaymentMethod = itemBinding.textCardPaymentMethod

    override fun bind(item: DetailsAdapterItem) {
        (item as? DetailsAdapterItem.CardDetails)?.let { cardDetails ->
            with(cardDetails) {
                cardNumber.text = creditCard?.number
                cardStatus.text = subscription?.status
                cardPlan.text = subscription?.plan
                cardTerm.text = subscription?.term
                cardPaymentMethod.text = subscription?.paymentMethod
            }
        }
    }

    companion object {
        fun create(parent: ViewGroup): DetailsCardViewHolder {
            val inflate = LayoutInflater.from(parent.context)
            val itemBinding = ItemCardDetailsBinding.inflate(inflate, parent, false)
            return DetailsCardViewHolder(itemBinding)
        }
    }
}