package CharacterIO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopy {
    public static void main(String args[]) throws IOException {
        int numberRead;
        char[] buffer = new char[80];
        FileWriter fw = new FileWriter("example_1_1.txt");
        FileReader fr = new FileReader("example_1.txt");
        while((numberRead = fr.read(buffer)) > -1) {
            fw.write(buffer, 0, numberRead);
        }
        fw.close();
        fr.close();
    }
}
