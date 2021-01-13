package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

val SHOE_ONE = Shoe("Boot 6 INCH PREMIUM", 39.00, "Timberland", "When you think of Timberland boots, youre thinking of these classic waterproof boots.", listOf("ic_baseline_shoe_default_24"))
val SHOE_TWO = Shoe("Cloud X", 36.00, "One", "The On Running Cloud X training shoes mixes training and running into one light and comfortable shoe to help you achieve your lofty goals.", listOf("ic_baseline_shoe_default_24"))
val SHOE_THREE = Shoe("Pegasus Trail 2", 41.00, "Nike", "Don't let elevation changes, rocks, and loose gravel impede your journey across some serious terrain with the Nike® Pegasus Trail 2 shoes.", listOf("ic_baseline_shoe_default_24"))
val SHOE_FOUR = Shoe("Solar Boost 21", 45.00, "Adidas", "Synthetic outsole. Textile lining and insole.", listOf("ic_baseline_shoe_default_24"))

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