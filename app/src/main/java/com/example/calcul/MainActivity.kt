package com.example.calcul

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView
    private var operand: Double = 0.0
    private var operation: String = ""
    var isDot: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)

    }

    fun numberClick(view: View) {
        if (view is TextView) {
            val number: String = view.text.toString()
            var result: String = resultTextView.text.toString()

            if (result == "0") {
                result = ""
            }

            resultTextView.text = result + number

        }
    }
    fun operationClick(view: View){
        if(view is TextView){

            if (!TextUtils.isEmpty(resultTextView.text)){
                operand = resultTextView.text.toString().toDouble()
            }
            this.operation = view.text.toString()

            resultTextView.text = ""
            isDot = false
        }
    }
    fun equalsClick(view: View){
        val secondOperandText: String = resultTextView.text.toString()
        var secOperand: Double = 0.0

        if(!TextUtils.isEmpty(secondOperandText)){
            secOperand = secondOperandText.toDouble()
        }
        when(operation){
            "+" -> resultTextView.text = (operand + secOperand).toString()
            "-" -> resultTextView.text = (operand - secOperand).toString()
            "*" -> resultTextView.text = (operand * secOperand).toString()
            "/" -> resultTextView.text = (operand / secOperand).toString()

        }
        isDot=true
    }
    fun clearClick(view: View){
        if (!TextUtils.isEmpty(resultTextView.text)){
            resultTextView.text = ""
        }
        isDot=false
    }
    fun dotClick(view: View){
        if (!TextUtils.isEmpty(resultTextView.text ) && isDot == false){
            resultTextView.text = resultTextView.text.toString() + "."
            isDot=true
        }
    }
    fun delClick(view: View){
        if (!TextUtils.isEmpty(resultTextView.text )){
            resultTextView.text = resultTextView.text.toString().dropLast(1)
        }
        isDot = false
    }
}