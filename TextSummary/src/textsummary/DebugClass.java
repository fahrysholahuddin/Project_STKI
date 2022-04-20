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
            System.out.println(KalimatObject.get(i));
        }

        System.out.println("\n---------Wordlist (kotor)---------");
        for (int i = 0; i < kataKotorObject.size(); i++) {
            System.out.println(i +" " + kataKotorObject.get(i));
            
        }

    }

    public static void printStats() {

        System.out.println("\n---------Stats---------");
        System.out.format("%-40s %d\n", "Number of Line: ", lines.size());
        System.out.format("%-40s %d\n", "Number of kalimat: ", KalimatObject.size());
        System.out.format("%-40s %d\n", "Number of word: ", kataKotorObject.size());
        
    }
}
