package com.elyeproj.canvaspaint

import android.graphics.LightingColorFilter
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.RadioButton
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var multipler_bb = 0
    var addition_bb = 0

    var multipler_bulb = 0
    var addition_bulb = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        seek_lighting_mul.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                multipler_bb = spread(progress)
                setLighting()
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        seek_lighting_add.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                addition_bb = spread(progress)
                setLighting()
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        seek_bulb_mul.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                multipler_bulb = spread(progress)
                setLighting()
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        seek_bulb_add.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                addition_bulb = spread(progress)
                setLighting()
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        seek_lighting.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                settingLightTuned(progress)
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })


        (radio_style.getChildAt(0) as RadioButton).isChecked = true
        radio_style.setOnCheckedChangeListener { _, checkedId ->
            when (findViewById<RadioButton>(checkedId).id) {
                R.id.radio_light_off ->settingLightTuned(0)
                R.id.radio_light_on -> settingLightTuned(128)
                R.id.radio_light_high -> settingLightTuned(255)
            }
        }

        // Initial setting
        settingLightTuned(0)
    }

    private fun settingLightTuned(progress: Int) {
        val bulbMul = spread((progress / 255f * 255f + 0).toInt())
        val bulbAdd = spread((progress / 255f * 200f + 0).toInt())
        val bbMul = spread((progress / 255f * 105f + 150).toInt())
        val bbAdd = spread((progress / 255f * 50f + 0).toInt())

        image_background.colorFilter = LightingColorFilter(bbMul, bbAdd)
        image_bulb.colorFilter = LightingColorFilter(bulbMul, bulbAdd)
    }

    private fun spread(progress: Int) = (progress * 0x10000 + progress * 0x100 + progress * 0x1)

    private fun setLighting() {
        image_background.colorFilter = LightingColorFilter(multipler_bb, addition_bb)
        image_bulb.colorFilter = LightingColorFilter(multipler_bulb, addition_bulb)
    }


}
