package at.ac.htl_leonding.wmc_test.test_wmc_android_der_kleine_wahlhelfer.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import at.ac.htl_leonding.wmc_test.test_wmc_android_der_kleine_wahlhelfer.data.daos.PartyDao
import at.ac.htl_leonding.wmc_test.test_wmc_android_der_kleine_wahlhelfer.data.entities.Party

@Database(
    entities = [Party::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun partyDao(): PartyDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun get(context: android.content.Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "der-kleine-wahlhelfer-db"
                ).build().also {
                    INSTANCE = it
                }
            }
    }
}