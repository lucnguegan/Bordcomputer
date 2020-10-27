package usbZulieferer;

import fahrzeugHersteller.*;

public class USBZuliefererInit implements DeviceFactory {

  @Override
  public Device createDevice() {
    return new USBDevice();
  }

}
