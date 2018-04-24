import java.io.DataInputStream;
import java.io.PrintStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client{
    //ClientConnect is meant to be run with the input of the ip and port of the host
    //ClientConnect will open a stream, and create a new thread to accept any an all input from the host
    public void ClientConnect(String ip, int Port) throws java.io.IOException{
        Socket Client;
        Scanner reader = new Scanner(System.in);

        Client = new Socket(ip, Port);
        if(Client==null){
            System.out.println("Error: No Host detected");
            return;
        }
        DataInputStream input;
        PrintStream output;
        String temp;

        input = new DataInputStream(Client.getInputStream());
        output = new PrintStream(Client.getOutputStream());

        if(input==null||output==null){
            System.out.println("Input/Output Error");
            return;
        }
        System.out.println("Connection Established...");

        //Insert "Type desired username, have host head and store it
        System.out.println(input.readLine());
        temp = reader.nextLine();


        Thread read = new ChatThread(input);
        read.start();


        while(read.isAlive()){

        output.println(temp);

        //temp = input.readLine();
        //System.out.println(temp);
        temp = reader.nextLine();



         }

    }

}
