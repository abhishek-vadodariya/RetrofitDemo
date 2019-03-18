package com.example.abhishek.firebase.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.abhishek.firebase.ModelClass.Pojo
import com.example.abhishek.firebase.R
import de.hdodenhof.circleimageview.CircleImageView

class RecyclerviewAdapter(private val pojolist: List<Pojo>, val context: Context) : RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder>()
{

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder
    {

        val view = LayoutInflater.from(context).inflate(R.layout.feed_recyclerview, viewGroup, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int
    {

        return pojolist.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {

        holder.feed_f_name.text = (pojolist[position].getFirstname())
        holder.feed_l_name.text = (pojolist[position].getLastname())
        holder.feed_bod.text = (pojolist[position].getBirthday())
        holder.emial_recy.text = (pojolist[position].getEmail())

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        val feed_profile_image = itemView.findViewById(R.id.feed_profile_image) as CircleImageView
        val feed_f_name  = itemView.findViewById(R.id.feed_f_name) as TextView
        val feed_l_name = itemView.findViewById(R.id.feed_l_name) as TextView
        val feed_bod = itemView.findViewById(R.id.feed_bod) as TextView
        val emial_recy = itemView.findViewById(R.id.emial_recy) as TextView


    }

}