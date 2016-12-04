package pe.edu.utp.examenfinal.activities;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.PowerManager;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.io.IOException;

import pe.edu.utp.examenfinal.ExamenFinalApplication;
import pe.edu.utp.examenfinal.R;
import pe.edu.utp.examenfinal.srv;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FragmentManager fragmentManager;
    private Button exercise_settings;
    private Button exercise_1_text;
    private Button exercise_2_text;
    private Button exercise_3_text;
    private Button exercise_4_text;
    private Button exercise_5_text;
    private Button exercise_6_text;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mContext = this;

        fragmentManager = getSupportFragmentManager();
        exercise_settings = (Button) findViewById( R.id.exercise_settings );
        exercise_settings.setOnClickListener( this );

        exercise_1_text = (Button) findViewById( R.id.exercise_1_text );
        exercise_1_text.setOnClickListener( this );

        exercise_2_text = (Button) findViewById( R.id.exercise_2_text );
        exercise_2_text.setOnClickListener( this );

        exercise_3_text = (Button) findViewById( R.id.exercise_3_text );
        exercise_3_text.setOnClickListener( this );

        exercise_4_text = (Button) findViewById( R.id.exercise_4_text );
        exercise_4_text.setOnClickListener( this );

        exercise_5_text = (Button) findViewById( R.id.exercise_5_text );
        exercise_5_text.setOnClickListener( this );

        exercise_6_text = (Button) findViewById( R.id.exercise_6_text );
        exercise_6_text.setOnClickListener( this );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            startActivity( new Intent( mContext, SettingsActivity.class ));
            return true;
        }
        if (id == R.id.action_credits) {
            ((ExamenFinalApplication)getApplication()).openCredits( fragmentManager );
            return true;
        }
        if (id == R.id.action_closed) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch ( view.getId() ){
            case R.id.exercise_settings:
                startActivity( new Intent( mContext, SettingsActivity.class ));
                break;
            case R.id.exercise_1_text:
                ((ExamenFinalApplication)getApplication()).openCredits( fragmentManager );
                break;
            case R.id.exercise_2_text:
                startActivity( new Intent( mContext, LoginActivity.class ));
                break;
            case R.id.exercise_3_text:
                startActivity( new Intent( mContext, VideoActivity.class ));
                break;
            case R.id.exercise_4_text:
                startActivity( new Intent( mContext, CallsActivity.class ));
                break;
            case R.id.exercise_5_text:
                startActivity( new Intent( mContext, LoginGestureActivity.class ));
                break;
            case R.id.exercise_6_text:
                Intent svc=new Intent(this, srv.class);
                startService(svc);
                /*
                String url = "http://www.stephaniequinn.com/Music/Commercial%20DEMO%20-%2009.mp3"; // your URL here
                MediaPlayer mediaPlayer = new MediaPlayer();
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                mediaPlayer.setWakeMode(getApplicationContext(), PowerManager.PARTIAL_WAKE_LOCK);
                try {
                    mediaPlayer.setDataSource(url);
                    mediaPlayer.prepare(); // might take long! (for buffering, etc)
                    mediaPlayer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }*/
                break;
            default:
                break;
        }
    }
}
