drop table if exists car;
drop table if exists _user;

CREATE TABLE public.car (
	mileage int4 NOT NULL,
	id varchar(36) NOT NULL,
	brand varchar(255) NOT NULL,
	color varchar(255) NOT NULL,
	model varchar(255) NOT NULL,
	production_year varchar(255) NOT NULL,
	registration_number varchar(255) NOT NULL,
	wheel_state varchar(255) NOT NULL,
	image oid NULL,
	CONSTRAINT car_pkey PRIMARY KEY (id),
	CONSTRAINT car_wheel_state_check CHECK (((wheel_state)::text = ANY ((ARRAY['GOOD'::character varying, 'MEDIUM'::character varying, 'BAD'::character varying])::text[])))
);

CREATE TABLE public."_user" (
                                id varchar(36) NOT NULL,
                                first_name varchar(255) NULL,
                                last_name varchar(255) NULL,
                                "password" varchar(255) NULL,
                                "role" varchar(255) NULL,
                                username varchar(255) NULL,
                                CONSTRAINT "_user_pkey" PRIMARY KEY (id),
                                CONSTRAINT "_user_role_check" CHECK (((role)::text = ANY ((ARRAY['DRIVER'::character varying, 'ADMIN'::character varying])::text[])))
);