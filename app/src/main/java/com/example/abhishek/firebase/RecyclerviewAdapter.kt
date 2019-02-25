package com.example.abhishek.firebase

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class RecyclerviewAdapter(private val pojolist: List<Pojo>,val context: Context) : RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder>()
{

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerviewAdapter.ViewHolder
    {

        val view = LayoutInflater.from(context).inflate(R.layout.feed_recyclerview, viewGroup, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int
    {

        return pojolist.size

    }

    override fun onBindViewHolder(holder: RecyclerviewAdapter.ViewHolder, position: Int)
    {

        holder.feed_f_name.text = (pojolist[position].first_name)
        holder.feed_l_name.text = (pojolist[position].last_name)
        holder.feed_bod.text = (pojolist[position].birth_date)
        holder.emial_recy.text = (pojolist[position].email)

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        val feed_profile_image = itemView.findViewById(R.id.feed_profile_image) as CircleImageView
        val feed_f_name  = itemView.findViewById(R.id.feed_f_name) as TextView
        val feed_l_name = itemView.findViewById(R.id.feed_l_name) as TextView
        val feed_bod = itemView.findViewById(R.id.feed_bod) as TextView
        val emial_recy = itemView.findViewById(R.id.emial_recy) as TextView


    }

}