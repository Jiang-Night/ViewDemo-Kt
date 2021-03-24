package me.jiangwan.viewdome

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(var context: Context?, var dataList: MutableList<Model>) :
    RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val modelImage: ImageView = view.findViewById(R.id.modeImage)
        val modelName: TextView = view.findViewById(R.id.modeName)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.model_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val model = dataList[position]
        holder.modelImage.setImageResource(model.imageId)
        holder.modelName.text = model.name

    }

    override fun getItemCount() = dataList.size
    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }


}