package at.ac.htl_leonding.wmc_test.test_wmc_android_der_kleine_wahlhelfer.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import at.ac.htl_leonding.wmc_test.test_wmc_android_der_kleine_wahlhelfer.data.repositories.PartyRepository

class PartyViewModelFactory(
    private val repository: PartyRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {

        if(modelClass.isAssignableFrom(PartyViewModel::class.java)) {
            return PartyViewModel(repository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}