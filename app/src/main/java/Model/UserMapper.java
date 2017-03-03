package model;

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

    public UserMapper(final User currentUser) {
        mDatabase = FirebaseDatabase.getInstance().getReference("users");


        // busca en bbdd el currentUSer
        mDatabase.child(currentUser.getId()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                if (snapshot.getValue() == null) {
                    UserMapper.add(currentUser);
                } else {
                    //TODO añadir puntos por logueo si la fecha actual es distinta a la ultima
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // TODO error de que no hay conexion
            }
        });
    }


    public static void add(User usuario) {
        Map<String, Object> postValues = usuario.toMap();
        Map<String, Object> childUpdates = new HashMap<>();
        //put(key,object)

        childUpdates.put(usuario.getId(), postValues);

        mDatabase.updateChildren(childUpdates);

    }
}
