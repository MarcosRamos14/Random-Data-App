package com.example.randomdataapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.switchMap
import com.example.randomdataapp.domain.models.UsersDTO
import com.example.randomdataapp.domain.usecase.GetUsersUseCase
import com.example.randomdataapp.domain.usecase.base.CoroutinesDispatchers
import com.example.randomdataapp.ui.extensions.watchStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val coroutinesDispatchers: CoroutinesDispatchers,
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel() {

    private val action = MutableLiveData<Action>()
    val state: LiveData<UiState> = action.switchMap {
        liveData(coroutinesDispatchers.io()) {
            when (it) {
                Action.Load -> {
                    getUsersUseCase().watchStatus(
                        loading = { emit(UiState.Loading) },
                        success = { users -> emit(UiState.Success(users)) },
                        error = { emit(UiState.Error) }
                    )
                }
            }
        }
    }

    fun getUsers() {
        action.value = Action.Load
    }

    sealed class UiState {
        object Loading : UiState()
        data class Success(val users: List<UsersDTO>) : UiState()
        object Error : UiState()
    }

    sealed class Action {
        object Load : Action()
    }
}