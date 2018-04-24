import java.io.DataInputStream;
import java.io.PrintStream;

//This Class stores the output of all clients, allowing easy broadcasting to all
public class ClientCatalogue {
    int maxclients=10;
    PrintStream[] catalogue = new PrintStream[maxclients];
    String[] Usernames = new String[maxclients];

   // ClientCatalogue(int max){
    //    maxclients=max;
    //    for(int i=1;i<maxclients;i++){
    //        catalogue[i]=null;
     //       Usernames[i]=null;
     //   }
    //}

    public  void AddClient(PrintStream address, String Name){
        synchronized (this) {
            for (int i = 1; i < maxclients; i++) {
                if (catalogue[i] == null) {
                    catalogue[i] = address;
                    Usernames[i] = Name;
                    return;
                }
            }
        }

    }
    public void DeleteClient(PrintStream address, String Name){
        synchronized (this){
            for (int i = 1; i < maxclients; i++) {
                if (catalogue[i] == address) {
                    catalogue[i] = null;
                    Usernames[i] = null;
                    return;
                }
            }
            System.out.println("Error on deleting user "+ Name +" on exit");

        }


    }
    public PrintStream[] GetClients(){
        return catalogue;
    }

}
