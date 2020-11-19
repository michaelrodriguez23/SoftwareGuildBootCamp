USE hotelDatabase; 
-- 1. Write a query that returns a list of reservations that end in July 2023, 
-- including the name of the guest, the room number(s), and the reservation dates.

SELECT
Guest.firstName,
Guest.LastName,
Reservations.GuestId,
RoomReservation.RoomId,
 Reservations.StartDate,
 Reservations.EndDate

FROM Reservations
INNER JOIN Guest ON Reservations.GuestID = Guest.GuestId 
INNER JOIN RoomReservation ON Reservations.ReservationId = RoomReservation.ReservationId
WHERE EndDate BETWEEN "2023-07-01"  AND "2023-07-31"
ORDER BY StartDate, GuestId;  

-- 3 Rows Returned

-- 2. Write a query that returns a list of all reservations for rooms with a jacuzzi,
-- displaying the guest's name, the room number, and the dates of the reservation.
SELECT 
Guest.firstName,
Guest.LastName,
Contact.ContactId,
RoomReservation.RoomId,
Reservations.StartDate,
Reservations.EndDate,
AmenityType.AmenityType

FROM 
RoomAmenity 
INNER JOIN RoomReservation ON RoomAmenity.RoomId = RoomReservation.RoomId 
INNER JOIN Reservations ON RoomReservation.ReservationId = Reservations.ReservationId
INNER JOIN Guest ON Guest.GuestId = Reservations.GuestId
INNER JOIN Contact ON Contact.ContactId = Guest.ContactId 
INNER JOIN AmenityType ON AmenityType.AmenityTypeId = RoomAmenity.AmenityTypeId

WHERE roomAmenity.AmenityTypeId = 3; 

-- Return 9 Rows
 
-- 3.Write a query that returns all the rooms reserved for a specific guest, including the guest's name, the room(s) reserved,
-- the starting date of the reservation, and how many people were included in the reservation. (Choose a guest's name from the existing data.)
SELECT 
CONCAT (Guest.firstName , Guest.LastName ) AS 'Name',
RoomReservation.RoomId 'Room Id' , 
(NumberOfAdults + NumberOfChildren) AS 'total Guest' ,
StartDate 'Start Date',
EndDate 'End Date'

FROM Reservations
INNER JOIN Guest ON Guest.GuestId = Reservations.GuestId
INNER JOIN RoomReservation ON RoomReservation.ReservationId = Reservations.ReservationId
WHERE firstName = 'Michael'; 
-- Returns 2 results
-- I have 2 total  Reservations

-- 4. Write a query that returns a list of rooms, reservation ID, and per-room cost for each reservation. 
-- The results should include all rooms, whether or not there is a reservation associated with the room. 

SELECT 
Rooms.RoomId,
RoomReservation.ReservationId,
Rooms.baseCost
FROM Rooms -- left table 
LEFT JOIN RoomReservation ON RoomReservation.RoomId = Rooms.RoomId ; -- right table

-- Returns 23 Rows 

-- 5. Write a query that returns all the rooms accommodating at least three guests and that are reserved on any date in April 2023.
SELECT *, 
sum(NumberOfAdults + NumberOfChildren) AS totalGuest -- Sum of guest
FROM Reservations
WHERE
StartDate BETWEEN "2023-04-01" AND "2023-04-30" 
OR EndDate BETWEEN "2023-04-01" AND "2023-04-30"
GROUP BY ReservationId  
HAVING sum(NumberOfAdults + NumberOfChildren) >= 3 ; 
-- Return 0 Guest, There aren't any guest who have a totalGuest min of 3, and have Have any reservations in April

-- 6. Write a query that returns a list of all guest names and the number of reservations per guest, 
-- sorted starting with the guest with the most reservations and then by the guest's last name.
SELECT   
COUNT(ReservationId) 'Total Resertvations',
Guest.FirstName ,
Guest.LastName 
FROM GUEST
INNER JOIN Contact ON Guest.ContactId = Contact.ContactId
INNER JOIN Reservations ON Guest.GuestId = Reservations.GuestId
GROUP BY Guest.GuestId
ORDER BY COUNT(ReservationId) DESC, Guest.LastName; -- Descending

-- Reutrns 11 Rows 

-- 7. Write a query that displays the name, address, and phone number of a guest based on their phone number. (
-- Choose a phone number from the existing data.)

SELECT 
Guest.firstName, 
Guest.LastName, 
Contact.Address,
Contact.Phone
FROM Contact
INNER JOIN Guest on Contact.ContactId = Guest.ContactId
WHERE Phone = '(347) 988-0192'; 

-- 1 Row Returned



