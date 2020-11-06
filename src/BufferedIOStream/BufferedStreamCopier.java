package BufferedIOStream;

import java.io.*;

public class BufferedStreamCopier {
    public static void main(String args[]) {
        try {
            copy(System.in, System.out);
        } catch(IOException e) {
            System.err.println(e);
        }
    }
    public static void copy(InputStream in, OutputStream out) throws IOException {
        synchronized (in) {
            synchronized (out) {
                BufferedInputStream bin = new BufferedInputStream(in);
                BufferedOutputStream bout = new BufferedOutputStream(out);
                while(true) {
                    // 버퍼에 있는 데이터를 읽음
                    int data = bin.read();
                    // ctrl + z 가 -1을 반환함.
                    if(data == -1) break;
                    bout.write(data);
                }
                // 버퍼에 있는 모든 데이터를 스트림으로 전송
                bout.flush();
            }
        }
    }
}
