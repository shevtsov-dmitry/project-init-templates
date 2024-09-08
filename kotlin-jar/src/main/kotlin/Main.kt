package org.script

import com.google.gson.Gson

fun main() {
    class Person(val name: String, val surname: String, val age: Int)
    val p  = Person("John", "Pimple", 52)
    val gson = Gson()
    val json = gson.toJson(p)
    print(json)
}

