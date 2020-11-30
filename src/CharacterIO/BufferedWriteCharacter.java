package CharacterIO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BufferedWriteCharacter {
    public static void main(String args[]) throws IOException {
        String text = "";
        Scanner sc = new Scanner(System.in);
        text = sc.nextLine();
        FileWriter fw = new FileWriter("example2_1.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write(text, 0, text.length());
        bw.flush();
        bw.close();
    }
}
