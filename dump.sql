--
-- PostgreSQL database dump
--

-- Dumped from database version 10.11
-- Dumped by pg_dump version 10.11

-- Started on 2020-02-21 14:19:03

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

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 201 (class 1259 OID 26091)
-- Name: topo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.topo (
    id bigint NOT NULL,
    date date,
    description text,
    etat character varying(255),
    lieux character varying(255),
    name character varying(255),
    user_id bigint NOT NULL
);


ALTER TABLE public.topo OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 26089)
-- Name: topo_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.topo ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.topo_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 2817 (class 0 OID 26091)
-- Dependencies: 201
-- Data for Name: topo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.topo (id, date, description, etat, lieux, name, user_id) FROM stdin;
1	2020-02-21	26135	DISPONIBLE	Sophia Antipolis	a	1
2	2020-02-21	26136	DISPONIBLE	cannes	a	1
3	2020-02-21	26137	DISPONIBLE	cannes	a	1
4	2020-02-21	26138	DISPONIBLE	cannes	b	1
5	2020-02-21	26139	DISPONIBLE	cannes	c	1
\.


--
-- TOC entry 2823 (class 0 OID 0)
-- Dependencies: 200
-- Name: topo_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.topo_id_seq', 5, true);


--
-- TOC entry 2693 (class 2606 OID 26098)
-- Name: topo topo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topo
    ADD CONSTRAINT topo_pkey PRIMARY KEY (id);


--
-- TOC entry 2694 (class 2606 OID 26124)
-- Name: topo fk5to68uy2v31lm71lj8s6m100u; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topo
    ADD CONSTRAINT fk5to68uy2v31lm71lj8s6m100u FOREIGN KEY (user_id) REFERENCES public.utilisateur(id);


-- Completed on 2020-02-21 14:19:04

--
-- PostgreSQL database dump complete
--

