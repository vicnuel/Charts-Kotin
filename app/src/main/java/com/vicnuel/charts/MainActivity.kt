package com.vicnuel.charts

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.vicnuel.charts.databinding.ActivityMainBinding

class  MainActivity : AppCompatActivity() {
    private lateinit var bindind: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        bindind =ActivityMainBinding.inflate(layoutInflater)

        setContentView(bindind.root)

        bindind.goBarChart.setOnClickListener{
            startActivity(Intent(this@MainActivity, BarChartActivity::class.java))
        }

        bindind.goPieChart.setOnClickListener{
            startActivity(Intent(this@MainActivity, PieChartActivity::class.java))
        }

        bindind.goRadarChart.setOnClickListener{
            startActivity(Intent(this@MainActivity,RadarChartActivity::class.java))
        }

    }
}