package pe.edu.utp.examenfinal.activities;

import android.content.Context;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import pe.edu.utp.examenfinal.ExamenFinalApplication;
import pe.edu.utp.examenfinal.R;
import pe.edu.utp.examenfinal.models.User;

public class LoginGestureActivity extends AppCompatActivity implements GestureOverlayView.OnGesturePerformedListener {
    private GestureLibrary libreria;
    private Context mContext;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_gesture);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mContext = this;
        
        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        user = ( (ExamenFinalApplication)getApplication() ).getPreferences();

        libreria = GestureLibraries.fromRawResource(this, R.raw.gestures);
        if (!libreria.load()) {
            finish();
        }
        GestureOverlayView gesturesView = (GestureOverlayView) findViewById(R.id.gestures);
        gesturesView.addOnGesturePerformedListener(this);

    }
    public void onGesturePerformed(GestureOverlayView ov, Gesture gesture) {
        ArrayList<Prediction> predictions = libreria.recognize(gesture);
        for (Prediction prediction : predictions){
            System.out.println( prediction.name + " - " + prediction.score );
            if ( prediction.name.equals("gesture") ){
                if( user.getScore() <= prediction.score ){
                    Toast.makeText(mContext, "Inició sesión correctamente", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else {
                    Toast.makeText(mContext, "Inténtelo de nuevo", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
