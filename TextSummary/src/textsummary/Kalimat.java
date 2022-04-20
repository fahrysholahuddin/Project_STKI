package textsummary;

/**
 *
 * @author fahry
 */
public class Kalimat {
    private String text;
    private int noKalimat;
    private static int nextN=0;
    
    public Kalimat(String text){
        this.text = text;
        this.noKalimat = nextN++;
    }
    
    @Override
    public String toString(){
        return "No. " + this.noKalimat + "\t Text " + this.text;
    }
    
    public String getText(){
        return this.text;
    }
    
    public int getNoKalimat(){
        return this.noKalimat;
    }
}
