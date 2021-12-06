package com.guy.class22a_and_7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        info = findViewById(R.id.info);

        Car c1 = new Car("Mitsubishi Carisma")
                .setLicense("8715620")
                .setYear(1998)
                .setFuel(8.7)
                .setManual(false);

        Car c2 = new Car("Suzuki Alto")
                .setLicense("1586878")
                .setYear(2014)
                .setFuel(5.7)
                .setManual(true);


        MyFirebaseDB.CallBack_String callBack_string = new MyFirebaseDB.CallBack_String() {
            @Override
            public void dataReady(String model) {
                Log.d("pttt", "Model: " + model + " Thread: " + Thread.currentThread().getName());
                info.setText(model);
            }
        };

        //MyFirebaseDB.getCarModelByLicense("8715620", callBack_string);

        MyFirebaseDB.CallBack_Cars callBack_cars = new MyFirebaseDB.CallBack_Cars() {
            @Override
            public void dataReady(ArrayList<Car> cars) {
                info.setText("" + cars.size());
            }
        };
        MyFirebaseDB.getAllCars(callBack_cars);

    }

    private void addCar(Car car) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("cars");
        myRef.child(car.getLicense()).setValue(car);
    }

}




































