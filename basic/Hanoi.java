package basic;

public class Hanoi {

    public static void hanoi(int n) {
        if (n > 0) {
            func(n, n, "left", "mid", "right");
        }
    }
    public static void func(int rest, int down, String from, String help, String to){
        if (rest == 1) {
            System.out.println("move " + down + " from " + from + " to " + to);
        } else {
            func(rest - 1, down - 1, from, to, help);
            func(1, down, from, help, to);
            func(rest - 1, down - 1, help, from, to);
        }
    }
    public static void process(int N, String from ,String to, String help){
        if(N==1){
            System.out.println("Move 1 from "+from + " to "+to);
        }
        else{
            process(N-1,from,help,to);
            System.out.println("Move "+N+" from "+from + " to "+to);
            process(N-1,help,to,from);
        }

    }
    public static void main(String[] args) {
        int n = 3;
//        hanoi(n);
        process(n, "左", "中", "右");
    }

}
