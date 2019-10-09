package com.example.quizbeta.data



class SearchModel {

    var name: String? = null

    fun getNames(): String {
        return name.toString()
    }

    fun setNames(name: String) {
        this.name = name
    }
}