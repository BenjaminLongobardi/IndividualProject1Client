package clientPackage;
/*
public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}
*/
import java.io.*;
import java.net.*;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.Scanner;

public class Main{
    public static void main(String args[])throws IOException {
        Scanner keyboard = new Scanner(System.in);
        try{
            int port = 16790;
            String host = "localhost";
            String registryURL = "rmi://" + host + ":" + port + "/hello";
            HelloInterface h = (HelloInterface)Naming.lookup(registryURL);
            System.out.println("Lookup completed " );
            System.out.println("Hello Server: ");
            System.out.println("Enter a message for the server, or type bye to quit");
            String clientMessage = keyboard.nextLine();

            while(!clientMessage.equals("bye")){
                String message = h.response(clientMessage);
                System.out.println("Server: "+message);
                System.out.println("Enter a message for the server, or type bye to quit");
                clientMessage = keyboard.nextLine();
            }
            String message = h.response(clientMessage);
            System.out.println(message);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
