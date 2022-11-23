package com.example.bikesinnantes.ui.pumps

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bikesinnantes.model.Pump

class PumpsViewModel : ViewModel() {

    private val _pumps = MutableLiveData<List<Pump>>().apply {
        value = ArrayList()
    }
    val pumps: MutableLiveData<List<Pump>> = _pumps
}