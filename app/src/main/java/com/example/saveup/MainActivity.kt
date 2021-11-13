package com.example.saveup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    //sets the value on the progress bar
    var progr = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var calculate = findViewById<Button>(R.id.calc)
        var item_total = findViewById<EditText>(R.id.item_total).text
        var item_name = findViewById<EditText>(R.id.item_name).text
        var amount_saved = findViewById<EditText>(R.id.amount_saved).text
        var total_saved = 0.0

        //progress bar displays the percentage of the item saved for in a circular fashion
        //with the percentage in the middle
        var progress_bar = findViewById<ProgressBar>(R.id.progress_bar)
        var text_view_progress = findViewById<TextView>(R.id.text_view_progress)
        var months_left = findViewById<TextView>(R.id.months_left)

        //determines how many months until the user has enough money for the item.
        calculate.setOnClickListener {
            total_saved += amount_saved.toString().toDouble()
            var percent = (total_saved / item_total.toString().toDouble()) * 100
            progr = percent.toInt()

            if (percent >= 100.0) {
                val intent = Intent(this, Celebration::class.java)
                startActivity(intent)
            }

            var months = ((item_total.toString().toDouble() - total_saved) / amount_saved.toString().toDouble()).toInt()

            months_left.text = ("Months till goal: $months")
            progress_bar.progress = 100 - progr
            text_view_progress.text = "$progr%"
        }
    }

}
