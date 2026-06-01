package at.ac.htl_leonding.wmc_test.test_wmc_android_der_kleine_wahlhelfer.data.daos

import androidx.room.*
import androidx.room.OnConflictStrategy
import at.ac.htl_leonding.wmc_test.test_wmc_android_der_kleine_wahlhelfer.data.entities.Party
import kotlinx.coroutines.flow.Flow

@Dao
interface PartyDao {

    @Query("SELECT * FROM parties")
    fun getAllParties(): Flow<List<Party>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertParty(party: Party)

    @Update
    suspend fun updateParty(party: Party)

    @Query("UPDATE parties SET currentVotes = :votes WHERE code = :code")
    suspend fun updateVotes(code: String, votes: Int)

    @Query("DELETE FROM parties")
    suspend fun deleteAll()

    @Query("UPDATE parties SET currentVotes = 0")
    suspend fun resetAllVotes()
}