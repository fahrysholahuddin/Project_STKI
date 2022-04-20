
package textsummary;

/**
 *
 * @author fahry
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String FILEPATH = "files/file-medium_en.txt";
        String LANGCODE = "EN";
        int LENGTH = 9;
        
        //membaca file dan membuat object Kalimat
        KalimatBuilder kb = new KalimatBuilder(LANGCODE, FILEPATH);
        
        //split menjadi objek kata
       KataBuilder kab = new KataBuilder();
       kab.getKata(LANGCODE, FILEPATH);
       kab.removeStopWords(LANGCODE);
       kab.doCount(kab.getObjectKataBersih());

       DebugClass.printInfo();
       DebugClass.printStats();
       

       
    }
    
}
