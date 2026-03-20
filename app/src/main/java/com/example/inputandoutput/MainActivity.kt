package com.example.inputandoutput

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    enum class Languages {
        ENGLISH,
        NDEBELE,
        PEDI,
        SOTHO,
        SWATI,
        TSONGA,
        TSWANA,
        VENDA,
        XHOSA,
        ZULU,
        AFRIKAANS,

    }


    @SuppressLint("SetTextI18n", "UseSwitchCompatOrMaterialCode", "CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //assigning UI elements to variables
        val editNameTxt = findViewById<EditText>(R.id.editNameTxt)
        val zuluSwitch = findViewById<Switch>(R.id.switchBtn)
        val displayTxt = findViewById<TextView>(R.id.displayTxt)
        val clickBtn = findViewById<Button>(R.id.clickBtn)


        //Create enum here


        // code for when the button is clicked
        clickBtn.setOnClickListener {
            //local variables only for the scope of THIS function
            var greeting: String
            var zulu: Boolean = zuluSwitch.isChecked
            var age: Int = 20

            // set up the spinner options
            val lanuageSpin = findViewById<Spinner>(R.id.languageSpin)
            lanuageSpin.adapter = ArrayAdapter<Languages>(
                this,android.R.layout.simple_list_item_1, Languages.values()
            )



//            //creating a toast to display when the user clicks the button
//            Toast.makeText(this@MainActivity, "Button clicked!",
//                Toast.LENGTH_LONG).show()
//
//            //if Zulu toggle is on
//            if(zulu) {
//                greeting = "Sawubona ${editNameTxt.text}"
//            }
//
//
//            //if Zulu toggle is NOT on
//            else {
//          //Special greeting if your name is Sam/Samantha AND your age is older than 20
//            if((editNameTxt.text.toString() == "Sam" || editNameTxt.text.toString() == "Samantha")
//                && age > 20) {
//
//                greeting = "Yo ${editNameTxt.text}"
//            } else {
//                //displaying the welcome message to the user
//                greeting = "Greetings ${editNameTxt.text}"
//
//            }
//
//        }
//         //display our greeting on the text field in our UI
//         displayTxt.text = greeting


            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }
    }}