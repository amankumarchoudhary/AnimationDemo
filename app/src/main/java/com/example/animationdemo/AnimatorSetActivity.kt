package com.example.animationdemo

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import kotlinx.android.synthetic.main.activity_animator_set.*
import android.animation.Animator
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



class AnimatorSetActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animator_set)

        val SEARCH_ANIMATION_DURATION = 5000L

        btn_start.setOnClickListener {

            val objectAnimatorStartBtn: ObjectAnimator = ObjectAnimator
                .ofFloat(btn_start, "translationX", 300f)
            objectAnimatorStartBtn.duration = SEARCH_ANIMATION_DURATION

            val objectAnimatorLogo: ObjectAnimator = ObjectAnimator
                .ofFloat(iv_logo, "alpha", 1f, 0f)
            objectAnimatorLogo.duration = SEARCH_ANIMATION_DURATION

            val objectAnimatorCancelBtn: ObjectAnimator = ObjectAnimator
                .ofFloat(btn_cancel, "alpha", 0f, 1f)
            objectAnimatorCancelBtn.duration = SEARCH_ANIMATION_DURATION

            val objectAnimatorEditText: ObjectAnimator = ObjectAnimator
                .ofFloat(et_dummy, "alpha", 0f, 1f)
            objectAnimatorEditText.duration = SEARCH_ANIMATION_DURATION


            val animatorSet = AnimatorSet()
            animatorSet.play(objectAnimatorStartBtn).with(objectAnimatorLogo)
            animatorSet.play(objectAnimatorStartBtn).with(objectAnimatorCancelBtn)
            animatorSet.play(objectAnimatorStartBtn).with(objectAnimatorEditText)

            animatorSet.start()

        }

        btn_cancel.setOnClickListener {
            val objectAnimatorStartBtn: ObjectAnimator = ObjectAnimator
                .ofFloat(btn_start, "translationX", 0f)
            objectAnimatorStartBtn.duration = SEARCH_ANIMATION_DURATION

            val objectAnimatorLogo: ObjectAnimator = ObjectAnimator
                .ofFloat(iv_logo, "alpha", 0f, 1f)
            objectAnimatorLogo.duration = SEARCH_ANIMATION_DURATION

            val objectAnimatorCancelBtn: ObjectAnimator = ObjectAnimator
                .ofFloat(btn_cancel, "alpha", 1f, 0f)
            objectAnimatorCancelBtn.duration = SEARCH_ANIMATION_DURATION
            objectAnimatorCancelBtn.startDelay=5000L  //To delay the animation this cancel button

            val objectAnimatorEditText: ObjectAnimator = ObjectAnimator
                .ofFloat(et_dummy, "alpha", 1f, 0f)
            objectAnimatorEditText.duration = SEARCH_ANIMATION_DURATION


            val animatorSet = AnimatorSet()
            animatorSet.play(objectAnimatorStartBtn).with(objectAnimatorLogo)
            animatorSet.play(objectAnimatorStartBtn).with(objectAnimatorCancelBtn)
            animatorSet.play(objectAnimatorStartBtn).with(objectAnimatorEditText)

            animatorSet.start()


            animatorSet.addListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator) {
                    // do anything before animation start
                }

                override fun onAnimationEnd(animation: Animator) {
                    // do other stuff after animation ends
                }

                override fun onAnimationCancel(animation: Animator) {
                    // do something when animation is cancelled
                }

                override fun onAnimationRepeat(animation: Animator) {
                    // do something when animation is repeating
                }
            })
        }
    }
}
