# Final-Project(CSS 348 – ADVANCED DATABASE MANAGEMENT SYSTEMS)
Team : PharmaDAD

Team Members(with github nicknames) : Tokmukhanbet Daulet(dato3), Zhomartuly Almas(ZhomartulyAlmas) , Dauren Khametov

Project Name : E-Pharmacy

## Phase 2

Project Description(This project is the continuation of what we did in the Database 2 course) :

As a result of the global pandemic in the Republic of Kazakhstan, everything has switched to remote control, we have identified that some areas are still not ready for such rapid changes in society. That’s the main reason why we decided to do something that will help in this difficult situation. As we know, in Kazakhstan we had a quarantine mode for a few months and we still have a quarantine mode in some regions but not as strict as it was a few months ago. And that‘s why people simply started to order the delivery for food, groceries and etc. But we didn’t have an option to order medicine. And even buying medicine was a catastrophic problem, because it was really hard to even find it. We had a shortage of medicine in our country. And that’s why a lot of people died. So in this project, we tried to ease that problem so that people in our country could easily buy or order medicine.

Basically, we are planning to create a website with a beautiful and easy-to-use user interface. We want to create a website so that, any category of people can easily use it. Potential clients can order any medicine which is available to any address in Almaty(in this project we only cover Almaty). Clients can see how many medicines are in stock right now. We will include the text field indicating the total price of medicines in the basket. And we will add a most-sold and recently-sold medicine list on the main page. So that users can see which medicines are highly demanded and which medicines are sold recently. After completing the purchase client can remove any medicine from his/her basket and finally fill out the address, phone number, bank card information, etc, and order medicine. If an order is successful then the client will receive an email, with the detailed info of the purchase. 

