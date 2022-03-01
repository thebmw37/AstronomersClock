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
    private var clockType: String? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_clock, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        clockTime = view.findViewById<TextView>(R.id.clockTime)
        clockUnits = view.findViewById<TextView>(R.id.clockUnits)
    }

    fun setClockType(type: String?) {
        clockType = type

        when(clockType) {
            "Date" -> clockUnits?.text = "DATE"
            "localTime" -> clockUnits?.text = "MOUNTAIN TIME"
        }
    }

    fun update() {
        when(clockType) {
            "Date" -> clockTime?.text = getDate()
            "localTime" -> clockTime?.text = getLocalTime()
        }
    }

    fun getDate(): String? {
        val dateTime = getDateTime()
        val dateTimeSplit = dateTime?.split("/")
        val month = dateTimeSplit?.get(0)
        val day = dateTimeSplit?.get(1)
        val year = dateTimeSplit?.get(2)?.split(" ")?.get(0)

        return convertMonthIntToString(month?.toInt()) + " " + day + ", " + year
    }

    private fun getLocalTime(): String? {
        return getDateTime()?.split(" ")?.get(1)
    }

    private fun getDateTime(): String? {
        val sdf = SimpleDateFormat("MM/dd/yyyy hh:mm:ss")
        return sdf.format(Calendar.getInstance().time)
    }

    private fun convertMonthIntToString(monthInt: Int?): String? {

        return when(monthInt) {
            1 -> "JAN"
            2 -> "FEB"
            3 -> "MAR"
            4 -> "APR"
            5 -> "MAY"
            6 -> "JUN"
            7 -> "JUL"
            8 -> "AUG"
            9 -> "SEP"
            10 -> "OCT"
            11 -> "NOV"
            12 -> "DEC"
            else -> null
        }
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