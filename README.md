# ProjectCalculator 
## Introduction
Final project on the 2. semester of the Computer Science education at KEA.

We had to create a project calculation tool with the ability to organize a hypothetical project and break it down into smaller pieces. 
The assignment was proposed by the company Alpha Solutions.
We were given the following requirements:

1. The tool should be able to break down a large project and categorize the pieces within different levels 
2. Within the lower levels, the tool should be able to handle the estimated work hours of the instances.
3. Furthermore, the tool should posses the capability of handling the restrictions of the projectpieces, specifically the dependencies between pieces.


Our application comply with all the requirements.

The business idea was to create a web based application wherein the user was able to create project, subprojects, tasks and subtasks. We wanted to implement a path-based organization that would give the user the optimal overview of each project branch.


## Structure
The `documents` folder contains all our design documents and diagram, and our assignment in the `Aflevering.ProjektKalkulation.pdf` file.

The program itself is located in the `ProjektKalkulation` directory.


## Run
1. Setup Database 
Run the content of `schema.sql` file in MySQL, to create the `AlphaSolutions` database.
Then run the content of `data.sql` file in MySQL, to create fill the database with test data.

2. Create application.properties
Navigate to `DateNRate/DateNRate/src/main/resources` and create a new file called `application.properties`.

Fill it with the following:
```
server.port=8081
user=[username]
password=[password]
url=jdbc:mysql://127.0.0.1:3306/AlphaSolutions?serverTimezone=UTC

```
Replace `[username]` and `[password]` with the username and password of the MySQL user you used to create the database.

3. Run the application
Open your IDE and open `ProjektkalkulationGit/ProjektKalkulation`
Then run the application.
 
Finally navigate to [localhost:8081](http://localhost:8081) to use the website.




## Contributors
[ThomasSimonsen20](https://github.com/ThomasSimonsen20)

[simonklejnstrup](https://github.com/simonklejnstrup)

[mikkelvase](https://github.com/mikkelvase)


