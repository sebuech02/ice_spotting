package pa_dev.train_spotting;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

public class sort_trains extends AppCompatActivity implements View.OnClickListener{
    public static RadioButton rb2;
    public static RadioButton rb3;
    public static RadioButton rb4;
    public static Switch sw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sort_trains);
        getSupportActionBar().setTitle("ICE-Spotting");
        getSupportActionBar().setSubtitle("Sortieren der Züge");
        init_sort();
    }
    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id==rb2.getId() || id==rb3.getId() || id==rb4.getId() || id==sw.getId()){
            save_sorts();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // R.menu.mymenu is a reference to an xml file named mymenu.xml which should be inside your res/menu directory.
        // If you don't have res/menu, just create a directory named "menu" inside res
        getMenuInflater().inflate(R.menu.mymenu_basic, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.mybutton) {
            this.onBackPressed();
        } else if (id==R.id.impressum) {
            startActivity(new Intent(sort_trains.this, impressum.class));
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed(){
        finish();
    }

    public void init_sort(){
        rb2=findViewById(R.id.sort_name);
        rb3=findViewById(R.id.sort_id);
        rb4=findViewById(R.id.sort_br);
        sw=findViewById(R.id.sort_reverse);

        rb2.setOnClickListener(this);
        rb3.setOnClickListener(this);
        rb4.setOnClickListener(this);
        sw.setOnClickListener(this);

        MainActivity.lade_sort();
        if(MainActivity.reverse){
            sw.setChecked(true);
        }
        if (MainActivity.sort_type==1) {
            rb2.setChecked(true);
        } else if (MainActivity.sort_type==2) {
            rb3.setChecked(true);
        } else if (MainActivity.sort_type==3) {
            rb4.setChecked(true);
        } else{
            System.out.println(MainActivity.sort_type + "FEHLER");
        }
    }
    public static void save_sorts(){
        MainActivity.database.putBoolean("sort_rev", sw.isChecked());
        if (rb2.isChecked()) {
            MainActivity.database.putInt("sort_type", 1);
        } else if (rb3.isChecked()) {
            MainActivity.database.putInt("sort_type", 2);
        } else if (rb4.isChecked()) {
            MainActivity.database.putInt("sort_type", 3);
        }
    }
}
