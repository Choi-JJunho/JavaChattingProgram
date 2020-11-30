package File;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileTest extends Frame implements ActionListener {
    private TextField enter;
    private TextArea output;

    public FileTest() {
        super("File Class Test");
        enter = new TextField("Enter the File name Or Directory name");
        enter.addActionListener(this);
        output = new TextArea();
        add(enter, BorderLayout.NORTH);
        add(output, BorderLayout.CENTER);
        addWindowListener(new WinListener());
        setSize(400, 400);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        File name = new File(e.getActionCommand());
        if (name.exists()) {
            output.setText(name.getName() + "is Exist\n" +
                    (name.isFile() ? "파일이다.\n" : "파일이 아니다.\n") +
                    (name.isDirectory() ? "디렉토리다.\n" : "디렉토리가 아니다.\n") +
                    (name.isAbsolute() ? "절대경로다.\n" : "절대경로가 아니다.\n") +
                    "마지막 수정날짜 : " + name.lastModified() +
                    "\n 파일 길이 : " + name.length() +
                    "\n 파일 경로 : " + name.getPath() +
                    "\n 절대경로 : " + name.getAbsolutePath() +
                    "\n 상위 디렉토리 : " + name.getParent()
            );

            if (name.isFile()) {
                try {
                    RandomAccessFile r = new RandomAccessFile(name, "r");
                    StringBuffer buf = new StringBuffer();
                    String text;
                    output.append("\n\n");
                    while ((text = r.readLine()) != null)
                        buf.append(text + "\n");
                    output.append(buf.toString());
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            } else if (name.isDirectory()) {
                String directory[] = name.list();
                output.append("\n\n디렉토리 내용 : \n");
                for (int i = 0; i < directory.length; i++)
                    output.append(directory[i] + "\n");
            }
        } else {
            output.setText(e.getActionCommand() + "은 존재하지 않는다.\n");
        }
    }

    public static void main(String args[]) {
        FileTest f = new FileTest();
    }

    class WinListener extends WindowAdapter {
        public void windowClosing(WindowEvent we) {
            System.exit(0);
        }
    }
}