In this project we are going to use the JAVA as a programming language and we will use Tomcat as a open-source implementation of the Java Servlet, JavaServer Pages, Java Expression Language and WebSocket technologies. As a database we will use Oracle. The main reason why we are going to use JAVA as a PL and Oracle as a DB is because we have a solid foundation of it from our experience in university. As a software architectural design we are planning to use MVC model, where we will split up the application data, the user interface, and control logic. To make our proect more realistic we will fetch the real data from [AptekaPlus](https://aptekaplus.kz) online pharmacy. All the medicine names, price, bar code, etc are going to be real. 

## Phase 3

Questions :

* How does a client know that they have successfully ordered a medicine?
* If a client wants to know which medicine is in high demand, how can he/she do it?
* How multiple medicines will be ordered ?
* Is there a way to find out which medicine has been bought recently?
* If the client unintentionally put some medicine into his/her basket, is there a way to remove it ?
* Where can the client see the total amount for which he wants to order the medicine ?
* Is there any kind of entertainment for the client?
* How the system will know who is ordering a medicine and how the basket is assigned to the user ?
* If the client is unknown for the system is there a way to register him/her ?
* If the user logs in, orders some medicine and logs out, what will happen to the ordered medicine ?
* Is there a way to see how many medicines are in stock ?
* If the particular medicine is sold, how the client will know about it ?
* How can the client actually see the medicine ?
* Can a client search for a particular medicine ?
* If the client wants to see the list of all the available medicine, how can he/she do it ?

Dataset :

We wanted to make this project as realistic as possible and complex enough to get a high grade. And that's why we created our own dataset which is quite small around 200 rows(medicines). We used a software called ParseHub to parse the medicine info from the [AptekaPlus](https://aptekaplus.kz) online pharmacy. Main reasons why our dataset is small is that, ParseHub only provides 200 parsedItems for free version and it take really a lot of time even to parse 10 items from website. That's why we only used 200rows which is still enough to realize our project. The main dataset is attached in github.

Answers/Functions :

* We implemented a Email Sender using Java library called JavaMAIL, which sends an email with detailed information about the order whenever someone orders a medicine. 
* We have added a list of the most requested medicines to the main page so that the client can see which medicine is bought most often. For this we created a table called **featured_medicines**.
* A client can order a multiple medicine putting all the medicines into his/her basket, all the infotmation about the medicines in the basket are stored in a table called **cart_table**. Whenever client logs in empty basket will be attached to the client and when the client logs out the basket is deleted automatically. All the infromation about the client is in **users** table.
* We also added a list of the recently bought medicines, so that client can see which medicines are bought recently. There is another table called **recent_medicines** which is responsible to recently bought medicines.
* There is a remove button in a clients basket, by clicking on it client can remove unnecessary medicines from his/her basket. And the medicine is removed from the **cart_table**.
* Client can see for how many tenge he/she already ordered a medicine near the basket. We added a total amount near the basket which will be changed depending on the clients orders.
* We added a NEWS page for the clients, where clients can read the recent and important news about the COVID-19 and etc. All the information about the news, date posted, etc are stored in a **news** table.
* Ordering is impossible if you are not logged in, in order to order a medicine you have to be logged in or register yourself. Because basket is attached to the client.
* There is a login/register page, if the client is new to the system then he/she can easily register him/herself and start ordering.
* Ordered medicine will be lost, because basket is attached to the client and whenever client logs out the basket is deleted automatically.
* Yes, there is. We added a in-stock number of medicines and if the number is 0 then order is not possible.
* When a client clicks on a medicine, there will be detailed information about that particular medicine and the client can see how many medicines are available right now. If the number is 0, then availability button becomes red and not clickable.
* By clicking on the medicine, he/she can see the detailed info about the medicine.
* We added a search engine, which searches medicine according to their names. Search is not case sensitive.
* There is a SHOP NOW button right in the center, by clicking it client can see all the available medicines.

## Phase 4

In the 4th phase of our final project we created an ER diagram and created tables accordingly, also in this phase we inserted our dataset.

Few words about why and how we created our ER diagram to make things clear. We don't have a lot of tables, only a few and the relation between them can be a little bit confusing. 

**users - cart_table** : The **users** table is the main table where we are going to store some needed data about the users. And each time the user is logged in the basket or cart would be assigned to the user. **cart_table** is the temporary table that is going to be used by a particular user and when the user will buy some medicines it will be updated. And if the user will log out then the table is going to be deleted. So that's why there is a concrete mandatory one-to-one relationship. 

**users - news** : **news** table is going to be used in order to show some important and interesting news worldwide. And the relationship there is created accordingly that one or many users can read many news. 

**users - buy_log** : **buy_log** is the table that is going to record the purchased medicines. And in one log table, there can be one or many users recorded. 

**cart_table - medicines** : **medicines** is the main table where we are going to store our medicines. And it is obvious that in one cart_table there can be one or many medicines.

**medicines - recent_medicines** : Now we know what we store in the medicines table, and the attributes of the medicines table are almost the same as in **recent_medicines**. The function of keeping track of recently bought medicines is going to be added to our project and this table is going to be used. It will just sort out the date_bought attribute and return the result. The relationship here is that one or many medicines can be in the list of recently bought medicines.

**medicines - featured_medicines** : It is a similar thing here, we just add a new attribute called number_bought and sort using that attribute to get a list of medicines that are sold most. The relation is pretty similar except that there can not be only one medicine, there should be many medicines in the list.

Also SQL queries of how we created our tables and inserted our dataset is attached in the repository.

## Phase 5

Actually, we made those 15 questions little bit not relevant to this phase and it was a little bit complicated to correctly associate the queries with the questions. But we tried to make it as clear as possible. All 15 query files are located in the **Phase#5** folder. All queries are made by all 3 of us.

## Phase 6

In this phase our project needs to be completely implemented, optimized and tested. But it is not actually fully implemented. There are few things to add. But for now it is working well and it is tested for many actions and etc. We optimized our queries so that they will work as fast as possible, but because of Tomcat server and Email Sender after the purchase, it is working little bit slow. In the future, the errors will be corrected and tested by users. 

* Build an user-interface (web, desktop or mobile application). You may choose any programming language you feel comfortable with.

In the DB 2 course, our interface was terrible to say the least(Because UI was not that important). But we redesigned it and made a very good looking and simple UI for user. You can check the screenshots of UI in the Phase#6/UI folder. We created a website using simple HTML, CSS, JS and nothing more and the Backend was implemented using Java(EE version) and the Tomcat server.

* Establish a connection with the created database. You may use JDBC libraries for the connection.

Establishing a connection with the database in the JavaEE is very easy using the JDBC library. We are using Oracle as our DB. Screenshots of how we establish a connection are in the Phase#6/DBConnection folder. In short, the connection is established using JDBC Driver name in our case it is **oracle.jdbc.driver.OracleDriver** and the JDBC URL which is **jdbc:oracle:thin:@//localhost:1521/orcl**, because currently, I am using Oracle on my Virtual Machine.

* Implement you project functions that will trigger corresponding SQL queries to retrieve the necessary data. The project functions have to be interactive, i.e. they have to allow the user to select a function from a menu and provide input arguments whenever required.

We have not only SQL queries, we also have a Oracle procedures and triggers. Which are very useful in optimizing and making your queries easy. As you saw in the UI all the Recent Medicines, Featured Medicines are retrieved from our DB, also the news section is retrieved from DB. Featured Medicines and Recent Medicines are retrived whenever the page is reloaded. And the News are retrieved whever the News section is clicked. We also implemented a search system which will search the particular medicines(Screenshot is also in the UI folder). And all those queries, procedures, triggers are working very clear and fast. All of them are retrieving necessary information for the user whenever needed. I am not sure should we submit all of our queries or not, because it is not clear, but if we should please contact us)

