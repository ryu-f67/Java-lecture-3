# ハイフン付きの国内携帯電話番号の有効性をチェックするプログラムです。
```
入力例:
    携帯電話番号を入力してください: 080-1234-5678

期待される出力例:
    080-1234-5678 は有効な携帯電話番号です。

入力例:
    携帯電話番号を入力してください: 08012345678

期待される出力例:
    08012345678 は無効な携帯電話番号です。
```

## 番号が有効となる条件  
今回の課題では、携帯電話番号が有効である条件を次のように設定した。  
- 070,080,090で始まる11桁の番号。
- "XXX-XXXX-XXXX"の形式で入力されていること。
- 下8桁に4種類以上の数字が使用されていること。(NG例 : 080-5433-4353)
- 下8桁に同じ数字が3回以上連続して使用されていないこと。(NG例 : 080-1116-4358, 090-5449-9913)
