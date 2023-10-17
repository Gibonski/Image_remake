package com.example.imageremake

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform