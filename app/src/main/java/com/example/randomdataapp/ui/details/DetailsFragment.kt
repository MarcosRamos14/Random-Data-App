package com.example.randomdataapp.ui.details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.randomdataapp.R
import com.example.randomdataapp.databinding.FragmentDetailsBinding
import com.example.randomdataapp.framework.imageLoader.ImageLoader
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DetailsFragment : Fragment(R.layout.fragment_details) {

    private lateinit var binding: FragmentDetailsBinding
    private val args by navArgs<DetailsFragmentArgs>()

    @Inject
    lateinit var imageLoader: ImageLoader

    private val detailsAdapter: DetailsAdapter by lazy {
        val detailsAdapter = DetailsAdapter()
        binding.recyclerDetails.adapter = detailsAdapter
        return@lazy detailsAdapter
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailsBinding.bind(view)
        setupListener()
        val userViewArgs = args.users

        detailsAdapter.submitUsersData(
            context = requireContext(),
            users = userViewArgs,
            creditCard = userViewArgs.creditCard,
            subscription = userViewArgs.subscription
        )
    }

    private fun setupListener() {
        binding.buttonBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}