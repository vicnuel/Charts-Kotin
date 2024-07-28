package com.vicnuel.charts

import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import com.vicnuel.charts.databinding.ActivityPieChartBinding

class PieChartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPieChartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPieChartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val list: ArrayList<PieEntry> = ArrayList()

        list.add(PieEntry(90f, "dep1"))
        list.add(PieEntry(100f, "dep2"))
        list.add(PieEntry(120f, "dep3"))
        list.add(PieEntry(143f, "dep4"))
        list.add(PieEntry(154f, "dep5"))

        val pieDataSet = PieDataSet(list, "Departamentos")

        pieDataSet.setColors(ColorTemplate.PASTEL_COLORS, 255)

        pieDataSet.valueTextSize=15f

        pieDataSet.valueTextColor = Color.BLACK

        val pieData = PieData(pieDataSet)

        with(binding) {
            pieChart.data = pieData
            pieChart.description.text = "Vendas por departamentos"
            pieChart.description.textSize = 15f
            pieChart.animateY(2000)

        }
    }
}