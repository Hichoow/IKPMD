package nl.hsleiden.eindappstudieplanner.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import nl.hsleiden.eindappstudieplanner.DAO.DAOvak;
import nl.hsleiden.eindappstudieplanner.R;
import nl.hsleiden.eindappstudieplanner.model.Studiepunten;
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
            Toast.makeText(this, "Signed Out", Toast.LENGTH_LONG).show();
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
        Vak iarch = new Vak("IARCH", 1, false, true, 3, "", 1);
        dao.addVerplichteVak(iarch);
        Vak iiwis = new Vak("IIWIS", 1, false, true, 3, "", 1);
        dao.addVerplichteVak(iiwis);
        Vak iipr = new Vak("IIPR", 1, false, true, 4, "", 1);
        dao.addVerplichteVak(iipr);
        Vak ipohbo = new Vak("IPOHBO", 1, false, true, 3, "", 1);
        dao.addVerplichteVak(ipohbo);
        Vak ioo1 = new Vak("IOO1", 1, false, true, 3, "", 1);
        dao.addVerplichteVak(ioo1);
        Vak irdb = new Vak("IRDB", 1, false, true, 3, "", 1);
        dao.addVerplichteVak(irdb);
        Vak iibui = new Vak("IIBUI", 1, false, true, 3, "", 1);
        dao.addVerplichteVak(iibui);
        Vak inet = new Vak("INET", 1, false, true, 3, "", 1);
        dao.addVerplichteVak(inet);
        Vak ipodm = new Vak("IPODM", 1, false, true, 2, "", 1);
        dao.addVerplichteVak(ipodm);
        Vak ipomedt = new Vak("IPOMEDT", 1, false, true, 2, "", 1);
        dao.addVerplichteVak(ipomedt);
        Vak iwder = new Vak("IWDER", 1, false, true, 3, "", 1);
        dao.addVerplichteVak(iwder);
        Vak iooa = new Vak("IOOA", 1, false, true, 4, "", 1);
        dao.addVerplichteVak(iooa);
        Vak iifito = new Vak("IIFITO", 1, false, true, 3, "", 1);
        dao.addVerplichteVak(iifito);
        Vak iprop = new Vak("IPROP", 1, false, true, 3, "", 1);
        dao.addVerplichteVak(iprop);
        Vak ipose = new Vak("IPOSE", 1, false, true, 2, "", 1);
        dao.addVerplichteVak(ipose);
        Vak ipofit = new Vak("IPOFIT", 1, false, true, 2, "", 1);
        dao.addVerplichteVak(ipofit);
        Vak iibpm = new Vak("IIBPM", 1, false, true, 3, "", 1);
        dao.addVerplichteVak(iibpm);
        Vak icommpr = new Vak("ICOMMPR", 1, false, true, 3, "", 1);
        dao.addVerplichteVak(icommpr);
        Vak islpr = new Vak("ISLPR", 1, false, true, 1, "", 1);
        dao.addVerplichteVak(islpr);
        Studiepunten studiepunten = new Studiepunten(1, 60);
        dao.aantalStudiepunten(studiepunten.getJaar(), studiepunten.getPunten());
    }
    public void setupTweedeJaarsVakken(){
        Vak idbms = new Vak("IDBMS", 1, false, true, 3, "", 2);
        dao.addVerplichteVak(idbms);
        Vak ipro2 = new Vak("IPRO2", 1, false, true, 3, "", 2);
        dao.addVerplichteVak(ipro2);
        Vak imal = new Vak("IMAL", 1, false, true, 3, "", 3);
        dao.addVerplichteVak(imal);
        Vak icommha = new Vak("ICOMMHA", 1, false, true, 3, "", 2);
        dao.addVerplichteVak(icommha);
        Vak ispv = new Vak("ISPV", 1, false, true, 4, "", 2);
        dao.addVerplichteVak(ispv);
        Studiepunten studiepunten = new Studiepunten(2, 16);
        dao.aantalStudiepunten(studiepunten.getJaar(), studiepunten.getPunten());
    }
    public void setupDerdeJaarsVakken(){
        Vak iethi = new Vak("IETHI", 1, false, true, 4, "", 3);
        dao.addVerplichteVak(iethi);
        Vak iitorg = new Vak("IITORG", 1, false, true, 4, "", 3);
        dao.addVerplichteVak(iitorg);
        Vak isecu = new Vak("ISECU", 1, false, true, 4, "", 3);
        dao.addVerplichteVak(isecu);
        Studiepunten studiepunten = new Studiepunten(3, 12);
        dao.aantalStudiepunten(studiepunten.getJaar(), studiepunten.getPunten());
    }
    public void setupVierdeJaarsVakken(){
        Vak iwls = new Vak("IWLS", 1, false, true, 4, "", 4);
        dao.addVerplichteVak(iwls);
        Vak iwlab = new Vak("IWLAB", 1, false, true, 4, "", 4);
        dao.addVerplichteVak(iwlab);
        Studiepunten studiepunten = new Studiepunten(4, 8);
        dao.aantalStudiepunten(studiepunten.getJaar(), studiepunten.getPunten());
    }
    public void setupKeuzeVakken(){
        Vak ikpmd = new Vak("IKPMD", 1, false, true, 4, "", 3);
        dao.addKeuzeVak(ikpmd);
        Vak ikue = new Vak("IKUE", 1, false, true, 4, "", 3);
        dao.addKeuzeVak(ikue);
        Vak ikrefact = new Vak("IKREFACT", 1, false, true, 4, "", 3);
        dao.addKeuzeVak(ikrefact);
        Vak ikfram = new Vak("IKFRAM", 1, false, true, 4, "", 3);
        dao.addKeuzeVak(ikfram);
    }


}