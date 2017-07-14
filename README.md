# _hair_salon_

#### _Program to add view and delete clients and stylists, 7/14/2017 version 1.0_

#### By _**Joel Bakken**_

## Description

_This program is designed to allow the user to add and delete stylists and clients and assign one to another_

## Setup/Installation Requirements

* _Run this program in your favorite browser._
* _setup the database using your built in terminal_

* _In your terminal in OSX enter in the following command:_
  _postgres_
* _Open a new terminal window and enter " psql "._
* _In that window enter the following commands:_

_' # CREATE DATABASE hair_salon; '
' # \c hair_salon '
' # CREATE TABLE stylists (id serial PRIMARY KEY, name varchar); '
' # CREATE TABLE clients (id serial PRIMARY KEY, name varchar, details varchar, stylistID int); '
' # CREATE DATABASE hair_salon_test WITH TEMPLATE hair_salon; '_
* _In yet another new terminal window go into the project directory which you have already saved to your desktop and type: gradle run_



## Known Bugs

_There are no known issues with this program._

## Support and contact details

_Please contact me at jkbetc@gmail.com if there are any problems with this program_

## Technologies Used

_JAVA, JUnit, Gradle, postgresql_

### License

*No license*

Copyright (c) 2017 **_Joel Bakken_**
