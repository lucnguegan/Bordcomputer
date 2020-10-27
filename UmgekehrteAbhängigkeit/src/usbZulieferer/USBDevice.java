package usbZulieferer;

import fahrzeugHersteller.Device;

public class USBDevice implements Device {
  public int p;


  public void louder() {
    p++;
  }
  public void quieter() {
    // not below zero
    if(p>0){
      p--;
    }
  }

  @Override
  public int getVolume() {
    return p;
  }

  public void next() {

  }
  public void prev() {

  }

  @Override
  public String getInfoText() {
    return null;
  }

  @Override
  public String[] getOptions() {
    return new String[0];
  }

  @Override
  public void chooseOption(String opt) {

  }

  public String play() {

    return "";
  }

}
