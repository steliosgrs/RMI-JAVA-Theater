import java.rmi.RemoteException;
import java.rmi.Remote;

public interface TheaterInterface extends Remote{

    StringBuilder list() throws RemoteException;
    String book(String[] args) throws RemoteException;
    String guests() throws RemoteException;
    //String cancel(String[] args) throws RemoteException;

}
