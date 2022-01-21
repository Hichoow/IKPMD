package nl.hsleiden.eindappstudieplanner.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import nl.hsleiden.eindappstudieplanner.DAO.DAOvak;
import nl.hsleiden.eindappstudieplanner.R;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null){
            startActivity(new Intent(MainActivity.this, DashboardActivity.class));
        }else{
            startActivity(new Intent(MainActivity.this, SignInActivity.class));
        }
        finish();
    }













}