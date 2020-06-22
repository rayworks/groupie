package com.xwray.groupie.example.item

import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.example.CustomItemDecoration
import com.xwray.groupie.example.R
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.item_carousel.*

/**
 * A horizontally scrolling RecyclerView, for use in a vertically scrolling RecyclerView.
 */
class CarouselItem(private val carouselDecoration: RecyclerView.ItemDecoration,
                   private val carouselAdapter: GroupAdapter<com.xwray.groupie.GroupieViewHolder>) : Item() {

    override fun getLayout(): Int {
        return R.layout.item_carousel
    }

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.recyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = carouselAdapter

            // We don't know if the layout we're passed has been bound before so
            // we need to ensure we don't register the item decoration multiple times,
            // by trying to remove it first. (Nothing happens if it's not registered.)

//            removeItemDecoration(carouselDecoration)
//            addItemDecoration(carouselDecoration)

            if(itemDecorationCount == 0) {

//                val dividerItemDecoration = DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL)
//                dividerItemDecoration.setDrawable(resources.getDrawable(R.drawable.divider_rect))
//                addItemDecoration(dividerItemDecoration, 0)

                val dimenBottom = resources.getDimensionPixelSize(R.dimen.level_cert_card_margin_bottom)
                val dimenHorizontal = resources.getDimensionPixelSize(R.dimen.level_cert_card_margin_horizontal)
                addItemDecoration(CustomItemDecoration(bottomPadding = dimenBottom, rightPadding = dimenHorizontal))
            }
        }
    }
}
