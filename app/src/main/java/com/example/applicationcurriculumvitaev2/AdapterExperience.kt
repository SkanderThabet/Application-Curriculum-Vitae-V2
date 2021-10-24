package com.example.applicationcurriculumvitaev2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterExperience(val experience: ArrayList<ExperienceData>) :
    RecyclerView.Adapter<AdapterExperience.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_experience, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemCompanyName.text = experience[position].companyname
        holder.itemContent.text = experience[position].companycontent
        holder.itemCompanyAddress.text = experience[position].companyaddress
        holder.itemImage.setImageResource(experience[position].companyimage)
        holder.itemStartDate.text = experience[position].companystartdate
        holder.itemEndDate.text = experience[position].companyenddate
    }

    override fun getItemCount(): Int = experience.size

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

}