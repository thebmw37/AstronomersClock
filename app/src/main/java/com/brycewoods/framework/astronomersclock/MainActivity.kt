/*
* Created by Bryce Woods (11/21/21)
*/

package com.brycewoods.framework.astronomersclock

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set background color to black
        getWindow().getDecorView().setBackgroundColor(Color.BLACK);
    }
}