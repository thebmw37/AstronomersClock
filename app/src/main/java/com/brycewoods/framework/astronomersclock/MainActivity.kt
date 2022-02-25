/*
* Created by Bryce Woods (11/21/21)
*/

package com.brycewoods.framework.astronomersclock

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.AttributeSet
import android.view.OrientationEventListener
import android.view.View

class MainActivity : AppCompatActivity() {

    var clock0: ClockFragment? = null
    var clock1: ClockFragment? = null
    var clock2: ClockFragment? = null
    var clock3: ClockFragment? = null
    var clock4: ClockFragment? = null
    var clock5: ClockFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clock0 = supportFragmentManager.findFragmentById(R.id.fragment0) as ClockFragment
        clock1 = supportFragmentManager.findFragmentById(R.id.fragment1) as ClockFragment
        clock2 = supportFragmentManager.findFragmentById(R.id.fragment2) as ClockFragment
        clock3 = supportFragmentManager.findFragmentById(R.id.fragment3) as ClockFragment
        clock4 = supportFragmentManager.findFragmentById(R.id.fragment4) as ClockFragment
        clock5 = supportFragmentManager.findFragmentById(R.id.fragment5) as ClockFragment

        clock1?.setDefaultText()
        clock2?.setDefaultText()
        clock3?.setDefaultText()
        clock4?.setDefaultText()
        clock5?.setDefaultText()

        this.onConfigurationChanged(this.resources.configuration)

        val handler1 = Looper.myLooper()?.let { Handler(it) }

        var runnable1: Runnable? = null

        runnable1 = Runnable {
            clock0!!.update()
            runnable1?.let { handler1?.postDelayed(it, 10) }
        }

        handler1?.postDelayed(runnable1, 10)

    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            clock0?.setTextSize(45F, 26F)
            clock1?.setTextSize(45F, 26F)
            clock2?.setTextSize(45F, 26F)
            clock3?.setTextSize(45F, 26F)
            clock4?.setTextSize(45F, 26F)
            clock5?.setTextSize(45F, 26F)
        }
        else {
            clock0?.setTextSize(30F, 22F)
            clock1?.setTextSize(30F, 22F)
            clock2?.setTextSize(30F, 22F)
            clock3?.setTextSize(30F, 22F)
            clock4?.setTextSize(30F, 22F)
            clock5?.setTextSize(30F, 22F)

        }
    }

}