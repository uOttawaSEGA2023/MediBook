package com.example.medibook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.medibook.classes.Administrator;
import com.example.medibook.classes.Doctor;
import com.example.medibook.classes.User;
import com.example.medibook.classes.Patient;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;


public class SignInActivity extends AppCompatActivity {

    private EditText editEmail, editPassword;
    private TextView txtEmail, txtPassword;
    private Button signIn,clickBack;
    private FirebaseAuth mAuth;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        mAuth = FirebaseAuth.getInstance();

        createViews();


        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initSignIn(); // check correct format before sign in
            }
        });

        clickBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignInActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });





    }

    public void createViews() {

        editEmail = findViewById(R.id.emailAddress);
        editPassword = findViewById(R.id.editTextTextPassword);

        txtEmail = findViewById(R.id.textWarnEmail);
        txtPassword = findViewById(R.id.textWarnPassword);

        signIn = findViewById(R.id.SignInButton);
        clickBack = findViewById(R.id.SignInButtonClickBackward);


    }


    public void initSignIn() {
        if(validateData() != null) {

            snackBar();

        }


    }


    public FirebaseUser validateData() {

        txtEmail.setVisibility(View.GONE);
        txtPassword.setVisibility(View.GONE);

        if ((editEmail.getText().toString().equals("") )|| (!editEmail.getText().toString().contains("@"))) {

            txtEmail.setText("Please enter your email");
            txtEmail.setVisibility(View.VISIBLE);
            if (editPassword.getText().toString().equals(""))
                txtPassword.setVisibility(View.VISIBLE);
            return null;
        } else if (editPassword.getText().toString().equals("")) { //second password check to make the UI more smooth
            txtPassword.setVisibility(View.VISIBLE);
            return null;
        } else {

            mAuth.signInWithEmailAndPassword(editEmail.getText().toString(), editPassword.getText().toString());
            FirebaseUser current = mAuth.getCurrentUser();
                if (current != null)
                    return current;

        }
        txtEmail.setText("Email or Password is incorrect");
        txtEmail.setVisibility(View.VISIBLE);

        return null;
    }


    public void snackBar() {

        txtEmail.setVisibility(View.GONE);
        txtPassword.setVisibility(View.GONE);


        View rootLayout = findViewById(R.id.signInLayout);
        Snackbar.make(rootLayout, "Logged in successfully", Snackbar.LENGTH_SHORT).show();
        if(validateData().getClass().equals(Doctor.class)) {
            Intent intent = new Intent(SignInActivity.this, DoctorInterface.class);
            startActivity(intent);
        } else if (validateData().getClass().equals(Doctor.class) && validateData().getClass().equals(Doctor.class)) {
            Intent intent = new Intent(SignInActivity.this, AdministratorInterface.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(SignInActivity.this, PatientInterface.class);
            startActivity(intent);
        }
    }



}


