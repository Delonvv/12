package com.example.delivery

import android.os.Bundle
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.on_boarding1)



    }

    var start_x = 0
    var end_x = 0

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_UP -> start_x = event.x.toInt()
            MotionEvent.ACTION_DOWN -> end_x = event.x.toInt()
        }
        if (start_x != 0 && end_x != 0) {
            if (start_x > end_x) {
                setContentView(R.layout.on_boarding1)
            } else if (start_x < end_x) {
                setContentView(R.layout.on_boarding2)
            }
            start_x = 0
            end_x = 0
        }
        return false
    }


}