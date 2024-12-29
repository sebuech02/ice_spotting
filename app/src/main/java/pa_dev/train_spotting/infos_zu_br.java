package pa_dev.train_spotting;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

public class infos_zu_br extends AppCompatActivity {
    public int nummer;
    public datensatzstamm stammdatenzunummer;
    public TextView title, utitle;
    public LinearLayout ll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.infos_br);
        getSupportActionBar().setTitle("ICE-Spotting");
        getSupportActionBar().setSubtitle("Baureihen-Details");
        nummer = Integer.parseInt(getIntent().getExtras().getString("id"));
        stammdatenzunummer = MainActivity.find_datensatz(nummer);
        title=findViewById(R.id.title);
        utitle=findViewById(R.id.untertitle);
        ll=findViewById(R.id.infos);

        title.setText("Die " + stammdatenzunummer.br);
        utitle.setText("Eine Baureihe des "+stammdatenzunummer.typ);
        determine_infos();
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
            startActivity(new Intent(infos_zu_br.this, impressum.class));
        }
        return super.onOptionsItemSelected(item);
    }

    public void determine_infos(){
        if(stammdatenzunummer.br.contains("401")){
            TableLayout tl = new TableLayout(this);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            tl.setLayoutParams(lp);
            tl.setShrinkAllColumns(true);
            tl.setColumnStretchable(0,true);
            tl.setColumnStretchable(1,true);
            tl.addView(make_tablerow("Erste Inbetriebnahme"," 1991 (2. Modernisierung 2020)"));
            tl.addView(make_tablerow("Anzahl der Züge"," aktuell 18, geplant 58"));
            tl.addView(make_tablerow("Anzahl Mittelwagen/Triebköpfe"," 9/2"));
            tl.addView(make_tablerow("Länge (Zug)"," 279 m"));
            tl.addView(make_tablerow("Anzahl angetriebener Achsen"," 8"));
            tl.addView(make_tablerow("Zuggewicht (leer)"," 627 t"));
            tl.addView(make_tablerow("Höchstgeschwindigkeit"," 280 km/h"));
            tl.addView(make_tablerow("Klimaanlage"," ja"));
            tl.addView(make_tablerow("Druckertüchtigung"," ja"));
            tl.addView(make_tablerow("WC-System"," geschlossen"));
            tl.addView(make_tablerow("Stromsystem"," Einsystem"));
            tl.addView(make_tablerow("Notbremsüberbrückung"," ja"));
            tl.addView(make_tablerow("Auslandseinsatz möglich"," nein"));
            tl.addView(make_tablerow("Bordrestaurant"," ja"));
            tl.addView(make_tablerow("Bordbistro"," ja"));
            tl.addView(make_tablerow("Sitzplätze (gesamt)"," 503"));
            tl.addView(make_tablerow("Aufteilung","1. Klasse/2. Klasse"));
            tl.addView(make_tablerow("davon Sitzplätze"," 110 (22%) 393 (78%)"));
            tl.addView(make_tablerow("Plätze im Handybereich"," 80 (73%) 299 (76%)"));
            tl.addView(make_tablerow("Plätze im Ruhebereich"," 30 (27%) 94 (24%)"));
            tl.addView(make_tablerow("Plätze im Familienbereich"," – 18 (6%)"));
            tl.addView(make_tablerow("Steckdosen am Platz"," ja ja"));
            tl.addView(make_tablerow("Kleinkindabteil"," nein ja (5 Sitzplätze)"));
            tl.addView(make_tablerow("Rollstuhlstellplätze"," nein ja, 2"));
            tl.addView(make_tablerow("Fahrradstellplätze"," nein nein"));
            tl.addView(make_tablerow("Kinderwagenstellplätze"," nein ja, 2, davon 1 im Kleinkindabteil"));
            tl.addView(make_tablerow("Elektronische Reservierungsanzeige"," ja ja"));
            tl.addView(make_tablerow("Elektronische Fahrgastinformation"," ja (dynamisch) ja (dynamisch)"));
            tl.addView(make_tablerow("WLAN"," ja ja"));
            ll.addView(tl);
        }else if (stammdatenzunummer.br.contains("402")) {
            TableLayout tl = new TableLayout(this);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            tl.setLayoutParams(lp);
            tl.setShrinkAllColumns(true);
            tl.setColumnStretchable(0,true);
            tl.setColumnStretchable(1,true);
            tl.addView(make_tablerow("Erste Inbetriebnahme"," 1996/2011"));
            tl.addView(make_tablerow("Anzahl der Züge"," 44"));
            tl.addView(make_tablerow("Anzahl Mittel-/Steuerwagen"," 6/1"));
            tl.addView(make_tablerow("Länge (Zug)"," 205 m"));
            tl.addView(make_tablerow("Anzahl angetriebener Achsen"," 4"));
            tl.addView(make_tablerow("Zuggewicht"," ca. 418 t"));
            tl.addView(make_tablerow("Höchstgeschwindigkeit"," 280 km/h"));
            tl.addView(make_tablerow("Klimaanlage"," ja"));
            tl.addView(make_tablerow("Druckertüchtigung"," ja"));
            tl.addView(make_tablerow("WC-System"," geschlossen"));
            tl.addView(make_tablerow("Stromsystem"," Einsystem"));
            tl.addView(make_tablerow("Notbremsüberbrückung"," ja"));
            tl.addView(make_tablerow("Auslandseinsatz möglich"," nein"));
            tl.addView(make_tablerow("Bordrestaurant"," ja"));
            tl.addView(make_tablerow("Bordbistro"," ja"));
            tl.addView(make_tablerow("Sitzplätze (gesamt)"," 381"));
            tl.addView(make_tablerow("Aufteilung","1. Klasse/2. Klasse"));
            tl.addView(make_tablerow("davon Sitzplätze"," 106 (28%) 275 (72%)"));
            tl.addView(make_tablerow("Plätze im Handybereich"," 85 (80%) 197 (72%)"));
            tl.addView(make_tablerow("Plätze im Ruhebereich"," 21 (20%) 78 (28%)"));
            tl.addView(make_tablerow("Plätze im Familenbereich"," – 16 (6%)"));
            tl.addView(make_tablerow("Steckdosen am Platz"," an allen Einzel- (je 1), Doppelsitzen (je 2) an allen Doppelsitzen (je 1)"));
            tl.addView(make_tablerow("Kleinkindabteil"," nein ja"));
            tl.addView(make_tablerow("Rollstuhlstellplätze"," nein ja (2)"));
            tl.addView(make_tablerow("Fahrradstellplätze"," nein nein"));
            tl.addView(make_tablerow("Elektronische Reservierungsanzeige"," ja ja"));
            tl.addView(make_tablerow("Infodisplay für Bordinformationen"," ja ja"));
            tl.addView(make_tablerow("WLAN"," ja ja"));
            ll.addView(tl);
        }else if (stammdatenzunummer.br.contains("403")) {
            TableLayout tl = new TableLayout(this);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            tl.setLayoutParams(lp);
            tl.setShrinkAllColumns(true);
            tl.setColumnStretchable(0,true);
            tl.setColumnStretchable(1,true);
            tl.addView(make_tablerow("Erste Inbetriebnahme"," 2000/Umbau 2002"));
            tl.addView(make_tablerow("Anzahl der Züge"," 37"));
            tl.addView(make_tablerow("Anzahl Mittel-/Endwagen"," 6/2"));
            tl.addView(make_tablerow("Länge (Zug)"," 200 m"));
            tl.addView(make_tablerow("Anzahl angetriebener Achsen"," 16"));
            tl.addView(make_tablerow("Zuggewicht"," ca. 410 t"));
            tl.addView(make_tablerow("Höchstgeschwindigkeit"," 330 km/h"));
            tl.addView(make_tablerow("Klimaanlage"," ja"));
            tl.addView(make_tablerow("Druckertüchtigung"," ja"));
            tl.addView(make_tablerow("WC-System"," geschlossen"));
            tl.addView(make_tablerow("Stromsystem"," Einsystem"));
            tl.addView(make_tablerow("Notbremsüberbrückung"," ja"));
            tl.addView(make_tablerow("Auslandseinsatz möglich"," nein"));
            tl.addView(make_tablerow("Bordrestaurant"," Sitzplätze im Bordbistro"));
            tl.addView(make_tablerow("Bordbistro"," ja"));
            tl.addView(make_tablerow("Sitzplätze (gesamt)"," 429"));
            tl.addView(make_tablerow("Aufteilung","1. Klasse/2. Klasse"));
            tl.addView(make_tablerow("davon Sitzplätze"," 98 (23%) 331 (77%)"));
            tl.addView(make_tablerow("Plätze im Handybereich"," 74 (76%) 257 (78%)"));
            tl.addView(make_tablerow("Plätze im Ruhebereich"," 24 (24%) 68 (21%)"));
            tl.addView(make_tablerow("Plätze im Familienbereich"," – 16 (5%)"));
            tl.addView(make_tablerow("Steckdosen am Platz"," an allen Doppel- und Einzelsitzen (je 1)\n an nahezu allen Doppelsitzen (je 1)"));
            tl.addView(make_tablerow("Kleinkindabteil"," nein ja"));
            tl.addView(make_tablerow("Rollstuhlstellplätze"," nein ja (1)"));
            tl.addView(make_tablerow("Fahrradstellplätze"," nein nein"));
            tl.addView(make_tablerow("Elektronische Reservierungsanzeige"," ja ja"));
            tl.addView(make_tablerow("Infodisplay für Bordinformationen"," ja ja"));
            tl.addView(make_tablerow("WLAN"," ja ja"));
            ll.addView(tl);
        }else if (stammdatenzunummer.br.contains("406")) {
            TableLayout tl = new TableLayout(this);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            tl.setLayoutParams(lp);
            tl.setShrinkAllColumns(true);
            tl.setColumnStretchable(0,true);
            tl.setColumnStretchable(1,true);
            tl.addView(make_tablerow("Erste Inbetriebnahme"," 2000/Umbau 2002"));
            tl.addView(make_tablerow("Anzahl der Züge"," 13 (+ 3 bei NS)"));
            tl.addView(make_tablerow("Anzahl Mittel-/Endwagen"," 6/2"));
            tl.addView(make_tablerow("Länge (Zug)"," 200 m"));
            tl.addView(make_tablerow("Anzahl angetriebener Achsen"," 16"));
            tl.addView(make_tablerow("Zuggewicht"," 435 t"));
            tl.addView(make_tablerow("Höchstgeschwindigkeit"," 330 km/h"));
            tl.addView(make_tablerow("Klimaanlage"," ja"));
            tl.addView(make_tablerow("Druckertüchtigung"," ja"));
            tl.addView(make_tablerow("WC-System"," geschlossen"));
            tl.addView(make_tablerow("Stromsystem"," Viersystem"));
            tl.addView(make_tablerow("Notbremsüberbrückung"," ja"));
            tl.addView(make_tablerow("Auslandseinsatz möglich"," NL, B"));
            tl.addView(make_tablerow("Bordrestaurant"," Sitzplätze im Bordbistro"));
            tl.addView(make_tablerow("Bordbistro"," ja"));
            tl.addView(make_tablerow("Sitzplätze (gesamt)"," 419"));
            tl.addView(make_tablerow("Aufteilung","1. Klasse/2. Klasse"));
            tl.addView(make_tablerow("davon Sitzplätze"," 93 (22%) 326 (78%)"));
            tl.addView(make_tablerow("Plätze im Handybereich"," 69 (74%) 256 (78%)"));
            tl.addView(make_tablerow("Plätze im Ruhebereich"," 24 (26%) 64 (20%)"));
            tl.addView(make_tablerow("Plätze im Familienbereich"," – 16 (5%)"));
            tl.addView(make_tablerow("Steckdosen am Platz"," an allen Doppel- und Einzelsitzen (je 1)\n an nahezu allen Doppelsitzen (je 1)"));
            tl.addView(make_tablerow("Kleinkindabteil"," nein ja"));
            tl.addView(make_tablerow("Rollstuhlstellplätze"," nein ja (1)"));
            tl.addView(make_tablerow("Fahrradstellplätze"," nein nein"));
            tl.addView(make_tablerow("Elektronische Reservierungsanzeige"," ja ja"));
            tl.addView(make_tablerow("Infodisplay für Bordinformationen"," ja ja"));
            tl.addView(make_tablerow("WLAN"," ja ja"));
            ll.addView(tl);
        }else if (stammdatenzunummer.br.contains("407")) {
            TableLayout tl = new TableLayout(this);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            tl.setLayoutParams(lp);
            tl.setShrinkAllColumns(true);
            tl.setColumnStretchable(0,true);
            tl.setColumnStretchable(1,true);
            tl.addView(make_tablerow("Erste Inbetriebnahme"," 2013"));
            tl.addView(make_tablerow("Anzahl der Züge"," 17"));
            tl.addView(make_tablerow("Anzahl Mittel-/Endwagen"," 6/2"));
            tl.addView(make_tablerow("Länge (Zug)"," 201 m"));
            tl.addView(make_tablerow("Anzahl angetriebener Achsen"," 16"));
            tl.addView(make_tablerow("Zuggewicht"," ca. 492 t"));
            tl.addView(make_tablerow("Höchstgeschwindigkeit"," 320 km/h"));
            tl.addView(make_tablerow("Klimaanlage"," ja"));
            tl.addView(make_tablerow("Druckertüchtigung"," ja"));
            tl.addView(make_tablerow("WC-System"," geschlossen"));
            tl.addView(make_tablerow("Stromsystem"," Mehrsystem"));
            tl.addView(make_tablerow("Notbremsüberbrückung"," ja"));
            tl.addView(make_tablerow("Auslandseinsatz möglich"," ja (F, geplant B)"));
            tl.addView(make_tablerow("Bordrestaurant"," ja, 16 Sitzplätze"));
            tl.addView(make_tablerow("Bordbistro"," ja"));
            tl.addView(make_tablerow("Sitzplätze (gesamt)"," 444"));
            tl.addView(make_tablerow("Aufteilung","1. Klasse/2. Klasse"));
            tl.addView(make_tablerow("davon Sitzplätze"," 111 (25%) 333 (75%)"));
            tl.addView(make_tablerow("Plätze im Handybereich"," 87 (78%) 269 (81%)"));
            tl.addView(make_tablerow("Plätze im Ruhebereich"," 24 (22%) 64 (19%)"));
            tl.addView(make_tablerow("Plätze im Familienbereich"," – 16 (5%)"));
            tl.addView(make_tablerow("Steckdosen am Platz"," an allen Doppel- und Einzelsitzen (je 1)\n an allen Doppelsitzen (je 1)"));
            tl.addView(make_tablerow("Kleinkindbereich"," nein ja"));
            tl.addView(make_tablerow("Rollstuhlstellplätze/Hublift am Einstieg"," nein ja (2)/ja"));
            tl.addView(make_tablerow("Fahrradstellplätze"," nein nein"));
            tl.addView(make_tablerow("Elektronische Reservierungsanzeige"," ja ja"));
            tl.addView(make_tablerow("Infodisplay für Bordinformationen"," ja ja"));
            tl.addView(make_tablerow("WLAN"," ja ja"));
            ll.addView(tl);
        }else if (stammdatenzunummer.br.contains("411")) {
            TableLayout tl = new TableLayout(this);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            tl.setLayoutParams(lp);
            tl.setShrinkAllColumns(true);
            tl.setColumnStretchable(0,true);
            tl.setColumnStretchable(1,true);
            tl.addView(make_tablerow("Erste Inbetriebnahme"," 2004 ff"));
            tl.addView(make_tablerow("Anzahl der Züge"," 28"));
            tl.addView(make_tablerow("Anzahl Mittel-/Endwagen"," 5/2"));
            tl.addView(make_tablerow("Länge (Zug)"," 185 m"));
            tl.addView(make_tablerow("Anzahl angetriebener Achsen"," 8"));
            tl.addView(make_tablerow("Zuggewicht"," 368 t"));
            tl.addView(make_tablerow("Höchstgeschwindigkeit"," 230 km/h"));
            tl.addView(make_tablerow("Klimaanlage"," ja"));
            tl.addView(make_tablerow("Druckertüchtigung"," ja"));
            tl.addView(make_tablerow("WC-System"," geschlossen"));
            tl.addView(make_tablerow("Stromsystem"," Einsystem"));
            tl.addView(make_tablerow("Notbremsüberbrückung"," ja"));
            tl.addView(make_tablerow("Auslandseinsatz möglich"," ja (A)"));
            tl.addView(make_tablerow("Bordrestaurant"," ja"));
            tl.addView(make_tablerow("Bordbistro"," ja"));
            tl.addView(make_tablerow("Sitzplätze (gesamt)"," 376"));
            tl.addView(make_tablerow("Aufteilung","1. Klasse/2. Klasse"));
            tl.addView(make_tablerow("davon Sitzplätze"," 55 (15%) 321 (85%)"));
            tl.addView(make_tablerow("Plätze im Handybereich"," 49 (89%) 241 (75%)"));
            tl.addView(make_tablerow("Plätze im Ruhebereich"," 6 (11%) 74 (23%)"));
            tl.addView(make_tablerow("Plätze im Familienbereich"," – 20 (6%)"));
            tl.addView(make_tablerow("Steckdosen am Platz"," an allen Doppel- und Einzelsitzen (je 1) \n an allen Doppel- und Einzelsitzen (je 1)"));
            tl.addView(make_tablerow("Kleinkindabteil"," nein ja"));
            tl.addView(make_tablerow("Rollstuhlstellplätze"," nein ja (1)"));
            tl.addView(make_tablerow("Fahrradstellplätze"," nein ja (3)"));
            tl.addView(make_tablerow("Elektronische Reservierungsanzeige"," ja ja"));
            tl.addView(make_tablerow("Infodisplay für Bordinformationen"," ja ja"));
            tl.addView(make_tablerow("WLAN"," ja ja"));
            ll.addView(tl);
        }else if (stammdatenzunummer.br.contains("415")) {
            TableLayout tl = new TableLayout(this);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            tl.setLayoutParams(lp);
            tl.setShrinkAllColumns(true);
            tl.setColumnStretchable(0,true);
            tl.setColumnStretchable(1,true);
            tl.addView(make_tablerow("Erste Inbetriebnahme"," 1999"));
            tl.addView(make_tablerow("Anzahl der Züge"," 11"));
            tl.addView(make_tablerow("Anzahl Mittel-/Endwagen"," 3/2"));
            tl.addView(make_tablerow("Länge (Zug)"," 133 m"));
            tl.addView(make_tablerow("Anzahl angetriebener Achsen"," 6"));
            tl.addView(make_tablerow("Zuggewicht"," ca. 273 t"));
            tl.addView(make_tablerow("Höchstgeschwindigkeit"," 230 km/h"));
            tl.addView(make_tablerow("Klimaanlage"," ja"));
            tl.addView(make_tablerow("Druckertüchtigung"," ja"));
            tl.addView(make_tablerow("WC-System"," geschlossen"));
            tl.addView(make_tablerow("Stromsystem"," Einsystem"));
            tl.addView(make_tablerow("Notbremsüberbrückung"," ja"));
            tl.addView(make_tablerow("Auslandseinsatz möglich"," nein"));
            tl.addView(make_tablerow("Bordrestaurant"," nein"));
            tl.addView(make_tablerow("Bordbistro"," ja"));
            tl.addView(make_tablerow("Sitzplätze (gesamt)"," 250"));
            tl.addView(make_tablerow("Aufteilung","1. Klasse/2. Klasse"));
            tl.addView(make_tablerow("davon Sitzplätze"," 41 (16%) 209 (83%)"));
            tl.addView(make_tablerow("Plätze im Handybereich"," 35 (85%) 139 (67%)"));
            tl.addView(make_tablerow("Plätze im Ruhebereich"," 6 (14%) 70 (33%)"));
            tl.addView(make_tablerow("Plätze im Familienbereich"," – 8 (4%)"));
            tl.addView(make_tablerow("Steckdosen am Platz"," an allen Doppel- und Einzelsitzen (je 1)\n an allen Doppelsitzen, im KKA (je 1)"));
            tl.addView(make_tablerow("Kleinkindabteil mit besonderer Ausstattung"," nein ja"));
            tl.addView(make_tablerow("Rollstuhlstellplätze"," nein ja (1)"));
            tl.addView(make_tablerow("Fahrradstellplätze"," nein nein"));
            tl.addView(make_tablerow("Elektronische Reservierungsanzeige"," ja ja"));
            tl.addView(make_tablerow("Infodisplay für Bordinformationen"," ja ja"));
            tl.addView(make_tablerow("WLAN"," ja ja"));
            ll.addView(tl);
        }else if (stammdatenzunummer.br.contains("605")) {
            TableLayout tl = new TableLayout(this);
            TableLayout.LayoutParams lp = new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT);
            tl.setLayoutParams(lp);
            tl.setShrinkAllColumns(true);
            tl.setColumnStretchable(0,true);
            tl.setColumnStretchable(1,true);
            tl.addView(make_tablerow("Infos:   ", "Daten zur Baureihe 605\n stehen leider derzeit nicht\n zur Verfügung. Die Züge wurden\n zwischen 1998–2000 hergestellt \nund waren von 2001 bis 2017 im Personenverkehr\n present, seitdem werden sie nur noch \nfür Testzwecke verwendet."));
            //tl.addView(make_tablerow("und hier", "Wo?"));
            ll.addView(tl);
        }
    }
    public TableRow make_tablerow(String a, String b){
        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams li = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        TableRow tr = new TableRow(this);
        TextView tv1=new TextView(this);
        TextView tv2=new TextView(this);
        tr.setLayoutParams(lp);
        tv1.setText(a);
        tv2.setText(b);
        tr.addView(tv1);
        tr.addView(tv2);
        return tr;
    }

}
