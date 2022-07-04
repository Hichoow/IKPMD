package nl.hsleiden.eindappstudieplanner.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

import nl.hsleiden.eindappstudieplanner.DAO.DAOvak;
import nl.hsleiden.eindappstudieplanner.R;

public class GrafiekenActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private AnyChartView anyChartView;
    private String[] vakken = { "IARCH", "IIWIS", "IIPR", "IPOHBO","IOO1","IRDB","IIBUI","INET",
                                "IPODM","IPOMEDT","IWDER","IOOA","IIFITO","IPROP","IPOSE","IPOFIT",
                                "IIBPM", "ICOMMPR","ISLPR"};
    private int[] earnings = {3, 3, 4, 3, 3, 3, 3, 3, 2, 2, 3, 4, 3, 3, 2, 2, 3, 3, 1};
    private DAOvak dao = new DAOvak();
    private Object[] str = {};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafieken);

        mAuth = FirebaseAuth.getInstance();

        anyChartView = findViewById(R.id.any_chart_view);


        setupPieChart();
    }

    public void setupPieChart(){
        Pie pie = AnyChart.pie();
        List<DataEntry> dataEntries = new ArrayList<>();
        for (int i = 0; i < vakken.length; i++){
            dataEntries.add(new ValueDataEntry(vakken[i], earnings[i]));
        }

        pie.data(dataEntries);
        anyChartView.setChart(pie);

    }
}