* Display (or vizualize) the retrieved data to the users (or clients). The teams are welcome to create, extract and report some statistical information based on the project data (bonus points). 

Screenshots are in Phase#6/UI folder. And for bonus points, I want to report statistical information that medicines are not permissible for many of Kazakhstan citizens. Because the minimum wage in Kazakhstan in 2021 is around 42500 tenge. Which is an extremely small amount of money to simply survive. And because of that many people can not afford a particular medicine. Especially old people, really need medications to live a longer life but due to the absence of money, they can not afford that. In 2020, we experienced a shortage of medicines during pandemics and it was not only a shortage but also the fact that these medicines were very expensive and many simply died due to the fact that they could not buy these medicines. We took our dataset to check the prices of medicines and we can see the prices like 188000 and other extremely expensive medicines. And if we will just imagine an old man or woman that has a salary of 42500 tenge and who is very ill and needs the medicine which costs 188000. How will they afford that ?(Screenshot in Phase#6/Statistic) Medicines have risen in price by 30%, this is official information from newtimes.kz for 26.03.21. This is a very big problem and for this reason we chose to do this project to implement. This is a very big problem and for this reason we chose to do this project to implement.

## Phase 7

In this phase of our project we had to choose 7 most complex SELECT queries out of 15 queries submitted before and write their corresponding relational expressions and relation algebra trees. But the problem that we faced is, when we created 15 quetions we did not think that we have to write sql queries and their corresponding RA expressions. And because of that our sql queries are too simple and most of them are not even SELECT queries. That's why we chose the SELECT queries that we had and wrote their corresponding RA expressions. Also we had a 3 SELECT queries that used OFFSET and FETCH some FIRST ROWS ONLY expressions. We couldn't find any information regarding how to limit the number of selected rows in RA. And finally it was clear that there are no such RA operators. But we were not sure about that, and we used only one of those 3 queries in case if we did it not correctly. 

## Phase 8

Actually, we didn't even do 8th phase like 5th and 7th phases. Because when we created our questions we didn't expect that we are going to do such things with our queries and because of that our questions are simlpe and the queries for them are also simple. For completing this 8th phase we don't even have joins in all of 15 queris and because of that we only counted the cardinailities of 1 tables and the execution time for each of them.  

## Phase 9

Since we took quite easy queries in previous phases we decided to choose different queries and little bit different functionalities. Many of them are already mentioned in 15 queries/questions in previous phases. We inserted some code in our backend to check how many miliseconds it takes for the functionality to trigger the quiey and retrieve it. And here what we got,

1.Shop Now function, which returns list of all the medicines from our main dataset by clikcing on a "Shop Now" button. Average runtime is 32+9+12+6+5/5 = 12.8 ms.

2.Search system, which searches for particular medicines from medicines dataset. Average runtime is 43+21+12+29+15/5 = 24 ms.

3.Register function, which simply registers the user. Average runtime is 11+6+8+14+5/5 = 8.8 ms.

4.Runtime of displaying the most sold medicines. Average runtime is 31+14+25+16+11/5 = 19.4 ms.

5.Runtime of displaying the recently sold medicines. Average runtime is 52+20+12+17+10/5 = 22.2 ms.

6.Adding a medicine into the basket. Average runtime is 12+19+10+21+13/5 = 15 ms.

7.Buying the medicines from basket. Average runtime is 156+128+179+142+98/5 = 140.6 ms. The main reason why this functionality works that slow is that we have a mail sender that notifies the user that he bought the medicines and sends the order number, etc. And this mail sender is really slow for some reason. I even tried a new project with a mail sender only, but still it takes around 60-100ms to send a message. To fasten the runtime of this functionality, I even added a trigger and 2 procedures to fasten the queries but still it takes around 140 ms.

For bonus points, I added a 7 screenshots in Phase#9 folder where you can see the execution plan but I couldnt change the time there to a miliseconds.

## Phase 10

So in a final Phase of our Project we have to write a page long project report, which is in a Phase#10 folder. And time slot chosen for a presentation is 30 April 10AM - 10:15AM. Also we have to prepare the presentation which is also in a Phase#10 folder. The prerecorded video of our project is https://www.youtube.com/watch?v=MpFQxkonEA8 .
