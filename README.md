# Final-Project(CSS 348 – ADVANCED DATABASE MANAGEMENT SYSTEMS)
Team : PharmaDAD

Team Members : Tokmukhanbet Daulet, Zhomartuly Almas , Dauren Khametov

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
