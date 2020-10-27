package cdZulieferer;
import zuliefererInterface.Device;

public class CDKlasse implements Device {

  public CDKlasse() {
    // TODO Auto-generated constructor stub
    System.out.println("CD Player");
  }

  public void next() {
    System.out.println("Next song on CD");
  }

  public void louder(int p) {
    // TODO Auto-generated method stub

  }

  public void quieter(int p) {
    // TODO Auto-generated method stub

  }

  @Override
  public void louder() {

  }

  @Override
  public void quieter() {

  }

  @Override
  public int getVolume() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public void prev() {
    // TODO Auto-generated method stub

  }

  @Override
  public String getInfoText() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String[] getOptions() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void chooseOption(String opt) {

  }

  public void chooseOptions(String opt) {
    // TODO Auto-generated method stub

  }

  @Override
  public String play() {
    // TODO Auto-generated method stub
    return "null";
  }
}
