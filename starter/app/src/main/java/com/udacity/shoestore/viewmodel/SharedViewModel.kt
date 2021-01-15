package com.udacity.shoestore.viewmodel

import android.text.BoringLayout
import android.util.Log
import android.view.View
import androidx.lifecycle.*
import androidx.navigation.findNavController
import com.udacity.shoestore.models.Shoe

val SHOE_ONE = Shoe("Boot 6 INCH PREMIUM", 39.00, "Timberland", "When you think of Timberland boots, youre thinking of these classic waterproof boots.", listOf("ic_baseline_shoe_default_24"))
val SHOE_TWO = Shoe("Cloud X", 36.00, "One", "The On Running Cloud X training shoes mixes training and running into one light and comfortable shoe to help you achieve your lofty goals.", listOf("ic_baseline_shoe_default_24"))
val SHOE_THREE = Shoe("Pegasus Trail 2", 41.00, "Nike", "Don't let elevation changes, rocks, and loose gravel impede your journey across some serious terrain with the Nike® Pegasus Trail 2 shoes.", listOf("ic_baseline_shoe_default_24"))
val SHOE_FOUR = Shoe("Solar Boost 21", 45.00, "Adidas", "Synthetic outsole. Textile lining and insole.", listOf("ic_baseline_shoe_default_24"))

class SharedViewModel: ViewModel() {

    //Shoe list
    private var _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    //Authentication state
    private var _loggedIn = MutableLiveData<Boolean>()
    val loggedin: LiveData<Boolean>
        get() = _loggedIn


    //Details from the shoe that will be added
    var name = MutableLiveData<String>("")
    var description = MutableLiveData<String>("")
    var company = MutableLiveData<String>("")
    var size = MutableLiveData<String>("")
    val isSaveButtonEnabled = MediatorLiveData<Boolean>()

    init {
        _shoeList.value = mutableListOf(SHOE_ONE, SHOE_TWO, SHOE_THREE, SHOE_FOUR)
        _loggedIn.value = false
        isSaveButtonEnabled.addSource(name) {validateForm(name.value)}
        isSaveButtonEnabled.addSource(size) {validateForm(size.value)}
    }

    //Shoe name and size are mandatory to save a new shoe to the list.
    private fun validateForm(value: String?) {
        isSaveButtonEnabled.value =
            !(value.isNullOrEmpty() || size.value.isNullOrEmpty() || name.value.isNullOrEmpty())
    }


    fun addShoe(view: View) {
        val sizeTransform: Double = size.value.toString().toDoubleOrNull() ?: 0.0
        _shoeList.value?.add(Shoe(name.value.toString(), sizeTransform, company.value.toString(), description.value.toString()))
        cleanShoeDetailInput()
        view.findNavController().navigateUp()
    }


   private fun cleanShoeDetailInput() {
        name.value = ""
        description.value = ""
        company.value = ""
        size.value = ""
    }

    fun logIn() {
        _loggedIn.value = true
    }

    fun logOut() {
        _loggedIn.value = false
    }

}
