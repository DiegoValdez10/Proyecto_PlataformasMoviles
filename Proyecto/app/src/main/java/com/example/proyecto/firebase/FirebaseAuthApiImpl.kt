package com.example.proyecto.firebase

import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

import kotlinx.coroutines.tasks.await

class FirebaseAuthApiImpl: AuthApi {
    override suspend fun signInWithEmailAndPassword(
        email: String,
        password: String
    ): Resource<String> {
        try {
            val auth = Firebase.auth

            val response = auth.signInWithEmailAndPassword(email, password).await()

            val userInfo = response.user
            return if(userInfo != null){
                Resource.Success(data = userInfo.uid)
            }
            else {
                Resource.Error(message = "Error en login")
            }
        } catch (e: Exception){
            return Resource.Error(message = "Error en login")
        }
    }

    override suspend fun createUserWithEmailAndPassword(
        email: String,
        password: String
    ): Resource<String> {
        try {
            val auth = Firebase.auth

            val response = auth.createUserWithEmailAndPassword(email, password).await()

            val userInfo = response.user
            return if(userInfo != null){
                Resource.Success(data = userInfo.uid)
            }
            else {
                Resource.Error(message = "Error en registrar")
            }
        } catch (e: Exception){
            return Resource.Error(message = "Error en registrar")
        }
    }
}