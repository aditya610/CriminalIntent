package com.bignerdranch.android.criminalintent

import android.app.Application

class CriminalIntenApplicaton: Application() {
    override fun onCreate() {
        super.onCreate()
        CrimeRepository.intialize(this)
    }
}