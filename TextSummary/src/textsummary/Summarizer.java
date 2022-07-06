package textsummary;
import java.util.ArrayList;
import java.util.Collections;


public class Summarizer {
    private ArrayList<Kata> maxWordList = KataBuilder.getMaxKataList();

    public Summarizer(){}

    public void sortTokWordList (){
        Collections.sort(maxWordList, new ComparatorKata() {
            @Override public int compare(Kata w1, Kata w2){
                return w1.getMilikKalimatNo() > w2.getMilikKalimatNo() ? 1 : -1;
            }
        });
    }
    
    

    public void createSummary(){
        ArrayList<Kalimat > kalimat = KalimatBuilder.getKalimatObject();

        System.out.println("\n------------------Summary-------------------");
        for (int i = 0; i < maxWordList.size(); i++) {
            int j = maxWordList.get(i).getMilikKalimatNo();
            System.out.format("'%s\n'",kalimat.get(j).getText());
        }

    }
}
