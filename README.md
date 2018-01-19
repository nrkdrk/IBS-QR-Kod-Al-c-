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


```java
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
