package basic;

import java.util.Arrays;
import java.util.Comparator;

public class LowestLexicography {

    public static class MyComparator implements Comparator<String>{
        @Override
        public int compare(String o1, String o2) {
            return (o1+o2).compareTo(o2+o1);
        }
    }
    public static String lowestString(String[] strs){
        if(strs.length == 0 || strs == null)
            return null;
        Arrays.sort(strs,new MyComparator());
        String res = "";
        for(int i=0;i<strs.length;i++){
            res+= strs[i];
        }
        return res;
    }
    public static void main(String[] args) {
        String[] strs1 = { "jibw", "ji", "jp", "bw", "jis" };
        System.out.println(lowestString(strs1));

        String[] strs2 = { "ba", "b" };
        System.out.println(lowestString(strs2));

    }
}
