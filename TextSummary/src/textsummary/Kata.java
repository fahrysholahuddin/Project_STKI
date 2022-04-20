package textsummary;
import java.util.ArrayList;

/**
 *
 * @author fahry
 */
public class Kata {
    private String kataText;
    private int milikKalimatN;
    private int kejadian = -1;
    static ArrayList<Kata> kataKotor = new ArrayList<Kata>();
    
    public Kata(String kata, int milikKalimatN) {
        this.kataText = kata;
        this.milikKalimatN = milikKalimatN;
        kataKotor.add(this);
    }
    
    @Override
    public String toString(){
        return String.format("%-20s ...milik kalimat %s", this.kataText, this.milikKalimatN);
    }
    
    public static ArrayList<Kata> getKataKotor(){
        return kataKotor;
    }
    
    public String getKataText(){
        return this.kataText;
    }
    
    public int getMilikKalimatNo(){
        return this.milikKalimatN;
    }
    
    public void setKejadianKata(int kejadian){
        this.kejadian = kejadian;
    }
    
    public int getKataKejadian(){
        return this.kejadian;
    }
    
    @Override
    public boolean equals(Object obj) {
        //null instanceof Object akan bernilai salah
        if (!(obj instanceof Kata))
            return false;
        
        return this.kataText.equals(((Kata)obj).kataText) ? true : false;
    }
    
    @Override
    public int hashCode(){
        return this.kataText.hashCode(); 
    }
    
    
    public int compareTo(Kata kata){
        if(this.kejadian < kata.kejadian)
            return -1;
        else if(this.kejadian > kata.kejadian)
            return 1;
        return 0;
    }
    
}
