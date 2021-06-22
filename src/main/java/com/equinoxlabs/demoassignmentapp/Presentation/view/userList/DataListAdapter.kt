package com.equinoxlabs.demoassignmentapp.Presentation.view.userList

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.equinoxlabs.demoassignmentapp.Domain.entity.DataE
import com.equinoxlabs.demoassignmentapp.R
import kotlinx.android.synthetic.main.data_item.view.*

class DataListAdapter(
        var context: Context,
        val items: List<DataE>
    ) :RecyclerView.Adapter<DataListAdapter.ViewHolder>(),Filterable {

    private var mItemsFilterable = items

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.data_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return mItemsFilterable?.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.eName.setText("Name : " + items.get(position).name)
        holder.deptName.setText("Name of Department : " + items.get(position).deptName)

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val eName = itemView.txt_name
        val deptName = itemView.txt_dept_name

    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(charSequence: CharSequence?): FilterResults {
                val charString = charSequence.toString()
                if (charString.isEmpty()) {
                    mItemsFilterable = items
                } else {
                    val filteredList: MutableList<DataE> = ArrayList()
                    for (row in items) {
                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.name!!.toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row)
                        }
                    }
                    mItemsFilterable = filteredList
                }
                val filterResults = FilterResults()
                filterResults.values = mItemsFilterable
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                mItemsFilterable = (results!!.values as ArrayList<DataE>?)!!
                // refresh the list with filtered data
                // refresh the list with filtered data
                notifyDataSetChanged()
            }

         }
    }

}
