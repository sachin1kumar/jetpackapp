package advice.detailed.com.jetpackapp.view

import advice.detailed.com.jetpackapp.model.RecentPosts.RecentPosts
import advice.detailed.com.jetpackapp.R
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.recent_posts.view.*

class RecentPostsAdapter :
    RecyclerView.Adapter<RecentPostsAdapter.ViewHolder>(),BindableRecentPostAdapter<RecentPosts> {

    private lateinit var recentPost: List<RecentPosts>

    override fun setData(items: List<RecentPosts>) {
        recentPost = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val inflater = LayoutInflater.from(p0.context)
        return ViewHolder(inflater.inflate(R.layout.recent_posts, p0, false))
    }

    override fun getItemCount(): Int {
        return recentPost.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bind(recentPost[p1].technology,recentPost[p1].post)
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(technology:String?, post: String?){
            itemView.techonolgy.text = technology
            itemView.post.text = post
        }

    }


}