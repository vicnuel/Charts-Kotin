package com.vicnuel.charts

import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.utils.ColorTemplate
import com.vicnuel.charts.databinding.ActivityBarChartBinding

class BarChartActivity : AppCompatActivity() {

    private lateinit var bindind: ActivityBarChartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        bindind = ActivityBarChartBinding.inflate(layoutInflater)

        setContentView(bindind.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val list:ArrayList<BarEntry> = ArrayList()

        list.add(BarEntry(100f, 50f))
        list.add(BarEntry(101f, 31f))
        list.add(BarEntry(102f, 12f))
        list.add(BarEntry(103f, 13f))
        list.add(BarEntry(104f, -14f))

        val barDataSet = BarDataSet(list, "List")

        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS, 255)

        barDataSet.valueTextColor= Color.BLACK

        val barData = BarData(barDataSet)

        with(bindind) {
            barChart.data=barData
            barChart.description.text = "Gráfico de Barra"
            barChart.animateY(200)
        }
    }
}