package com.example.randomdataapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.randomdataapp.R
import com.example.randomdataapp.databinding.ItemHomeBinding
import com.example.randomdataapp.domain.models.UsersDTO
import com.example.randomdataapp.framework.imageLoader.ImageLoader
import com.example.randomdataapp.ui.home.HomeAdapter.*
import com.example.randomdataapp.ui.util.OnItemClick
import javax.inject.Inject

class HomeAdapter @Inject constructor(
    private val imageLoader: ImageLoader,
    private val onItemClick: OnItemClick
) : ListAdapter<UsersDTO, HomeViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder.create(parent, imageLoader, onItemClick)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class HomeViewHolder(
        itemHomeBinding: ItemHomeBinding,
        private val imageLoader: ImageLoader,
        private val onItemClick: OnItemClick
    ) : RecyclerView.ViewHolder(itemHomeBinding.root) {

        private val imageHome = itemHomeBinding.imageItemHome
        private val textUserName = itemHomeBinding.textUserName
        private val textAddressEmail = itemHomeBinding.textAddressEmail

        fun bind(person: UsersDTO) {
            val errorLoadingImage = R.string.error_loading_image.toString()

            textUserName.text = person.userName
            textAddressEmail.text = person.email
            imageHome.transitionName = person.userName
            imageLoader.load(
                imageView = imageHome,
                imageUrl = person.imageUrl ?: errorLoadingImage
            )
            itemView.setOnClickListener {
                onItemClick.invoke(person, imageHome)
            }
        }

        companion object {
            fun create(
                parent: ViewGroup,
                imageLoader: ImageLoader,
                onItemClick: OnItemClick
            ): HomeViewHolder {
                val inflate = LayoutInflater.from(parent.context)
                val itemBinding = ItemHomeBinding.inflate(inflate, parent, false)
                return HomeViewHolder(itemBinding, imageLoader, onItemClick)
            }
        }
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<UsersDTO>() {
            override fun areItemsTheSame(oldItem: UsersDTO, newItem: UsersDTO): Boolean {
                return oldItem.userName == newItem.userName
            }

            override fun areContentsTheSame(oldItem: UsersDTO, newItem: UsersDTO): Boolean {
                return oldItem == newItem
            }
        }
    }
}