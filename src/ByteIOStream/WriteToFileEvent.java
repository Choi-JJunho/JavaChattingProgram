package ByteIOStream;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteToFileEvent extends Frame implements ActionListener {
    Label lfile, ldata;
    TextField tfile, tdata;
    Button save;
    String filename, data;
    byte buffer[] = new byte[80];

    public WriteToFileEvent(String str) {
        super(str);
        setLayout(new FlowLayout());
        lfile = new Label("insert file name");
        add(lfile);
        tfile = new TextField(20);
        add(tfile);
        ldata = new Label("insert data");
        add(ldata);
        tdata = new TextField(20);
        add(tdata);

        Button save = new Button("save");
        save.addActionListener(this);
        add(save);
        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
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
        WriteToFileEvent text = new WriteToFileEvent("save File");
        text.setSize(270, 150);
        text.show();
    }

    public void actionPerformed(ActionEvent ae) {
        filename = tfile.getText();
        data = tdata.getText();
        buffer = data.getBytes();
        try {
            // 해당 클래스는 Byte 단위로 데이터를 전송하기 때문에 tdata 필드에 저장된 문자를 getBytes()로 byte 데이터로 변환하여 전송
            FileOutputStream fout = new FileOutputStream(filename);
            fout.write(buffer);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

}
