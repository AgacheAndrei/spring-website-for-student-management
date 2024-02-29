# Spring Boot Website
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
An website with Spring Boot for the backend, frontend created with Thymeleaf, HTML, CSS, Bootstrap and for the stoarege a SQL database.
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
<img align="left" width="40px" style="padding-right:10px" src="https://upload.wikimedia.org/wikipedia/commons/thumb/7/79/Spring_Boot.svg/768px-Spring_Boot.svg.png" /> 
<img align="left" width="40px" style="padding-right:10px" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/html5/html5-original-wordmark.svg" /> 
<img align="left" width="40px" style="padding-right:10px" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/css3/css3-original-wordmark.svg" /> 
<img align="left" width="40px" style="padding-right:10px" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/mysql/mysql-original-wordmark.svg" /> 
<img align="left" width="40px" style="padding-right:10px" src="https://github.com/AgacheAndrei/Database-Project-Java-Application-with-SQL./assets/36128809/a70ec2cd-1130-4719-ab97-0f7d0a67b843" /> 

<br>

### Admin -> Email: andrei@cuza.com, Password: admin
### Secretary -> Email: ana@cuza.com, Password: sec
<br>

### Data base - concept
![Picture1](https://github.com/AgacheAndrei/php-website-for-student-management/assets/36128809/38608ac0-f09d-4c72-a4c4-5cc636508c27)

### How to use it
#### The program opens with a login window where authorized individuals need to log in using their institutional email and password.
![image](https://github.com/AgacheAndrei/Database-Project-Java-Application-with-SQL./assets/36128809/4621c042-1ad6-4d19-9d36-7ec920726b37)
#### Access credentials of the authorized person.
![image](https://github.com/AgacheAndrei/Database-Project-Java-Application-with-SQL./assets/36128809/e27da42b-3b47-4068-b84f-94c1ff6eb0f5)
#### Invalid access data, data validation is observed during authentication, the person must repeat the login operation.
![image](https://github.com/AgacheAndrei/Database-Project-Java-Application-with-SQL./assets/36128809/34357c0a-a0bc-4550-a110-e622bb458213)
#### Register a new person
![image](https://github.com/AgacheAndrei/Database-Project-Java-Application-with-SQL./assets/36128809/00c83f2a-8006-4824-be6a-d7c97cc72106)
### Based on the authentication data used, the person, depending on their role as either an administrator or secretary, will see an interface that allows them to perform role-specific activities.
### View Administrator:
#### This person has access to all the panels, and the data in them is modified in real-time.
![image](https://github.com/AgacheAndrei/Database-Project-Java-Application-with-SQL./assets/36128809/99c19ae9-9d12-451a-a41e-a5b6500f9e22)
#### He can add a student by filling in the specific fields.
![image](https://github.com/AgacheAndrei/Database-Project-Java-Application-with-SQL./assets/36128809/5ed950bf-94b0-4e7d-9ea4-3beb9c427777)
#### The process of modifying a student.
![image](https://github.com/AgacheAndrei/Database-Project-Java-Application-with-SQL./assets/36128809/fd392758-39d9-4a91-baac-54f0d87e4561)
#### Deletion - removing a student from the database, with a pop-up system to announce the outcome of the operation. Before deleting student 1188:
![image](https://github.com/AgacheAndrei/Database-Project-Java-Application-with-SQL./assets/36128809/cab04e76-54db-425b-9869-502966dc0acd)
#### After
![image](https://github.com/AgacheAndrei/Database-Project-Java-Application-with-SQL./assets/36128809/be3d266d-1313-4736-bc05-3f860a5c51f5)
#### Listing data from tables with scholarship recipients and the type of scholarships:
![image](https://github.com/AgacheAndrei/Database-Project-Java-Application-with-SQL./assets/36128809/231bf47b-146c-4435-a8e3-472500d17eb7)
![image](https://github.com/AgacheAndrei/Database-Project-Java-Application-with-SQL./assets/36128809/e08cf5c3-b78f-4796-ac8c-e8e0a199564d)
#### Pie chart and Bar chart graphics with important data from tables.
![image](https://github.com/AgacheAndrei/Database-Project-Java-Application-with-SQL./assets/36128809/926a3806-82e8-4df7-93cb-34f067584a57)
#### Real-time analysis of activities on the platform.
![image](https://github.com/AgacheAndrei/Database-Project-Java-Application-with-SQL./assets/36128809/6d0fdd27-0b18-4015-9c22-c9af90ecec86)
#### Raport generating in Excel, PDF and the process of uploading
![image](https://github.com/AgacheAndrei/Database-Project-Java-Application-with-SQL./assets/36128809/b1aec124-8401-47cd-94a6-2516d34fe170)
![image](https://github.com/AgacheAndrei/Database-Project-Java-Application-with-SQL./assets/36128809/4ffad44a-c0f8-4bcb-86f1-4875dbdb0c1c)
![image](https://github.com/AgacheAndrei/Database-Project-Java-Application-with-SQL./assets/36128809/3a6b7aea-e3df-4932-9c63-77a324e4529a)
![image](https://github.com/AgacheAndrei/Database-Project-Java-Application-with-SQL./assets/36128809/dc233f0d-01fa-4eb2-b35e-28817d9acd4c)
![image](https://github.com/AgacheAndrei/Database-Project-Java-Application-with-SQL./assets/36128809/147ca1f7-f790-403f-b21c-47b982a47097)
![image](https://github.com/AgacheAndrei/Database-Project-Java-Application-with-SQL./assets/36128809/c16ce417-1ced-4b76-8546-c77ff5e7dbaf)
![image](https://github.com/AgacheAndrei/Database-Project-Java-Application-with-SQL./assets/36128809/e2917aef-6792-4b6a-852f-dd151a7a6e8e)
![image](https://github.com/AgacheAndrei/Database-Project-Java-Application-with-SQL./assets/36128809/a05e9efd-1a8f-48ea-85c2-fbf0c360c8c8)

### View Secretary:
#### He has access all the panels except analysis of activities. The data in them is modified in real-time.
![image](https://github.com/AgacheAndrei/Database-Project-Java-Application-with-SQL./assets/36128809/f9068f79-d043-4697-9416-b0bbcc3ed1ce)
#### He can filter student data based on multiple conditions such as class, minimum average in ascending or descending order, and whether they are scholarship recipients or not.
![image](https://github.com/AgacheAndrei/Database-Project-Java-Application-with-SQL./assets/36128809/4902c0f1-bd13-457b-a360-b9c36dd1e7e2)
#### Searching for a student by their registration number.
![image](https://github.com/AgacheAndrei/Database-Project-Java-Application-with-SQL./assets/36128809/ee0e48ac-c84f-430a-9962-3b4d1c116886)
#### Various types of reports are displayed in the reserved space, here are some examples of reports.
![image](https://github.com/AgacheAndrei/Database-Project-Java-Application-with-SQL./assets/36128809/2bfef416-c2f5-4e66-bc9f-d46501628622)
![image](https://github.com/AgacheAndrei/Database-Project-Java-Application-with-SQL./assets/36128809/c8867ad0-0c9f-4b29-9eb7-2237e67352aa)
#### And all the other admin activity
