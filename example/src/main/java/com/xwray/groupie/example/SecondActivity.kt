package com.xwray.groupie.example

import android.os.Bundle
import android.view.ContextThemeWrapper
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Section
import com.xwray.groupie.example.core.decoration.CarouselItemDecoration
import com.xwray.groupie.example.core.decoration.DebugItemDecoration
import com.xwray.groupie.example.item.CarouselItem
import com.xwray.groupie.example.item.LevelCardItem
import com.xwray.groupie.example.item.TextItem
import com.xwray.groupie.groupiex.plusAssign
import kotlinx.android.synthetic.main.activity_main.*

class SecondActivity : AppCompatActivity() {
    private val gray: Int by lazy { ContextCompat.getColor(this, R.color.background) }
    private val betweenPadding: Int by lazy { resources.getDimensionPixelSize(R.dimen.padding_standard) }
    private val rainbow200: IntArray by lazy { resources.getIntArray(R.array.rainbow_200) }


    private val groupAdapter = GroupAdapter<GroupieViewHolder>()
    lateinit var groupLayoutManager:GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        populateAdapter()

        setupLayout()
    }

    private fun populateAdapter() {
        groupAdapter.clear()

        val texts = arrayListOf("Beginner High", "Elementary", "Intermediate", "Upper-Intermediate", "Advance", "Upper-Advance")
        // Horizontal carousel
        for (i in 0 .. 5) {
            groupAdapter += TextItem(texts[i])
            groupAdapter += makeCarouselItem()
        }
        /*groupAdapter += Section(TextItem("Beginner")).apply {
            add(makeCarouselItem())
        }

        groupAdapter += Section(TextItem("Elementary")).apply {
            add(makeCarouselItem())
        }

        groupAdapter += Section(TextItem("Intermediate")).apply {
            add(makeCarouselItem())
        }

        groupAdapter += Section(TextItem("Upper-Intermediate")).apply {
            add(makeCarouselItem())
        }

        groupAdapter += Section(TextItem("Advance")).apply {
            add(makeCarouselItem())
        }

        groupAdapter += Section(TextItem("Upper-Advance")).apply {
            add(makeCarouselItem())
        }*/
    }

    private fun makeCarouselItem(): CarouselItem {
        val carouselDecoration = CarouselItemDecoration(0xFFFFFF, betweenPadding)
        val carouselAdapter = GroupAdapter<GroupieViewHolder>()

        val array = arrayOf("Elementary", "Level 1", "Level 2", "Level 3", "Level 4", "Level 5", "Level 6","Level 7", "Level 8", "Level 9")
        for (i in 0..9) {
            carouselAdapter += LevelCardItem(array[i], i == 0)
        }
        return CarouselItem(carouselDecoration, carouselAdapter)
    }

    private fun setupLayout() {
        groupLayoutManager = GridLayoutManager(this, groupAdapter.spanCount)/*.apply {
            spanSizeLookup = groupAdapter.spanSizeLookup
        }*/

        recyclerView.apply {
            layoutManager = groupLayoutManager
//            addItemDecoration(HeaderItemDecoration(gray, betweenPadding))
//            addItemDecoration(InsetItemDecoration(gray, betweenPadding))
//            addItemDecoration(DebugItemDecoration(context))

            /*val dividerItemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            dividerItemDecoration.setDrawable(getDrawable(R.drawable.divider_rect))
            addItemDecoration(dividerItemDecoration)*/

            adapter = groupAdapter
        }
    }
}