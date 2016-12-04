package pe.edu.utp.examenfinal.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import pe.edu.utp.examenfinal.ExamenFinalApplication;
import pe.edu.utp.examenfinal.R;
import pe.edu.utp.examenfinal.models.User;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final User user = ( (ExamenFinalApplication) getApplication()).getPreferences();
        final EditText username = ( EditText )findViewById( R.id.username );
        final EditText password = ( EditText )findViewById( R.id.password );
        final EditText score = ( EditText )findViewById( R.id.score );

        username.setText( user.getUsername() );
        password.setText( user.getPassword() );
        score.setText( user.getScore() + "" );

        Button action_save = ( Button )findViewById( R.id.action_save );
        action_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user.setUsername( username.getText().toString() );
                user.setPassword( password.getText().toString() );
                user.setScore( Integer.parseInt( score.getText().toString() ) );
                ( (ExamenFinalApplication) getApplication()).UpdatePreferences( user );
                Toast.makeText(SettingsActivity.this, "Se guardó correctamente sus datos", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

}
