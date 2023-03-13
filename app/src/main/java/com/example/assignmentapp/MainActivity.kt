package com.example.assignmentapp

import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.assignmentapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var score = 0
        var choice = 0

        binding.btnQues1.setOnClickListener {
            val options = arrayOf("Java", "C++", "C", "None of the above")
            val builder1 = AlertDialog.Builder(this)
            builder1.setTitle("Android is based on which of the following language?")
            builder1.setSingleChoiceItems(options, 0, DialogInterface.OnClickListener { dialogInterface, i ->
                choice = i
            })

            builder1.setPositiveButton("Submit", DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(this, "Submitted Successfully", Toast.LENGTH_SHORT).show()
                if(choice == 0){
                    score++
                }
            })

            builder1.setNegativeButton("Decline", DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(this, "Your response isn't submitted", Toast.LENGTH_SHORT).show()
            })
            builder1.show()
        }
        choice = 0

        binding.btnQues2.setOnClickListener {
            val options = arrayOf("Third-party emulators", "Emulator included in Android SDK", "Physical android phone", "None of the above")
            val builder2 = AlertDialog.Builder(this)
            builder2.setTitle("On which of the following, developers can test the app?")
            builder2.setMultiChoiceItems(options, null, DialogInterface.OnMultiChoiceClickListener { dialogInterface, i, b ->
                choice = i
            })

            builder2.setPositiveButton("Submit", DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(this, "Submitted Successfully", Toast.LENGTH_SHORT).show()
                if(choice != 3){
                    score++
                }
            })

            builder2.setNegativeButton("Decline", DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(this, "Your response isn't submitted", Toast.LENGTH_SHORT).show()
            })
            builder2.show()
        }
        choice = 0
        binding.btnQues3.setOnClickListener {
            val options = arrayOf("onClick", "onCreate", "onSelect", "None of the above")
            val builder3 = AlertDialog.Builder(this)
            builder3.setTitle("Which method is used to handle clicking of a button?")
            builder3.setSingleChoiceItems(options, 0, DialogInterface.OnClickListener { dialogInterface, i ->
                choice = i
            })

            builder3.setPositiveButton("Submit", DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(this, "Submitted Successfully", Toast.LENGTH_SHORT).show()
                if(choice == 0){
                    score++
                }
            })

            builder3.setNegativeButton("Decline", DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(this, "Your response isn't submitted", Toast.LENGTH_SHORT).show()
            })
            builder3.show()
        }

        binding.btnScore.setOnClickListener {
            val builder4 = AlertDialog.Builder(this)
            builder4.setTitle("Your final score is $score")
            builder4.setMessage("Congratulations, great work")
            builder4.setIcon(R.drawable.ic_baseline_celebration_24)
            builder4.setPositiveButton("Close", DialogInterface.OnClickListener { dialogInterface, i ->

            })
            builder4.setNegativeButton("Feedback", DialogInterface.OnClickListener { dialogInterface, i ->
                val intent = Intent(this, SmileyRatingView::class.java)
                startActivity(intent)
            })
            builder4.show()
        }

        binding.btnExit.setOnClickListener {
            val builder5 = AlertDialog.Builder(this)
            builder5.setTitle("Are you sure?")
            builder5.setMessage("You want to leave the exam")
            builder5.setIcon(R.drawable.ic_baseline_exit_to_app_24)
            builder5.setPositiveButton("Yes", DialogInterface.OnClickListener { dialogInterface, i ->
                finish()
            })
            builder5.setNegativeButton("No", DialogInterface.OnClickListener { dialogInterface, i ->

            })
            builder5.show()
        }
    }
}