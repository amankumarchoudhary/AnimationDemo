package com.example.animationdemo

import android.animation.AnimatorInflater
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_value_animator.*

class ValueAnimatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_value_animator)

        /*val valueAnimator:ValueAnimator= ValueAnimator.ofFloat(0f,1000f)
        valueAnimator.interpolator=AccelerateDecelerateInterpolator()

        valueAnimator.duration=5000*/



        /*val valueAnimator:ValueAnimator=AnimatorInflater
            .loadAnimator(this,R.animator.value_animator_ex) as ValueAnimator*/

        /*valueAnimator.addUpdateListener {
            val progress=it.animatedValue as Float
            tv_animate.translationY= progress
        }

        valueAnimator.start()*/

        /*val objectAnimator:ObjectAnimator= ObjectAnimator.ofFloat(tv_animate,"translationY",
            0f,1000f)
        objectAnimator.interpolator=AccelerateDecelerateInterpolator()
        objectAnimator.duration=5000*/

        val objectAnimator=AnimatorInflater.loadAnimator(this,R.animator.object_animator_ex) as ObjectAnimator
        objectAnimator.target=tv_animate
        objectAnimator.start()

        objectAnimator.start()
        tv_animate.setOnClickListener {
            Toast.makeText(this@ValueAnimatorActivity,"yeah!",Toast.LENGTH_SHORT).show()
            Log.d("msg","Done")
        }
    }
}
