package c.hayeon.seprroject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import c.hayeon.seprroject.model.User;

public class DetailActivity extends AppCompatActivity {

    EditText nameEt;
    EditText idEt;
    EditText passwordEt;
    EditText add1Et;
    EditText add2Et;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        nameEt = findViewById(R.id.nameEt);
        idEt = findViewById(R.id.idEt);
        passwordEt = findViewById(R.id.passwordEt);
        add1Et = findViewById(R.id.add1Et);
        add2Et = findViewById(R.id.add2Et);

        user = (User) getIntent().getExtras().getSerializable("user");

        String name = user.getFirstName() + " " + user.getLastName();
        String add1 = user.getRoadNumber() + " " + user.getStreetName();
        String add2 = user.getSuburbName() + " " + user.getPostcode();
        nameEt.setText(name);
        idEt.setText(user.getStudentId());
        passwordEt.setText(user.getPassword());
        add1Et.setText(add1);
        add2Et.setText(add2);

        nameEt.setEnabled(false);
        idEt.setEnabled(false);
        passwordEt.setEnabled(false);
        add1Et.setEnabled(false);
        add2Et.setEnabled(false);
    }
}
