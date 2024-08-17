package org.example;

public class Main {

  public static void main(String[] args) {
    MobilePhoneNumberEntry mpne = new MobilePhoneNumberEntry();
    boolean isOK = false;

    while (!isOK) {
      isOK = MobilePhoneNumberChecker.validatePhoneNumber(mpne.entryPhoneNumber());
      if (isOK) {
        break;
      }
      mpne.fetchScanner();
      System.out.println();
    }
  }
}
