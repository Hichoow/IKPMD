package nl.hsleiden.eindappstudieplanner.DAO;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

import nl.hsleiden.eindappstudieplanner.interfaces.MyCallback;
import nl.hsleiden.eindappstudieplanner.model.Vak;

public class DAOvak {
    private DatabaseReference databaseReference;
    private FirebaseAuth mAuth;
    private ArrayList<String> uuidList;
    private ArrayList<String> vakkenList;
    private Long studiepunten;

    public DAOvak(){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReferenceFromUrl("https://ikpmd-4f306-default-rtdb.firebaseio.com/");
        mAuth = FirebaseAuth.getInstance();
        uuidList = new ArrayList<>();
        vakkenList = new ArrayList<>();
        studiepunten = 0L;
    }

    public Task<Void> addVerplichteVak(Vak vak){
        return databaseReference.child("users").child(mAuth.getUid()).child(String.valueOf(vak.getJaar())).child(vak.getName()).setValue(vak);
    }

    public Task<Void> addKeuzeVak(Vak vak){
        return databaseReference.child("users").child(mAuth.getUid()).child("keuzevakken").child(vak.getName()).setValue(vak);
    }

    public Task<Void> updateVerplichteVakken(int jaar, String vakNaam, HashMap<String, Object> hashMap){
        return databaseReference.child("users").child(mAuth.getUid()).child(String.valueOf(jaar)).child(vakNaam).updateChildren(hashMap);
    }

    public Task<Void> updateKeuzeVakken(String positie, String vakNaam, HashMap<String, Object> hashMap){
        return databaseReference.child("users").child(mAuth.getUid()).child(positie).child(vakNaam).updateChildren(hashMap);
    }

    public Task<Void> aantalStudiepunten(int jaar, int punten){
        return databaseReference.child("users").child(mAuth.getUid()).child(String.valueOf(jaar)).child("totalePunten").setValue(punten);
    }

    public DatabaseReference getVerplichteVakByName(int jaar, String vakNaam){
        return databaseReference.child("users").child(mAuth.getUid()).child(String.valueOf(jaar)).child(vakNaam);
    }

    public DatabaseReference getKeuzeVakByName(String positie, String vakNaam){
        return databaseReference.child("users").child(mAuth.getUid()).child(positie).child(vakNaam);
    }

    public void getVerplichteVakken(int jaar, MyCallback myCallback){
        databaseReference.child("users").child(mAuth.getUid()).child(String.valueOf(jaar))
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            String item = snapshot.getKey();
                            vakkenList.add(item);
                        }
                        myCallback.onCallback(vakkenList);
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {}
                });
    }

    public void getKeuzeVakken(String positie, MyCallback myCallback){
        databaseReference.child("users").child(mAuth.getUid()).child(String.valueOf(positie))
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            String item = snapshot.getKey();
                            vakkenList.add(item);
                        }
                        myCallback.onCallback(vakkenList);
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {}
                });
    }


    public void readData(MyCallback myCallback) {

        databaseReference.child("users")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            String item = snapshot.getKey();
                            uuidList.add(item);
                        }
                        myCallback.onCallback(uuidList);
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {}
                });
    }



}
