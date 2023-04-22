import java.util.Scanner;

public class PrimMain{
    static String[] wayList = {"Minneapolis,Chicago,355",
        "Minneapolis,Nashville,695",
        "Chicago,St. Louis,262",
        "Chicago,Milwaukee,74",
        "Chicago,Louisville,269",
        "St. Louis,Louisville,242",
        "Milwaukee,Louisville,348",
        "Nashville,Louisville,151",
        "Louisville,Cincinnati,83",
        "Louisville,Detroit,306",
        "Cincinnati,Detroit,230"};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        SpanningTrees spTree = new SpanningTrees(wayList);
        spTree.findMinSpanTree(input);
        sc.close();
    }
      
}
