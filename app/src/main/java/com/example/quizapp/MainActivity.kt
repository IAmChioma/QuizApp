package com.example.quizapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.RadioButton
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDateTime
import java.util.Date
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity(){
    var score = 0.0

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        radioGroup.setOnCheckedChangeListener{ group, checkId ->
            val clicked = radioGroup.findViewById(R.id.yes) as RadioButton
            val checked = clicked.isChecked
            if(checked){
                score += 33.3
            }

        }
        submit.setOnClickListener(submitClickAction())
        reset.setOnClickListener{resetButtonClick()}



    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun submitClickAction(): (View) -> Unit = {
        val builder = AlertDialog.Builder(this@MainActivity)
        //  Set the basic information for the builder object
        var currentDate = LocalDateTime.now();
        var response =
            "Congratulations! You submitted on ${currentDate.month} ${currentDate.dayOfMonth}, ${currentDate.year}\n" +
                    "and ${currentDate.hour}:${currentDate.minute} , You achieved  ${score.roundToInt()}%”\n"

        builder.setTitle("Result")
        builder.setMessage(response)
        builder.setIcon(R.drawable.alerticon)

        builder.setPositiveButton("Ok") { dialogInterface, which ->
            resetButtonClick()
            dialogInterface.dismiss() // dismiss the dialog
        }

        val dialog: AlertDialog = builder.create()
        dialog.show()

    }

    fun resetButtonClick() {
        reset.setOnClickListener {
            radioGroup.clearCheck()
            if (checkBox_running.isChecked) {
                checkBox_running.setChecked(false)
            }
            if (checkBox_destroyed.isChecked) {
                checkBox_destroyed.setChecked(false)
            }
            if (checkBox_paused.isChecked) {
                checkBox_paused.setChecked(false)
            }
            if (checkBox_a.isChecked) {
                checkBox_a.setChecked(false)
            }
            if (checkBox_b.isChecked) {
                checkBox_b.setChecked(false)
            }
            if (checkBox_none.isChecked) {
                checkBox_none.setChecked(false)
            }

            score = 0.0
        }
    }

    fun onCheckboxClicked(view: View) {
        // Logic to check is it right component
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked

            when (view.id) {
                R.id.checkBox_running -> {
                    if (checked) {
                        score += 0
                    }
                }
                R.id.checkBox_destroyed -> {
                    if (checked) {
                        score += 33.3
                    }
                }
                R.id.checkBox_paused -> {
                    if (checked) {
                        score += 0
                    }
                }
            }

        }

    }
    fun onCheckboxClickedQuestion3(view: View) {
        // Logic to check is it right component
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked

            when (view.id) {
                R.id.checkBox_a -> {
                    if (checked) {
                        score += 16.65
                    }
                }
                R.id.checkBox_b -> {
                    if (checked) {
                        score += 16.65
                    }
                }
                R.id.checkBox_none -> {
                    if (checked) {
                        score += 0
                    }
                }
            }


        }
        }

}