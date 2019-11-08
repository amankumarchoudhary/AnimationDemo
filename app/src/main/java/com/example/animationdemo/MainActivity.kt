package com.example.animationdemo

import android.content.Intent
import android.graphics.drawable.Animatable
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<ImageView>(R.id.image_view)
        val animatable: Animatable = imageView.drawable as Animatable
        animatable.start()

        /* val imageView=findViewById<ImageView>(R.id.image_view)
        imageView.setBackgroundResource(R.drawable.anim)
        val animationDrawable= imageView.background as AnimationDrawable?

        imageView.setOnClickListener{
            animationDrawable?.start()
        }*/

        imageView.setOnClickListener {
            Toast.makeText(this,"yes",Toast.LENGTH_SHORT).show()
            val intent=Intent(this,CrossfadeActivity::class.java)
            startActivity(intent)

        }
    }
}
