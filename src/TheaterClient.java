import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class TheaterClient extends UnicastRemoteObject {

    protected TheaterClient() throws RemoteException{
        
    }

    public static void main(String[] args) {
        try{
            // Create the Remote Object
            String url = "rmi://" + InteAddress.getLocalHost().getHostAddress + ":52369/Hello";
            // Binding the remote object (stub) in our own registry
            Remote remote_obj = Naming.lookup(url);
            TheaterInterface remote_server = (TheaterInterface)remote_obj;

            System.out.println("Εφαρμογή Εισιτηρίων Θεάτρου");
            if (args.length == 1) {
                Options();
            } else {
                switch (args[1]) {
                    case "list":
                        if (args.leangth == 2) {
                            System.out.println(remote_server.list());
                        } else {
                            System.out.println("Λάθος ορίσματα");
                            System.exit(1);
                        }
                        break;
                    case "book":
                        if (args.length == 5) {
                            Server.book(args);
                        } else {
                            System.out.println("Λάθος ορίσματα");
                            System.exit(1);
                        }
                        break;
                    case "guests":
                        if (args.leangth == 2) {
                            System.out.println(remote_server.guests());
                        } else {
                            System.out.println("Λάθος ορίσματα");
                            System.exit(1);
                        }
                        break;
                    case "cancel":
                        if (args.length == 5) {
                            System.out.println(remote_server.cancel(args));
                        } else {
                            System.out.println("Λάθος ορίσματα");
                            System.exit(1);
                        }
                        break;
                    default:
                        System.out.println("Λάθος ορίσματα");
                        System.exit(1);
                }
            }

        } catch (Exception e) {
            System.out.println("Remote Error" +e);
        }

    }

    public static void Options(){
        System.out.println("~~~\tΕπιλογές\t~~~")
        System.out.println("1. Για διαθέσιμες θέσεις: TheaterClient list <hostname> ")
        System.out.println("2. Για κράτηση θέσεων: TheaterClient book <hostname> <type> <number> <name>")
        System.out.println("3. Για όσους έχουν κάνει κράτηση: TheaterClient guests <hostname>")
        System.out.println("4. Για ακύρωση θέσεων: TheaterClient cancel <hostname> <type> <number> <name>")
    }

}
