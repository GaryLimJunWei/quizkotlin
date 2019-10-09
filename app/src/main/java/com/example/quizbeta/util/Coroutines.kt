package com.example.quizbeta.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


// To create this object so we can access it and no need to add all the function to be suspend
object Coroutines
{

    /*
        This function have another function inside it's parameters
        Adding the suspend function inside, and Unit means void in Java
     */
    fun main(work:suspend(() -> Unit)) =
        CoroutineScope(Dispatchers.Main).launch {
            work()
        }

}