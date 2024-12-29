package pa_dev.train_spotting;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

public class filter_trains extends AppCompatActivity implements View.OnClickListener{
    public static CheckBox b1;
    public static CheckBox b2;
    public static CheckBox b3;
    public static CheckBox r1;
    public static CheckBox r2;
    public static CheckBox r3;
    public static CheckBox r6;
    public static CheckBox r7;
    public static CheckBox r11;
    public static CheckBox r15;
    public static CheckBox r05;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filter_trains);
        getSupportActionBar().setTitle("ICE-Spotting");
        getSupportActionBar().setSubtitle("Filter die Züge");
        init_checkboxen();
    }
    @Override
    public void onClick(View v){
        int id=v.getId();
        if ((id==b1.getId()) || (id==b2.getId()) || (id==b3.getId()) || (id==r1.getId()) || (id==r2.getId()) || (id==r3.getId()) || (id==r6.getId()) || (id==r7.getId()) || (id==r11.getId()) || (id==r15.getId()) || (id==r05.getId())){
            save_filter();
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
            startActivity(new Intent(filter_trains.this, impressum.class));
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed(){
        //save_filter();
        finish();
    }
    public void init_checkboxen(){
        b1=findViewById(R.id.ohne_entry);
        b2=findViewById(R.id.saw);
        b3=findViewById(R.id.drove);
        r1=findViewById(R.id.br401);
        r2=findViewById(R.id.br402);
        r3=findViewById(R.id.br403);
        r6=findViewById(R.id.br406);
        r7=findViewById(R.id.br407);
        r11=findViewById(R.id.br411);
        r15=findViewById(R.id.br415);
        r05=findViewById(R.id.br605);

        MainActivity.lade_filter();
        b1.setChecked(MainActivity.fnoentry);
        b2.setChecked(MainActivity.fsaw);
        b3.setChecked(MainActivity.frode);
        r1.setChecked(MainActivity.f401);
        r2.setChecked(MainActivity.f402);
        r3.setChecked(MainActivity.f403);
        r6.setChecked(MainActivity.f406);
        r7.setChecked(MainActivity.f407);
        r11.setChecked(MainActivity.f411);
        r15.setChecked(MainActivity.f415);
        r05.setChecked(MainActivity.f605);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        r1.setOnClickListener(this);
        r2.setOnClickListener(this);
        r3.setOnClickListener(this);
        r6.setOnClickListener(this);
        r7.setOnClickListener(this);
        r11.setOnClickListener(this);
        r15.setOnClickListener(this);
        r05.setOnClickListener(this);
    }

    public static void save_filter(){
        MainActivity.database.putBoolean("noentry", b1.isChecked());
        MainActivity.database.putBoolean("saw", b2.isChecked());
        MainActivity.database.putBoolean("rode", b3.isChecked());
        MainActivity.database.putBoolean("401", r1.isChecked());
        MainActivity.database.putBoolean("402", r2.isChecked());
        MainActivity.database.putBoolean("403", r3.isChecked());
        MainActivity.database.putBoolean("406", r6.isChecked());
        MainActivity.database.putBoolean("407", r7.isChecked());
        MainActivity.database.putBoolean("411", r11.isChecked());
        MainActivity.database.putBoolean("415", r15.isChecked());
        MainActivity.database.putBoolean("605", r05.isChecked());
    }
}
