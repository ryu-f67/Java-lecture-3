package org.example;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MobilePhoneNumberChecker {
  Scanner scanner = new Scanner(System.in);

  private String entryPhoneNumber() {
    System.out.print("携帯電話の電話番号を入力してください。(ハイフンあり) : ");
    return scanner.next();
  }

  private void validatePhoneNumber(String phoneNumber) {
    if (!phoneNumber.matches("^0[789]0-[0-9]{4}-[0-9]{4}$")) {
      System.out.println(phoneNumber + " は無効な携帯電話番号です。");
      System.out.println("電話番号の形式が違います。XXX-XXXX-XXXX のように入力してください。");
      System.out.println();
      scanner.nextLine();
      checkMobilePhoneNumber();
    } else if (!checkNumberOfUniqueNumbers(phoneNumber)) {
      System.out.println(phoneNumber + " は無効な携帯電話番号です。");
      System.out.println("下8桁に4種類以上の数字が使用されていません。");
      System.out.println();
      scanner.nextLine();
      checkMobilePhoneNumber();
    } else if (!checkConsecutiveNumbers(phoneNumber)) {
      System.out.println(phoneNumber + " は無効な携帯電話番号です。");
      System.out.println("下8桁に同じ数字が3回以上連続して使用されています。");
      System.out.println();
      scanner.nextLine();
      checkMobilePhoneNumber();
    } else {
      System.out.println(phoneNumber + " は有効な携帯電話番号です。");
      scanner.close();
    }
  }

  // 下8桁を取り出す
  private String findLastEightDigits(String phoneNumber) {
    return phoneNumber.substring(4,8)+phoneNumber.substring(9,13);
  }

  // 4種類以上の数字が使用されているかチェック
  private boolean checkNumberOfUniqueNumbers(String phoneNumber) {
    Set<Character> uniqueNumber = new HashSet<>();
    for (char c : findLastEightDigits(phoneNumber).toCharArray()) {
      uniqueNumber.add(c);
    }
    return uniqueNumber.size() >= 4;
  }

  // 同じ数字が3回以上連続して使用されていないかチェック
  private boolean checkConsecutiveNumbers(String phoneNumber) {
    int count = 1;
    for (int i = 1; i < findLastEightDigits(phoneNumber).length(); i++) {
      if (findLastEightDigits(phoneNumber).charAt(i) == findLastEightDigits(phoneNumber).charAt(i - 1)) {
        count++;
        if (count >= 3) {
          return false;
        }
      } else {
        count = 1;
      }
    }
   return true;
  }

  public void checkMobilePhoneNumber() {
    String mobilePhoneNumber = entryPhoneNumber();
    validatePhoneNumber(mobilePhoneNumber);

  }
}
