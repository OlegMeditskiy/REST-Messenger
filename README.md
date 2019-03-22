# REST-Messenger

Message REST

------------------------------------------------------------------------------------------------------------------------------------------
3 entities: Dialog, Users and Message
Relationships 
Dialog *-* Users /Dialog 1-* Message/Users *-* Dialog/Users 1-* Message
Description:
This REST Webservice and client allow you to send messages between users in dialogs.

Create new user using POST http://localhost:8080/Message/rest/users
{“firstName”:”…”,”lastName”:”…”,”age”:”…”}
 
Get user list using GET http://localhost:8080/Message/rest/users
 

Create new dialog using POST http://localhost:8080/Message/rest/dialog
{"name":"Oleg-Ruslan-Dialog"}
 
Get dialog list using GET http://localhost:8080/Message/rest/dialog
 
Create message using POST http://localhost:8080/Message/rest/message/dialog/3/user/1
Write dialog id first then user id and message in body
{"message":"Hi Ruslan, i want to meet you today."}
 
Get all messages from Dialog using GET http://localhost:8080/Message/rest/dialog/getMessages/3
Write dialog id after getMessages

You can also: 
•	get dialog’s users using GET http://localhost:8080/Message/rest/dialog/getUsers
•	get user’s messages using GET http://localhost:8080/Message/rest/users/getMessages/1 Write user id after getMessages
•	get user’s dialogs using GET http://localhost:8080/Message/rest/users/getDialogs/1 Write user id after getDialogs


