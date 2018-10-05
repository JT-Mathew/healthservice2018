package c.hayeon.seprroject.model;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;
import java.util.UUID;

import c.hayeon.seprroject.R;

public class AddAppiontDetail extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();

    DatabaseReference myRef = database.getReference();

    private EditText nameEdit;
    private EditText idEdit;

    private Button submitButton;
    private Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_appiont_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nameEdit = (EditText) findViewById(R.id.detailEditEdit2);
        idEdit = (EditText) findViewById(R.id.detailEditEdit);

        submitButton = (Button) findViewById(R.id.submitDetailButton);
        searchButton = (Button) findViewById(R.id.searchDetailButton2);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String id = doctor.docId;
                String id = idEdit.getText().toString();
                String name = nameEdit.getText().toString();
                submit(id, name);


            }
        });

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = idEdit.getText().toString();

                search(id);


            }


        });


    }


    private void search(String id) {
        final String myID = id;
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Doctor myDoctor = dataSnapshot.child("Doctor").child(myID).getValue(Doctor.class);
                try {

                    Toast.makeText(AddAppiontDetail.this, myDoctor.docName, Toast.LENGTH_SHORT).show();

//                    String newName = "new Leo";
//                    myDoctor.setDocName(newName);
//                    myRef.child("Doctor").child(myDoctor.docId).setValue(myDoctor);
                    //change name according to Id

                } catch (NullPointerException e) {
                    Toast.makeText(AddAppiontDetail.this, "Sorry, No current doctor is available", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        //myRef.child("Doctor").child(id).setValue(doctor);
//        Toast.makeText(AddAppiontDetail.this, "Name is "+ name, Toast.LENGTH_SHORT).show();
    }

    private void submit(String id, String name) {
        Doctor mDoctor = new Doctor(id, name);
        myRef.child("Doctor").child(id).setValue(mDoctor);
        Toast.makeText(AddAppiontDetail.this, name + id, Toast.LENGTH_SHORT).show();

    }


}
