package at.ac.htl_leonding.wmc_test.test_wmc_android_der_kleine_wahlhelfer.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import at.ac.htl_leonding.wmc_test.test_wmc_android_der_kleine_wahlhelfer.data.entities.Party
import at.ac.htl_leonding.wmc_test.test_wmc_android_der_kleine_wahlhelfer.data.repositories.PartyRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class PartyViewModel(
    private val repository: PartyRepository
) : ViewModel() {

    val parties = repository.parties.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    fun addVotes(
        party: Party,
        amount: Int
    ) {
        viewModelScope.launch {
            repository.updateVotes(
                code = party.code,
                votes = party.currentVotes + amount
            )
        }
    }
}