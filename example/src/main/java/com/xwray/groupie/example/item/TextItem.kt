package com.xwray.groupie.example.item

//import com.xwray.groupie.Item
import com.xwray.groupie.example.R
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.item_header_title.*

class TextItem(private val title: String) : Item() {

    override fun getLayout(): Int {
        return R.layout.item_header_title
    }

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.title.text = this.title
    }
}