package fahrzeugHersteller;
import cdZulieferer.*;
import usbZulieferer.USBDevice;
import zuliefererInterface.Device;


public class Integrator {


  public static void main(String[] args) {
    Device[] installedDevices = new Device[3];
    installedDevices[0] = new USBDevice();
    installedDevices[1] = new CDKlasse();
    installedDevices[2] = new CDPlayer();

    new Bordcomputer(installedDevices);
  }




}
