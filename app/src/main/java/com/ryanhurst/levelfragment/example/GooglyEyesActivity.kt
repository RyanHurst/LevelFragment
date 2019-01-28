package com.ryanhurst.levelfragment.example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ryanhurst.levelfragment.R

/**
 * Activity to show two [GooglyEyeFragment]s
 */
internal class GooglyEyesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_googly_eyes)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .add(R.id.left, GooglyEyeFragment())
                    .add(R.id.right, GooglyEyeFragment())
                    .commit()
        }
    }
}
