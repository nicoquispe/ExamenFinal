package pe.edu.utp.examenfinal;

import android.app.Application;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentManager;

import com.orm.SugarApp;

import pe.edu.utp.examenfinal.fragments.DetailsMe;
import pe.edu.utp.examenfinal.models.User;

/**
 * Created by elbuenpixel on 03/12/16.
 */

public class ExamenFinalApplication extends SugarApp {

    private SharedPreferences sharedPreferences;

    @Override
    public void onCreate() {
        super.onCreate();
        sharedPreferences = getApplicationContext().getSharedPreferences( "ExamenFinal", MODE_PRIVATE);
        //UpdatePreferences(new User("nicoquispe", "123456", 8));
    }

    public void UpdatePreferences(User user) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", user.getUsername());
        editor.putString("password", user.getPassword());
        editor.putInt("score", user.getScore());
        editor.apply();
    }

    public User getPreferences() {
        User user = new User();
        user.setUsername(sharedPreferences.getString("username", "nicoquispe"));
        user.setPassword(sharedPreferences.getString("password", "123456"));
        user.setScore(sharedPreferences.getInt("score", 8));
        return user;
    }

    public void openCredits(FragmentManager fragmentManager) {
        DetailsMe detailsMe = new DetailsMe();
        detailsMe.show(fragmentManager, "dialog");
    }
}
