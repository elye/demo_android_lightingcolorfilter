package com.elyeproj.canvaspaint

import android.graphics.ColorMatrixColorFilter
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.CompoundButton
import android.widget.RadioButton
import kotlinx.android.synthetic.main.activity_matrix.*

class MatrixActivity : AppCompatActivity() {

    private val radioList by lazy {
        listOf(
            radio_original, radio_red, radio_green, radio_blue, radio_gray,
            radio_gray_red, radio_gray_green, radio_gray_blue, radio_inverse,
            radio_binary, radio_black_white, radio_black_white_light, radio_gbr, radio_brg
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matrix)

        val listener: CompoundButton.OnCheckedChangeListener =
            CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
                if (!isChecked) return@OnCheckedChangeListener
                when (buttonView.id) {
                    radio_original.id -> if (isChecked) {
                        setLighting(
                            matrix = floatArrayOf(
                                1f, 0f, 0f, 0f, 0f,
                                0f, 1f, 0f, 0f, 0f,
                                0f, 0f, 1f, 0f, 0f,
                                0f, 0f, 0f, 1f, 0f
                            )
                        )
                    }
                    radio_gray.id -> if (isChecked) {
                        setLighting(
                            matrix = floatArrayOf(
                                0.33f, 0.33f, 0.33f, 0f, 0f,
                                0.33f, 0.33f, 0.33f, 0f, 0f,
                                0.33f, 0.33f, 0.33f, 0f, 0f,
                                0f, 0f, 0f, 1f, 0f
                            )
                        )

                    }
                    radio_gray_red.id -> if (isChecked) {
                        setLighting(
                            matrix = floatArrayOf(
                                1f, 0f, 0f, 0f, 0f,
                                1f, 0f, 0f, 0f, 0f,
                                1f, 0f, 0f, 0f, 0f,
                                0f, 0f, 0f, 1f, 0f
                            )
                        )
                    }
                    radio_gray_green.id -> if (isChecked) {
                        setLighting(
                            matrix = floatArrayOf(
                                0f, 1f, 0f, 0f, 0f,
                                0f, 1f, 0f, 0f, 0f,
                                0f, 1f, 0f, 0f, 0f,
                                0f, 0f, 0f, 1f, 0f
                            )
                        )
                    }
                    radio_gray_blue.id -> if (isChecked) {
                        setLighting(
                            matrix = floatArrayOf(
                                0f, 0f, 1f, 0f, 0f,
                                0f, 0f, 1f, 0f, 0f,
                                0f, 0f, 1f, 0f, 0f,
                                0f, 0f, 0f, 1f, 0f
                            )
                        )
                    }
                    radio_red.id -> if (isChecked) {
                        setLighting(
                            matrix = floatArrayOf(
                                1f, 1f, 1f, 0f, 0f,
                                0f, 0f, 0f, 0f, 0f,
                                1f, 0f, 0f, 0f, 0f,
                                0f, 0f, 0f, 1f, 0f
                            )
                        )
                    }
                    radio_green.id -> if (isChecked) {
                        setLighting(
                            matrix = floatArrayOf(
                                0f, 0f, 0f, 0f, 0f,
                                1f, 1f, 1f, 0f, 0f,
                                0f, 0f, 0f, 0f, 0f,
                                0f, 0f, 0f, 1f, 0f
                            )
                        )
                    }
                    radio_blue.id -> if (isChecked) {
                        setLighting(
                            matrix = floatArrayOf(
                                0f, 0f, 0f, 0f, 0f,
                                0f, 0f, 0f, 0f, 0f,
                                1f, 1f, 1f, 0f, 0f,
                                0f, 0f, 0f, 1f, 0f
                            )
                        )
                    }
                    radio_inverse.id -> if (isChecked) {
                        setLighting(
                            matrix = floatArrayOf(
                                -1f, 0f, 0f, 0f, 255f,
                                0f, -1f, 0f, 0f, 255f,
                                0f, 0f, -1f, 0f, 255f,
                                0f, 0f, 0f, 1f, 0f
                            )
                        )
                    }
                    radio_binary.id -> if (isChecked) {
                        setLighting(
                            matrix = floatArrayOf(
                                255f, 0f, 0f, 0f, -128*255f,
                                0f, 255f, 0f, 0f, -128*255f,
                                0f, 0f, 255f, 0f, -128*255f,
                                0f, 0f, 0f, 1f, 0f
                            )
                        )
                    }
                    radio_black_white.id -> if (isChecked) {
                        setLighting(
                            matrix = floatArrayOf(
                                85f, 85f, 85f, 0f, -128*255f,
                                85f, 85f, 85f, 0f, -128*255f,
                                85f, 85f, 85f, 0f, -128*255f,
                                0f, 0f, 0f, 1f, 0f
                            )
                        )
                    }
                    radio_black_white_light.id -> if (isChecked) {
                        setLighting(
                            matrix = floatArrayOf(
                                85f, 85f, 85f, 0f, -96*255f,
                                85f, 85f, 85f, 0f, -96*255f,
                                85f, 85f, 85f, 0f, -96*255f,
                                0f, 0f, 0f, 1f, 0f
                            )
                        )
                    }
                    radio_gbr.id -> if (isChecked) {
                        setLighting(
                            matrix = floatArrayOf(
                                0f, 0f, 1f, 0f, 0f,
                                1f, 0f, 0f, 0f, 0f,
                                0f, 1f, 0f, 0f, 0f,
                                0f, 0f, 0f, 1f, 0f
                            )
                        )
                    }
                    radio_brg.id -> if (isChecked) {
                        setLighting(
                            matrix = floatArrayOf(
                                0f, 1f, 0f, 0f, 0f,
                                0f, 0f, 1f, 0f, 0f,
                                1f, 0f, 0f, 0f, 0f,
                                0f, 0f, 0f, 1f, 0f
                            )
                        )
                    }
                }
                uncheckedAllExcept(buttonView as RadioButton)
            }


        radioList.forEach {
            it.setOnCheckedChangeListener(listener)
        }
    }

    private fun uncheckedAllExcept(radioButton: RadioButton) {
        radioList.filter{ it != radioButton }.forEach { it.isChecked = false }
    }

    private fun setLighting(matrix: FloatArray) {
        image_background.colorFilter = ColorMatrixColorFilter(matrix)
    }

}
