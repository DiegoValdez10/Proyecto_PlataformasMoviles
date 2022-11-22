package com.example.proyecto.firebase

interface AuthRepository {
    suspend fun signInWithEmailAndPassword(email: String, password: String) : String?
    suspend fun createUserWithEmailAndPassword(email: String, password: String) : String?
}