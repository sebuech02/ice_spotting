package pa_dev.train_spotting;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class trainview extends AppCompatActivity implements View.OnClickListener {
    public int nummer;
    public datensatzstamm stammdatenzunummer;
    public TextView tit, utit, ice;
    public Button br, sichtung;
    public LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trainview);
        getSupportActionBar().setTitle("ICE-Spotting");
        getSupportActionBar().setSubtitle("Zug-Details");
        nummer = Integer.parseInt(getIntent().getExtras().getString("id"));
        stammdatenzunummer=MainActivity.find_datensatz(nummer);
        tit=findViewById(R.id.title);
        utit=findViewById(R.id.untertitle);
        br=findViewById(R.id.baureihe);
        ice=findViewById(R.id.icetyp);
        container=findViewById(R.id.container_notiz);
        sichtung=findViewById(R.id.addsichtung);

        tit.setText("Tr.: " + String.valueOf(stammdatenzunummer.zahl));
        utit.setText(stammdatenzunummer.name);
        br.setText(stammdatenzunummer.br);
        ice.setText(stammdatenzunummer.typ);
        fill_notizen();

        br.setOnClickListener(this);
        sichtung.setOnClickListener(this);

    }
    @Override
    public void onResume() {
        super.onResume();
        fill_notizen();
    }
    @Override
    public void onRestart() {
        super.onRestart();
        fill_notizen();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == br.getId()) {
            String str = String.valueOf(stammdatenzunummer.zahl);
            if (!str.equals("null")) {
                Intent actvar = new Intent(trainview.this, infos_zu_br.class);
                actvar.putExtra("id", str);
                startActivity(actvar);
            }
        } else if (v.getId() == sichtung.getId()) {
            String str = String.valueOf(stammdatenzunummer.zahl);
            if (!str.equals("null")) {
                Intent actvar = new Intent(trainview.this, add_sichtung.class);
                actvar.putExtra("id", str);
                startActivity(actvar);
            }
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu_basic, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.mybutton) {
            this.onBackPressed();
        } else if (id==R.id.impressum) {
            startActivity(new Intent(trainview.this, impressum.class));
        }
        return true;
    }

    public void fill_notizen(){
        container.removeAllViews();
        ArrayList<datensatzeintrag_mit_datum> list_del = new ArrayList<datensatzeintrag_mit_datum>();
        if(MainActivity.eintrag_mit_datum!=null) {
            for (datensatzeintrag_mit_datum el : MainActivity.eintrag_mit_datum) {
                if (el.zug_id == nummer) {
                    TextView tv = new TextView(this);
                    TextView tv2 = new TextView(this);
                    TextView tv3 = new TextView(this);
                    Button del = new Button(this);
                    View div = MainActivity.makediv(this);
                    if (el.gefahren && el.gesehen) {
                        tv.setText("Drin Gefahren und Gesehen");
                    } else if (el.gesehen) {
                        tv.setText("Nur gesehen");
                    } else {
                        tv.setText("Drin gefahren");
                    }
                    tv.setTextSize(22);
                    tv3.setText("Am: "+el.datum);
                    tv3.setTextSize(18);
                    tv3.setGravity(Gravity.CENTER);
                    Typeface tf = null;
                    tv.setTypeface(tf, Typeface.BOLD);
                    tv2.setText(el.bemerkung);
                    del.setText("Eintrag löschen?");
                    del.setBackground(getDrawable(R.drawable.shape_wagon3));
                    del.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            MainActivity.del_eintrag(el);
                            fill_notizen();
                        }
                    });
                    container.addView(tv);
                    if(el.datum.length()>2){
                        container.addView(tv3);
                    }
                    container.addView(tv2);
                    container.addView(del);
                    container.addView(div);
                }
            }
        }
    }
}
