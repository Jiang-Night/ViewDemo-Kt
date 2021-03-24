package me.jiangwan.viewdome

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter2(var context: Context?, var dataList: MutableList<Model2>) :
    RecyclerView.Adapter<RecyclerAdapter2.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val model2Image: ImageView = view.findViewById(R.id.modeImage2)
        val model2Name: TextView = view.findViewById(R.id.modeName2)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerAdapter2.MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.model_item2, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter2.MyViewHolder, position: Int) {
        val model2 = dataList[position]
        holder.model2Image.setImageResource(model2.imageId)
        holder.model2Name.text = model2.name
    }

    override fun getItemCount() = dataList.size


}