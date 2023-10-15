package com.example.medibook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DoctorInterface extends AppCompatActivity {

    private Button logOffBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_interface);



    createViews();

        logOffBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(DoctorInterface.this,MainActivity.class);
            startActivity(intent);
        }
    });



}



    public void createViews(
    ){
        logOffBtn = findViewById(R.id.logOutAsDoctor);


    }

}