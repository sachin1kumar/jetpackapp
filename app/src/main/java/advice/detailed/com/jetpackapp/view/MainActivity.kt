package advice.detailed.com.jetpackapp.view

import advice.detailed.com.jetpackapp.model.RecentPosts.RecentPosts
import advice.detailed.com.jetpackapp.R
import advice.detailed.com.jetpackapp.viewmodel.JetpackViewModel
import advice.detailed.com.jetpackapp.databinding.ActivityMainBinding
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var viewModel: ViewModel? = null
    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var recentPostList: List<RecentPosts>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(JetpackViewModel::class.java)

        activityMainBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_main)

        (viewModel as JetpackViewModel).insertRecentPosts()

        (viewModel as JetpackViewModel).getRecentPosts().observe(this,android.arch.lifecycle.Observer{
            recentPostList = it!!
            val recentPostAdapter = RecentPostsAdapter()
            recentPostAdapter.setData(recentPostList)
            recyclerView.adapter = recentPostAdapter
            activityMainBinding.viewModel = viewModel as JetpackViewModel?
            //Log.e("LiveData:Observer:",mNewsInStr)
        })


    }

}
