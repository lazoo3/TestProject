# TestProject Spring REST
Installation Process
1.	First you need to execute TestProjectSQL.sql script using MySQL Workbench or some other way you prefer.
2.	Import this project using Eclipse or other IDE that you prefer
3.	You need to run this project on Tomcat version 8 or higher
4.  You will need Java 7 or higher, and if there are some problems with compiling, you should change from jre to jdk for compiling this project
5.	When the project is running you can use Postman or your browser to get the data and do with it what you need.<br/>
<br/>
<br/>
How to get data:
<br/>
Depending what you need the first controller the HomeController will give you all info about the specific user (http://localhost:8080/TestProject/core/home/getUserById/{id})
<br/>
This is just for specific info for User depending if you want to get info, delete, add new user or update(http://localhost:8080/TestProject/core/user/getUser/, http://localhost:8080/TestProject/core/user/getUserById/{id}, http://localhost:8080/TestProject/core/user/add/, http://localhost:8080/TestProject/core/user/update/{id}, http://localhost:8080/TestProject/core/user/delete/{id})
<br/>
To get info about avatar or add new, delete and update use(http://localhost:8080/TestProject/core/avatar/getAvatar/,http://localhost:8080/TestProject/core/avatar/add/,http://localhost:8080/TestProject/core/avatar/update/{id},http://localhost:8080/TestProject/core/avatar/delete/{id}
<br/>
To get info about billing address, add new, delete or update use(http://localhost:8080/TestProject/core/billingAddress/getBillingAddress/,http://localhost:8080/TestProject/core/billingAddress/add/,http://localhost:8080/TestProject/core/billingAddress/update/{id},http://localhost:8080/TestProject/core/billingAddress/delete/{id}
<br/>
To get info about role and add new, delete or update use(http://localhost:8080/TestProject/core/role/getRole/,http://localhost:8080/TestProject/core/role/add/,http://localhost:8080/TestProject/core/role/update/{id},http://localhost:8080/TestProject/core/role/delete/{id})
<br/>
To get info about company or add new, delete or update use(http://localhost:8080/TestProject/core/company/getCompany/,http://localhost:8080/TestProject/core/company/add/,http://localhost:8080/TestProject/core/company/update/{id},http://localhost:8080/TestProject/core/company/delete/{id}
<br/>
To get info about country or add new, delete or update use(http://localhost:8080/TestProject/core/country/getCountry/,http://localhost:8080/TestProject/core/country/add/,http://localhost:8080/TestProject/core/country/update/{id},http://localhost:8080/TestProject/core/country/delete/{id})
