package CharacterIO;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteCharacter {
    public static void main(String args[]) throws IOException {
        String text = "";
        Scanner sc = new Scanner(System.in);
        text = sc.nextLine();
        FileWriter fw = new FileWriter("example_1.txt");
        fw.write(text,0,text.length());
        fw.flush();
        fw.close();
    }
}
