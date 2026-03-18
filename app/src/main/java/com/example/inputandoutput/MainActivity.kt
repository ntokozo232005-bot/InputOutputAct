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
        val displayTxt = findViewById<TextView>(R.id.displayTxt)
        val editNameTxt = findViewById<EditText>(R.id.editNameTxt)
        val zuluBtn = findViewById<Switch>(R.id.switchBtn)



        // add code to the button that happens when its clicked
        button?.setOnClickListener {
            Toast.makeText(
                this@MainActivity,
                "Button clicked ", Toast.LENGTH_LONG
            ).show()

            displayTxt.text = "Welcome ,${editNameTxt.text}!"

            var greeting: String
            var zulu: Boolean = zuluBtn.isChecked
            var age: Int = 20


            // get the switch that turns on the Zulu greeting
            val switchBtn = findViewById<Switch>(R.id.switchBtn)

            // add code to the button that happens when its clicked
            button?.setOnClickListener {
                var greeting: String
                if (switchBtn.isChecked) {
                    greeting = "Sawubona ,${editNameTxt.text}!"
                } else {
                    // easter egg for sam
                    if (editNameTxt.text.toString() == "Sam") {
                        greeting = "Yo, ${editNameTxt.text}!"
                    } else {
                        greeting = " Greetings,${editNameTxt.text}!"
                    }

                }
                displayTxt.text = greeting

            }
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}