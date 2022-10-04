package com.example.facebook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.facebook.login.LoginManager
import com.google.firebase.auth.FirebaseAuth
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    var auth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var image = findViewById<ImageView>(R.id.imageView)
        var name = findViewById<TextView>(R.id.textView)
        var logout = findViewById<Button>(R.id.logout)
        name.setText(auth.currentUser?.displayName)
        Picasso.get()
            .load(auth.currentUser?.photoUrl)
            .into(image)
        logout.setOnClickListener {
            LoginManager.getInstance().logOut()

        }
    }



}


