# IBS-QR Kod Alıcı
![N|Solid](https://github.com/nrkdrk/IBS-QR-Kod-Al-c-/blob/master/image/nrkdrk.jpg)


IBS-QR Kod Alıcı
Mobil de geliştirilmiş olan IBS- QR Kod okuyucu ile soket programlama ile haberleşerek qr kod değerini ağ üzerinden bu uygulamaya göndermektedir.

# IBS-QR Kod Alıcı
Burada cihazın local ip'sini otomatik olarak alıyoruz.Bazı durumlarda portun kullanılma durumuna karşın port numarasını isteğe göre belirleyebilirsiniz. Ancak belirlediğiniz port numarasını mobil uygulamada ayarlar kısmından da değiştirerek aynı port'a yönlendirmeniz gerekmektedir.

![alt text](https://github.com/nrkdrk/IBS-QR-Kod-Al-c-/blob/master/image/%C4%B1bs-qr-kod-al%C4%B1c%C4%B1.PNG)

# IBS-QR Kod Okuyucu
https://github.com/nrkdrk/IBS-QR-Kod-Okuyucu
mobil uygulaması ile aşağıda ki qr kodu okuttuk ve menüden pc'ye aktar dedik.
Ardından qr koddaki değerimiz uygulamamıza gönderildi.


![alt text](https://github.com/nrkdrk/IBS-QR-Kod-Al-c-/blob/master/image/%C4%B1bs-qr-kod-al%C4%B1c%C4%B1%20kod%20ald%C4%B1.PNG)


# IBS-QR Kod Okuyucu IBSQRKodAlıcı Sınıfı
```java
/*24-11-2017*/
/*NrkDrk  Berk Can www.nrkdrk.com*/
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
     // aşağıda ayrıca metotlar anlatılacaktır
    }

    public static void main(String[] args) throws UnknownHostException {
        // aşağıda ayrıca metotlar anlatılacaktır
    }
}
```

# IBSQRKodAlıcı Sınıfı IBSQRKodAlıcı Metodu(Contract Method)

Bu metotda görsel ayarlamalarımızı bazı sistem ayarlarını yaptık

```java
/*24-11-2017*/
/*NrkDrk  Berk Can www.nrkdrk.com*/
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
```

# IBSQRKodAlıcı Sınıfı main Metodu(Main Method)

Bu metotda Sistemi başlattık ve sistem ayarlarını yaptık gelen qr değerini de ekrana yazdık

```java
/*24-11-2017*/
/*NrkDrk  Berk Can www.nrkdrk.com*/
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
```
