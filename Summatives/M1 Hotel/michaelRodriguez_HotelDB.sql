DROP DATABASE IF EXISTS hotelDatabase;
CREATE DATABASE IF NOT EXISTS hotelDatabase; 

USE hotelDatabase; 

CREATE TABLE Contact ( 
ContactId INT PRIMARY KEY AUTO_INCREMENT, 
Address  VARCHAR(30) NOT NULL, 
City VARCHAR(30) NOT NULL, 
State CHAR(2) NOT NULL, 
Zip INT NOT NULL, 
Phone VARCHAR(16) NOT NULL
);

CREATE TABLE Guest ( 
GuestId INT PRIMARY KEY AUTO_INCREMENT, 
ContactId INT NOT NULL,
FOREIGN KEY fk_Guest_ContactId(ContactId)
REFERENCES Contact(ContactId),
FirstName VARCHAR(30) NOT NULL, 
LastName VARCHAR(30) NOT NULL
); 

CREATE TABLE Rooms ( 
RoomId INT PRIMARY KEY , 
roomType VARCHAR(30) NOT NULL, 
ADA BOOL NOT NULL DEFAULT 0, 
StandardOccupency TINYINT NOT NULL, 
MaxOccupency TINYINT NOT NULL, 
BaseCost DECIMAL(9,2) NOT NULL, 
ExtraGuest DECIMAL(9,2) NOT NULL
);

CREATE TABLE Reservations ( 
ReservationId INT PRIMARY KEY AUTO_INCREMENT, 
GuestId INT NOT NULL,
NumberOfAdults INT NOT NULL, 
NumberOfChildren INT NOT NULL, 
StartDate DATE NOT NULL, 
EndDate DATE NOT NULL, 
TotalCost DECIMAL(9,2) NOT NULL,
FOREIGN KEY fk_Reservations_GuestId(GuestId)
REFERENCES
Guest(GuestId)
); 

CREATE TABLE AmenityType ( 
AmenityTypeId INT PRIMARY KEY AUTO_INCREMENT, 
AmenityType VARCHAR(20) NOT NULL
); 
CREATE TABLE RoomAmenity (
RoomId INT NOT NULL,
AmenityTypeId INT NOT NULL,
PRIMARY KEY pk_RoomAmenity (RoomId,AmenityTypeId),
FOREIGN KEY fk_RoomAmenity_RoomId(RoomId) 
REFERENCES Rooms(RoomId), 
FOREIGN KEY fk_RoomAmenity_AmenityTypeId(AmenityTypeId) 
REFERENCES AmenityType(AmenityTypeId) 
); 

CREATE TABLE RoomReservation ( 
ReservationId INT NOT NULL, 
RoomId INT NOT NULL, 
PRIMARY KEY pk_RoomReservation(ReservationId,RoomId), 
FOREIGN KEY fk_RoomReservation_Rooms(RoomId)
REFERENCES Rooms(RoomId),
FOREIGN KEY fk_RoomReservation_Reservations(ReservationId)
REFERENCES Reservations(ReservationId)
); 










