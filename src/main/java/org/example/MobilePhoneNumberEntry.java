package org.example;

import java.util.Scanner;

public class MobilePhoneNumberEntry {
  Scanner scanner = new Scanner(System.in);

  public String entryPhoneNumber() {
    System.out.print("携帯電話の電話番号を入力してください。(ハイフンあり) : ");
    return scanner.next();
  }

  public void fetchScanner() {
    scanner.nextLine();
  }
}
