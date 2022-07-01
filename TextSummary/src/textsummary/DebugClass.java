package textsummary;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class DebugClass {
    private static List<String> lines = KalimatBuilder.getLines();
    private static ArrayList<Kalimat> KalimatObject = KalimatBuilder.getKalimatObject();
    private static ArrayList<Kata> kataKotorObject = KataBuilder.getObjectKataBersih();
    private static ArrayList<Kata> kataBersihObject = KataBuilder.getObjectKataKotor();
    private static LinkedHashMap<Kata, Integer> freqMap = KataBuilder.getFreqMap();
    private static ArrayList<Kata> maxKataList = KataBuilder.getMaxKataList();

    public static void printInfo() {
        System.out.println("---------Baris -Raw- dari file ---------");
        for (String line : lines){
            System.out.println(line);
        }

        System.out.println("\n---------Mapping Setiap Kalimat---------");
        for (int i = 0; i < KalimatObject.size(); i++) {
            System.out.format("No : %d Kalimat : %s \n",KalimatObject.get(i).getNoKalimat(),KalimatObject.get(i).getText());
        }

        System.out.println("\n---------Wordlist (kotor)---------");
        for (int i = 0; i < kataKotorObject.size(); i++) {
            System.out.println(i +" " + kataKotorObject.get(i));
            
        }

    }

    public static void printStats() {

        System.out.println("\n---------Stats---------");
        System.out.format("%-40s %d\n", "Jumlah Line: ", lines.size());
        System.out.format("%-40s %d\n", "Jumlah kalimat: ", KalimatObject.size());
        System.out.format("%-40s %d\n", "Jumlah word: ", kataKotorObject.size());
        System.out.format("%-40s %d\n", "Jumlah stop-word removed: ", kataKotorObject.size()-kataBersihObject.size());
        System.out.format("%-40s %d\n", "Jumlah Kata tanpa Stop-Word: ", kataBersihObject.size());
    }

    public ArrayList<Integer> getStats(){
        ArrayList<Integer> stats = new ArrayList<Integer>();
        
        stats.add(lines.size());
        stats.add(KalimatObject.size());
        stats.add(kataKotorObject.size());
        stats.add(kataKotorObject.size()-kataBersihObject.size());
        stats.add(kataBersihObject.size());
        stats.add(freqMap.size());
        return stats;

    }

    public static void printFreqMap() {
        System.out.println("\n----------Jumlah Kejadian setiap Kata dan angka-----------");

        Set<Kata> keySet = freqMap.keySet();
        Kata[] kataUnik = keySet.toArray(new Kata[keySet.size()]);
        for (Kata string : kataUnik){
            int frequency = freqMap.get(string);
            System.out.printf("Kata: %-25s Kejadian %-10d ...di kalimat ke %d\n", string.getKataText(), frequency, string.getMilikKalimatNo());
            
        }
        System.out.println("Size of keyset is " + keySet.size());
    }

    public static void printTopWords(){
        System.out.println("\n------------------Top word------------------");
        for (int i = 0; i < maxKataList.size(); i++) {
            System.out.format("'%s' merupakan Top word dengan %5d kejadian. terdapat pada kalimat %d.\n", maxKataList.get(i).getKataText(), maxKataList.get(i).getKataKejadian(), maxKataList.get(i).getMilikKalimatNo());
           
        }
    }
}
