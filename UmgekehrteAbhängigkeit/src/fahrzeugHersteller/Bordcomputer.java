package fahrzeugHersteller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.Random;

public class Bordcomputer{

  private Device[] installedDevices;
  private Device playingDevice;

/*
  private static Singleton instance;
  // Verhindere die Erzeugung des Objektes über andere Methoden
  private Singleton () {}
  // Eine Zugriffsmethode auf Klassenebene, welches dir '''einmal''' ein konkretes
  // Objekt erzeugt und dieses zurückliefert.
  public static Singleton getInstance () {
    if (Singleton.instance == null) {
      Singleton.instance = new Singleton ();
    }
    return Singleton.instance;
  }
*/





  public Bordcomputer() {}

  public Bordcomputer(DeviceFactory[] devicesDF) {
    installedDevices = new Device[devicesDF.length];

    for(int i = 0; i < devicesDF.length; i++) {
      installedDevices[i] = devicesDF[i].createDevice();
    }

    // Random Device chosen
    Random r = new Random();
    playingDevice = installedDevices[r.nextInt(installedDevices.length)];
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
    System.out.println("fahrzeugHersteller.Device geaendert auf: " + playingDevice.getClass().getName());
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
