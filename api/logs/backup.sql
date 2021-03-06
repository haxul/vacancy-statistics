--
-- PostgreSQL database dump
--

-- Dumped from database version 11.7 (Debian 11.7-2.pgdg90+1)
-- Dumped by pg_dump version 11.7 (Ubuntu 11.7-2.pgdg18.04+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

ALTER TABLE IF EXISTS ONLY public.traces DROP CONSTRAINT IF EXISTS traces_pkey;
ALTER TABLE IF EXISTS ONLY public.databasechangeloglock DROP CONSTRAINT IF EXISTS databasechangeloglock_pkey;
DROP TABLE IF EXISTS public.traces;
DROP TABLE IF EXISTS public.databasechangeloglock;
DROP TABLE IF EXISTS public.databasechangelog;
SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: databasechangelog; Type: TABLE; Schema: public; Owner: haxul
--

CREATE TABLE public.databasechangelog (
    id character varying(255) NOT NULL,
    author character varying(255) NOT NULL,
    filename character varying(255) NOT NULL,
    dateexecuted timestamp without time zone NOT NULL,
    orderexecuted integer NOT NULL,
    exectype character varying(10) NOT NULL,
    md5sum character varying(35),
    description character varying(255),
    comments character varying(255),
    tag character varying(255),
    liquibase character varying(20),
    contexts character varying(255),
    labels character varying(255),
    deployment_id character varying(10)
);


ALTER TABLE public.databasechangelog OWNER TO haxul;

--
-- Name: databasechangeloglock; Type: TABLE; Schema: public; Owner: haxul
--

CREATE TABLE public.databasechangeloglock (
    id integer NOT NULL,
    locked boolean NOT NULL,
    lockgranted timestamp without time zone,
    lockedby character varying(255)
);


ALTER TABLE public.databasechangeloglock OWNER TO haxul;

--
-- Name: traces; Type: TABLE; Schema: public; Owner: haxul
--

CREATE TABLE public.traces (
    id integer NOT NULL,
    date date DEFAULT '2020-04-25'::date,
    "position" character varying(100) NOT NULL,
    city character varying(100) NOT NULL,
    count integer NOT NULL
);


ALTER TABLE public.traces OWNER TO haxul;

--
-- Name: traces_id_seq; Type: SEQUENCE; Schema: public; Owner: haxul
--

ALTER TABLE public.traces ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.traces_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Data for Name: databasechangelog; Type: TABLE DATA; Schema: public; Owner: haxul
--

INSERT INTO public.databasechangelog VALUES ('init', 'haxul', 'db/changelog/logs/init.xml', '2020-04-25 17:12:14.805122', 1, 'EXECUTED', '8:ba38b57e8622533d52a59001964c08e1', 'createTable tableName=traces', '', NULL, '3.8.8', NULL, NULL, '7834734719');


--
-- Data for Name: databasechangeloglock; Type: TABLE DATA; Schema: public; Owner: haxul
--

INSERT INTO public.databasechangeloglock VALUES (1, false, NULL, NULL);


--
-- Data for Name: traces; Type: TABLE DATA; Schema: public; Owner: haxul
--

INSERT INTO public.traces VALUES (1, '2020-04-26', 'java', 'samara', 101);
INSERT INTO public.traces VALUES (2, '2020-04-26', 'java', 'saint_petersburg', 1005);
INSERT INTO public.traces VALUES (3, '2020-04-26', 'java', 'moscow', 2387);
INSERT INTO public.traces VALUES (4, '2020-04-26', 'python', 'samara', 67);
INSERT INTO public.traces VALUES (5, '2020-04-26', 'python', 'saint_petersburg', 908);
INSERT INTO public.traces VALUES (6, '2020-04-26', 'python', 'moscow', 2581);
INSERT INTO public.traces VALUES (7, '2020-04-26', 'javascript', 'samara', 101);
INSERT INTO public.traces VALUES (8, '2020-04-26', 'javascript', 'saint_petersburg', 954);
INSERT INTO public.traces VALUES (9, '2020-04-26', 'javascript', 'moscow', 2414);
INSERT INTO public.traces VALUES (10, '2020-04-27', 'java', 'samara', 101);
INSERT INTO public.traces VALUES (11, '2020-04-27', 'java', 'saint_petersburg', 993);
INSERT INTO public.traces VALUES (12, '2020-04-27', 'java', 'moscow', 2348);
INSERT INTO public.traces VALUES (13, '2020-04-27', 'python', 'samara', 67);
INSERT INTO public.traces VALUES (14, '2020-04-27', 'python', 'saint_petersburg', 887);
INSERT INTO public.traces VALUES (15, '2020-04-27', 'python', 'moscow', 2538);
INSERT INTO public.traces VALUES (16, '2020-04-27', 'javascript', 'samara', 94);
INSERT INTO public.traces VALUES (17, '2020-04-27', 'javascript', 'saint_petersburg', 933);
INSERT INTO public.traces VALUES (18, '2020-04-27', 'javascript', 'moscow', 2370);
INSERT INTO public.traces VALUES (19, '2020-04-28', 'java', 'samara', 101);
INSERT INTO public.traces VALUES (20, '2020-04-28', 'java', 'saint_petersburg', 1010);
INSERT INTO public.traces VALUES (21, '2020-04-28', 'java', 'moscow', 2412);
INSERT INTO public.traces VALUES (22, '2020-04-28', 'python', 'samara', 68);
INSERT INTO public.traces VALUES (23, '2020-04-28', 'python', 'saint_petersburg', 911);
INSERT INTO public.traces VALUES (24, '2020-04-28', 'python', 'moscow', 2562);
INSERT INTO public.traces VALUES (25, '2020-04-28', 'javascript', 'samara', 96);
INSERT INTO public.traces VALUES (26, '2020-04-28', 'javascript', 'saint_petersburg', 954);
INSERT INTO public.traces VALUES (27, '2020-04-28', 'javascript', 'moscow', 2412);
INSERT INTO public.traces VALUES (28, '2020-04-29', 'java', 'samara', 101);
INSERT INTO public.traces VALUES (29, '2020-04-29', 'java', 'saint_petersburg', 1004);
INSERT INTO public.traces VALUES (30, '2020-04-29', 'java', 'moscow', 2436);
INSERT INTO public.traces VALUES (31, '2020-04-29', 'python', 'samara', 72);
INSERT INTO public.traces VALUES (32, '2020-04-29', 'python', 'saint_petersburg', 920);
INSERT INTO public.traces VALUES (33, '2020-04-29', 'python', 'moscow', 2576);
INSERT INTO public.traces VALUES (34, '2020-04-29', 'javascript', 'samara', 98);
INSERT INTO public.traces VALUES (35, '2020-04-29', 'javascript', 'saint_petersburg', 970);
INSERT INTO public.traces VALUES (36, '2020-04-29', 'javascript', 'moscow', 2429);
INSERT INTO public.traces VALUES (37, '2020-04-30', 'java', 'samara', 87);
INSERT INTO public.traces VALUES (38, '2020-04-30', 'java', 'saint_petersburg', 995);
INSERT INTO public.traces VALUES (39, '2020-04-30', 'java', 'moscow', 2368);
INSERT INTO public.traces VALUES (40, '2020-04-30', 'python', 'samara', 69);
INSERT INTO public.traces VALUES (41, '2020-04-30', 'python', 'saint_petersburg', 898);
INSERT INTO public.traces VALUES (42, '2020-04-30', 'python', 'moscow', 2485);
INSERT INTO public.traces VALUES (43, '2020-04-30', 'javascript', 'samara', 94);
INSERT INTO public.traces VALUES (44, '2020-04-30', 'javascript', 'saint_petersburg', 942);
INSERT INTO public.traces VALUES (45, '2020-04-30', 'javascript', 'moscow', 2323);
INSERT INTO public.traces VALUES (46, '2020-04-30', 'product_manager', 'samara', 75);
INSERT INTO public.traces VALUES (47, '2020-04-30', 'product_manager', 'saint_petersburg', 673);
INSERT INTO public.traces VALUES (48, '2020-04-30', 'product_manager', 'moscow', 2479);
INSERT INTO public.traces VALUES (49, '2020-05-01', 'java', 'samara', 84);
INSERT INTO public.traces VALUES (50, '2020-05-01', 'java', 'saint_petersburg', 981);
INSERT INTO public.traces VALUES (51, '2020-05-01', 'java', 'moscow', 2313);
INSERT INTO public.traces VALUES (52, '2020-05-01', 'python', 'samara', 68);
INSERT INTO public.traces VALUES (53, '2020-05-01', 'python', 'saint_petersburg', 888);
INSERT INTO public.traces VALUES (54, '2020-05-01', 'python', 'moscow', 2453);
INSERT INTO public.traces VALUES (55, '2020-05-01', 'javascript', 'samara', 92);
INSERT INTO public.traces VALUES (56, '2020-05-01', 'javascript', 'saint_petersburg', 910);
INSERT INTO public.traces VALUES (57, '2020-05-01', 'javascript', 'moscow', 2255);
INSERT INTO public.traces VALUES (58, '2020-05-01', 'product_manager', 'samara', 73);
INSERT INTO public.traces VALUES (59, '2020-05-01', 'product_manager', 'saint_petersburg', 651);
INSERT INTO public.traces VALUES (60, '2020-05-01', 'product_manager', 'moscow', 2436);
INSERT INTO public.traces VALUES (61, '2020-05-02', 'java', 'samara', 80);
INSERT INTO public.traces VALUES (62, '2020-05-02', 'java', 'saint_petersburg', 957);
INSERT INTO public.traces VALUES (63, '2020-05-02', 'java', 'moscow', 2249);
INSERT INTO public.traces VALUES (64, '2020-05-02', 'python', 'samara', 65);
INSERT INTO public.traces VALUES (65, '2020-05-02', 'python', 'saint_petersburg', 870);
INSERT INTO public.traces VALUES (66, '2020-05-02', 'python', 'moscow', 2380);
INSERT INTO public.traces VALUES (67, '2020-05-02', 'javascript', 'samara', 88);
INSERT INTO public.traces VALUES (68, '2020-05-02', 'javascript', 'saint_petersburg', 880);
INSERT INTO public.traces VALUES (69, '2020-05-02', 'javascript', 'moscow', 2182);
INSERT INTO public.traces VALUES (70, '2020-05-02', 'product_manager', 'samara', 69);
INSERT INTO public.traces VALUES (71, '2020-05-02', 'product_manager', 'saint_petersburg', 629);
INSERT INTO public.traces VALUES (72, '2020-05-02', 'product_manager', 'moscow', 2365);


--
-- Name: traces_id_seq; Type: SEQUENCE SET; Schema: public; Owner: haxul
--

SELECT pg_catalog.setval('public.traces_id_seq', 72, true);


--
-- Name: databasechangeloglock databasechangeloglock_pkey; Type: CONSTRAINT; Schema: public; Owner: haxul
--

ALTER TABLE ONLY public.databasechangeloglock
    ADD CONSTRAINT databasechangeloglock_pkey PRIMARY KEY (id);


--
-- Name: traces traces_pkey; Type: CONSTRAINT; Schema: public; Owner: haxul
--

ALTER TABLE ONLY public.traces
    ADD CONSTRAINT traces_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

