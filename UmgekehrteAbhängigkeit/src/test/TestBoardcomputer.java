package test;
import cdZulieferer.CDZuliefererInit;
import fahrzeugHersteller.Bordcomputer;
import fahrzeugHersteller.DeviceFactory;
import usbZulieferer.USBZuliefererInit;

public class TestBoardcomputer {

    public static void main(String[] args) throws ClassNotFoundException {
      DeviceFactory[] dF = new DeviceFactory[2];

      dF[0] = new CDZuliefererInit();
      dF[1] = new USBZuliefererInit();
      Bordcomputer b = new Bordcomputer(dF);

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
