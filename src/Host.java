import java.io.DataInputStream;
import java.io.PrintStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Host {
    //HostCreate will create a host through given port
    //Host will accept any incoming client and open a new thread for them
    //Any input from one client will be broadcast to all
    public void HostCreate(int Port) throws  java.io.IOException{
        ServerSocket Host;
        Socket client;
        DataInputStream input;
        PrintStream output;
        String temp;
        Host = new ServerSocket(Port);
        int i =1;


        client = Host.accept();
        input = new DataInputStream(client.getInputStream());
        output = new PrintStream(client.getOutputStream());

        while (true){
            temp = input.readUTF();
            output.println("Server: "+ temp);

        }

    }


}
