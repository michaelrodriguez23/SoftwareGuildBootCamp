INSERT INTO Contact (ContactId,Address,City, State, Zip , Phone) VALUES
    (1,'100 Pitt St','New York','NY','10002','(347) 988-0192'),
    (2,'379 Old Shore Street','Council Bluffs', 'IA', '51501', '(478)277-9632'),
    (3,'750 Wintergreen Dr','Wasilla','AK', '99654','(478) 277- 9632'),
    (4,'9662 Foxrun Lane','Harlingen','TX', '78552','(308) 494-0198'),
    (5,'9378 W. Augusta Ave.','West Deptford', 'NJ', '8096', '(214) 730-0298'), 
    (6,'762 Wild Rose Street','Saginaw', 'MI', '48601', '(377) 507-0974'), 
    (7,'7 Poplar Dr.', 'Arvada', 'CO', '80003', '(814) 485-2615'), 
    (8,'70 Oakwood St.',	'Zion',	'IL','60099', '(279) 491-0960'), 
    (9,'7556 Arrowhead St.', 'Cumberland', 'RI', '2864','(446) 396-6785'), 
    (10, '939 Linda Rd.', 'Oswego', 'NY', '13126', '(834) 727-1001'),
    (11,'939 Linda Rd.', 'Burke', 'VA', '22015','(446) 351-6860'), 
    (12,'87 Queen St.','Drexel Hill','PA',	'19026','(231) 893-2755');
   
    
    INSERT INTO Guest (contactId, firstName, lastName) VALUES
    (1, 'Michael', 'Rodriguez'), 
    (2, 'Mack',	'Simmer'), 
    (3, 'Bettyann','Seery'), 
    (4,'Duane',	'Cullison'), 
    (5, 'Karie' ,'Yang'),
    (6, 'Aurore','Lipton'),
    (7, 'Zachery','Luechtefeld'),
    (8, 'Jeremiah','Pendergrass'), 
    (9, 'Walter	', 'Holaway'), 
    (10, 'Wilfred',	'Vise'), 
    (11,'Maritza','Tilton'),
    (12, 'Joleen', 'Tison');
    
-- SELECT * 
-- FROM Guest 
-- WHERE contactId = 8;

DELETE FROM roomReservation
WHERE reservationID = 8;

 DELETE FROM Reservations 
 WHERE guestId = 8;
 
DELETE FROM Guest
WHERE contactId = 8; 

DELETE FROM Contact
WHERE contactId = 8; 

SELECT * 
FROM Contact 
WHERE contactID = 8;



INSERT INTO Reservations( guestId,numberOfAdults,numberOfChildren,startDate,endDate,totalCost) VALUES
    (1, 1, 1, '2023-03-17','2023-03-20', 199),
    (2, 1, 4,'2023-11-22', '2023-11-25', 430),
    (3, 2,1,'2023-02-05','2023-02-10',999.95),
    (4, 2,0,'2023-02-22','2023-02-24',349.98),
    (5, 2, 2,'2023-03-06', '2023-03-07',199.99),
    (6, 3,0,'2023-03-18','2023-03-23',924.95),
    (7, '2','2','2023-03-29','2023-03-31',349.98),
    (8, 2,0, '2023-03-31','2023-04-05',874.95), 
    (9,3,1,'2023-07-13','2023-07-14',184.99),
    (10,1,1,'2023-04-23','2023-04-24',174.99),
    (11,2,0,'2023-12-24','2023-12-28',699.96),
    (12,'2','0','2023-06-10','2023-06-14',599.96),
    (2,2,0,'2023-09-16','2023-09-17',149.99),
    (9,1,0,'2023-04-09','2023-04-13',799.96),
    (2,1,0,'2023-02-02','2023-02-04',299.98),
    (5,2,2,'2023-09-13','2023-09-15',399.98),
    (6,3,0,'2023-06-17','2023-06-18', 184.99),
    (9,1,0,'2023-04-09','2023-04-13',799.96),
    (10,4,2,'2023-07-18','2023-07-21',1259.97),
    (11,2,4,'2023-05-30','2023-06-02',1199.97),
    (12,1,0,'2023-06-10','2023-06-14',599.96),
    (1,2,0,'2023-06-28','2023-07-02',699.96);
    
  
INSERT INTO Rooms(roomId, roomType, ADA, StandardOccupency,maxOccupency,baseCost,extraGuest) VALUES
(201,'Double',0,2,4,200,10),
(202,'Double',1, 2,4,175,10),
(203,'Double',0,2,4,199.99,10),
(204,'Double',1,2,4,174.99,10),
(205,'Single',0,2,2,174.99, 0.00), 
(206,'Single',1,2,2,149.99,0.00),
(207,'Single',0,2,2,174.99,	0.00),
(208,'Single',1,2,2,149.99,0.00),
(301,'Double',0,2,4,199.99,	10),
(302,'Double',1,2,4, 174.99,10),
(303,'Double',0,2,4,199.99,10),
(304,'Double',1,2,4,174.99,10),
(305,'Single',0,2,2,174.99,0.00),
(306,'Single',1,2,2,149.99,0.00),
(307,'Single',0,2,2,174.99,0.00),
(308,'Single',1,2,2,149.99,0.00),
(401,'Suite',1,3,8,'399.99','20'),
(402,'Suite',1,3,8,399.99,20);
  SELECT * 
FROM Reservations ;

INSERT INTO AmenityType(AmenityTypeId,AmenityType) VALUES
(1,'Microwave'), 
(2,'Refridgerator'),
(3,'Jacuzzi'),
(4,'Oven'); 


INSERT INTO RoomReservation(ReservationId,RoomId) VALUES
(1,307),
(2,206),
(3,203),
(4,305),
(5,201),
(6,302),
(7,202),
(8,304),
(9,204),
(10,207),
(11,302),
(12,206),
(13,208),
(14,301),
(15,308),
(16,203),
(17,304),
(18,301),
(19,401),
(20,401),
(21,208),
(22,205); 
 

INSERT INTO RoomAmenity(RoomId,AmenityTypeId) VALUES
(201,1),
(201,3), 
(202,2),
(203,1),
(203,3),
(204,2),
(205,1),
(205,2),
(205,3),
(206,1),
(206,2),
(207,1),
(207,2),
(207,3),
(208,1),
(208,2),
(301,1),
(301,3),
(302,2),
(303,1),
(303,3),
(304,2),
(305,1),
(305,2),
(305,3),
(306,1),
(306,2),
(307,1),
(307,2),
(307,3),
(308,1),
(308,2),
(401,1),
(401,2),
(401,4),
(402,1),
(402,2);






	
    
	
    
	
	
    





