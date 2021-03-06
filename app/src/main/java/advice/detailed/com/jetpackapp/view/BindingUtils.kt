package advice.detailed.com.jetpackapp.view

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView

@BindingAdapter("data")
fun <T> setRecyclerViewProperties(recyclerView: RecyclerView, items: List<T>) {
    if (recyclerView.adapter is BindableRecentPostAdapter<*>) {
        (recyclerView.adapter as BindableRecentPostAdapter<T>).setData(items)
    }
}