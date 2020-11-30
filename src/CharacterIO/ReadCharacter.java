package CharacterIO;

import java.io.FileReader;
import java.io.IOException;

public class ReadCharacter {
    public static void main(String args[]) throws IOException{
        int numberRead;
        String data;
        char[] buffer = new char[80];
        FileReader fr = new FileReader("example_1.txt");
        while((numberRead = fr.read(buffer)) > -1) {
            System.out.println(buffer);
        }
        fr.close();
    }
}
