package dev.filipebezerra.example.colormyviews

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import dev.filipebezerra.example.colormyviews.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView<MainActivityBinding>(this, R.layout.main_activity)
            .apply {
                viewBinding = this
                setListeners()
            }
    }

    private fun setListeners() {
        listOf(
            viewBinding.boxOneText,
            viewBinding.boxTwoText,
            viewBinding.boxThreeText,
            viewBinding.boxFourText,
            viewBinding.boxFiveText,
            viewBinding.constraintLayout,
            viewBinding.redButton,
            viewBinding.yellowButton,
            viewBinding.greenButton,
        ).forEach { view ->
            view.setOnClickListener { makeColoredOf(view) }
        }
    }

    private fun makeColoredOf(view: View) {
        when (view.id) {
            // Boxes using Color class colors for background
            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)

            // Boxes using Android color resources for background
            R.id.box_three_text -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.box_four_text -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.box_five_text -> view.setBackgroundResource(android.R.color.holo_green_light)

            // Boxes using custom colors for background
            R.id.red_button -> viewBinding.boxThreeText.setBackgroundResource(R.color.red)
            R.id.yellow_button -> viewBinding.boxFourText.setBackgroundResource(R.color.yellow)
            R.id.green_button -> viewBinding.boxFiveText.setBackgroundResource(R.color.green)

            else -> view.setBackgroundResource(R.color.purple_200)
        }
    }
}