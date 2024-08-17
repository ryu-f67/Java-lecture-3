package org.example;

import java.util.HashSet;
import java.util.Set;

public class MobilePhoneNumberChecker {

  public static boolean validatePhoneNumber(String phoneNumber) {
    if (!phoneNumber.matches("^0[789]0-[0-9]{4}-[0-9]{4}$")) {
      System.out.println(phoneNumber + " は無効な携帯電話番号です。");
      System.out.println("電話番号の形式が違います。XXX-XXXX-XXXX のように入力してください。");
      return false;
    } else if (!checkNumberOfUniqueNumbers(phoneNumber)) {
      System.out.println(phoneNumber + " は無効な携帯電話番号です。");
      System.out.println("下8桁に4種類以上の数字が使用されていません。");
      return false;
    } else if (!checkConsecutiveNumbers(phoneNumber)) {
      System.out.println(phoneNumber + " は無効な携帯電話番号です。");
      System.out.println("下8桁に同じ数字が3回以上連続して使用されています。");
      return false;
    } else {
      System.out.println(phoneNumber + " は有効な携帯電話番号です。");
      return true;
    }
  }

  // 下8桁を取り出す
  private static String findLastEightDigits(String phoneNumber) {
    return phoneNumber.substring(4,8)+phoneNumber.substring(9,13);
  }

  // 4種類以上の数字が使用されているかチェック
  private static boolean checkNumberOfUniqueNumbers(String phoneNumber) {
    Set<Character> uniqueNumber = new HashSet<>();
    for (char c : findLastEightDigits(phoneNumber).toCharArray()) {
      uniqueNumber.add(c);
    }
    return uniqueNumber.size() >= 4;
  }

  // 同じ数字が3回以上連続して使用されていないかチェック
  private static boolean checkConsecutiveNumbers(String phoneNumber) {
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
}
