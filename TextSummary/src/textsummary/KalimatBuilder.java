package textsummary;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author fahry
 */
public class KalimatBuilder {
    //Deklarasi Variabel
    private static final String SEPERATORS = ". ";
    private static List<String> lines;
    private static ArrayList<Kalimat> kalimatObject = new ArrayList<Kalimat>();
    
    public KalimatBuilder(String language, String filePath){
        //membuat list kalimat object
        getKalimat(filePath);
    }
    
    public static ArrayList<Kalimat> getKalimatObject(){
        return kalimatObject;
    }
    
    public static List<String> getLines(){
        return lines;
    }
    
    private ArrayList<Kalimat> getKalimat (String path){
        //
        lines = FileHandler.readFile(path);
        //
        for(String line : lines){
            
            //segala sebelum tanda titik dan blank space adalah kalimat
            String[] splitLines = line.split("(?<=\\. {0,1})");
            
            //romove blang space
            for (int j = 0; j < splitLines.length; j++){
                if(splitLines[j].equals(" "))
                    splitLines[j] = null;
            }
            
            for (String aKalimat : splitLines ){
                if(aKalimat!=null)
                {
                    Kalimat k = new Kalimat(aKalimat);
                    kalimatObject.add(k);
                }
            }
        }
        return kalimatObject;
    }
}
