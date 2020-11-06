package FilterIOStream;

import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteCharString {
    static DataOutputStream dos;
    public static void main(String args[]) {
        try {
            String data;
            FileOutputStream fout = new FileOutputStream("C:\\JunhoChoi\\gg.txt");
            dos = new DataOutputStream(fout);
            dos.writeChar(65);
            dos.writeUTF("안녕하세요");
            dos.writeUTF("자바 채팅~");
        } catch (EOFException e) {
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            try {
                if(dos != null) dos.close();
                if(dos != null) dos.close();
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
}
