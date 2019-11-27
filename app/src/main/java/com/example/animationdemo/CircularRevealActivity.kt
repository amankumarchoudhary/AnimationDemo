package com.example.animationdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.R.attr.start
import android.view.ViewAnimationUtils
import android.animation.Animator
import android.animation.AnimatorInflater
import android.opengl.ETC1.getHeight
import android.opengl.ETC1.getWidth
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import kotlinx.android.synthetic.main.activity_circular_reveal.*


class CircularRevealActivity : AppCompatActivity() {

    var isAbleToShowCircularReveal=true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_circular_reveal)

        fab.setOnClickListener {
            if(isAbleToShowCircularReveal) {
                createCircularReveal(parent_view)
                isAbleToShowCircularReveal=false
            }else{
                hideCircularReveal(parent_view)
                isAbleToShowCircularReveal=true
            }
        }
    }


    private fun createCircularReveal(view:View){
        val centerX = fab.x.toInt() + fab.width / 2
        val centerY = fab.y.toInt()
        val finalRadius = Math.hypot(view.width.toDouble(), view.height.toDouble()).toFloat()
        // starts the effect at centerX, center Y and covers final radius

        val revealAnimator = ViewAnimationUtils.createCircularReveal(
            view,
            centerX, centerY, 0f, finalRadius
        )

        revealAnimator.duration=2000L

        view.visibility = View.VISIBLE
        revealAnimator.start()
    }

    private fun hideCircularReveal(view:View){
        val cx=fab.x.toInt()+fab.width/2
        val cy=fab.y.toInt()
        val initialRadius=Math.hypot(view.width.toDouble(),view.height.toDouble()).toFloat()

        val revealCircularAnimator=ViewAnimationUtils.createCircularReveal(
            view,cx,cy,initialRadius,0f
        )

        revealCircularAnimator.duration=2000L

        revealCircularAnimator.addListener(object: Animator.AnimatorListener{
            override fun onAnimationRepeat(p0: Animator?) {
            }

            override fun onAnimationEnd(p0: Animator?) {
                view.visibility=View.INVISIBLE
            }

            override fun onAnimationCancel(p0: Animator?) {
            }

            override fun onAnimationStart(p0: Animator?) {
            }

        })

        revealCircularAnimator.start()


    }
}
