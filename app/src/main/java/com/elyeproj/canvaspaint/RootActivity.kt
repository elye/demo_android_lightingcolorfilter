package com.elyeproj.canvaspaint

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_root.*

class RootActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_root)

        button_lighting.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        button_color.setOnClickListener {
            startActivity(Intent(this, ColorActivity::class.java))
        }
    }

}
