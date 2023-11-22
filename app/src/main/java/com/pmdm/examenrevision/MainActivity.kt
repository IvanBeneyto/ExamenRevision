package com.pmdm.examenrevision

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var vTable2: CardView
    private lateinit var vTable4: CardView
    private lateinit var vTable8: CardView
    private lateinit var btnBook: FloatingActionButton
    private lateinit var btnUpHour: FloatingActionButton
    private lateinit var btnDownHour: FloatingActionButton
    private lateinit var etName: EditText
    private lateinit var tvHour: TextView

    private var tableSel: Int = 0
    private var iHourSel = 0
    private var numEaters = 2
    private var lHours = listOf("20:00", "21:00", "22:00")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComponents()
        initListeners()
    }

    private fun initListeners() {
        vTable2.setOnClickListener {
            tableSel = 0
            numEaters = 2
            setTableColor()
        }
        vTable4.setOnClickListener {
            tableSel = 1
            numEaters = 4
            setTableColor()
        }
        vTable8.setOnClickListener {
            tableSel = 2
            numEaters = 8
            setTableColor()
        }

        btnUpHour.setOnClickListener {
            if (iHourSel == lHours.size - 1) iHourSel = 0
            else iHourSel++
            tvHour.text = lHours[iHourSel]
        }

        btnDownHour.setOnClickListener {
            if (iHourSel == 0) iHourSel = lHours.size - 1
            else iHourSel--
            tvHour.text = lHours[iHourSel]
        }

        btnBook.setOnClickListener {
            val name = etName.text.toString()
            if (name.isEmpty()) {
                Toast.makeText(this, "Introduce tu nombre antes de reservar", Toast.LENGTH_LONG)
                    .show()
            } else {
                val intentGA = Intent(this, ResultActivity::class.java)
                intentGA.putExtra("EXTRA_NAME", name)
                intentGA.putExtra("EXTRA_HOUR", lHours[iHourSel])
                intentGA.putExtra("EXTRA_TABLE", numEaters)
                startActivity(intentGA)
            }
        }
    }

    private fun setTableColor() {
        vTable2.setCardBackgroundColor(getBackgroundColor(tableSel == 0))
        vTable4.setCardBackgroundColor(getBackgroundColor(tableSel == 1))
        vTable8.setCardBackgroundColor(getBackgroundColor(tableSel == 2))
    }

    private fun getBackgroundColor(isCompSelected: Boolean): Int {
        val colorReference = if (isCompSelected) {
            R.color.seleccionados
        } else {
            R.color.elementos
        }
        return ContextCompat.getColor(this, colorReference)
    }

    private fun initComponents() {
        vTable2 = findViewById(R.id.vTable2)
        vTable4 = findViewById(R.id.vTable4)
        vTable8 = findViewById(R.id.vTable8)
        btnBook = findViewById(R.id.btnBook)
        btnUpHour = findViewById(R.id.btnUpHour)
        btnDownHour = findViewById(R.id.btnDownHour)
        etName = findViewById(R.id.etName)
        tvHour = findViewById(R.id.tvHour)
    }
}