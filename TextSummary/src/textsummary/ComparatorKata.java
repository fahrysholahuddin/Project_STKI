package textsummary;

import java.util.Comparator;

public class ComparatorKata implements Comparator<Kata>{
    public int compare(Kata w1, Kata w2){
        if(w1.getMilikKalimatNo() < w2.getMilikKalimatNo())
            return -1;
        else if(w1.getMilikKalimatNo() > w2.getMilikKalimatNo())
            return 1;
        return 0;
    }
}