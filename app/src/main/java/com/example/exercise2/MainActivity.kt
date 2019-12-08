package com.example.exercise2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputWeight=findViewById<EditText>(R.id.editTextWeight)
        val inputHeight=findViewById<EditText>(R.id.editTextHeight)
        val showImage:ImageView=findViewById(R.id.imageViewProfile)
        val showBMI=findViewById<TextView>(R.id.textViewBMI)

        findViewById<Button>(R.id.buttonCalculate).setOnClickListener(){
            val weight=inputWeight.text.toString().toDouble()
            val height=inputHeight.text.toString().toDouble()

            val bmi=weight/((height/100)*(height/100))

            if(bmi<18.5){
                showImage.setImageResource(R.drawable.under)
            }else if(bmi>=18.5 && bmi<=24.9){
                showImage.setImageResource(R.drawable.normal)
            }else{
                showImage.setImageResource(R.drawable.over)
            }
            showBMI.setText(String.format("BMI: %.2f", bmi))
        }

        findViewById<Button>(R.id.buttonReset).setOnClickListener(){
            inputWeight.setText("")
            inputHeight.setText("")
            showImage.setImageResource(R.drawable.empty)
            showBMI.setText(String.format("BMI: "))
        }
    }
}
