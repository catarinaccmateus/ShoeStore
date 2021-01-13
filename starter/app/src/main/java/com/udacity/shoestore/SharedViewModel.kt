package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

val SHOE_ONE = Shoe("Boot 6 INCH PREMIUM", 39.00, "Timberland", "When you think of Timberland boots, youre thinking of these classic waterproof boots.", listOf(""))
val SHOE_TWO = Shoe("Boot 6 INCH PREMIUM", 36.00, "Timberland", "When you think of Timberland boots, youre thinking of these classic waterproof boots.", listOf(""))
val SHOE_THREE = Shoe("Boot 6 INCH PREMIUM", 41.00, "Timberland", "When you think of Timberland boots, youre thinking of these classic waterproof boots.", listOf(""))
val SHOE_FOUR = Shoe("Boot 6 INCH PREMIUM", 45.00, "Timberland", "When you think of Timberland boots, youre thinking of these classic waterproof boots.", listOf(""))

class SharedViewModel: ViewModel() {

    private var _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
    get() = _shoeList

    init {
        _shoeList.value = mutableListOf(SHOE_ONE, SHOE_TWO, SHOE_THREE, SHOE_FOUR)
    }

    fun addShoe(shoe: Shoe) {
        _shoeList.value?.add(shoe)
    }
}