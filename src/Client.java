import java.io.DataInputStream;
import java.io.PrintStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client{
    //ClientConnect is meant to be run with the input of the ip and port of the host
    //ClientConnect will open a stream, and create a new thread to accept any an all input from the host
    public void ClientConnect(String ip, int Port) throws java.io.IOException{
        Socket Client;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

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
        temp = reader.readLine();
        while(temp!=null){
            output.println(temp);
            temp = input.readUTF();
            System.out.println(temp);
            temp = reader.readLine();


        }



    }
}
