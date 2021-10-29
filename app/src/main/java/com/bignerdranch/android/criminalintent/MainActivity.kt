package com.bignerdranch.android.criminalintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.util.*

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity(),CrimeListFragment.Callbacks {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragmet_container)
        if (currentFragment == null) {
            val fragmet = CrimeListFragment.newInstance()
            supportFragmentManager.beginTransaction().add(R.id.fragmet_container,fragmet)
                .commit()
        }
    }

    override fun onCrimeSelected(crimeId: UUID) {
        val fragment = CrimeFragment.newInstance(crimeId)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmet_container, fragment)
            .addToBackStack(null)
            .commit()

    }
}