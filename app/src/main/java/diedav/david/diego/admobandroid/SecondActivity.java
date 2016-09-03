package diedav.david.diego.admobandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    public InterstitialAd intersticial;
    Button btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        btnRegresar = (Button)findViewById(R.id.btnRegresar);
        btnRegresar.setOnClickListener(this);

        initInterstitial();

        intersticial.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                displayIntersticial();
            }
        });

    }

    private void initInterstitial() {
        AdRequest adRequest = new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
        //Preparar anuncio
        intersticial = new InterstitialAd(SecondActivity.this);
        //Insertar el anuncio
        intersticial.setAdUnitId(getString(R.string.AdMob_intersticial));
        intersticial.loadAd(adRequest);
    }

    public void displayIntersticial(){
        if(intersticial.isLoaded()){
            intersticial.show();
        }
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnRegresar){
            if (intersticial.isLoaded()) {
                intersticial.show();
            } else {
                startActivity(new Intent(this, MainActivity.class));
            }
        }
    }


}
