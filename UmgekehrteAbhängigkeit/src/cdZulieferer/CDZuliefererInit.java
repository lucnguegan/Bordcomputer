package cdZulieferer;

import fahrzeugHersteller.Device;
import fahrzeugHersteller.DeviceFactory;

public class CDZuliefererInit implements DeviceFactory {

  @Override
  public Device createDevice() {
    return new CDPlayer();
  }
}
