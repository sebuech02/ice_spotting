package pa_dev.train_spotting;

import android.app.Application;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class add_sichtung extends trainview implements View.OnClickListener{
    public int nummer;
    public datensatzstamm stammdatenzunummer;
    public CheckBox sehen, fahren, datum_sw;
    public EditText bemerkung;
    public Button submit;
    public TextView time;
    public static Date selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_sichtung);
        getSupportActionBar().setTitle("Sichtung hinzufügen");
        nummer = Integer.parseInt(getIntent().getExtras().getString("id"));
        stammdatenzunummer = MainActivity.find_datensatz(nummer);
        getSupportActionBar().setSubtitle("ICE-" + nummer + "/" + stammdatenzunummer.name);
        fahren=findViewById(R.id.gefahren);
        sehen=findViewById(R.id.gesehen);
        bemerkung=findViewById(R.id.bemerkung);
        submit=findViewById(R.id.submit);
        time=findViewById(R.id.timestamp);
        datum_sw=findViewById(R.id.timestamp_switch);

        fill_current_time();

        time.setOnClickListener(this);
        datum_sw.setOnClickListener(this);
        submit.setOnClickListener(this);
    }
    @Override
    public void onBackPressed(){
        fill_notizen();
        super.onBackPressed();
    }

    @Override
    public void onClick(View v){
        int id=v.getId();
        if(id==submit.getId()){
            if (sehen.isChecked() || fahren.isChecked()){
                if(datum_sw.isChecked()){
                    datensatzeintrag_mit_datum temp = new datensatzeintrag_mit_datum(nummer, sehen.isChecked(), fahren.isChecked(), bemerkung.getText().toString());
                    MainActivity.sichtung_add(temp);
                } else{
                    datensatzeintrag_mit_datum temp = new datensatzeintrag_mit_datum(nummer, sehen.isChecked(), fahren.isChecked(), bemerkung.getText().toString(), convert_date_to_string(selected));
                    MainActivity.sichtung_add(temp);
                }
                this.onBackPressed();
            } else{
                Toast.makeText(this, "Du musst wenigstens etwas ausgewählt haben.", Toast.LENGTH_LONG).show();
            }
        } else if (id==time.getId() && !datum_sw.isChecked()) {
            DatePickerFragment dpf = new DatePickerFragment(time);
            dpf.show(getSupportFragmentManager(), "datePicker");
            set_selected_date();
        } else if (id==datum_sw.getId()) {
            if(datum_sw.isChecked()){
                time.setText("  -/-  ");
            } else {
                set_selected_date();
            }

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
            startActivity(new Intent(add_sichtung.this, impressum.class));
        }
        return true;
    }

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {
        public TextView tv;
        public DatePickerFragment(TextView t){
            this.tv=t;
        }
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker.
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it.
            return new DatePickerDialog(requireContext(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(year, month, day);
            selected=calendar.getTime();
            tv.setText("  "+convert_stat_date_to_string(selected)+"  ");
        }
    }

    public static String convert_stat_date_to_string(Date input){
        SimpleDateFormat timeStampFormat = new SimpleDateFormat("dd.MM.yyyy");
        String filename = timeStampFormat.format(input).toString();
        return(filename);
    }
    public String convert_date_to_string(Date input){
        SimpleDateFormat timeStampFormat = new SimpleDateFormat("dd.MM.yyyy");
        String filename = timeStampFormat.format(input).toString();
        return(filename);
    }
    public void fill_current_time(){
        Date temp = Calendar.getInstance().getTime();
        selected=temp;
        time.setText("  "+convert_date_to_string(temp)+"  ");
    }

    public void set_selected_date(){
        time.setText("  "+convert_stat_date_to_string(selected)+"  ");
    }


}
