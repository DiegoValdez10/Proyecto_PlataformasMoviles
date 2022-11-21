package com.example.proyecto.firebase

class AuthRepositoryImpl(
    private val api: AuthApi
) : AuthRepository {
    override suspend fun signInWithEmailAndPassword(email: String, password: String) : String? {
        val authResponse = api.signInWithEmailAndPassword(email, password)

        return if (authResponse is Resource.Success)
            authResponse.data!!
        else
            null
    }

    override suspend fun createUserWithEmailAndPassword(email: String, password: String) : String? {
        val authResponse = api.createUserWithEmailAndPassword(email, password)

        return if (authResponse is Resource.Success)
            authResponse.data!!
        else
            null
    }
}