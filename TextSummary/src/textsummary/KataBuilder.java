package textsummary;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author fahry
 */
public class KataBuilder {
    private static ArrayList<Kata> objectKataKotor = new ArrayList<Kata>();
    private static ArrayList<Kata> objectKataBersih;
    private static LinkedHashMap<Kata, Integer> freqMap = new LinkedHashMap<Kata, Integer>();
    private static ArrayList<Kata> maxKataList = new ArrayList<>();
    
    
    public KataBuilder(){}
    
    public List<Kata> getKata(String language, String path){
        ArrayList<Kalimat> kalimatObjects = KalimatBuilder.getKalimatObject();
        
        String[] kataDalamKalimat = null;
        
        for (Kalimat kalimat : kalimatObjects){
            if(language.equals("ID"))
                kataDalamKalimat = kalimat.getText().split("([^\\w']+)");
            else
                System.out.println("Tolong masukan code bahasa");
            
            //penomoran kalimat
            int noKalimat = kalimat.getNoKalimat();
            
            for (String kata : kataDalamKalimat){
                Kata k = new Kata(kata.toLowerCase(), noKalimat);
                objectKataKotor.add(k);
            }
        }
        return objectKataKotor;
    }

    public static ArrayList<Kata> getObjectKataKotor() {
        return objectKataBersih;
    }

    public static ArrayList<Kata> getObjectKataBersih() {
        return objectKataKotor;
    }

    public static LinkedHashMap<Kata, Integer> getFreqMap() {
        return freqMap;
    }

    
    public ArrayList<Kata> removeStopWords(String language){
        List<String> stopWords = null;
        
        if(language.equals("ID"))
            stopWords = FileHandler.readFile("files/stopwords-id.txt");
        else
            System.err.println("Tolong masukan code bahasa");
        
        objectKataBersih = new ArrayList<>(Kata.getKataKotor());
        for (Kata kata : objectKataKotor){
            if(stopWords.contains(kata.getKataText())){
                objectKataBersih.remove(kata);
            }
        }
        return objectKataBersih;
    }
    
    public LinkedHashMap<Kata, Integer> doCount(ArrayList<Kata> list){
        int freq;
        Kata kataSaatIni;
        
        for (int i = 0; i < list.size(); i++){
            kataSaatIni = list.get(i);
            
            if(!freqMap.containsKey(kataSaatIni)){
                freq = Collections.frequency(list, kataSaatIni);
                freqMap.put(kataSaatIni, freq);
                kataSaatIni.setKejadianKata(freq);
            }
        }
        return freqMap;
    }

    public void TopKata (int nTopEntri){
        if(nTopEntri == 0 ){
            System.err.println("Tidak bisa 0.");
        return;
        }
        else if (nTopEntri > freqMap.size()){
            System.err.println("Nomor yang dimasukan lebih dari total baris");
            System.err.println("Membatalkan...");
            return;
        }

        Kata tempKata = null;
        List<Kata> keys = new ArrayList<>(freqMap.keySet());


        int counter = 0;
        while(counter!=nTopEntri){
            Kata maxKata = null;

            for (Kata kata : keys){
                if (tempKata == null || kata.compareTo(tempKata) > 0){
                    tempKata = kata;
                }
            }
            
            maxKata = tempKata;

            if(!cekKalimatSamaNo(maxKataList, maxKata)){
                maxKataList.add(maxKata);
                counter++;
            }

            keys.remove(maxKata);
            tempKata = null;
            maxKata = null;
        }
    }

    private boolean cekKalimatSamaNo(ArrayList<Kata> list, Kata k){
        if(k==null)
            return false;

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getMilikKalimatNo() == k.getMilikKalimatNo())
                return true;
        }
        return false;
    }

    public static ArrayList<Kata> getMaxKataList(){
        return maxKataList;
    }

  
}
