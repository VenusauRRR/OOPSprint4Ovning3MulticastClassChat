package ÖvnUpp5bTelefonBokPrataMedKompis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    Server(){
        try (ServerSocket ss = new ServerSocket(22222);
             Socket sock = ss.accept();
             BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
             PrintWriter out = new PrintWriter(sock.getOutputStream(),true)
        ) {
            DAO database = new DAO();
            String temp;
            String contact;
            out.println("Enter a contact name");
            while (true){
                if ((temp = in.readLine()) != null){
                    contact = database.getKompis(temp);
                    if (contact != null){
                        out.println("Contact information:\n" + contact);
                    } else {
                        out.println("No such contact. \nTry again");

                    }
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        Server s = new Server();
    }
}
