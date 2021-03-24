package me.jiangwan.viewdome

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter4(var context: Context?, var dataList: MutableList<Model4>) :
    RecyclerView.Adapter<RecyclerAdapter4.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val model4Image: ImageView = view.findViewById(R.id.modeImage4)
        val model4Name: TextView = view.findViewById(R.id.modeName4)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerAdapter4.MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.model_item4, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter4.MyViewHolder, position: Int) {
        val model4 = dataList[position]
        holder.model4Image.setImageResource(model4.imageId)
        holder.model4Name.text = model4.name
    }

    override fun getItemCount() = dataList.size


}