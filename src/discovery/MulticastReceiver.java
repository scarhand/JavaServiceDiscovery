package discovery;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class MulticastReceiver extends Thread implements Constants {
  protected MulticastSocket socket = null;
  protected byte[] buf = new byte[256];

  public InetAddress findService() {
    InetAddress result = null;
    try {
      socket = new MulticastSocket(PORT);
      InetAddress group = InetAddress.getByName(ADDRESS);
      socket.joinGroup(group);
      while (result == null) {
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        socket.receive(packet);
        String received = new String(packet.getData(), 0, packet.getLength());
        System.out.println("I GOT: " + received);
        System.out.println("FROM: " + packet.getAddress());
        if (MESSAGE.equals(received)) {
          result = packet.getAddress();
        }
      }
      socket.leaveGroup(group);
      socket.close();
    } catch (UnknownHostException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return result;
  }
}
