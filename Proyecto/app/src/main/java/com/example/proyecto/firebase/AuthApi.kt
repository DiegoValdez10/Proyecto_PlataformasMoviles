package com.example.proyecto.firebase

interface AuthApi {
    suspend fun signInWithEmailAndPassword(email: String, password: String) : Resource<String>
    suspend fun createUserWithEmailAndPassword(email: String, password: String) : Resource<String>
}