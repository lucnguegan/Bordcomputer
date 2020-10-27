package fahrzeugHersteller;

public interface Device {

  void louder();

  void quieter();

  int getVolume();

  void next();

  void prev();

  String getInfoText();

  String[] getOptions();

  void chooseOption(String opt);

  String play();
}
