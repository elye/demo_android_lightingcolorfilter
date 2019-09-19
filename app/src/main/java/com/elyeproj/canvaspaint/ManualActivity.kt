package com.elyeproj.canvaspaint

import android.graphics.LightingColorFilter
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_manual.*

class ManualActivity : AppCompatActivity() {

    var multipler_bb = 0
    var addition_bb = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manual)

        seek_lighting_mul.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                multipler_bb = spread(progress)
                black_background.alpha = 1-progress.toFloat()/255
                setLighting()
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        seek_lighting_add.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                addition_bb = spread(progress)
                white_background.alpha = progress.toFloat()/255
                setLighting()
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        // Initial setting
        settingLightTuned(0)
    }

    private fun settingLightTuned(progress: Int) {
        val bbMul = spread((progress / 255f * 105f + 150).toInt())
        val bbAdd = spread((progress / 255f * 50f + 0).toInt())

        image_background.colorFilter = LightingColorFilter(bbMul, bbAdd)
    }

    private fun spread(progress: Int) = (progress * 0x10000 + progress * 0x100 + progress * 0x1)

    private fun setLighting() {
        image_background.colorFilter = LightingColorFilter(multipler_bb, addition_bb)
    }
}
