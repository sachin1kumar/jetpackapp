package advice.detailed.com.jetpackapp.model

import advice.detailed.com.jetpackapp.model.RecentPosts.RecentPostDao
import advice.detailed.com.jetpackapp.model.RecentPosts.RecentPosts
import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase


@Database(entities = arrayOf(RecentPosts::class), version = 4, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun recentDao(): RecentPostDao

}