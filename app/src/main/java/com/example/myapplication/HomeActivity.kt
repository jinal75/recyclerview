package com.example.myapplication


import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class HomeActivity : AppCompatActivity() {
    lateinit var Name:TextView
    lateinit var message:TextView
    lateinit var  image:ImageView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        Name=findViewById(R.id.txt_name)
        message=findViewById(R.id.txt_message)
        image=findViewById(R.id.img)

        //geting data from adapter
        val intent = intent
        val name = intent.getStringExtra("name")
        Toast.makeText(this, "name : $name", Toast.LENGTH_SHORT).show()
        Name.text=intent.getStringExtra("name")
        message.text=intent.getStringExtra("message")
        Glide.with(this).load("image")
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_launcher_foreground)
            .into(image);
           }
}