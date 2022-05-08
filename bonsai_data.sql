--Populating the tables--


-----Accounts------
insert into account(accountEmail, accountPass,
	accountLastName, accountFirstName,accountAddress,
	accountPhone, accountAUIer)
values ('Y.Boubbou@aui.ma','younes_pass','Boubbou', 'Younes', 
		'162 Hay El Fath C.Y.M Rabat, Morocco', '+212652925439', true),
		
		('A.Ahenjir@aui.ma', 'amine_pass','Ahenjir', 'Amine', 
		 '211, bd Yacoub El Mansour Maârif, Grand Casablanca','+212668689348', true),
		 
		('S.Chamrah@aui.ma', 'soundous_pass','Chamrah', 'Soundous', 'avenue Mohammed V, 10010',
		 '+212666624080', true),
		 
		 ('Abmoula43@gmail.com', 'abdel_pass','Charki', 'Abdelmoula',
		 'av Hassan II, imm. Uniprix, Souss-Massa-Drâa', '+212523402575', false),
		 
		 ('Hassan93@hotmail.com', 'hassan_pass','Lekbir', 'Hassan', 
		  '  rue Amyot Inville, Arsalane, Grand Casablanca', '+212522620930', false);

------Employees------

insert into employee 
values  ('AA87976', 'El Moustaghfir', 'Sanae', 'Waiter', '0668689348', '35'),
		('AB67839', 'Fakir', 'Mohammed', 'Cook', '0678981967', '198'),
		('F206290', 'Bousfiha', 'Amine', 'Cook', '0652890628', '27'),
		('F32345', 'Bakhouri', 'Taha', 'Waiter', '0689761265', '85');

-----Suppliers-----

insert into supplier 
values
(01, 'XYZ', 'Mohammed Nahid', '0678982389'),
(02, 'ABC', 'Sara Bahida', '0662647378'),
(03, 'Best Rice', 'Abdellah Moungid', '0652925439');


------SupplyTransactions-------

insert into supplyTransaction
values
(01, '10 kg of salmon and other types of fish', '2021-11-27', '12:45', 625.99, 01),
(02, '5 kg of meat', '2021-12-12', '14:30', 500.00, 02),
(03, '20 kg of rice', '2021-12-18', '11:23', 895.12, 03);


