package com.example.calculator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    private var operand1: Double? = null
    private var operand2: Double = 0.0
    private var pendingOperation = "="


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listener = View.OnClickListener { v ->
            val b = v as TextView
            newNumber.append(b.text.toString())
        }

        btn0.setOnClickListener(listener)
        btn1.setOnClickListener(listener)
        btn2.setOnClickListener(listener)
        btn3.setOnClickListener(listener)
        btn4.setOnClickListener(listener)
        btn5.setOnClickListener(listener)
        btn6.setOnClickListener(listener)
        btn7.setOnClickListener(listener)
        btn8.setOnClickListener(listener)
        btn9.setOnClickListener(listener)
        btnDot.setOnClickListener(listener)

        val opListener = View.OnClickListener { v ->
            val op = (v as TextView).text.toString()
            val value = newNumber.text.toString()
            if (value.isNotEmpty()) {
                performOperation(value, op)
            }
            pendingOperation = op
            operation.text = pendingOperation
        }

        btnEqual.setOnClickListener(opListener)
        btnPlus.setOnClickListener(opListener)
        btnMinus.setOnClickListener(opListener)
        btnMult.setOnClickListener(opListener)
        btnDiv.setOnClickListener(opListener)

        btnAC.setOnClickListener {
            finish();
            startActivity(intent);
        }

        btnDel.setOnClickListener {
            newNumber.setText(newNumber.text.dropLast(1))
            newNumber.setSelection(newNumber.length())
        }

    }

    private fun performOperation(value: String, oper: String) {
        if (operand1 == null) {
            operand1 = value.toDouble()
        } else {
            operand2 = value.toDouble()

            if (operation.text == "=") {
                operation.text = oper
            }

            when (operation.text) {
                "=" -> operand1 = operand2
                "/" -> if (operand2 == 0.0) {
                    operand1 = Double.NaN
                } else {
                    operand1 = operand1!! / operand2
                }
                "*" -> operand1 = operand1!! * operand2
                "-" -> operand1 = operand1!! - operand2
                "+" -> operand1 = operand1!! + operand2
            }

        }
        result.setText(operand1.toString())
        newNumber.setText("")
    }

}







