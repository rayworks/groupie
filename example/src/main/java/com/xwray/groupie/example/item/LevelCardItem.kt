package com.xwray.groupie.example.item

import android.view.Gravity
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import com.rayworks.shadowlib.RoundLinerLayoutNormal
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import com.xwray.groupie.example.R

class LevelCardItem(private val title: String, private val highlighted: Boolean = false) : Item<GroupieViewHolder>() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.root.findViewById<TextView>(R.id.name).text = title
    }

    override fun getLayout(): Int = if (highlighted) R.layout.item_cert_card_first else R.layout.item_cert_card

    override fun getViewType(): Int {
        if (highlighted) {
            return R.layout.item_cert_card_first
        }
        return super.getViewType()
    }

    override fun createViewHolder(itemView: View): GroupieViewHolder {
        return super.createViewHolder(itemView).apply { setIsRecyclable(false) }
    }

    override fun bind(viewHolder: GroupieViewHolder, position: Int, payloads: MutableList<Any>) {
        super.bind(viewHolder, position, payloads)
        if (position == 0 && highlighted) {
            val topLayout = viewHolder.root.findViewById<RoundLinerLayoutNormal>(R.id.top_layout)

            val contentLayout = viewHolder.root.findViewById<RelativeLayout>(R.id.card_layout)
            contentLayout.background = null

            topLayout.updateShadowBackground(
                    shadowGravity = Gravity.BOTTOM,
                    insetBottomValue = topLayout.currElevation * 2,
                    dy = (topLayout.currElevation / 2).toFloat()
            )
        }
    }

}