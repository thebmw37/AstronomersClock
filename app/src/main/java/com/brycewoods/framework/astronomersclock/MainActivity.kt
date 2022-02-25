/*
* Created by Bryce Woods (11/21/21)
*/

package com.brycewoods.framework.astronomersclock

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.AttributeSet
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val clock0 = supportFragmentManager.findFragmentById(R.id.fragment0) as ClockFragment

        val handler1 = Looper.myLooper()?.let { Handler(it) }

        var runnable1: Runnable? = null

        runnable1 = Runnable {
            clock0.update()
            runnable1?.let { handler1?.postDelayed(it, 200) }
        }

        handler1?.postDelayed(runnable1, 200)
    }

}