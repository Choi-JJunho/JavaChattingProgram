package CharacterIO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class WriteCharacterUTF8 {
    public static void main(String args[]) throws IOException {
        String text = "";
        Scanner sc = new Scanner(System.in);
        text = sc.nextLine();
        FileOutputStream fos = new FileOutputStream("example2.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
        osw.write(text, 0, text.length());
        osw.flush();
        osw.close();
    }
}
