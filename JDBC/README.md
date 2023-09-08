# JDBC 筆記

## 如何連接至DataBase(ＭySQL)

1. 註冊JDBC Driver（固定寫法）
```java
Class.forName("oracle.jdbc.driver.OracleDriver");  
```

2. 創建一個連接(Connection)

語法： （資料庫地址、帳號、密碼）
```java
public static Connection getConnection(String url,String name,String password)  
throws SQLException 
//範例
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/mysql_toturial","system","password");  
```

3. 創建一個Statement

Connection介面的createStatement()方法用於建立語句。語句的物件負責執行與資料庫的查詢。
```java
public Statement createStatement()throws SQLException 
//範例
Statement stmt=con.createStatement();  
``` 
4. 執行查詢

```java
public ResultSet executeQuery(String sql)throws SQLException  
//範例

ResultSet rs=stmt.executeQuery("select * from emp");  
  
while(rs.next()){  
System.out.println(rs.getInt(1)+" "+rs.getString(2));  
}  
```
5. 關閉連接

用完記得要關！！！
```java
public void close()throws SQLException  
//範例
con.close();  
```

## 實際連線範例

```java
package com.toturial;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Statement;
public class TestMySQLConnection {
    public static void main(String[] args) {
        // JDBC URL, username, and password of MySQL server
        String url = "jdbc:mysql://localhost:3306/mysql_toturial";
        String user = "root";
        String password = "password";

        try {
            // Register the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Open a connection
            Connection connection = DriverManager.getConnection(url, user, password);
            java.sql.Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("select * from student");
            while(resultSet.next()) {
            	int sid=resultSet.getInt("s_id");
            	String sname=resultSet.getString("s_name");
            	Date sbirthDate=resultSet.getDate("s_birth");
            	System.out.println(sid +" "+ sname+" "+ sbirthDate);
            }
            
            // Check if the connection is successful
//            if (connection != null) {
//                System.out.println("Connected to the database!");
//                connection.close();
//            }
        } catch (SQLException e) {
            System.err.println("Failed to connect to the database!");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC driver not found!");
            e.printStackTrace();
        }
    }
}
```


# Statement & PrepareStatement

**透過創建Statement物件，就可以使用該物件的方法去針對資料庫進行查詢等功能。
但由於Statement容易遭到Sql注入攻擊，故目前基本上不用Statement
而是使用PrepareStatement**

## PrepareStatement

在executeQuery,Update等方法中需要放入一個參數為SQL的語法
但語法中可以使用?先不指定資料，後續透過setInt等方法來決定要搜尋什麼資料，看起來用法比較靈活一些。
```java
//先設定想要的增刪改查語句，sql語言的參數部分在java以?代替
String query = "insert into employee values (?,?,?)";
//建立一個preparedstatement物件，並將欲使用的sql語句放入參數
PreparedStatement stmt=con.prepareStatement(query);
//針對該物件調用setInt方法(query裡面的第幾個?=參數,設定什麼值)
stmt.setInt(1,101);
stmt.setString(2,"Ken");
stmt.setInt(3,3000);
//參數設定完之後，將資料寫入資料庫，必須使用executeUpdate()將資料寫入資料庫
int eft= stmt.executeUpdate();

System.out.println(eft + " records inserted");
```

## 透過PrepareStatement進行增刪改查
sql連線方式相同同上
先建立一個PrepareStatment物件
```java
PreparedStatement stmt=con.prepareStatement([增刪改查]);
```
### 增
```java
String query="select * from teacher";//訂定sql搜尋語法
ResultSet rs = stmt.executeUpdate(query);//將搜尋結果存到ResultSet中
while(rs.next()){
    //rs.getInt()輸入String可依照sql欄位名稱取值
    //但如果是輸入int數字，則是依照第n欄取值
    int id = rs.getInt("t_id");
    String name= rs.getString("t_name");
    System.out.println(id +" "+ name);
}//透過回圈將其列印

stm
```
### 刪
```java
String del="delete from teacher where t_name = 'ken'";//訂定sql搜尋語法
//executeUpdate,executeQuery...等方法，會回傳一個int，回傳的內容是受到影響的行數。
//基本上preparestatement是不支援刪除功能，但可以使用update語法達成。
int rs= stmt.executeUpdate(del);
System.out.println(rs +" records effected");

```
### 改
```java
String update="update teacher set t_name='ken' where t_name ='haha'";//訂定sql搜尋語法
stmt.executeUpdate();
//後續也可以透過上述方法列印受影響行數or將結果跑回圈列印出來
```
### 查
```java
String query="select * from teacher; //訂定sql搜尋語法
//executeQuery會回傳一個物件ResultSet，可以將其儲存起來並進行後續資料處理。
ResultSet rst = stmt.executeQuery();
```

## ResultSetMetaData

在透過executeQuery獲得一個ResultSet之後，還可以使用下列語法取得ResultSetMetaData
```java
ResultSet rst= stmt.executeQuery("select * from teacher");
java.sql.ResultSetMetaData mtdt  =rst.getMetaData();
```
MetaData主要是用來獲取資料庫的標籤名稱，其中還有一些方法可以方便地計算總數、或是檢查欄位是否可為null;

從connection物件中獲得資料庫元數據
Connection --> DataBaseMetaData
從ResultSet物件中獲得資料庫表格元數據
ResultSet --> ResultSetMetaData