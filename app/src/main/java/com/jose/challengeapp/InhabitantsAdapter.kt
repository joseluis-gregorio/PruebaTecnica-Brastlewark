package com.jose.challengeapp

import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.item_inhabitant.view.*

typealias OnClickInhabitantOption = (Brastlewark) -> Unit

class InhabitantsAdapter(val inhabitants: ArrayList<Brastlewark>, val context: Context):RecyclerView.Adapter<InhabitantsAdapter.InhabitantsHolder>(){
    private var onClickItem:OnClickInhabitantOption? = null

    fun setOnClickItem(onClickItem:OnClickInhabitantOption){
        this.onClickItem = onClickItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InhabitantsHolder {
        val v= LayoutInflater.from(parent.context).inflate(R.layout.item_inhabitant,parent,false)
        return InhabitantsHolder(v)
    }

    override fun getItemCount(): Int {
        return inhabitants.size
    }

    override fun onBindViewHolder(holder:InhabitantsAdapter.InhabitantsHolder, position: Int) {
        holder.bind(inhabitants[position],context)
        holder.itemView.layout_inhabitant.setOnClickListener {
            onClickItem?.invoke(inhabitants[position])
        }
    }

    class InhabitantsHolder(view:View):RecyclerView.ViewHolder(view),Constants{

        val title_product:TextView=itemView.findViewById(R.id.name_inhabitant) as TextView
        val picture: ImageView =itemView.findViewById(R.id.photo_inhabitant) as ImageView

        fun bind(data: Brastlewark, context: Context){
            title_product.text=data.name
            Glide.with(context).load(data.getImageURL()).error(R.drawable.ic_gnomo).into(picture)
        }
    }
}