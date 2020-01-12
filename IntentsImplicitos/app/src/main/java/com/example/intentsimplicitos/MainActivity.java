    package com.example.intentsimplicitos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.hardware.camera2.CameraDevice;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

    public class MainActivity extends AppCompatActivity {

        private EditText mWebsiteEditText;
        private EditText mLocationEditText;
        private EditText mShareTextEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebsiteEditText = findViewById(R.id.website_edittext);
        mLocationEditText = findViewById(R.id.location_edittext);
        mShareTextEditText = findViewById(R.id.share_edittext);
    }

        public void openWebsite(View view) {

            //Se extrae URL
            String url = mWebsiteEditText.getText().toString();
            //Se convierte el URI y se crea un Intent.
            Uri webpage = Uri.parse(url);
            Intent intent = new Intent(Intent.ACTION_VIEW,webpage);

            //Busca si alguna actividad puede resolver la solicitud
            if(intent.resolveActivity(getPackageManager()) != null){
                startActivity(intent);
            }else{
                Log.d("ImplicitIntent","Can´t handle this!");
            }
    }

        public void openLocation(View view) {
            /*String loc = mLocationEditText.getText().toString();
            Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
            Intent intent = new Intent(Intent.ACTION_VIEW,addressUri);

            if (intent.resolveActivity(getPackageManager()) != null){
                startActivity(intent);
            }else{
                Log.d("ImplicitIntent","Can´t handle this Content!");
            }*/

            Uri gmmIntentUri = Uri.parse("geo:37.7749,-122.4194");
            Uri gmmIntentUri2 = Uri.parse("geo:0,0?q=restaurants");
            Uri gmmIntentUri4 = Uri.parse("geo:37.7749,-122.4194?z=10&q=restaurants");
            Uri gmmIntentUri5 = Uri.parse("geo:0,0?q=1600 Amphitheatre Parkway, Mountain+View, California");
            Uri gmmIntentUri6 = Uri.parse("geo:0,0?q=101+main+street");
            Uri gmmIntentUri7 = Uri.parse("geo:37.7749,-122.4194?q=101+main+street");
            Uri gmmIntentUri8 = Uri.parse("geo:0,0?q=-33.8666,151.1957(Google+Sydney)");
            Uri gmmIntentUri9 = Uri.parse("http://plus.codes/849VQJQ5+XX");
            Uri gmmIntentUri10 = Uri.parse("google.navigation:q=Taronga+Zoo,+Sydney+Australia");
            Uri gmmIntentUri11 = Uri.parse("google.navigation:q=Taronga+Zoo,+Sydney+Australia&avoid=tf");
            Uri gmmIntentUri12 = Uri.parse("google.navigation:q=Taronga+Zoo,+Sydney+Australia&mode=b");
            Uri gmmIntentUri13 = Uri.parse("google.navigation:q=Connaught+Place,+New+Delhi,Delhi&mode=l");
            Uri gmmIntentUri14 = Uri.parse("google.streetview:cbll=46.414382,10.013988");
            Uri gmmIntentUri15 = Uri.parse("google.streetview:panoid=Iaa2JyfIggYAAAQfCZU9KQ");
            Uri gmmIntentUri16 = Uri.parse("google.streetview:cbll=29.9774614,31.1329645&cbp=0,30,0,0,-15");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri15);
            mapIntent.setPackage("com.google.android.apps.maps");
            if (mapIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(mapIntent);
            }

        }

        public void shareText(View view) {
            String txt = mShareTextEditText.getText().toString();
            String mimeType = "text/plain";

            ShareCompat.IntentBuilder
                    .from(this) //El activity que lanza éste recurso compartido Intent(this)
                    .setType(mimeType) //El tipo MIME del elemento a compartir
                    .setChooserTitle(R.string.textShare) //El titulo que aparece en el selector de aplicaciones del sistema
                    .setText(txt) //El texto real a compartir
                    .startChooser(); //Muestra el selector de aplicaciones del sistema y envía el Intent
        }

        public void TakePicture(View view) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivity(intent);
        }
    }
