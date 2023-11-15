package com.example.medibook;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AppointmentAcceptedList extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AppointmentAcceptedListAdapter adapter;
    private List<Appointment> acceptAppointmentList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_accepted_list);

        recyclerView = findViewById(R.id.acceptedAppointmentList);


        fetchAppointments(userList -> {
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            adapter = new AppointmentAcceptedListAdapter(acceptAppointmentList, this);
            recyclerView.setAdapter(adapter);

        });


    }


    private void fetchAppointments(OnDataFetchedCallback callback) {
        acceptAppointmentList = new ArrayList<>();
        MainActivity.appointmentRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                acceptAppointmentList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Appointment appointment = snapshot.getValue(Appointment.class);
                    String status = snapshot.child("status").getValue(String.class);
                    if ("Accepted".equals(status)) { //only add when status is accepted
                        acceptAppointmentList.add(appointment);
                    }


                }
                callback.onDataFetched(acceptAppointmentList);

            }

            public void onCancelled(DatabaseError databaseError) {
                // Handle errors.
            }
        });
    }

    public interface OnDataFetchedCallback {
        void onDataFetched(List<Appointment> acceptAppointmentList);
    }







}

