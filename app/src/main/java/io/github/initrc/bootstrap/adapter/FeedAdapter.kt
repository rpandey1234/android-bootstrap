package io.github.initrc.bootstrap.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import io.github.initrc.bootstrap.R
import io.github.initrc.bootstrap.model.Photo
import util.inflate

/**
 * Feed adapter.
 */
class FeedAdapter : RecyclerView.Adapter<FeedAdapter.ViewHolder>() {
    var items = mutableListOf<Photo>()

    fun addPhotos(photos: List<Photo>) {
        items.addAll(photos)
        notifyItemRangeChanged(itemCount - photos.size, photos.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val itemView = parent?.inflate(R.layout.view_photo_item)
        return ViewHolder(itemView!!)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val photo: Photo? = items.getOrNull(position)
        photo?.images?.getOrNull(0)?.url?.let {
            Glide.with(holder?.photoIv?.context).load(it)
                    .error(android.R.drawable.stat_sys_download).crossFade().into(holder?.photoIv)
        }
        holder?.nameTv?.text = photo?.name
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val photoIv = itemView.findViewById(R.id.photoIv) as ImageView
        val nameTv = itemView.findViewById(R.id.nameTv) as TextView
    }
}