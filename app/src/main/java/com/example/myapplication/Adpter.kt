package com.example.myapplication


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recuclerview.Model.RowModel
import de.hdodenhof.circleimageview.CircleImageView

import java.util.*

class Adpter(var context: Context, var modelList: List<RowModel>) :
    RecyclerView.Adapter<Adpter.MyHolder>(), Filterable {
    var modelListFilter: List<RowModel>

    init {
        modelListFilter = modelList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.row_item, parent, false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val name = modelListFilter[position].name
        val messages = modelListFilter[position].message
        val image = modelListFilter[position].image
        holder.name.text = name
        holder.message.text = messages
       // holder.imageView.setImageResource(R.drawable.ic_launcher_background)
    }

    override fun getItemCount(): Int {
        return modelListFilter.size
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence): FilterResults {
                val charcater = constraint.toString()
                modelListFilter = if (charcater.isEmpty()) {
                    modelList
                } else {
                    val filterList: MutableList<RowModel> = ArrayList()
                    for (row in modelList) {
                        if (row.name.lowercase(Locale.getDefault()).contains(
                                charcater.lowercase(
                                    Locale.getDefault()
                                )
                            )
                        ) {
                            filterList.add(row)
                        }
                    }
                    filterList
                }
                val filterResults = FilterResults()
                filterResults.values = modelListFilter
                return filterResults
            }

            override fun publishResults(constraint: CharSequence, results: FilterResults) {
                modelListFilter = results.values as ArrayList<RowModel>
                notifyDataSetChanged()
            }
        }
    }

    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        //var imageView: CircleImageView
        var name: TextView
        var message: TextView

        init {
           // imageView = itemView.findViewById(R.id.profile_image)
            name = itemView.findViewById(R.id.name)
            message = itemView.findViewById(R.id.message)
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            val postion = adapterPosition
            Toast.makeText(context, "postion$postion", Toast.LENGTH_SHORT).show()
            val intent = Intent(context, HomeActivity::class.java)
            intent.putExtra("name", modelListFilter[postion].name)
            intent.putExtra("message",modelListFilter[postion].message)
            intent.putExtra("image",modelListFilter[postion].image)
            context.startActivity(intent)
        }
    }
}