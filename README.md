# parking-slot-rest-api
A microservice for managing a parking lot


Example DB inserts
------------------

CREATE TABLE public.tickets (
	ticket_id serial4 NOT NULL,
	vehicle_plate varchar(40) NOT NULL,
	color varchar(20) NOT NULL,
	vehicle_type varchar NOT NULL,
	CONSTRAINT tickets_pkey PRIMARY KEY (ticket_id),
	CONSTRAINT vehicle_plate_unique UNIQUE (vehicle_plate)
);
