package pa_dev.train_spotting;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class impressum extends AppCompatActivity implements View.OnClickListener{
    public Button mail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.impressum);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("ICE-Spotting");
        getSupportActionBar().setSubtitle("Info/Impressum");
        mail=findViewById(R.id.mail);
        mail.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        int id=v.getId();
        if (id==mail.getId()){
            Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                    "mailto","sebastian.buechler@tutanota.de", null));
            intent.putExtra(Intent.EXTRA_SUBJECT, "AF: ICE-Spotting");
            intent.putExtra(Intent.EXTRA_TEXT, "Was ist Ihr/Dein Anliegen?");
            startActivity(Intent.createChooser(intent, "Email-Anbieter auswählen:"));
        }
    }
}
