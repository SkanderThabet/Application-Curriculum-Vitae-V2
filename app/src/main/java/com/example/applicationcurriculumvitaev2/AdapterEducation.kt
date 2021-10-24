package com.example.applicationcurriculumvitaev2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class AdapterEducation(val education : ArrayList<EducationData>) : RecyclerView.Adapter<AdapterEducation.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_education, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemCompanyName.text=education[position].companyname_ed
        holder.itemImage.setImageResource(education[position].companyimage_ed)
        holder.itemStartDate.text=education[position].companystartdate_ed
        holder.itemEndDate.text=education[position].companyenddate_ed
        holder.itemCompanyAddress.text=education[position].companyaddress_ed
    }

    override fun getItemCount(): Int {
        return education.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemCompanyName: TextView
        var itemCompanyAddress: TextView
        var itemStartDate: TextView
        var itemEndDate: TextView

        init {
            itemImage= itemView.findViewById(R.id.logo_ed)
            itemCompanyName=itemView.findViewById(R.id.company_name_ed)
            itemCompanyAddress=itemView.findViewById(R.id.company_address_ed)
            itemStartDate=itemView.findViewById(R.id.start_date_ed)
            itemEndDate=itemView.findViewById(R.id.end_date_ed)
        }
    }


}