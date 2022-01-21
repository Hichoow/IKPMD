package nl.hsleiden.eindappstudieplanner.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

import nl.hsleiden.eindappstudieplanner.DAO.DAOvak;
import nl.hsleiden.eindappstudieplanner.R;
import nl.hsleiden.eindappstudieplanner.model.Vak;

public class DashboardActivity extends AppCompatActivity {


    private FirebaseAuth mAuth;
    private DAOvak dao = new DAOvak();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        mAuth = FirebaseAuth.getInstance();

        Button vakken_btn = findViewById(R.id.vakken_btn);
        vakken_btn.setOnClickListener(v -> {
            startActivity(new Intent(DashboardActivity.this, VerplichteVakkenActivity.class));
        });

        Button keuzeVakkenBtn = findViewById(R.id.keuzeVakkenBtn);
        keuzeVakkenBtn.setOnClickListener(v -> {
            startActivity(new Intent(DashboardActivity.this, KeuzeVakkenActivity.class));
        });

        Button sign_out_btn = findViewById(R.id.sign_out_btn);
        sign_out_btn.setOnClickListener(v -> {
            mAuth.signOut();
            startActivity(new Intent(DashboardActivity.this, SignInActivity.class));
            finish();
        });



        dao.readData(value -> {
            if (!value.contains(mAuth.getUid())){
                setupEersteJaarsVakken();
                setupTweedeJaarsVakken();
                setupDerdeJaarsVakken();
                setupVierdeJaarsVakken();
                setupKeuzeVakken();
            }

        });
    }

    public void setupEersteJaarsVakken(){
        Vak iarch = new Vak("IARCH", 1, false, true, 10, "", 1);
        dao.addVak(iarch);
        Vak iiwis = new Vak("IIWIS", 1, false, true, 10, "", 1);
        dao.addVak(iiwis);
        Vak iipr = new Vak("IIPR", 1, false, true, 10, "", 1);
        dao.addVak(iipr);
        Vak ipohbo = new Vak("IPOHBO", 1, false, true, 10, "", 1);
        dao.addVak(ipohbo);
        Vak ioo1 = new Vak("IOO1", 1, false, true, 10, "", 1);
        dao.addVak(ioo1);
        Vak irdb = new Vak("IRDB", 1, false, true, 10, "", 1);
        dao.addVak(irdb);
        Vak iibui = new Vak("IIBUI", 1, false, true, 10, "", 1);
        dao.addVak(iibui);
        Vak inet = new Vak("INET", 1, false, true, 10, "", 1);
        dao.addVak(inet);
        Vak ipodm = new Vak("IPODM", 1, false, true, 10, "", 1);
        dao.addVak(ipodm);
        Vak ipomedt = new Vak("IPOMEDT", 1, false, true, 10, "", 1);
        dao.addVak(ipomedt);
        Vak iwder = new Vak("IWDER", 1, false, true, 10, "", 1);
        dao.addVak(iwder);
        Vak iooa = new Vak("IOOA", 1, false, true, 10, "", 1);
        dao.addVak(iooa);
        Vak iifito = new Vak("IIFITO", 1, false, true, 10, "", 1);
        dao.addVak(iifito);
        Vak iprop = new Vak("IPROP", 1, false, true, 10, "", 1);
        dao.addVak(iprop);
        Vak ipose = new Vak("IPOSE", 1, false, true, 10, "", 1);
        dao.addVak(ipose);
        Vak ipofit = new Vak("IPOFIT", 1, false, true, 10, "", 1);
        dao.addVak(ipofit);
        Vak iipbdama = new Vak("IIPBDAMA", 1, false, true, 10, "", 1);
        dao.addVak(iipbdama);
        Vak iipiata = new Vak("IIPIATA", 1, false, true, 10, "", 1);
        dao.addVak(iipiata);
        Vak iipsene = new Vak("IIPSENE", 1, false, true, 10, "", 1);
        dao.addVak(iipsene);
        Vak iipforit = new Vak("IIPFORIT", 1, false, true, 10, "", 1);
        dao.addVak(iipforit);
        Vak iibpm = new Vak("IIBPM", 1, false, true, 10, "", 1);
        dao.addVak(iibpm);
        Vak icommpr = new Vak("ICOMMPR", 1, false, true, 10, "", 1);
        dao.addVak(icommpr);
        Vak islpr = new Vak("ISLPR", 1, false, true, 10, "", 1);
        dao.addVak(islpr);
    }
    public void setupTweedeJaarsVakken(){
        Vak idbms = new Vak("IDBMS", 1, false, true, 4, "", 2);
        dao.addVak(idbms);
        Vak ipro2 = new Vak("IPRO2", 1, false, true, 4, "", 2);
        dao.addVak(ipro2);
        Vak imal = new Vak("IMAL", 1, false, true, 4, "", 3);
        dao.addVak(imal);
        Vak icommha = new Vak("ICOMMHA", 1, false, true, 4, "", 2);
        dao.addVak(icommha);
        Vak ispv = new Vak("ISPV", 1, false, true, 4, "", 2);
        dao.addVak(ispv);
    }
    public void setupDerdeJaarsVakken(){
        Vak iethi = new Vak("IETHI", 1, false, true, 4, "", 3);
        dao.addVak(iethi);
        Vak iitorg = new Vak("IITORG", 1, false, true, 4, "", 3);
        dao.addVak(iitorg);
        Vak isecu = new Vak("ISECU", 1, false, true, 4, "", 3);
        dao.addVak(isecu);
    }
    public void setupVierdeJaarsVakken(){

    }
    public void setupKeuzeVakken(){
        Vak iethi = new Vak("IETHI", 1, false, true, 4, "", 3);
        dao.addVak(iethi);
        Vak iitorg = new Vak("IITORG", 1, false, true, 4, "", 3);
        dao.addVak(iitorg);
        Vak isecu = new Vak("ISECU", 1, false, true, 4, "", 3);
        dao.addVak(isecu);
    }


}