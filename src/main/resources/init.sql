CREATE DATABASE caselab
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;

CREATE TABLE IF NOT EXISTS public.tb_file
(
    file_id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    title character varying(255) COLLATE pg_catalog."default" NOT NULL,
    creation_date timestamp with time zone NOT NULL,
    description text COLLATE pg_catalog."default",
    content bytea NOT NULL,
    CONSTRAINT file_id PRIMARY KEY (file_id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.tb_file
    OWNER to postgres;