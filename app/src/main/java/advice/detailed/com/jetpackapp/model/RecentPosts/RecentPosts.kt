package advice.detailed.com.jetpackapp.model.RecentPosts

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "RecentPosts")
data class RecentPosts(
    @PrimaryKey(autoGenerate = true)
    var postid: Int,

    @ColumnInfo(name = "technology")
    var technology: String?,

    @ColumnInfo(name = "post")
    var post: String?
)