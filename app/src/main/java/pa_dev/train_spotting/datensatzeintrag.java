package pa_dev.train_spotting;

public class datensatzeintrag {
    public int zug_id;
    public boolean gesehen, gefahren;
    public String bemerkung;

    public datensatzeintrag(int id, boolean sehen, boolean fahren, String notiz){
        this.zug_id=id;
        this.gesehen=sehen;
        this.gefahren=fahren;
        this.bemerkung=notiz;
    }
}
