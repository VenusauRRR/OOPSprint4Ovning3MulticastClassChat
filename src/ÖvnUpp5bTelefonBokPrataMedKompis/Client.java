package ÖvnUpp5bTelefonBokPrataMedKompis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    Client(){
        try (Socket sock = new Socket("127.0.0.1", 22222);
             BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
             PrintWriter out = new PrintWriter(sock.getOutputStream(),true)
        ) {
            String fromServer;
            String toServer;
            Scanner sc = new Scanner(System.in);
           while (true){
               if ((fromServer = br.readLine()) != null){
                   System.out.println(fromServer);
               }
//               if ((toServer = sc.nextLine()) != null){
//                   out.println(toServer);
//               }
           }
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static void main(String[] args) {
        Client c = new Client();
    }
}
