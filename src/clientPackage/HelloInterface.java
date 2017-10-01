package clientPackage;

/**
 * Created by Benjamin on 10/1/2017.
 */
import java.rmi.*;
public interface HelloInterface extends Remote {
    public String response(String name) throws java.rmi.RemoteException;
}
