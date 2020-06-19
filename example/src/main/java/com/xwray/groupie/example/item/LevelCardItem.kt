package com.xwray.groupie.example.item

import android.view.View
import android.widget.TextView
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import com.xwray.groupie.example.R

class LevelCardItem(private val title: String) : Item<GroupieViewHolder>() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.root.findViewById<TextView>(R.id.name).text = title
    }

    override fun getLayout(): Int = R.layout.item_cert_card

    override fun createViewHolder(itemView: View): GroupieViewHolder {
        return super.createViewHolder(itemView).apply { setIsRecyclable(false) }
    }

}