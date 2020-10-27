package cdZulieferer;

import fahrzeugHersteller.Device;

public class CDPlayer implements Device {

  private int volume;

  public CDPlayer() {
    volume = 50;
  }

  @Override
  public void louder() {
    if(volume++<100) {
      volume++;
    }
  }

  @Override
  public void quieter() {
    if(volume-->0) {
      volume--;
    }
  }

  @Override
  public int getVolume() {
    return volume;
  }

  @Override
  public void next() {
    System.out.println("next song");
  }

  @Override
  public void prev() {
    System.out.println("previous song");
  }

  @Override
  public String getInfoText() {
    System.out.println("INFO");
    return null;
  }

  @Override
  public String[] getOptions() {
    //System.out.println("get Options");
    return new String[0];
  }

  @Override
  public void chooseOption(String opt) {
    //System.out.println("choose Option");
  }

  @Override
  public String play() {
    //System.out.println("play");
    return null;
  }

  public void shuffle() {
    System.out.println("Songlist shuffled");
  }

  public void repeat() {
    System.out.println("Song wird wiederholt");
  }

  public void mute() {
    volume=0;
    System.out.println("mute");
  }
}
