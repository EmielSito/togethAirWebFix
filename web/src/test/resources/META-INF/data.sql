insert into user(id, email, password) values(1000, 'abc@def.com', '12345');
insert into user(id, email, password) values(2000, 'sara@home.net', '98745');
insert into user(id, email, password) values(3000, 'peg@java.com', '63542');

insert into airline(id, airlineId, airlineName) values(1000, 'KLM156', 'KLM');
insert into airline(id, airlineId, airlineName) values(2000, 'BR', 'BritishAir');
insert into airline(id, airlineId, airlineName) values(3000, 'TK', 'TurkishAirlines');

insert into location(id, airportCode, airportCountry, airportName, LocationId, region) values(1000, 'zvm', 'Belgium', 'Zaventem', 'bez', 'EASTERNAFRICA');
insert into location(id, airportCode, airportCountry, airportName, LocationId, region) values(2000, 'ikia', 'Iran', 'Imam Khomeini', 'teh', 'WESTERNASIA');
insert into location(id, airportCode, airportCountry, airportName, LocationId, region) values(3000, 'sch', 'Netherlands', 'Schiphol', 'ams', 'NORTHERNEUROPE');

insert into flight(id, flightNumber, airline_id, departure_id, destination_id) values(1000, 'kl568', 1000, 1000, 2000);
insert into flight(id, flightNumber, airline_id, departure_id, destination_id) values(2000, 'tk4587', 2000, 2000, 3000);
insert into flight(id, flightNumber, airline_id, departure_id, destination_id) values(3000, 'tk8475', 2000, 1000, 2000);

insert into volumediscount(id, numberOfTickets, percent, plane_id) values(1000, 5, 2, 1000);
insert into volumediscount(id, numberOfTickets, percent, plane_id) values(2000, 5, 2, 2000);
insert into volumediscount(id, numberOfTickets, percent, plane_id) values(3000, 10, 5, 1000);


insert into plane(id, arrivalDate, departureDate, planeNumber, flight_id) values(1000, '2018-10-15 13:00:00','2018-10-15 11:00:00', 'testPlane111', 1000);
insert into plane(id, arrivalDate, departureDate, planeNumber, flight_id) values(2000, '2017-12-04 22:30:00','2017-12-04 20:30:00', 'testPlane222', 1000);
insert into plane(id, arrivalDate, departureDate, planeNumber, flight_id) values(3000, '2018-02-01 11:00:00','2018-02-01 08:00:00', 'testPlane333', 2000);

insert into seat(id, seatNumber, basePrice, classType, isAvailable, plane_id) values(1000, '1a', 1200, 'BUSINESS', true, 1000);
insert into seat(id, seatNumber, basePrice, classType, isAvailable, plane_id) values(4000, '1d', 1200, 'BUSINESS',true, 1000);
insert into seat(id, seatNumber, basePrice, classType, isAvailable, plane_id) values(5000, '1a', 800, 'ECONOMY',true,  2000);
insert into seat(id, seatNumber, basePrice, classType, isAvailable, plane_id) values(6000, '2b', 800, 'ECONOMY',true,  2000);
insert into seat(id, seatNumber, basePrice, classType, isAvailable, plane_id) values(3000, '20f', 650, 'ECONOMY',true,  3000);

insert into booking(id, bookingDate, payWithCreditCard, payment_id, user_id) values(1000, '2017-11-14', true, 1000, 1000);

insert into payment(id, isPaid, paymentMethod) values(1000, TRUE , 'CREDITCARD');














