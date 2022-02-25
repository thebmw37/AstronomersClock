package com.brycewoods.framework.astronomersclock

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import java.text.SimpleDateFormat
import java.util.*

/**
 * A simple [Fragment] subclass.
 * Use the [ClockFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ClockFragment : Fragment() {

    private var clockTime: TextView? = null
    private var clockUnits: TextView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_clock, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        clockTime = view.findViewById<TextView>(R.id.clockTime)
        clockUnits = view.findViewById<TextView>(R.id.clockUnits)
    }

    fun update() {
        clockTime?.text = getLocalTime()
    }

    fun getLocalTime(): String? {
        return getDateTime()?.split(" ")?.get(1)
    }

    fun getDateTime(): String? {
        val sdf = SimpleDateFormat("MM/dd/yyyy hh:mm:ss")
        return sdf.format(Calendar.getInstance().time)
    }

    fun setTextSize(clockSize: Float, unitSize: Float) {
        clockTime?.textSize = clockSize
        clockUnits?.textSize = unitSize
    }

    fun setDefaultText() {
        clockTime?.text = "00:00:00"
        clockUnits?.text = "Units"
    }
}