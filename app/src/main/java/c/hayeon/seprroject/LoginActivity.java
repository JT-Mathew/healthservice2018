package c.hayeon.seprroject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import c.hayeon.seprroject.model.AddAppiontDetail;
import c.hayeon.seprroject.model.Appointment;
import c.hayeon.seprroject.model.Doctor;
import c.hayeon.seprroject.model.User;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();

    DatabaseReference myRef = database.getReference();


    EditText idEt;
    EditText passwordEt;
    Button loginBtn;
    Button exitBtn;
    User test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        idEt = findViewById(R.id.idEt);
        passwordEt = findViewById(R.id.passwordEt);
        loginBtn = findViewById(R.id.loginBtn);
        exitBtn = findViewById(R.id.exitBtn);

        test = new User("Hayeon", "Kim", "1",
                "1", "46", "Raleigh Avenue",
                "Caringbah", 2229);

        myRef.child("User").child(test.studentId).setValue(test);


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                search(idEt.getText().toString(),passwordEt.getText().toString());

            /*    if (idEt.getText().toString().equals(test.getStudentId()) &&
                        passwordEt.getText().toString().equals(test.getPassword())) {

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("user", test);
                    startActivityForResult(intent, 0);
                } else {
                    Toast.makeText(getApplicationContext(), "Wrong Credential", Toast.LENGTH_SHORT).show();
                }*/
            }
        });

        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


    private void search(String id, String password) {
        final String myID = id;
        final String myPassword = password;
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User myUser = dataSnapshot.child("User").child(myID).getValue(User.class);
                try {
                    Toast.makeText(LoginActivity.this, myUser.password, Toast.LENGTH_SHORT).show();

                    if(myUser.password.equals(myPassword)){

                        Toast.makeText(LoginActivity.this, "Log in", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.putExtra("user", test);
                        startActivityForResult(intent, 0);
                    }else{
                        Toast.makeText(LoginActivity.this, "Wrong password", Toast.LENGTH_SHORT).show();
                    }

                } catch (NullPointerException e) {
                    Toast.makeText(LoginActivity.this, "Sorry, No current user is available", Toast.LENGTH_SHORT).show();
                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}