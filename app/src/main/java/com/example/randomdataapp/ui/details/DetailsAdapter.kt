package com.example.randomdataapp.ui.details

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.randomdataapp.R
import com.example.randomdataapp.domain.models.CreditCardDTO
import com.example.randomdataapp.domain.models.SubscriptionDTO
import com.example.randomdataapp.domain.models.UsersDTO
import com.example.randomdataapp.framework.imageLoader.ImageLoader
import com.example.randomdataapp.ui.details.DetailsAdapterItem.Companion.diff
import com.example.randomdataapp.ui.details.viewHolders.DetailsBaseViewHolder
import com.example.randomdataapp.ui.details.viewHolders.DetailsCardViewHolder
import com.example.randomdataapp.ui.details.viewHolders.DetailsRegisterViewHolder

class DetailsAdapter : ListAdapter<DetailsAdapterItem, DetailsBaseViewHolder>(diff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsBaseViewHolder {
        return when (viewType) {
            DetailsAdapterItem.CARD_TYPE -> DetailsCardViewHolder.create(parent)
            DetailsAdapterItem.REGISTER_TYPE -> DetailsRegisterViewHolder.create(parent)
            else -> throw Exception("Unknown viewType $viewType")
        }
    }

    override fun onBindViewHolder(holder: DetailsBaseViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).viewType
    }

    fun submitUsersData(
        context: Context,
        users: UsersDTO,
        creditCard: CreditCardDTO? = null,
        subscription: SubscriptionDTO? = null
    ) {
        val items = mutableListOf<DetailsAdapterItem>()
        with(items) {
            add(DetailsAdapterItem.CardDetails(creditCard, subscription))
            addAll(
                listOf(
                    DetailsAdapterItem.RegisterDetails(
                        context.getString(R.string.full_name_label, users.fullName)
                    ),
                    DetailsAdapterItem.RegisterDetails(
                        context.getString(R.string.full_email_label, users.email)
                    ),
                    DetailsAdapterItem.RegisterDetails(
                        context.getString(R.string.full_phone_number_label, users.phoneNumber)
                    ),
                    DetailsAdapterItem.RegisterDetails(
                        context.getString(R.string.full_date_of_birth_label, users.dateOfBirth)
                    ),
                    DetailsAdapterItem.RegisterDetails(
                        context.getString(R.string.full_employment_title_label, users.employment?.title)
                    ),
                    DetailsAdapterItem.RegisterDetails(
                        context.getString(R.string.full_employment_key_skill_label, users.employment?.keySkill)
                    ),
                )
            )
        }
        submitList(items)
    }
}