package at.ac.htl_leonding.wmc_test.test_wmc_android_der_kleine_wahlhelfer.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "parties")
data class Party(
    @PrimaryKey
    val code: String,

    val name: String,

    val currentVotes: Int
)