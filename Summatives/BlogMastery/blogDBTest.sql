DROP DATABASE IF EXISTS blogTestDB;
CREATE DATABASE blogTestDB;
USE blogTestDB;

CREATE TABLE Users(
	userId int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    firstName VARCHAR(30) NOT NULL,
    lastName VARCHAR(30) NOT NULL,
    email VARCHAR(40)NOT NULL, 
    userName VARCHAR(50) NOT NULL,
    userPassword VARCHAR(50) NOT NULL,
    enabled BOOLEAN NOT NULL
); 

CREATE TABLE Roles( 
roleId INT PRIMARY KEY AUTO_INCREMENT NOT NULL, 
role VARCHAR(20)
);

CREATE TABLE UserRole ( 
userId INT, 
FOREIGN KEY fk_Users_userId(userId)
REFERENCES Users(userId), 
roleId INT,
FOREIGN KEY fk_Roles_roleId(roleId)
REFERENCES Roles(roleId)
);

CREATE TABLE HashTags(
	hashTagId int PRIMARY KEY auto_increment NOT NULL,
    hashTag VARCHAR(40) NOT NULL
);



CREATE TABLE Posts ( 
postId INT PRIMARY KEY auto_increment NOT NULL,
userId INT,
FOREIGN KEY fk_Users_userId(userId)
REFERENCES Users(userId), 
title VarChar(30) NOT NULL, 
published bool NOT NULL, 
postDate DATE NOT NULL,
timePosted DATE, 
timeExpiration DATE, 
timeScheduled DATE, 
usersPost VARCHAR(3000) NOT NULL,
imgUrl VARCHAR(200),
staticPageFlag bool NOT NULL
); 

CREATE TABLE Comments(
commentId INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
userId INT NOT NULL,
FOREIGN KEY fk_Users_userId(userId)
REFERENCES Users(userId),
postId INT NOT NULL,
FOREIGN KEY fk_Posts_postId(postId)
REFERENCES Posts(postId),
commentDate Date NOT NULL,
comment VARCHAR(255)
);

Create TABLE PostHashTags (
postId INT NOT NULL,
FOREIGN KEY fk_Posts_postId(postId)
REFERENCES Posts(postId),
hashTagId INT NOT NULL,
FOREIGN KEY fk_HashTags_hashTagId(hashTagId)
REFERENCES HashTags(hashTagId),
PRIMARY KEY(postId, hashTagId)
);
insert into Roles(roleId, role)
values(1,1);

insert into Users(userId,firstName,lastName,email,userName,userPassword,enabled)
    values(1,"Michael","Rodriguez","mr@michaelmail.com","admin", "password", true),
        (2,"user","userLastname","user@michaelmail.com","user","password");
insert into UserRole(userId,roleId)
    values(1,1),(1,2),(2,2);


Select * From Users;

Select * From Posts;
SELECT u.* FROM Users u 
JOIN Comments c ON u.userId = c.userId 
JOIN Posts p ON c.postId = p.postId
WHERE p.postId = 8;
        
	insert into `Users`(`userId`,`firstName`,`lastName`,`email`,`userName`,`userPassword`,`enabled`)
    values(1,"Michael","Rodriguez","mr@michaelmail.com","admin", "password", true),
        (2,"user","userLastname","user@michaelmail.com","user","password", true);


insert into `Roles`(`roleId`,`role`)
    values(1,"ROLE_ADMIN"), (2,"ROLE_USER");
    
insert into `UserRole`(`userId`,`roleId`)
    values(1,1),(1,2),(2,2);


