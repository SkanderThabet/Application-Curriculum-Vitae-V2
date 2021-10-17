package com.example.applicationcurriculumvitaev2

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class AdapterExperience : RecyclerView.Adapter<AdapterExperience.ViewHolder>() {
    /**
     * Inner class of ViewHolder
     */
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemCompanyName: TextView
        var itemCompanyAddress: TextView
        var itemStartDate: TextView
        var itemEndDate: TextView
        var itemContent: TextView

        /**
         * init to initialize the above variables
         */
        init {
            itemImage = itemView.findViewById(R.id.logo_placeholder)
            itemCompanyName = itemView.findViewById(R.id.company_name)
            itemCompanyAddress = itemView.findViewById(R.id.company_address)
            itemStartDate = itemView.findViewById(R.id.start_date)
            itemEndDate = itemView.findViewById(R.id.end_date)
            itemContent = itemView.findViewById(R.id.content_experience)
        }

    }

    /**
     * Array to list all the companies
     */

    private val titles = arrayOf("AMAZON", "FACEBOOK", "LINKEDIN", "GOOGLE", "MICROSOFT", "ESPRIT")
    private val countries = arrayOf("TUNISIA", "USA")
    private val contentExperience = arrayOf("Test test test test","Test test test test","Test test test test","Test test test test","Test test test test","Test test test test","Test test test test","Test test test test","Test test test test")
    private val images = arrayOf(
        R.drawable.ic_logo_esprit,
        R.drawable.ic_logo_google,
        R.drawable.ic_logo_microsoft,
        R.drawable.ic_logo_facebook,
        R.drawable.ic_logo_amazon,
        R.drawable.ic_logo_linkedin
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.fragment_experience, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemCompanyName.text = titles[position]
        holder.itemContent.text=contentExperience[position]
        holder.itemCompanyAddress.text=countries[position]
        holder.itemImage.setImageResource(images[position])
    }

    override fun getItemCount(): Int {
        return titles.size
    }


}