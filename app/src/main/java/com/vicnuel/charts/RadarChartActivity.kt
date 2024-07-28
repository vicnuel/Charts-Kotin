package com.vicnuel.charts

import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.github.mikephil.charting.data.RadarData
import com.github.mikephil.charting.data.RadarDataSet
import com.github.mikephil.charting.data.RadarEntry
import com.github.mikephil.charting.utils.ColorTemplate
import com.vicnuel.charts.databinding.ActivityRadarChartBinding

class RadarChartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRadarChartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRadarChartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val list: ArrayList<RadarEntry> = ArrayList()

        list.add(RadarEntry(166f))
        list.add(RadarEntry(155f))
        list.add(RadarEntry(144f))
        list.add(RadarEntry(133f))
        list.add(RadarEntry(122f))

        val radarDataSet = RadarDataSet(list, "Lista")

        with(radarDataSet) {
            setColors(ColorTemplate.COLORFUL_COLORS, 255)
            lineWidth=2f
            valueTextSize=14f
            valueTextColor=Color.RED
        }

        val radarData = RadarData()
        radarData.addDataSet(radarDataSet)

        with(binding) {
            radarChart.data = radarData
            radarChart.description.text = "Dados"
            radarChart.animateY(2000)

        }


    }
}