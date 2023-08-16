package com.example.randomdataapp.ui.details.viewHolders

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.randomdataapp.databinding.ItemRegistrationDetailsBinding
import com.example.randomdataapp.ui.details.DetailsAdapterItem

class DetailsRegisterViewHolder(
    itemBinding: ItemRegistrationDetailsBinding
) : DetailsBaseViewHolder(itemBinding.root) {

    private val registerData = itemBinding.textRegister

    override fun bind(item: DetailsAdapterItem) {
        (item as? DetailsAdapterItem.RegisterDetails)?.let {
            registerData.text = item.userInfo
        }
    }

    companion object {
        fun create(parent: ViewGroup): DetailsRegisterViewHolder {
            val inflate = LayoutInflater.from(parent.context)
            val itemBinding = ItemRegistrationDetailsBinding.inflate(inflate, parent, false)
            return DetailsRegisterViewHolder(itemBinding)
        }
    }
}