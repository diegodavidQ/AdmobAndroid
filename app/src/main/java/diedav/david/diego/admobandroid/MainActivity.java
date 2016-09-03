package diedav.david.diego.admobandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private AdView adView;
    Button btnActividad2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnActividad2 = (Button)findViewById(R.id.btnActividad2);
        btnActividad2.setOnClickListener(this);

        adView = (AdView) findViewById(R.id.banner_AdMob);

        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)        // Para todos los emuladores
               // .addTestDevice("AC98C820A50B4AD8A2106EDE96FB87D4")  // Un ejemplo de un ID de un dispositivo
                .build();
        adView.loadAd(adRequest);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (adView != null) {
            adView.resume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (adView != null) {
            adView.pause();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (adView != null) {
            adView.destroy();
        }
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnActividad2){
            Intent i = new Intent(this,SecondActivity.class);
            startActivity(i);
        }
    }
}
