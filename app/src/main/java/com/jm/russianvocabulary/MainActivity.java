package com.jm.russianvocabulary;

import static com.jm.russianvocabulary.Vocab.rusArray;
import static com.jm.russianvocabulary.Vocab.engArray;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.app.DownloadManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import java.io.File;


public class MainActivity extends AppCompatActivity {

    int i = 0;
    int j = 0;


    public void deleteMp3() {
        File file = new File("/storage/emulated/0/Android/data/com.jm.russianvocabulary/files/Download", "temp.mp3");
        boolean deleted = file.delete();
    }

    public void beginDownload() {

        String s = "https://translate.google.com/translate_tts?ie=UTF-8&total=1&idx=0&client=tw-ob&tl=ru&q=" + rusArray[i];
        deleteMp3();
        File file = new File("/storage/emulated/0/Android/data/com.jm.russianvocabulary/files/Download", "temp.mp3");
        DownloadManager.Request request = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            request = new DownloadManager.Request(Uri.parse(s))
                    .setTitle("temp.mp3")
                    .setDestinationUri(Uri.fromFile(file))
                    .setRequiresCharging(false)
                    .setAllowedOverMetered(true)
                    .setNotificationVisibility(2)
                    .setVisibleInDownloadsUi(false)
                    .setAllowedOverRoaming(true);
        }
        else {
            request = new DownloadManager.Request(Uri.parse(s))
                    .setTitle("temp.mp3")
                    .setDestinationUri(Uri.fromFile(file))
                    .setNotificationVisibility(2)
                    .setVisibleInDownloadsUi(false)
                    .setAllowedOverMetered(true)
                    .setAllowedOverRoaming(true);
        }

        DownloadManager downloadManager=(DownloadManager)getSystemService((DOWNLOAD_SERVICE));
        downloadManager.enqueue(request);

    }

    public void audioPlayer(View view){
        MediaPlayer mp = new MediaPlayer();

        try {
            mp.setDataSource("/storage/emulated/0/Android/data/com.jm.russianvocabulary/files/Download/temp.mp3");
            mp.prepare();
            mp.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void nextClick (View view) {
        if (i < 0 || i >= (rusArray.length - 1)) {
            i = 0;

        } else {
            TextView textView = (TextView) findViewById(R.id.textView);
            i++;
            textView.setText(rusArray[i]);
            beginDownload();

        }
        if (j < 0 || j >= (engArray.length - 1)) {
            j = 0;
        } else {
            TextView textView2 = (TextView) findViewById(R.id.textView2);
            j++;
            textView2.setText(engArray[j]);

        }
    }

    public void previousClick (View view) {
        if (i <= 0 || i >= (rusArray.length -1)) {
            i = 0;


        } else {
            TextView textView = (TextView) findViewById(R.id.textView);
            i--;
            textView.setText(rusArray[i]);
            beginDownload();
        }
        if (j <= 0 || j >= (engArray.length -1)) {
            j = 0;
        } else {
            TextView textView2 = (TextView) findViewById(R.id.textView2);
            j--;
            textView2.setText(engArray[j]);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.vocabulary, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        if (item.getItemId() == R.id.item1) {
            TextView textView = (TextView) findViewById(R.id.textView);
            textView.setText(rusArray[0]);
            i = 0;
            j = 0;
        }

        if (item.getItemId() == R.id.item2) {
            TextView textView2 = (TextView) findViewById(R.id.textView);
            textView2.setText(rusArray[818]);
            i = 818;
            j = 818;
        }
        if (item.getItemId() == R.id.item3) {
            TextView textView3 = (TextView) findViewById(R.id.textView);
            textView3.setText(rusArray[2472]);
            i = 2472;
            j = 2472;
        }
        if (item.getItemId() == R.id.item4) {
            TextView textView3 = (TextView) findViewById(R.id.textView);
            textView3.setText(rusArray[2589]);
            i = 2589;
            j = 2589;
        }
        if (item.getItemId() == R.id.item5) {
            TextView textView3 = (TextView) findViewById(R.id.textView);
            textView3.setText(rusArray[2616]);
            i = 2616;
            j = 2616;
        }
        if (item.getItemId() == R.id.item6) {
            TextView textView3 = (TextView) findViewById(R.id.textView);
            textView3.setText(rusArray[2967]);
            i = 2967;
            j = 2967;
        }
        if (item.getItemId() == R.id.item7) {
            TextView textView3 = (TextView) findViewById(R.id.textView);
            textView3.setText(rusArray[2992]);
            i = 2992;
            j = 2992;
        }
        if (item.getItemId() == R.id.item8) {
            TextView textView3 = (TextView) findViewById(R.id.textView);
            textView3.setText(rusArray[3008]);
            i = 3008;
            j = 3008;
        } else {
            return super.onOptionsItemSelected(item);
        }
        return true;
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("clic", i);
        outState.putInt("clic2", j);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        i = savedInstanceState.getInt("clic");
        j = savedInstanceState.getInt("clic2");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

