package CharacterIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadByLine {
    public static void main(String args[]) {
        String text = "";
        Scanner sc = new Scanner(System.in);
        text = sc.nextLine();
        String data;
        try {
            FileReader fr = new FileReader(text);
            BufferedReader br = new BufferedReader(fr);
            while ((data = br.readLine()) != null) {
                System.out.println(data);
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
