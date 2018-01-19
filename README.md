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
