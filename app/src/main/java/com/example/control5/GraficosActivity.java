package com.example.control5;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;

public class GraficosActivity extends AppCompatActivity {

    private BarChart barchart;
    private String [] month= new String[] {"Model 3", "H2", "Camaro SS"};
    private int [] sales= new int[] {45, 43, 40};
    private int[] colors= new int[] {Color.BLUE, Color.RED, Color.GREEN};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graficos);
        barchart = (BarChart) findViewById(R.id.grafica);
        legend(barchart);
        createCharts();

    }
    private Chart getSameChart(Chart chart, String description, int textColor, int background){
        chart.getDescription().setText(description);
        chart.getDescription().setTextSize(15);
        chart.setBackgroundColor(background);
        return chart;
    }
    private void legend (Chart chart){
        Legend legend=chart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        ArrayList<LegendEntry> entries = new ArrayList<>();
        for(int i=0;i<month.length;i++){
            LegendEntry entry = new LegendEntry();
            entry.formColor = colors[i];
            entry.label = month[i];
            entries.add(entry);
        }
        legend.setCustom(entries);
    }

    private ArrayList <BarEntry> getBarEntries(){
        ArrayList<BarEntry> entries = new ArrayList<>();
        for(int i=0; i< month.length; i++)
            entries.add(new BarEntry(i, sales[i]));
            return entries;
    }

    private void axisX(XAxis axis){
        axis.setGranularityEnabled(true);
        axis.setPosition(XAxis.XAxisPosition.BOTTOM);
        axis.setValueFormatter(new IndexAxisValueFormatter(month));
    }
    private void axisLeft(YAxis axis){
        axis.setEnabled(false);
    }
    private void axisRight(YAxis axis){
        axis.setEnabled(false);
    }
    public void createCharts(){
        barchart = (BarChart) getSameChart(barchart, "Ventas", Color.RED, Color.WHITE);
        barchart.setDrawBarShadow(true);
        barchart.setData(getBarData());
        barchart.invalidate();
        barchart.setDrawGridBackground(true);
        axisX(barchart.getXAxis());
        axisLeft(barchart.getAxisLeft());
        axisRight(barchart.getAxisRight());
    }
    private DataSet getData(DataSet dataSet){
        dataSet.setColors(colors);
        dataSet.setValueTextColor(Color.WHITE);
        dataSet.setValueTextSize(10);
        return dataSet;
    }
    private BarData getBarData(){
        BarDataSet barDataSet = (BarDataSet) getData(new BarDataSet(getBarEntries(), ""));
        barDataSet.setBarShadowColor(Color.GRAY);
        BarData barData = new BarData(barDataSet);
        barData.setBarWidth(0.45f);
        return barData;
    }
}