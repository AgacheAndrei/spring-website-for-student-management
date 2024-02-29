# Database Project -- Java Application with SQL
## Project for univeristy

## The goal of the app
<p>
 The application developed addresses the issue of managing both scholarship and non-scholarship students within a high school.
</p>

## Analyze problems

<p>
A high school is a general education institution where graduates of primary schools are admitted, and where the knowledge required for further studies in higher education or various vocational fields is taught.
A student is considered a scholarship recipient if they meet certain conditions imposed by the state and the educational institution they are a part of. According to the current legislation, there can be several types of scholarship recipients:
Please note that all scholarships require a minimum overall grade that must be exceeded to enter the scholarship application process. These minimum grades vary widely depending on the type of scholarship and current legislation.
</p>
<pre>
- Merit Scholars: These students have an overall grade above a minimum set by the high school and the Inspectorate for Education in the city where the high school is located.
- Olympic Scholars: These are students who have achieved outstanding results at national or international levels in various olympiads.
- Social Scholarships are divided into different categories based on the challenges faced by a student. These categories include scholarships for students who are orphaned by one or both parents, students from rural areas, students facing difficult situations, and students with serious health issues or disabilities.
</pre>
<p>
Scholarships represent compensation that varies depending on the type of scholarship and the current legislation, and it is given to the student or their guardian during the validity period of the scholarship application.
There are scholarships that last for:
</p>
<pre>
- 6 months, such as academic scholarships like merit scholarships and Olympic scholarships.
- 12 months, such as social scholarships in the categories mentioned above.
</pre>
For example, a merit scholarship can reach up to 600 lei per month.
<p>
All types of scholarships require different types of documents to be submitted by students in a dossier, and after the evaluation process, the student finds out whether they will be on the list of scholarship recipients. For example, a merit scholarship requires a copy of the ID card, a copy of the student's transcript, and other documents that are already available at the high school, such as a copy of the birth certificate.
Each student receives a specific code for the documents they submit for a particular scholarship, which helps in the quick identification of the desired scholarship type. The secretariat can search for students much more quickly and easily based on this code.
For example, the code "CICNFM" is for a student applying for a merit scholarship.
</p>
<pre>
The main entities involved in the student management system are:
- The Student: Identified by:
  - Registration Number
  - Last Name
  - First Name
  - Personal Identification Number (CNP)
  - Other details such as address, phone number, overall grade, etc.
- The Administrator: Identified by:
  - An identifier received from the high school (authentication code, email, etc.)
  - Password
  - Role - What they are responsible for
- The Secretary: Identified by:
  - An identifier received from the high school (authentication code, email, etc.)
  - Password
  - Role - What they are responsible for
- The Type of Scholarship: Identified by:
  - Affiliated code
  - Set of rules for obtaining
  - Name
  - Required documents
  - Value
  - Duration
</pre>

## Interaction Module
<p>
The Administrator is the person responsible for managing students, modifying, altering, or deleting student data, as well as removing students from various systems, files, and lists that the high school maintains.
The Secretary is responsible for managing student records, financial records, creating various reports required by the educational institution, and organizing students into different categories (scholarship type, class, year of study, etc.).
The Student is the individual for whom documents and records are managed.
The Type of Scholarship represents the rules for approving scholarship applications, the duration of the scholarship, the value, and the eligible individuals for specific scholarships.
</p>
In addition to these main entities, there are some ancillary entities that play roles in categorizing students into multiple categories, such as:
<pre>
Classes:
 -Class Name
 -Start Year of the educational cycle
 -Specialization
 -Schedule
 -Specializations:
Name:
 -Duration
 -Subjects studied
 -Specification of the in-depth area
Profiles:
 -Name
 -General area of subjects studied
</pre>

## Code solution
<pre>
Application with a Java Swing interface for high school student management, data retrieval done in Java, SQL database.
Features:
- Adding new students to the system as scholarship or non-scholarship students.
- Modifying student data.
- Deleting students from the school's database.
- Searching for a student to analyze their data.
- Listing data from the database.
- Filtering data based on various fields in the database and displaying it.
- Generating graphs with data from various critical reports from different tables.
- Generating reports with essential information for the school.
- Maintaining an activity history in the database.
- Exporting reports in Excel format.
- Exporting tables in Excel format.
- Importing tables from Excel format.
- User authentication with field validation.
- Login and sign-out without closing the application.

