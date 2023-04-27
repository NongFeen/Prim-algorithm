import java.util.Scanner;

public class Intro {
    private String input;
    Intro(){
        System.out.println("Please input the name of starting point");
        Scanner sc = new Scanner(System.in);
        this.input = sc.nextLine();
        sc.close();
    }
    @Override
    public String toString() {
        return input;
    }
}
