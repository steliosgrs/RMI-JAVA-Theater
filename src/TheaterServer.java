import java.rmi.Naming;
import java.rmi.server.*;


public class TheaterServer {

   public TheaterServer() {

       try {
           TheaterImpl Server = new TheaterImpl();
           Registry reg = LocateRegistry.createRegistry(52369);
           String url = "rmi://" + InteAddress.getLocalHost().getHostAddress + ":52369/Hello";
           Naming.rebind(url, Server);

       } catch (Exception e) {
           System.out.println("Error: " + e);
       }

   }

   public static void main(String[] args) {
       new TheaterServer();
   }
}
