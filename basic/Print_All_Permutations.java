package basic;

public class Print_All_Permutations {
    public static void process(char[] chs, int i,String res) {
        if(i == chs.length){
            System.out.println(res);
            return;
        }
        process(chs, i+1, res);
        process(chs, i+1, res+String.valueOf(chs[i]));
    }
    public static void main(String[] args) {
        String test = "abc";
        process(test.toCharArray(), 0, "");
    }
}
