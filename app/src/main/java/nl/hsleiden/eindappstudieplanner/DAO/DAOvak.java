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

    public DAOvak(){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReferenceFromUrl("https://ikpmd-4f306-default-rtdb.firebaseio.com/");
        mAuth = FirebaseAuth.getInstance();
        uuidList = new ArrayList<>();
        vakkenList = new ArrayList<>();
    }

    public Task<Void> addVak(Vak vak){
        return databaseReference.child("users").child(mAuth.getUid()).child(String.valueOf(vak.getJaar())).child(vak.getName()).setValue(vak);
    }

    public Task<Void> addKeuzeVak(Vak vak){
        return databaseReference.child("users").child(mAuth.getUid()).child("keuzevakken").setValue(vak);
    }

    public Task<Void> update(int jaar, String vakNaam, HashMap<String, Object> hashMap){
        return databaseReference.child("users").child(mAuth.getUid()).child(String.valueOf(jaar)).child(vakNaam).updateChildren(hashMap);
    }

    public DatabaseReference getVakByName(int jaar, String vakNaam){
        return databaseReference.child("users").child(mAuth.getUid()).child(String.valueOf(jaar)).child(vakNaam);
    }

    public void getVakken(int jaar, MyCallback myCallback){
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