------------- DISH ------------- 
INSERT INTO Dish (dishId, dishName, dishType, dishPrice, dishPopularity) VALUES
(001, 'Maki Concombre','LES MAKIS', 18, 2),
(002, 'Maki Avocat','LES MAKIS', 22, 3),
(003, 'Maki Surimi','LES MAKIS', 25, 3),
(004, 'Maki Saumon','LES MAKIS', 25, 4),
(005, 'Maki Crevette','LES MAKIS', 25, 4),
(006, 'Maki Crevette Panée','LES MAKIS', 28, 4),
(007, 'Maki Saumon Avocat','LES MAKIS', 28, 4),
(008, 'Maki Anguille','LES MAKIS)', 35, 2),
(009, 'Futomaki','LES MAKIS', 40, 4),
(010, 'Temaki Saumon', 'LES TEMAKI', 40, 3),
(011, 'Temaki Crevette', 'LES TEMAKI', 40, 5),
(012, 'Temaki Crabe', 'LES TEMAKI', 45, 4),
(013, 'Nems Nutella', 'LES NEMS JAPONAIS', 30, 5),
(014, 'Nems Fromage', 'LES NEMS JAPONAIS', 40, 4),
(015, 'Nems Poulet', 'LES NEMS JAPONAIS', 45, 5),
(016, 'Nems Crevettes', 'LES NEMS JAPONAIS', 55, 4),
(017, 'Riz Cantonais Nature', 'RIZ CANTONAIS', 15, 4),
(018, 'Riz Végétarien', 'RIZ CANTONAIS', 45, 3),
(019, 'Riz Poulet', 'RIZ CANTONAIS', 60, 3),
(020, 'Riz Bœuf', 'RIZ CANTONAIS', 60, 4),
(021, 'Riz Crevettes Calamars', 'RIZ CANTONAIS', 75, 5),
(022, 'Soupe Vietnamienne', 'LES SOUPES', 45, 4),
(023, 'Soupe Thai', 'LES SOUPES', 50, 3),
(024, 'Soupe Coco', 'LES SOUPES', 55, 2),
(025, 'Soupe Bonsai', 'LES SOUPES', 60, 5),
(026, 'Salade Vietnamienne', 'LES ENTRÉES', 55, 5),
(027, 'Salade de chef', 'LES ENTRÉES', 60, 5),
(028, 'Tartare saumon', 'LES ENTRÉES', 60, 4),
(029, 'Carpaccio', 'LES ENTRÉES', 60, 4),
(030, 'Chirashis', 'LES ENTRÉES', 65, 5),
(031, 'Riz Nature', 'LES ENTRÉES', 15, 2),
(032, 'Wok Végétarien', 'WOKS', 60, 5),
(033, 'Wok Poulet', 'WOKS', 70, 4),
(034, 'Wok Bœuf', 'WOKS', 80, 4),
(035, 'Wok Bonsai', 'WOKS', 90, 5),
(036, 'Curry Saumon', 'POISSONS', 80, 5),
(037, 'Curry Fruits de Mer', 'POISSONS', 90, 5),
(038, 'Filet de Saumon', 'POISSONS', 110, 3),
(039, 'Poulet Ananas', 'POULET', 70, 2),
(040, 'Poulet Basilic', 'POULET', 75, 5),
(041, 'Poulet Broccoli', 'POULET', 80, 4),
(042, 'Poulet Curry', 'POULET', 70, 5),
(043, 'Poulet Ananas', 'POULET', 70, 3),
(044, 'Eau Minerale', 'BOISSONS', 10, 5),
(045, 'Soda', 'BOISSONS', 15, 5),
(046, 'Nespresso', 'BOISSONS', 18, 5),
(047, 'Thé au Jasmin', 'BOISSONS', 20, 5),
(048, 'Jus de Gingembre', 'LES BOISSONS', 25, 5),
(049, 'Bonoffee pie', 'LES DESSERTS', 30, 4),
(050, 'Salade de fruits', 'LES DESSERTS', 30, 4),
(051, 'Panna cotta', 'LES DESSERTS', 30, 5),
(052, 'Fondant au chocolat', 'LES DESSERTS', 40, 4),
(053, 'Nigiri Saumon', 'LES NIGIRIS', 35, 5),
(054, 'Nigiri Crevette', 'LES NIGIRIS', 40, 3),
(055, 'Nigiri Angille', 'LES NIGIRIS', 45, 4),
(056, 'Sashimi Saumon', 'LES SASHIMIS', 45, 5),
(057, 'Sashimi Tataki', 'LES SASHIMIS', 50, 4),
(058, 'Spring Mango Eby', 'LES SPRING ROLLS', 65, 5),
(059, 'Black Spring Roll', 'LES SPRING ROLLS', 65, 4),
(060, 'Spring Roll Saumon', 'LES SPRING ROLLS', 60, 4),
(061, 'Spring Roll Crevette', 'LES SPRING ROLLS', 60, 4),
(062, 'Spring Mango Saumon Pané', 'LES SPRING ROLLS', 65, 5),
(063, 'Spring Mango Crevette Panée', 'LES SPRING ROLLS', 65, 5),
(064, 'White Sushi Cheese', 'SPECIAL ROLL', 55, 3),
(065, 'Black Tigre Roll', 'SPECIAL ROLL', 55, 4),
(066, 'Lollipop Sushi', 'SPECIAL ROLL', 60, 4),
(067, 'Purple Spring Roll', 'SPECIAL ROLL', 55, 4),
(068, 'Special Saumon Tataki', 'SPECIAL ROLL', 60, 4),
(069, 'Brochette Sushi', 'SPECIAL ROLL', 65, 3),
(070, 'Bonsai Touch', 'SPECIAL ROLL', 70, 5),
(071, 'Bœuf Basilic', 'BŒUFS', 75, 5),
(072, 'Bœuf Broccoli', 'BŒUFS', 80, 5),
(073, 'Bœuf Curry', 'BŒUFS', 70, 4),
(074, 'Filet de Bœuf', 'BŒUFS', 110, 5),
(075, 'Bœuf au Fromage', 'LES BROCHETTES', 55, 5),
(076, 'Bœuf au Fromage pané', 'LES BROCHETTES', 60, 4),
(077, 'Brochettes Poulet Sauce Cacahuète', 'LES BROCHETTES', 60, 5),
(078, 'Brochettes de Saumon', 'LES BROCHETTES', 70, 3),
(079, ' Maki, California, Fry (12 PC)', 'LES ASSORTIMENTS', 80, 5),
(080, ' Maki, California, Fry (24 PC)', 'LES ASSORTIMENTS', 140, 5),
(081, ' Maki, California, Fry (36 PC)', 'LES ASSORTIMENTS', 210, 5),
(082, ' Maki, California, Fry (62 PC)', 'LES ASSORTIMENTS', 320, 5),
(083, ' California, Spring Roll, Fry (12 PC)', 'LES ASSORTIMENTS', 110, 4),
(084, ' California, Spring Roll, Fry (24 PC)', 'LES ASSORTIMENTS', 190, 4),
(085, ' California, Spring Roll, Fry (36 PC)', 'LES ASSORTIMENTS', 270, 4),
(086, ' California, Spring Roll, Fry (62 PC)', 'LES ASSORTIMENTS', 420, 4),
(087, ' Special Roll, Spring Roll, Fry (12 PC)', 'LES ASSORTIMENTS', 150, 5),
(088, ' Special Roll, Spring Roll, Fry (24 PC)', 'LES ASSORTIMENTS', 250, 5),
(089, ' Special Roll, Spring Roll, Fry (36 PC)', 'LES ASSORTIMENTS', 330, 5),
(090, ' Special Roll, Spring Roll, Fry (62 PC)', 'LES ASSORTIMENTS', 550, 5);


------------- FoodOrder ------------- 
INSERT INTO FoodOrder VALUES
(0001, 'Sur Place', '2021-12-01', '12:00:22', '0666786578', 145, 0, 'AA87976', 01 ),
(0002, 'Sur Place', '2021-12-01', '13:00', '0668632218', 250, 0, 'AA87976', 02 ),
(0003, 'Emportée', '2021-12-02', '22:00', '0668009897', 350, 0, 'AB67839', 04 );

------------ OrderTransaction ------------- 
SELECT * from OrderTransaction;
INSERT INTO OrderTransaction (ordertranstime, ordertransdate) VALUES 
('12:01','2021-12-01'),
('13:01','2021-12-01'),
('22:01','2021-12-02');