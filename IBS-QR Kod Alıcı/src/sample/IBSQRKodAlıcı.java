package sample;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * Created by Berk Can on 24.10.2017.
 */

public class IBSQRKodAlıcı extends JFrame {

    private static ServerSocket serverSocket;
    private static Socket socket;
    private static BufferedReader bufferedReader;
    private static InputStreamReader ınputStreamReader;
    private static String data="",ipAdress;
    private static int portNumber;
    private static JTextField portNumberTextField;
    private static JLabel jLabel,jLabel1,jLabel2;
    private static JTextField getPortNumberTextField;
    private static JTextArea jTextArea;
    private static JScrollPane jScrollPane;

    public IBSQRKodAlıcı(){
        this.setTitle("IBS-QR Kod Alıcı");
        this.setSize(350 , 420);
        this.setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jLabel = new JLabel("Port Numaranız");
        jLabel2 = new JLabel("Ip Adresiniz: "+ipAdress);
        getPortNumberTextField = new JTextField("7844");
        jLabel1 = new JLabel("");
        jTextArea=new JTextArea(5,1);
        jScrollPane=new JScrollPane(jTextArea);
        this.add(jLabel);     // veya this.getContentPane().add(buton1);
        this.add(jLabel1);     // veya this.getContentPane().add(buton1);
        this.add(jLabel2);     // veya this.getContentPane().add(buton1);
        this.add(getPortNumberTextField);     // veya this.getContentPane().add(buton1);
        this.add(jScrollPane);     // veya this.getContentPane().add(buton1);
        jLabel.setBounds(10,20,100,40);
        jLabel2.setBounds(10,0,200,40);
        jLabel1.setBounds(10,40,400,40);
        getPortNumberTextField.setBounds(100,30,100,20);
        jScrollPane.setBounds(10,60,318,300);
        portNumber=Integer.parseInt(getPortNumberTextField.getText().toString());

    }

    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        String adres=address.toString();
        String[] adresArray = adres.split("/");
        int countryLineCount = adresArray.length;
        for(int i=1; i< countryLineCount; i++) {
            System.out.println("Yerel IP Adres : "+ adresArray[i]);
            ipAdress=adresArray[i];
        }
        new IBSQRKodAlıcı();
        try {
            System.out.println("server port aktif, port:"+portNumber);
            while (true){
                serverSocket=new ServerSocket(portNumber);
                socket=serverSocket.accept();
                ınputStreamReader=new InputStreamReader(socket.getInputStream());
                bufferedReader=new BufferedReader(ınputStreamReader);
                data=bufferedReader.readLine();
                if(data!=null){
                    System.out.println(data);
                    jTextArea.setLineWrap(true);
                    jTextArea.setWrapStyleWord(true);
                    jTextArea.setText(data);
                    //jLabel1.setText("Verileriniz Aktarıldı.Şimdi hangi formatta kaydedelim?");
                }
                ınputStreamReader.close();
                bufferedReader.close();
                serverSocket.close();
                socket.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
