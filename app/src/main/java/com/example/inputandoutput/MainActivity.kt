package com.example.inputandoutput

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n", "UseSwitchCompatOrMaterialCode", "CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        // get the button using the id we set on the user interface
        val button = findViewById<Button>(R.id.clickBtn)

        // get the text view and edit text
        val welcomeTxt =
            findViewById<TextView>(R.id.displayTxt)
        val editNameTxt =
            findViewById<EditText>(R.id.editNameTxt)


        //add code to the button that happens when its clicked
        button?.setOnClickListener {
            Toast.makeText(this@MainActivity,
                "Button Clicked", Toast.LENGTH_SHORT).show()
        }
            welcomeTxt.text = "Welcome ,${editNameTxt.text}!"

        // get the switch that turns on the Zulu greeting
        val zuluBtn = findViewById<Switch>(R.id.switchBtn)

        // add the  age
        val age: Int = 20

        // add code to the button that happens when its clicked
        button?.setOnClickListener {
            var greeting: String
            if (zuluBtn.isChecked) {
                greeting = "Sawubona ,${editNameTxt.text}!"
            } else {
                // Easter egg for Sam
                greeting = if (editNameTxt.text.toString() == "Sam") {
                    "Hello ,${editNameTxt.text}!"
                } else {
                    "Hello ,${editNameTxt.text}!"

                }
            }
            welcomeTxt.text = greeting
            val zulu: Boolean = zuluBtn.isChecked
            if (zulu) {
                welcomeTxt.text = "Sawubona ,${editNameTxt.text}!"
            } else {
                // easter egg for Sam/Samantha
                greeting = "Hello ,${editNameTxt.text}!"

        }

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}