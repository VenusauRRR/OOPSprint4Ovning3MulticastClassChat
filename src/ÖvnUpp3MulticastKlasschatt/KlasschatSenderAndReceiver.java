package ÖvnUpp3MulticastKlasschatt;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.*;

public class KlasschatSenderAndReceiver extends JFrame{

    static String name;
    JPanel panel = new JPanel();
    JButton disconnect = new JButton("Disconnect");
    static JTextArea displayarea = new JTextArea(20,20);
    JTextField textingarea = new JTextField(30);

    KlasschatSenderAndReceiver(String name){
        this.name = name;
        setTitle("ClassChat: " + getName());
        setLayout(new BorderLayout());
        add(disconnect,BorderLayout.NORTH);
        add(displayarea,BorderLayout.CENTER);
        add(textingarea,BorderLayout.SOUTH);
        displayarea.setEditable(false);

        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        sendNetworkSetup(getName() + ": CONNECTED");

        disconnect.addActionListener(e -> {
            sendNetworkSetup(getName() + ": DISCONNECTED");
            System.exit(0);
        });

        textingarea.addActionListener(e -> {
            sendNetworkSetup(getName() + ": " + textingarea.getText());
            textingarea.setText("");
        });

        KlasschatReceiver();
    }

    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog("What is your name?");
        KlasschatSenderAndReceiver ks = new KlasschatSenderAndReceiver(name);
    }

    public void sendNetworkSetup(String sendMsg){
        try {
            InetAddress ip = InetAddress.getByName("233.233.233.233");
            int toPort = 23333;
            MulticastSocket msocket = new MulticastSocket(toPort);

            byte[] toByte = sendMsg.getBytes();

            DatagramPacket dp = new DatagramPacket(toByte,toByte.length,ip,toPort);
            msocket.send(dp);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    public void KlasschatReceiver(){
        try {
            InetAddress ip = InetAddress.getByName("233.233.233.233");
            int recPort = 23333;
            MulticastSocket msocket = new MulticastSocket(recPort);

            InetSocketAddress group = new InetSocketAddress(ip,recPort);
            NetworkInterface netIf = NetworkInterface.getByName("wireless_32768");
            msocket.joinGroup(group,netIf);

            while (true){
                byte[] getByte = new byte[265];
                DatagramPacket dp = new DatagramPacket(getByte,0,getByte.length);
                msocket.receive(dp);
                String s = new String(dp.getData(),0,dp.getLength());
                displayarea.append(s + "\n");
            }
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getName() {
        return name;
    }
}
