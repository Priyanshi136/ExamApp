package com.example.assignmentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.assignmentapp.databinding.ActivitySmileyRatingViewBinding

class SmileyRatingView : AppCompatActivity() {

    lateinit var binding : ActivitySmileyRatingViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySmileyRatingViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.ratingBar.setOnRatingBarChangeListener { _, rating, _ ->
            binding.smileyView.setSmiley(rating =
//            if(rating > 4){
//                rating-1
//            } else {
//                rating
//            }
            rating-1
            )
        }

        binding.btnSubmit.setOnClickListener {
            finish()
            Toast.makeText(this, "Thanks for the feedback :)", Toast.LENGTH_SHORT).show()
        }

    }
}