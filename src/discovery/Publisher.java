package discovery;

import java.io.IOException;

public class Publisher implements Constants {

  public static void main(String[] args) {
    MulticastPublisher mp = new MulticastPublisher();
    while(true) {
      try {
        System.out.println("Broadcasting the message '" + MESSAGE + "'...");
        mp.multicast(MESSAGE);
        Thread.sleep(1000);
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }
}
