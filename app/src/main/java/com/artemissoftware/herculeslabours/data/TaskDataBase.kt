package com.artemissoftware.herculeslabours.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.artemissoftware.herculeslabours.di.ApplicationScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@Database(entities = [Task::class], version = 1)
abstract class TaskDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDao

    class Callback @Inject constructor(private val database: Provider<TaskDatabase>, @ApplicationScope private val applicationScope: CoroutineScope) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            val dao = database.get().taskDao()

            applicationScope.launch {
                dao.insert(Task("Slay the Nemean lion"))
                dao.insert(Task("Slay the nine-headed Lernaean Hydra"))
                dao.insert(Task("Capture the Ceryneian Hind", important = true))
                dao.insert(Task("Capture the Erymanthian Boar", completed = true))
                dao.insert(Task("Clean the Augean stables in a single day"))
                dao.insert(Task("Slay the Stymphalian birds", completed = true))
                dao.insert(Task("Capture the Cretan Bull"))
                dao.insert(Task("Steal the Mares of Diomedes"))
                dao.insert(Task("Obtain the girdle of Hippolyta, queen of the Amazons"))
                dao.insert(Task("Obtain the cattle of the three-bodied giant Geryon", important = true))
                dao.insert(Task("Steal three of the golden apples of the Hesperides", completed = true))
                dao.insert(Task("Capture and bring back Cerberus"))
            }
        }
    }
}