Roles:
-Administrator:
  - Adding new students to the system as scholarship or non-scholarship students.
  - Modifying student data.
  - Deleting students from the school's database.
  - Listing data from the database.
  - Generating graphs with data from various critical reports from different tables.
  - Exporting tables in Excel format.
  - Analyzing the history of activities in the database.

-Secretary:
  - Searching for a student to analyze their data.
  - Listing data from the database.
  - Filtering data based on various fields in the database and displaying it.
  - Generating graphs with data from various critical reports from different tables.
  - Generating reports with essential information for the school.
  - Exporting reports in Excel format.
  - Importing student data from Excel format.

It includes essential features for data management, reporting, and user interaction.
</pre>
### Programing languages and technology used
<img align="left" width="40px" style="padding-right:10px" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original-wordmark.svg" /> 
<img align="left" width="40px" style="padding-right:10px" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/mysql/mysql-original-wordmark.svg" /> 
<img align="left" width="40px" style="padding-right:10px" src="https://github.com/AgacheAndrei/Database-Project-Java-Application-with-SQL./assets/36128809/a70ec2cd-1130-4719-ab97-0f7d0a67b843" /> 

<br>
<br>

<pre>
I used the JConnector driver to establish the connection between the Java program and the database.
  ->For saving files in .xlsx format, I used POI, XMLBEANS, LOG4J.
  ->For creating animations, I used TIMINGFRAMEWORK.
</pre>
<br>

