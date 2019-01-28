package com.ryanhurst.levelfragment.example


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ryanhurst.levelfragment.R
import com.ryanhurst.levelfragment.LevelFragment

/**
 * A simple [Fragment] subclass.
 */
internal class GooglyEyeFragment : LevelFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_googly_eye, container, false)
    }
}
