package at.ac.htl_leonding.wmc_test.test_wmc_android_der_kleine_wahlhelfer.data.repositories

import at.ac.htl_leonding.wmc_test.test_wmc_android_der_kleine_wahlhelfer.data.daos.PartyDao
import at.ac.htl_leonding.wmc_test.test_wmc_android_der_kleine_wahlhelfer.data.entities.Party


class PartyRepository(
    private val dao: PartyDao
) {

    val parties = dao.getAllParties()

    suspend fun updateVotes(
        code: String,
        votes: Int
    ) {
        dao.updateVotes(code, votes)
    }

    suspend fun insertParty(
        party: Party
    ) {
        dao.insertParty(party)
    }

    suspend fun resetAllVotes() {
        dao.resetAllVotes()
    }
}