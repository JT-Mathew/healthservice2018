package c.hayeon.seprroject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import c.hayeon.seprroject.model.User;

public class BookingActivity extends AppCompatActivity {

    User user;
    TextView nameTv;
    Toolbar menubar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        user = (User) getIntent().getExtras().getSerializable("user");
        nameTv = findViewById(R.id.nameTv);
        nameTv.setText(user.getFirstName());

        //menu bar
        menubar = findViewById(R.id.menuBar);
        setSupportActionBar(menubar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        menubar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_goback));
        menubar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();//What to do on back clicked
            }
        });
    }
<<<<<<< HEAD

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }
=======
>>>>>>> parent of 9955e9b... a
}
