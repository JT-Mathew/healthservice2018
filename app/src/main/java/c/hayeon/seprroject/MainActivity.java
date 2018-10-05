package c.hayeon.seprroject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import c.hayeon.seprroject.model.AddAppointment;
import c.hayeon.seprroject.model.User;


public class MainActivity extends AppCompatActivity {
    Button detailBtn;
    Button newAppBtn;
    Button mngButton;
    TextView nameTv;
    Toolbar menubar;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = (User) getIntent().getExtras().getSerializable("user");
        nameTv = findViewById(R.id.nameTv);
        String name = user.getFirstName() + " " + user.getLastName();
        nameTv.setText(name);

        //menubar related
        menubar = findViewById(R.id.menuBar);
        setSupportActionBar(menubar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        detailBtn = findViewById(R.id.detailsBtn);
        detailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                intent.putExtra("user", user);
                startActivityForResult(intent, 0);
            }
        });
        newAppBtn = findViewById(R.id.newAppBtn);
        newAppBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BookingActivity.class);
                intent.putExtra("user", user);
                startActivityForResult(intent, 0);

            }
        });

        mngButton = (Button) findViewById(R.id.mngAppBtn);
        mngButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AddAppointment.class));
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }
}

