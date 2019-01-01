package advice.detailed.com.jetpackapp.viewmodel

import advice.detailed.com.jetpackapp.model.AppDatabase
import advice.detailed.com.jetpackapp.model.AppDbInstance
import advice.detailed.com.jetpackapp.model.RecentPosts.RecentPosts
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class JetpackViewModel : ViewModel() {

    var mappDatabase: AppDatabase = AppDbInstance.getdbInstance()
    var mRecentPosts:  MutableLiveData<List<RecentPosts>>? = null

    private fun getMutableRefRecent() : MutableLiveData<List<RecentPosts>>{
        if(mRecentPosts==null){
            mRecentPosts = MutableLiveData()
        }
        return mRecentPosts as MutableLiveData<List<RecentPosts>>
    }

    fun insertRecentPosts(){
        val recentSamplePosts = listOf(RecentPosts(1,"android","Testing"),
            RecentPosts(2,"ios","IOS Testing"),
            RecentPosts(3,"React","React Testing"))
        mappDatabase.recentDao().addRecentPost(recentSamplePosts)
    }

    fun getRecentPosts() : MutableLiveData<List<RecentPosts>>{
        var recentPosts = getMutableRefRecent()
        recentPosts.value = mappDatabase.recentDao().getAllRecent()
        return recentPosts
    }

}