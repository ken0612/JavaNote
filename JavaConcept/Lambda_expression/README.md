# Lambda Expression
* 結合使用StreamAPI有豐富功能可以簡短、快速的完成功能
* 基本格式：
```Java!
parameter -> expression 
//針對括號內輸入參數，並在expression處寫上針對參數的動作
(para1,para2) -> expression
//若參數有兩個以上，則需要使用小括號將其包裝起來
parameter ->{codeBody} 
//若需要寫超過一行的程式碼，則需要使用大括號將codeBody包起來
```