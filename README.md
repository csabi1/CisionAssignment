# Cision assignment project.
This assignment project, contains two enpoints:
    - Save palindrome request.
    - Find all saved requests.
## Installation
In order to try out the program, a postgres database 
must be provided, with the following table: 
```linux
create table palindrome (
	id serial4,
	content varchar(255),
	timestamp timestamp,
	longest_palindrome_size int	
);
```