package com.example.randomdataapp.ui.home

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.randomdataapp.R
import com.example.randomdataapp.databinding.FragmentHomeBinding
import com.example.randomdataapp.framework.imageLoader.ImageLoader
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()

    @Inject
    lateinit var imageLoader: ImageLoader

    private val homeAdapter: HomeAdapter by lazy {
        HomeAdapter(imageLoader) { users, view ->
            val directions = HomeFragmentDirections
                .actionHomeFragmentToDetailsFragment(users)
            findNavController().navigate(directions)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        initAdapter()
        observerUiState()
        viewModel.getUsers()
    }

    private fun initAdapter() {
        with(binding.recyclerHome) {
            setHasFixedSize(true)
            adapter = homeAdapter
        }
    }

    private fun observerUiState() {
        viewModel.state.observe(viewLifecycleOwner) { uiState ->
            binding.flipperHome.displayedChild = when (uiState) {
                HomeViewModel.UiState.Loading -> {
                    setShimmerVisibility(true)
                    FLIPPER_CHILD_LOADING
                }
                is HomeViewModel.UiState.Success -> {
                    setShimmerVisibility(false)
                    homeAdapter.submitList(uiState.users)
                    FLIPPER_CHILD_SUCCESS
                }
                HomeViewModel.UiState.Error -> {
                    setShimmerVisibility(false)
                    setupListenerRetry()
                    FLIPPER_CHILD_ERROR
                }
            }
        }
    }

    private fun setupListenerRetry() {
        binding.includeErrorView.buttonRetry.setOnClickListener {
            viewModel.getUsers()
        }
    }

    private fun setShimmerVisibility(visibility: Boolean) {
        binding.includeViewHomeLoadingState.shimmerHome.run {
            isVisible = visibility
            if (visibility) {
                startShimmer()
            } else stopShimmer()
        }
    }

    companion object {
        private const val FLIPPER_CHILD_LOADING = 0
        private const val FLIPPER_CHILD_SUCCESS = 1
        private const val FLIPPER_CHILD_ERROR = 2
    }
}