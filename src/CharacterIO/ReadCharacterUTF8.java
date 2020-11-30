package CharacterIO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadCharacterUTF8 {
    public static void main(String args[]) throws IOException {
        int byteRead;
        char[] buffer = new char[128];
        FileInputStream fis = new FileInputStream("example2.txt");
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        while((byteRead = isr.read(buffer)) != -1) {
            System.out.println(buffer);
        }
    }
}
