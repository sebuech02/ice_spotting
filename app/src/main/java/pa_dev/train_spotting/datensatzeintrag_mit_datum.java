package pa_dev.train_spotting;

import java.util.Date;

public class datensatzeintrag_mit_datum {
    public int zug_id;
    public boolean gesehen, gefahren;
    public String bemerkung;
    public String datum;

    public datensatzeintrag_mit_datum(int id, boolean sehen, boolean fahren, String notiz){
        this.zug_id=id;
        this.gesehen=sehen;
        this.gefahren=fahren;
        this.bemerkung=notiz;
        this.datum="";
    }

    public datensatzeintrag_mit_datum(int id, boolean sehen, boolean fahren, String notiz, String dat){
        this.zug_id=id;
        this.gesehen=sehen;
        this.gefahren=fahren;
        this.bemerkung=notiz;
        this.datum=dat;
    }
}
