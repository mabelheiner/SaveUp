package com.example.saveup

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Celebration: AppCompatActivity() {

    //displays a congratulation message to the user
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.celebration)

        // allows the user to go back and add a new item
        var again = findViewById<Button>(R.id.new_item)

        again.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}