package FilterIOStream;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadSeqFile extends Frame implements ActionListener {
    private TextField account, name, balance;
    private Button next, done;
    private DataInputStream input;
    public ReadSeqFile() {
        super("고객파일 읽기");
        try {
            input = new DataInputStream(new FileInputStream("C:\\JunhoChoi\\gg.txt"));
        } catch (IOException e) {
            System.err.println(e.toString());
            System.exit(1);
        }
        setSize(250,130);
        setLayout(new GridLayout(4,2));
        add(new Label("account"));
        account = new TextField(20);
        add(account);

        add(new Label("name"));
        name = new TextField(20);
        add(name);

        add(new Label("balance"));
        balance = new TextField(20);
        add(balance);

        next = new Button("Output");
        next.addActionListener(this);
        add(next);

        done = new Button("Exit");
        done.addActionListener(this);
        add(done);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == next) readRecord();
        else closeFile();
    }

    public void readRecord() {
        int accountNo;
        double d;
        String namedata;
        try {
            accountNo = input.readInt();
            namedata = input.readUTF();
            d = input.readDouble();
            account.setText(String.valueOf(accountNo));
            name.setText(namedata);
            balance.setText(String.valueOf(d));
        } catch (EOFException eof) {
            closeFile();
        } catch (IOException io) {
            System.err.println(io.toString());
            System.exit(1);
        }
    }
    private void closeFile() {
        try {
            input.close();
            System.exit(0);
        } catch (IOException io) {
            System.err.println(io.toString());
            System.exit(1);
        }
    }
    public static void main(String args[]) {
        new ReadSeqFile();
    }
}
