package pa_dev.train_spotting;

public class datensatzstamm {
    public int zahl;
    public String br;
    public String typ;
    public String name;

    public datensatzstamm(int zugnummer, String baureihe, String ice, String bezeichnung){
        this.zahl=zugnummer;
        this.br=baureihe;
        this.typ=ice;
        this.name=bezeichnung;
    }

    public int getbrint(){
        int i=0;
        if (this.br.contains("401")){
            i=401;
        } else if (this.br.contains("402")) {
            i=402;
        } else if (this.br.contains("403")) {
            i=403;
        } else if (this.br.contains("406")) {
            i=406;
        } else if (this.br.contains("407")) {
            i=407;
        } else if (this.br.contains("411")) {
            i=411;
        } else if (this.br.contains("415")) {
            i=415;
        } else if (this.br.contains("605")) {
            i=605;
        }
        return i;
    }
}
