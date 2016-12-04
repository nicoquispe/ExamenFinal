package pe.edu.utp.examenfinal;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.os.PowerManager;
import android.util.Log;

import java.io.IOException;

import pe.edu.utp.examenfinal.activities.MainActivity;

/**
 * Created by elbuenpixel on 04/12/16.
 */

public class srv extends Service  implements MediaPlayer.OnPreparedListener{

    MediaPlayer mediaPlayer;
    String url = "http://www.stephaniequinn.com/Music/Commercial%20DEMO%20-%2009.mp3"; // your URL here
    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }

    public void onCreate() {
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mediaPlayer.setWakeMode(getApplicationContext(), PowerManager.PARTIAL_WAKE_LOCK);
        try {
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepare(); // might take long! (for buffering, etc)
            //mediaPlayer.setOnPreparedListener(this);
            //mediaPlayer.prepareAsync();
            mediaPlayer.start();
            /*
            PendingIntent pi = PendingIntent.getActivity(getApplicationContext(), 0, new Intent(getApplicationContext(), MainActivity.class),
                    PendingIntent.FLAG_UPDATE_CURRENT);
            Notification notification = new Notification();

            Notification.Builder builder = new Notification.Builder(getApplicationContext());

            builder.setAutoCancel(true);
            builder.setTicker("this is ticker text");
            builder.setContentTitle("Playing MP3");
            //builder.setContentText("You have a new message");
            builder.setSmallIcon(R.drawable.ic_notifications_black_24dp);
            builder.setContentIntent(pi);
            builder.setOngoing(false);
            //builder.setSubText("This is subtext...");   //API level 16
            builder.setNumber(100);
            builder.build();
            notification = builder.getNotification();

            startForeground(123, notification);
            */
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer.start();
        return START_STICKY;
    }
    @Override
    public void onDestroy() {
        mediaPlayer.stop();
        if (mediaPlayer != null) mediaPlayer.release();
    }

    public void onStart(Intent intent, int startid) {

        Log.d("aaa", "On start");
        mediaPlayer.start();
    }
    public void onPrepared(MediaPlayer player) {
        player.start();
    }
}
