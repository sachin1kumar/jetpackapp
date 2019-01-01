package advice.detailed.com.jetpackapp.model.RecentPosts

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface RecentPostDao {

    @Insert
    fun addRecentPost(recentPosts:List<RecentPosts>)

    @Query("SELECT * FROM RecentPosts")
    fun getAllRecent(): List<RecentPosts>
}