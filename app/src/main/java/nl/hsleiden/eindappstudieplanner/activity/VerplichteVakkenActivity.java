package nl.hsleiden.eindappstudieplanner.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import nl.hsleiden.eindappstudieplanner.R;
import nl.hsleiden.eindappstudieplanner.fragment.Jaar1Fragment;
import nl.hsleiden.eindappstudieplanner.fragment.Jaar2Fragment;
import nl.hsleiden.eindappstudieplanner.fragment.Jaar3Fragment;
import nl.hsleiden.eindappstudieplanner.fragment.Jaar4Fragment;

public class VerplichteVakkenActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verplichtevakken);

        mAuth = FirebaseAuth.getInstance();


    }
    public void selectFrag(View view) {
        Fragment fr;

        if(view == findViewById(R.id.button1)) {
            fr = new Jaar1Fragment();

        }else if(view == findViewById(R.id.button2)){

            fr = new Jaar2Fragment();
        }else if(view == findViewById(R.id.button3)){
            fr = new Jaar3Fragment();
        }else {
            fr = new Jaar4Fragment();
        }

        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_place, fr);
        fragmentTransaction.commit();

    }
}