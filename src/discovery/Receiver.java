package discovery;

import java.net.InetAddress;

public class Receiver {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    MulticastReceiver mr = new MulticastReceiver();
    InetAddress address = mr.findService();
    System.out.println("I have found the service on: " + address);
  }

}
