package com.yashishu.statestrivia

import android.icu.number.Notation.simple
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView.RecyclerListener
import android.widget.ExpandableListView.OnChildClickListener
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//important adapter code

class StateAdapter(
  private  val stateList: List<State>,

  private val clickListener: (Int) -> Unit
) : RecyclerView.Adapter<StateAdapter.ViewHolder>() {
    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        private lateinit var txtName: TextView
        fun bind(state: State){
            txtName = view.findViewById(android.R.id.text1)
            txtName.text = state.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       //inflate--content generation
        val layout= android.R.layout.simple_list_item_1
        return ViewHolder(LayoutInflater.from(parent.context).inflate(layout,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(stateList[position])
        holder.view.setOnClickListener {clickListener(position) }
    }

    override fun getItemCount()= stateList.size

}