package c.hayeon.seprroject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import c.hayeon.seprroject.model.User;


public class MainActivity extends AppCompatActivity {
    Button detailBtn;
    Button logoutBtn;
    TextView nameTv;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = (User) getIntent().getExtras().getSerializable("user");
        nameTv = findViewById(R.id.nameTv);
        String name = user.getFirstName() + " " + user.getLastName();
        nameTv.setText(name);

        detailBtn = findViewById(R.id.detailsBtn);
        detailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                intent.putExtra("user", user);
                startActivityForResult(intent, 0);
            }
        });

        logoutBtn = findViewById(R.id.logoutBtn);
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

