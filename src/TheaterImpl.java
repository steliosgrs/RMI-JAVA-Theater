import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//The Remote Object Class, implements the server interface
public class TheaterImpl extends UnicastRemoteObject implements TheaterServer{

    String res = "Empty";
    Theater theater = new Theater();
    private List<Client> Clients = new ArrayList<>();

    public TheaterImpl() throws RemoteException {

    }
    // For cancel
    // private final List<Theater> seatA = new ArrayList<>();
    // private final List<Theater> seatB = new ArrayList<>();
    // private final List<Theater> seatC = new ArrayList<>();
    // private final List<Theater> seatD = new ArrayList<>();
    // private final List<Theater> seatE = new ArrayList<>();


    public StringBuilder list() throws RemoteException{
        StringBuilder available_seats = new StringBuilder();
        available_seats.append(theater.seats[0]).append(" θέσεις Πλατεία - Ζώνη Α (κωδικός: ΠΑ) - τιμή: ").append(theater.cost[0]).append(" Ευρώ");
        available_seats.append(theater.seats[1]).append(" θέσεις Πλατεία - Ζώνη Β (κωδικός: ΠΒ) - τιμή: ").append(theater.cost[1]).append(" Ευρώ");
        available_seats.append(theater.seats[2]).append(" θέσεις Πλατεία - Ζώνη Γ (κωδικός: ΠΓ) - τιμή: ").append(theater.cost[2]).append(" Ευρώ");
        available_seats.append(theater.seats[3]).append(" θέσεις Κεντρικός Εξώστης (κωδικός: ΚΕ) - τιμή: ").append(theater.cost[3]).append(" Ευρώ");
        available_seats.append(theater.seats[4]).append(" θέσεις Πλαϊνά Θεωρεία (κωδικός: ΠΘ) - τιμή: ").append(theater.cost[4]).append(" Ευρώ");
        return available_seats;
    }



    public StringBuilder book(String[] args) throws RemoteException{

        String Type = args[2];                       // Τύπος θέσεων
        int Number = Integer.parseInt(args[3]);     // Αριθμός θέσεων
        String Name = args[4];                       // Ονοματεπώνυμο
        int TotalPrice =0;                          // Συνολικό ποσό
        StringBuilder book_seats = new StringBuilder();
        if (theater.if_available(Type,Number)) {
            TotalPrice = Number * theater.getCost(Type);
            Client current_client = new Client (Type,Number,Name,TotalPrice);
            Clients.add(current_client);
            book_seats.append("Ο πελάτης").append(Name).append("για ").append(Number).append("θέσεις").append(Type).append("και οφείλει ").append(TotalPrice);
        }else {
            System.out.println("Δεν υπάρχουν τόσες θέσεις");
        }
        return book_seats;
    }


    public String guests() throws RemoteException{
        if (res=="Empty") {
            res = "Δεν βρέθηκαν πελάτες";

        } else {
            System.out.println("Λίστα Πελατών");
            for (Client x : Clients) {
                res = "Ο πελάτης " + x.name + "έχει κάνει κράτηση για" + x.number + "θέσεις τύπου" +x.type +"με κόστος" +x.ticket_price+"\n";
            }
        }
        return res;
    }

/*

    public String cancel() throws RemoteException{
        String Type = args[2]                       // Τύπος θέσεων
        int Number = Integer.parseInt(args[3]);     // Αριθμός θέσεων
        String Name = args[4]                       // Ονοματεπώνυμο
        int TotalPrice =0;                          // Συνολικό ποσό

        for (Client y : Clients ) {

        }
        return res;
    }*/

}
