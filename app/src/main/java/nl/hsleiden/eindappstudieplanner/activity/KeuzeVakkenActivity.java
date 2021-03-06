package nl.hsleiden.eindappstudieplanner.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

import nl.hsleiden.eindappstudieplanner.DAO.DAOvak;
import nl.hsleiden.eindappstudieplanner.R;

public class KeuzeVakkenActivity extends AppCompatActivity {

    private EditText vakCijferTxt;
    private EditText vakAtknTXT;
    private EditText vakSpTxt;
    private Button opslaanBtn;
    private RadioButton afgerondBtn1;
    private RadioButton afgerondBtn2;
    private RadioButton verplichtBtn1;
    private RadioButton verplichtBtn2;
    private DAOvak dao = new DAOvak();
    private ArrayList<String> vakken = new ArrayList<>();
    private Spinner dropdown;
    private String item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keuze_vakken);


        opslaanBtn = findViewById(R.id.opslaanBtn);
        vakCijferTxt = findViewById(R.id.vakCijferTxt);
        vakAtknTXT = findViewById(R.id.vakAtknTXT);
        vakSpTxt = findViewById((R.id.vakSpTxt));
        afgerondBtn1 = findViewById(R.id.afgerondBtn1);
        afgerondBtn2 = findViewById(R.id.afgerondBtn2);
        verplichtBtn1 = findViewById(R.id.verplichtBtn1);
        verplichtBtn2 = findViewById(R.id.verplichtBtn2);
        dropdown = findViewById(R.id.spinner1);

        dao.getKeuzeVakken("keuzevakken", value -> {
            vakken.addAll(value);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_spinner_item, vakken);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dropdown.setAdapter(adapter);
        });
        dropdown.setOnItemSelectedListener (new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                item = dropdown.getSelectedItem().toString();
                dao.getKeuzeVakByName("keuzevakken", item)
                        .addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                                    snapshotLoop(snapshot);
                                }
                            }
                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                            }
                        });
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        opslaanBtn.setOnClickListener(v -> {
            saveData();
            Toast.makeText(this, "Succesvol opgeslagen", Toast.LENGTH_LONG).show();
        });
    }

    public void saveData(){
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("cijfer", Double.valueOf(String.valueOf(vakCijferTxt.getText())));
        hashMap.put("studiepunten", Integer.valueOf(String.valueOf(vakSpTxt.getText())));
        hashMap.put("aantekeningen", vakAtknTXT.getText().toString());
        if (afgerondBtn1.isChecked()){
            hashMap.put("afgerond", true);
        } else if(afgerondBtn2.isChecked()){
            hashMap.put("afgerond", false);
        }
        if (verplichtBtn1.isChecked()){
            hashMap.put("verplicht", true);
        } else if(verplichtBtn2.isChecked()){
            hashMap.put("verplicht", false);
        }
        System.out.println(hashMap);
        dao.updateKeuzeVakken("keuzevakken", item, hashMap);
    }

    public void snapshotLoop(DataSnapshot snapshot){
        if (snapshot.getKey().contains("cijfer")){
            vakCijferTxt.setText(String.valueOf(snapshot.getValue()));
        }
        if (snapshot.getKey().contains("studiepunten")){
            vakSpTxt.setText(String.valueOf(snapshot.getValue()));
        }
        if (snapshot.getKey().contains("aantekeningen")){
            vakAtknTXT.setText((String) snapshot.getValue());
        }
        if (snapshot.getKey().contains("afgerond")){
            if ((Boolean) snapshot.getValue()){
                afgerondBtn1.setChecked(true);
            }else{
                afgerondBtn2.setChecked(true);
            }
        }
        if (snapshot.getKey().contains("verplicht")){
            if ((Boolean) snapshot.getValue()){
                verplichtBtn1.setChecked(true);
            }else{
                verplichtBtn2.setChecked(true);
            }
        }
    }
}