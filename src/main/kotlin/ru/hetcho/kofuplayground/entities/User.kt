package ru.hetcho.kofuplayground.entities

data class User(
    var name: String,
    var surname: String
) {
    var id: Long? = null
}