package fahrzeugHersteller;

import java.lang.reflect.Method;
import java.util.Random;
import zuliefererInterface.Device;
import usbZulieferer.USBDevice;
import cdZulieferer.*;

public class Bordcomputer {

  private String[] deviceName;
  private Device[] installedDevices;
  private Device playingDevice;

  public static void main(String[] args) {
    Bordcomputer computer = new Bordcomputer();

    String className = computer.getClass().getName();

    Method[] classMethods = computer.getClass().getDeclaredMethods();
    for(Method methode : classMethods){
      String parameter = "";

      if(methode.getParameterTypes().length != 0) {
        parameter = methode.getParameterTypes()[0].getSimpleName();
        parameter = parameter + "  " + methode.getName();
      }

      System.out.println("" + methode.getName() + "(" + parameter + ")" + "    " + methode.getReturnType().getSimpleName() );
    }



  }

  public Bordcomputer() {
    try {
      setDevices();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    Random r = new Random();
    playingDevice = installedDevices[r.nextInt(installedDevices.length)];

    int low = 0;
    int high = playingDevice.getClass().getDeclaredMethods().length;
    int result = r.nextInt(high-low) + low;
    enterOption(result);


  }

  private void setDevices() throws ClassNotFoundException {
    // Erstellt Objekte der Devices
    // speichert das in installedDevices
    installedDevices = new Device[3];
    installedDevices[0] = new USBDevice();
    installedDevices[1] = new CDKlasse();
    installedDevices[2] = new CDPlayer();
  }

  public void shutdown() {
    System.out.println("Boardcomputer wird heruntergefahren");
  }

  public void changeDevice() {
    for(int i = 0; i < installedDevices.length; i++) {
      if (playingDevice == installedDevices[i]) {
        playingDevice = installedDevices[(i+1)% installedDevices.length];
        break;
      }
    }
    System.out.println("zuliefererInterface.Device geaendert auf: " + playingDevice.getClass().getName());
  }

  public void showOptions() {
    // show methods of class in playingDevice
    // zeigt nur Methoden, die Optionen sind (3 zusätzliche Methoden)
    System.out.println("Show Options:");
    Method[] methods = playingDevice.getClass().getDeclaredMethods();
    for(Method method : methods) {
      System.out.println("Methode - " + method.getName());
    }
  }

  public void enterOption(int choice) {
    // RNG enter Option
    // choice % methods.count
    Method[] methods = playingDevice.getClass().getDeclaredMethods();
    methods[choice].setAccessible(true);
    try {
      if(methods[choice].getGenericParameterTypes().length==0) {
        methods[choice].invoke(playingDevice);
      } else {
        System.out.println("Invoke konnte nicht ausgefuehrt werden, da Parameter erwartet werden.");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    // RANDOM METHODE WÄHLEN
    // INVOKE
  }

  public void louder(int p) {
    if (p > playingDevice.getVolume()) {
      int diff = p - playingDevice.getVolume();

      for (int i = 0; i < diff; i++) {
        playingDevice.louder();
      }
    }
    showVolume();
  }

  public void quieter(int p) {
    if (p < playingDevice.getVolume()) {
      int diff = playingDevice.getVolume() - p;

      for (int i = 0; i < diff; i++) {
        playingDevice.quieter();
      }
    }
    showVolume();
  }

  public void showVolume() {
    System.out.println("Volume: " + playingDevice.getVolume());
  }

  public void next() {
    playingDevice.next();
    System.out.println("next");
  }

  public void prev() {
    playingDevice.prev();
    System.out.println("prev");
  }

  public void play() {
    playingDevice.play();
    System.out.println("play");
  }


}
