package FilterIOStream;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CreateSeqFile extends Frame implements ActionListener {
    private TextField account, name, balance;
    private Button enter, done;
    private DataOutputStream output;
    public CreateSeqFile() {
        super("고객파일 생성");
        try {
            output = new DataOutputStream(new FileOutputStream("C:\\JunhoChoi\\gg.txt"));
        } catch (IOException e) {
            System.err.println(e.toString());
            System.exit(1);
        }
        setSize(250, 130);
        setLayout(new GridLayout(4,2));
        add(new Label("account"));
        account = new TextField();
        add(account);

        add(new Label("name"));
        name = new TextField(20);
        add(name);

        add(new Label("balance"));
        balance = new TextField(20);
        add(balance);

        enter = new Button("save");
        enter.addActionListener(this);
        add(enter);

        done = new Button("exit");
        done.addActionListener(this);
        add(done);

        setVisible(true);
    }
    public void addRecord() {
        int accountNo = 0;
        String d;
        if(!account.getText().equals("")) {
            try {
                accountNo = Integer.parseInt(account.getText());
                if(accountNo > 0) {
                    output.writeInt(accountNo);
                    output.writeUTF(name.getText());
                    d = balance.getText();
                    output.writeDouble(Double.valueOf(d));
                }
                account.setText("");
                name.setText("");
                balance.setText("");
            } catch (NumberFormatException e){
                System.err.println(e);
            } catch (IOException e) {
                System.err.println(e.toString());
                System.exit(1);
            }
        }
    }
    public void actionPerformed(ActionEvent e) {
        addRecord();
        if(e.getSource() == done) {
            try {
                output.close();
            } catch (IOException io) {
                System.err.println(io.toString());
            }
            System.exit(0);
        }
    }
    public static void main(String args[]) {
        new CreateSeqFile();
    }
}
