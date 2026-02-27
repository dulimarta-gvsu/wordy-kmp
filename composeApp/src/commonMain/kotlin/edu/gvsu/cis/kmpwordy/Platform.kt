package edu.gvsu.cis.kmpwordy

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform