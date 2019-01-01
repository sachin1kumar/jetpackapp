package advice.detailed.com.jetpackapp.model

import advice.detailed.com.jetpackapp.MyApplication
import android.arch.persistence.room.Room

object AppDbInstance{

    fun getdbInstance() : AppDatabase{

        return Room.databaseBuilder(
            MyApplication.instance,
            AppDatabase::class.java, "jetpackDb")
            .allowMainThreadQueries()
            .build()
    }
}