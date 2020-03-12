package com.example.pilltime

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class recyviewAdap(dt:Array<String?>,name:Array<String?>,num: Int):RecyclerView.Adapter<recyviewAdap.recyviewholder>() {

    private val adapdt = dt

    private val adapname = name
    private val adapnum=num


    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): recyviewholder {
       val view:View=LayoutInflater.from(parent.context ).inflate(R.layout.itemlist,parent,false)

        return recyviewholder(view)
    }

    override fun getItemCount(): Int {
        return adapnum
    }

    override fun onBindViewHolder(holder: recyviewholder, num: Int) {

        holder.bind(num,adapdt,adapname)
        //holder.kind.text="1"
       // holder.dt.text="2"



/*        holder.dt.setOnClickListener {

            Toast.makeText(this@MainActivity,"abc",Toast.LENGTH_SHORT).show()
        }*/

    }


    class recyviewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dt= itemView.findViewById<TextView>(R.id.DTtext)
        val kind= itemView.findViewById<TextView>(R.id.kindtext)
        fun bind(num:Int,bindname:Array<String?>,binddt:Array<String?>){

            dt.text=binddt[num]
            kind.text=bindname[num]

        }


    }


}