package com.example.randomdataapp.domain.usecase

import com.example.randomdataapp.data.repository.HomeRepository
import com.example.randomdataapp.domain.models.UsersDTO
import com.example.randomdataapp.domain.usecase.base.CoroutinesDispatchers
import com.example.randomdataapp.domain.usecase.base.ResultStatus
import com.example.randomdataapp.domain.usecase.base.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface GetUsersUseCase {
    operator fun invoke(params: Unit = Unit) : Flow<ResultStatus<List<UsersDTO>>>
}

class GetUsersUseCaseImpl @Inject constructor(
    private val repository: HomeRepository,
    private val dispatchers: CoroutinesDispatchers
) : UseCase<Unit, List<UsersDTO>>(), GetUsersUseCase {

    override suspend fun doWork(params: Unit): ResultStatus<List<UsersDTO>> {
        return withContext(dispatchers.io()) {
            val users = repository.getUsers()
            ResultStatus.Success(users)
        }
    }
}