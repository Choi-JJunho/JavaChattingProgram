package ByteIOStream;

import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadFromFileEvent extends Frame implements ActionListener {
    Label lfile;
    TextField tfile;
    TextArea tadata;
    String filename;
    public ReadFromFileEvent(String str) {
        super(str);
        setLayout(new FlowLayout());
        lfile = new Label("input file name");
        add(lfile);
        tfile = new TextField(20);
        tfile.addActionListener(this);
        add(tfile);
        tadata = new TextArea(3, 35);
        add(tadata);
        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }

    public static void main(String args[]) {
        ReadFromFileEvent test = new ReadFromFileEvent("read file");
        test.setSize(270,160);
        test.show();
    }

    public void actionPerformed(ActionEvent ac) {
        byte buffer[] = new byte[100];
        filename = tfile.getText();
        try {
            FileInputStream fin = new FileInputStream(filename);
            fin.read(buffer);
            String data = new String(buffer);
            tadata.setText(data + "\n");
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}
