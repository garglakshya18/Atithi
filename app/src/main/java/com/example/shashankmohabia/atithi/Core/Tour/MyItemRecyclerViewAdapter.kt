package com.example.shashankmohabia.atithi.Core.Tour

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.shashankmohabia.atithi.R


import com.example.shashankmohabia.atithi.Core.Tour.TourFragment.OnListFragmentInteractionListener
import com.example.shashankmohabia.atithi.Core.Tour.dummy.DummyContent.DummyItem
import com.example.shashankmohabia.atithi.Data.Model_Classes.Place

import kotlinx.android.synthetic.main.tour_fragment_item.view.*

/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class MyItemRecyclerViewAdapter(
        private val mValues: MutableList<Place>,
        private val mListener: OnListFragmentInteractionListener?)
    : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as Place
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
            mListener?.onListFragmentInteraction(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.tour_fragment_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.place_name.text = item.name
        holder.place_location.text = holder.getPlaceString(item.city, item.state)

        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val place_name: TextView = mView.place_name
        val place_location: TextView = mView.place_location

        fun getPlaceString(city: String, state: String): String {
            return "$city, $state"
        }
    }
}
