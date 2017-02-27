package model;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Santi on 26/02/2017.
 */

public class UserMapper {
    private static DatabaseReference mDatabase;
    private static int countUsers;
    private final static String TAG = "UserMapper";

    public UserMapper() {
        mDatabase = FirebaseDatabase.getInstance().getReference("users");
        DatabaseReference countUsersReference = mDatabase.child("count_users");
        countUsersReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                countUsers = dataSnapshot.getValue(Integer.class);
                Log.e(TAG, "onDataChange: ");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
//TODO mostrar mensaje de que no hay conexion
            }
        });
    }


    public static void add(User usuario) {


        Map<String, Object> postValues = usuario.toMap();
        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put(Integer.toString(countUsers), postValues);

        mDatabase.updateChildren(childUpdates);
        countUsers++;
        //TODO aumentar count_users en firebase
    }

}
