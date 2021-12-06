package com.guy.class22a_and_7;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MyFirebaseDB {

    public interface CallBack_String {
        void dataReady(String value);
    }

    public interface CallBack_Cars {
        void dataReady(ArrayList<Car> cars);
    }

    public static void getAllCars(CallBack_Cars callBack_cars) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("cars");
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<Car> cars = new ArrayList<>();
                for (DataSnapshot child : snapshot.getChildren()) {
                    try {
                        Car c = child.getValue(Car.class);
                        cars.add(c);
                    } catch (Exception ex) {}

                }
                if (callBack_cars != null) {
                    callBack_cars.dataReady(cars);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public static void getCarModelByLicense(String license, CallBack_String callBack_string) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("cars");
        myRef.child(license).child("model").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.d("pttt", "A Thread: " + Thread.currentThread().getName());
                String model = snapshot.getValue().toString();
                if (callBack_string != null) {
                    callBack_string.dataReady(model);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
























