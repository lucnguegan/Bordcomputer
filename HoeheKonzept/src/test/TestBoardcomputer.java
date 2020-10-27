package test;
import fahrzeugHersteller.Bordcomputer;

public class TestBoardcomputer {

    public static void main(String[] args) throws ClassNotFoundException {
      Bordcomputer b = new Bordcomputer();

      // play forwards and backwards on actual device
      b.play();
      b.next();
      b.play();
      b.next();
      b.play();
      b.prev();
      b.play();

      // moving to next device
      b.changeDevice();
      b.play();
      b.changeDevice();
      b.play();

      // testing volume
      b.showVolume();
      b.louder(3);
      b.showVolume();
      b.quieter(2);
      b.showVolume();

      // testing options
      b.showOptions();
      b.enterOption(2);



  }
}
