
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
        KalimatBuilder KalimatBuilder = new KalimatBuilder(LANGCODE, FILEPATH);
        
        //split menjadi objek kata
        KataBuilder kataBuilder = new KataBuilder();
        kataBuilder.getKata(LANGCODE, FILEPATH);
        kataBuilder.removeStopWords(LANGCODE);
        kataBuilder.doCount(kataBuilder.getObjectKataBersih());

        DebugClass.printFreqMap();
        DebugClass.printStats();
       
        kataBuilder.TopKata(LENGTH);

        Summarizer sumrizr = new Summarizer();
        sumrizr.sortTokWordList();
       
        DebugClass.printTopWords();
        sumrizr.createSummary();
    }
    
}
