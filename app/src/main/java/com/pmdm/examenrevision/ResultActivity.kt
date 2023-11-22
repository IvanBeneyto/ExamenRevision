package com.pmdm.examenrevision

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    private lateinit var tvResult:TextView
    private var name:String = ""
    private var hour:String = ""
    private var seats:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        initComponents()
        getExtras()
        initUI()
    }

    private fun initComponents() {
        tvResult = findViewById(R.id.tvResult)
    }

    private fun getExtras() {
        name = intent.extras?.getString("EXTRA_NAME").orEmpty()
        hour = intent.extras?.getString("EXTRA_HOUR").orEmpty()
        seats = intent.extras?.getString("EXTRA_TABLE").orEmpty()
    }

    private fun initUI() {
        tvResult.text = "MESA RESERVADA PARA $seats A NOMBRE DE $name PARA LAS $hour"
    }
}