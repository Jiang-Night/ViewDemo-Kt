package me.jiangwan.viewdome

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter3(var context: Context?, var dataList: MutableList<Model3>) :
RecyclerView.Adapter<RecyclerAdapter3.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val model3Image: CardView = view.findViewById(R.id.cardview)
        val model3Name: TextView = view.findViewById(R.id.modeName3)
        val model3Nub: TextView = view.findViewById(R.id.modeNub3)
        val model3Card: TextView = view.findViewById(R.id.modeCard_Nub)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerAdapter3.MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recyclerview_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter3.MyViewHolder, position: Int) {
        val model3 = dataList[position]
        holder.model3Name.text = model3.name3
        holder.model3Card.text= model3.Bank_card_number
        holder.model3Nub.text= model3.nub3
        holder.model3Image.setCardBackgroundColor(model3.imageId3)

    }

    override fun getItemCount() = dataList.size
}