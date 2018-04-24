import java.io.DataInputStream;
import java.io.PrintStream;
import java.net.Socket;

public class ClientHandler extends Thread {
    DataInputStream input;
    PrintStream output;
    String Username;
    ClientCatalogue index;
    ClientHandler(DataInputStream input, PrintStream output){
        this.input=input;
        this.output=output;
    }
    ClientHandler(Socket Client) throws java.io.IOException{
        input = new DataInputStream(Client.getInputStream());
        output= new PrintStream(Client.getOutputStream());
    }
    ClientHandler(Socket Client, ClientCatalogue index) throws java.io.IOException{
        input = new DataInputStream(Client.getInputStream());
        output= new PrintStream(Client.getOutputStream());
        this.index=index;
    }
    public void linkCatalogue(ClientCatalogue index){
        synchronized (this) {
            this.index = index;
        }
    }
    public void run(){
        //The creation of the thread, first gets a username for the Client, then sends it to read
        System.out.println("Client Stream created"); //Confirm thread created
        output.println("Welcome! Enter desired Username:");
        Username="Anonymous";
        //try to take input and overwrite username
        try {
            Username = input.readLine();
        }
        catch (java.io.IOException e){
            System.out.println(e);
        }
        //send to read
        System.out.println("User has chosen name: "+ Username);

        index.AddClient(output, Username);

        try{
            read();
        }
        catch (java.io.IOException e){
            System.out.println(e);
        }
    }
    public void  read() throws java.io.IOException{
        //This is meant to be the dedicated read for the client
        //In a loop read input from client, then send the message to broadcast
        //Additionally if client input matches a command, it will be read and redirected from here
        String temp=null;
        String endmark=null;
        System.out.println("Reading from User: "+ Username);
        while (true){

            temp = input.readLine();
            System.out.println(Username+" :"+temp);
            //output.println(Username+": "+ temp);
            if(temp.equals("EXIT")||temp.equals("Exit")||temp.equals("exit")){quit();break;}
            broadcast(temp);

        }

    }

    public void  broadcast(String temp){
        //takes the input from read and sends to all clients
        synchronized (this) {
            PrintStream[] catalogue = index.catalogue;
            for (int i = 1; i < index.maxclients; i++) {
                if (catalogue[i] != null) {
                    catalogue[i].println(Username + ": " + temp );
                }
            }
        }
    }
    public void quit(){

        output.println("Server: Exit");

    }
}