### Data base - concept
![Picture1](https://github.com/AgacheAndrei/php-website-for-student-management/assets/36128809/38608ac0-f09d-4c72-a4c4-5cc636508c27)

### How to use it
#### The program opens with a login window where authorized individuals need to log in using their institutional email and password.
![Screenshot_20221224_040928](https://github.com/AgacheAndrei/Database-Project-Java-Application-with-SQL./assets/36128809/bae84836-dfae-4091-bc82-8735a6cd8436)
#### Access credentials of the authorized person.
![Screenshot_20221224_040953](https://github.com/AgacheAndrei/Database-Project-Java-Application-with-SQL./assets/36128809/30b1d755-163d-4a69-8114-8f694f2ed9e6)
#### Invalid access data, data validation is observed during authentication, the person must repeat the login operation.
![Screenshot_20221224_041252](https://github.com/AgacheAndrei/Database-Project-Java-Application-with-SQL./assets/36128809/c6816a2f-e1e5-4b17-acdd-feacf7630e36)
### Based on the authentication data used, the person, depending on their role as either an administrator or secretary, will see an interface that allows them to perform role-specific activities.
### View Administrator:
#### This person has access to 4 panels, and the data in them is modified in real-time.
![Screenshot_20221224_043004](https://github.com/AgacheAndrei/Database-Project-Java-Application-with-SQL./assets/36128809/83407333-fc66-43a8-a38c-4280a579cbac)
#### He can add a student by filling in the specific fields.
![Screenshot_20221224_043004](https://github.com/AgacheAndrei/Database-Project-Java-Application-with-SQL./assets/36128809/ec610e9c-9b3a-463b-8818-5fa71e11753d)
#### After clicking the add button, a pop-up appears to announce whether the insertion was successful in the database, meaning if the data met the validation requirements.
![Screenshot_20221224_043103](https://github.com/AgacheAndrei/Database-Project-Java-Application-with-SQL./assets/36128809/784a2e80-39b6-4393-a33b-cd1317ef623d)
#### The process of modifying a student also involves the same pop-up system to announce the outcome of the operation.
![Screenshot_20221224_043730](https://github.com/AgacheAndrei/Database-Project-Java-Application-with-SQL./assets/36128809/a0bcfbd1-9ea5-4ca2-82f9-f2a2c2c0ab0d)
#### Deletion - removing a student from the database, with a pop-up system to announce the outcome of the operation. Before deleting student 1188:
![Screenshot_20221224_044026](https://github.com/AgacheAndrei/Database-Project-Java-Application-with-SQL./assets/36128809/42c4727b-8ea5-40cd-bf85-3df9e4f1717e)
![Screenshot_20221224_044129](https://github.com/AgacheAndrei/Database-Project-Java-Application-with-SQL./assets/36128809/08b71e4e-23c6-4f55-bf71-8c2ebb7b42f6)
#### After
![Screenshot_20221224_044146](https://github.com/AgacheAndrei/Database-Project-Java-Application-with-SQL./assets/36128809/b0c67ae7-22a0-4f64-9c9c-0d4e89d17f7d)
#### Listing data from tables with scholarship recipients and the type of scholarships:
![Screenshot_20221224_044405](https://github.com/AgacheAndrei/Database-Project-Java-Application-with-SQL./assets/36128809/386d134c-8a0d-4e3c-bb30-2178a3d442a1)
#### Pie chart graphics with important data from tables.
![Screenshot_20221224_044631](https://github.com/AgacheAndrei/Database-Project-Java-Application-with-SQL./assets/36128809/b53c09f7-1a5b-4208-b4c1-333c32bdb4e6)
#### Real-time analysis of activities on the platform.
![Screenshot_20221224_044753](https://github.com/AgacheAndrei/Database-Project-Java-Application-with-SQL./assets/36128809/f1dff0ac-33ab-49d1-8872-68aac2dfabcc)
#### Saving the student table to an Excel file.
![Screenshot_20221224_045324](https://github.com/AgacheAndrei/Database-Project-Java-Application-with-SQL./assets/36128809/5b1d2d3c-7ce8-4add-b05e-5c54578218b7)
![Screenshot_20221224_045357](https://github.com/AgacheAndrei/Database-Project-Java-Application-with-SQL./assets/36128809/c9d12f73-c363-498c-96b1-1aa73e3b0972)
### View Secretary:
#### He has access to 3 panels, and the data in them is modified in real-time.
![Screenshot_20221224_045627](https://github.com/AgacheAndrei/Database-Project-Java-Application-with-SQL./assets/36128809/3f81bd21-f8f3-42d6-b505-e89ecaccf1ea)
#### He can filter student data based on multiple conditions such as class, minimum average in ascending or descending order, and whether they are scholarship recipients or not.
![Screenshot_20221224_050025](https://github.com/AgacheAndrei/Database-Project-Java-Application-with-SQL./assets/36128809/a2a21c9b-99c7-47c3-8fd0-4cd6bda20418)
#### Searching for a student by their registration number.
![Screenshot_20221224_050224](https://github.com/AgacheAndrei/Database-Project-Java-Application-with-SQL./assets/36128809/2607b55c-727f-4ba9-9401-45dbba3d6cb4)
#### Various types of reports are displayed in the reserved space, here are some examples of reports.
![Screenshot_20221224_050525](https://github.com/AgacheAndrei/Database-Project-Java-Application-with-SQL./assets/36128809/e7841763-6ca2-453b-b63e-55c38760b783)
![Screenshot_20221224_050601](https://github.com/AgacheAndrei/Database-Project-Java-Application-with-SQL./assets/36128809/fa83a11d-e953-4b20-bce3-14fae3daa741)
![Screenshot_20221224_050620](https://github.com/AgacheAndrei/Database-Project-Java-Application-with-SQL./assets/36128809/1d393537-222a-44c6-ad95-1caea81d26a4)
#### Saving the student table to an Excel file.
![Screenshot_20221224_050738](https://github.com/AgacheAndrei/Database-Project-Java-Application-with-SQL./assets/36128809/3f6f4586-7008-4811-9c58-f36ea0d850f4)
![Screenshot_20221224_050757](https://github.com/AgacheAndrei/Database-Project-Java-Application-with-SQL./assets/36128809/7992cf48-7d6c-41ed-811c-0c8545e032d4)
![Screenshot_20221224_050841](https://github.com/AgacheAndrei/Database-Project-Java-Application-with-SQL./assets/36128809/b7d69e46-1c70-48b7-831e-a6ec88d457cb)
#### Importing Extracted Data
![Screenshot_20230110_070535](https://github.com/AgacheAndrei/Database-Project-Java-Application-with-SQL./assets/36128809/07b17813-b6b6-4a83-8997-33536b961d00)
![Screenshot_20230110_070612](https://github.com/AgacheAndrei/Database-Project-Java-Application-with-SQL./assets/36128809/9061e3cf-46db-4cf6-8a6a-fede58cb4f32)
#### Listing data from tables with scholarship recipients and the type of scholarships.
![Screenshot_20221224_044959](https://github.com/AgacheAndrei/Database-Project-Java-Application-with-SQL./assets/36128809/cf7589f3-f1a6-446b-bbd9-c4bf26cb452e)
#### Pie chart graphics with important data from table
![Screenshot_20221224_045052](https://github.com/AgacheAndrei/Database-Project-Java-Application-with-SQL./assets/36128809/dc4d87c2-9b8e-43e9-b21e-9bc3ec253fb0)
