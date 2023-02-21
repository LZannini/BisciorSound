
--
-- Per aggiungere il DB basta creare un nuovo database su pg e usare il comando "Restore" con il file "BisciorSound.sql".
--

--
-- CREAZIONE TABELLA UTENTE
--

CREATE TABLE IF NOT EXISTS public.utente
(
    user_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 20 MINVALUE 20 MAXVALUE 100000000 CACHE 1 ),
    username character varying(32) COLLATE pg_catalog."default" NOT NULL,
    password character varying(20) COLLATE pg_catalog."default" NOT NULL,
    admin boolean NOT NULL DEFAULT false,
    CONSTRAINT "AUTO_INCREMENT" PRIMARY KEY (user_id),
    CONSTRAINT conun UNIQUE (username),
    CONSTRAINT utente_username_key UNIQUE (username)
)

-- Trigger: controllo_lunghezzapassword

-- DROP TRIGGER IF EXISTS controllo_lunghezzapassword ON public.utente;

CREATE TRIGGER controllo_lunghezzapassword
    AFTER INSERT
    ON public.utente
    FOR EACH ROW
    EXECUTE FUNCTION public.controllo_lunghezzapassword();

-- Trigger: controllo_sicurezzapassword

-- DROP TRIGGER IF EXISTS controllo_sicurezzapassword ON public.utente;

CREATE TRIGGER controllo_username
    AFTER INSERT
    ON public.utente
    FOR EACH ROW
    EXECUTE FUNCTION public.controllo_username();


--
-- CREAZIONE TABELLA TRACCIA
--


CREATE TABLE IF NOT EXISTS public.traccia
(
    id_track integer NOT NULL,
    autore character varying(32) COLLATE pg_catalog."default" NOT NULL,
    versione integer NOT NULL,
    nome character varying(32) COLLATE pg_catalog."default" NOT NULL,
    album character varying(32) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT traccia_pkey PRIMARY KEY (id_track),
    CONSTRAINT traccia_album_fkey FOREIGN KEY (album)
        REFERENCES public.album (nome_album) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

-- Trigger: controllo_anno_albumtraccia

-- DROP TRIGGER IF EXISTS controllo_anno_albumtraccia ON public.traccia;

CREATE TRIGGER controllo_anno_albumtraccia
    AFTER INSERT
    ON public.traccia
    FOR EACH ROW
    EXECUTE FUNCTION public.controllo_anno_albumtraccia();


--
-- CREAZIONE TABELLA ALBUM
--


CREATE TABLE IF NOT EXISTS public.album
(
    nome_album character varying(32) COLLATE pg_catalog."default" NOT NULL,
    artista character varying(32) COLLATE pg_catalog."default",
    anno_uscita integer NOT NULL,
    CONSTRAINT album_pkey PRIMARY KEY (nome_album)
)


--
-- CREAZIONE TABELLA COVER
--


CREATE TABLE IF NOT EXISTS public.cover
(
    autore character varying(32) COLLATE pg_catalog."default" NOT NULL,
    anno_nascita integer NOT NULL,
    anno_rivisitazione integer NOT NULL,
    nome character varying(32) COLLATE pg_catalog."default" NOT NULL,
    album character varying(32) COLLATE pg_catalog."default",
    id_cover integer NOT NULL,
    traccia_originale integer NOT NULL,
    CONSTRAINT cover_pkey PRIMARY KEY (id_cover),
    CONSTRAINT uni UNIQUE (anno_nascita),
    CONSTRAINT fk1 FOREIGN KEY (traccia_originale)
        REFERENCES public.traccia (id_track) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk2 FOREIGN KEY (album)
        REFERENCES public.album (nome_album) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

-- Trigger: controllo_autorecover

-- DROP TRIGGER IF EXISTS controllo_autorecover ON public.cover;

CREATE TRIGGER controllo_autorecover
    AFTER INSERT
    ON public.cover
    FOR EACH ROW
    EXECUTE FUNCTION public.controllo_autorecover();


--
-- CREAZIONE TABELLA PREFERITI_TRACCIA
--


CREATE TABLE IF NOT EXISTS public.preferiti_traccia
(
    id_utente integer NOT NULL,
    id_traccia integer NOT NULL,
    id_preferito integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 54 MINVALUE 54 MAXVALUE 100000 CACHE 1 ),
    CONSTRAINT preferiti_id_traccia_fkey FOREIGN KEY (id_traccia)
        REFERENCES public.traccia (id_track) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT preferiti_id_utente_fkey FOREIGN KEY (id_utente)
        REFERENCES public.utente (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

-- Trigger: controllo_preferiti_traccia

-- DROP TRIGGER IF EXISTS controllo_preferiti_traccia ON public.preferiti_traccia;

CREATE TRIGGER controllo_preferiti_traccia
    AFTER INSERT
    ON public.preferiti_traccia
    FOR EACH ROW
    EXECUTE FUNCTION public.controllo_preferiti_traccia();


--
-- CREAZIONE TABELLA PREFERITI_COVER
--


CREATE TABLE IF NOT EXISTS public.preferiti_cover
(
    id_utente integer NOT NULL,
    id_cover integer NOT NULL,
    id_preferito integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 26 MINVALUE 26 MAXVALUE 100000 CACHE 1 ),
    CONSTRAINT preferiti_cover_pkey PRIMARY KEY (id_preferito),
    CONSTRAINT preferiti_cover_id_cover_fkey FOREIGN KEY (id_cover)
        REFERENCES public.cover (id_cover) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT preferiti_cover_id_utente_fkey FOREIGN KEY (id_utente)
        REFERENCES public.utente (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

-- Trigger: controllo_preferiti_cover

-- DROP TRIGGER IF EXISTS controllo_preferiti_cover ON public.preferiti_cover;

CREATE TRIGGER controllo_preferiti_cover
    AFTER INSERT
    ON public.preferiti_cover
    FOR EACH ROW
    EXECUTE FUNCTION public.controllo_preferiti_cover();


--
-- CREAZIONE TABELLA ASCOLTO_TRACCIA
--


CREATE TABLE IF NOT EXISTS public.ascolto_traccia
(
    id_ascolto integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 75 MINVALUE 75 MAXVALUE 100000 CACHE 1 ),
    id_utente integer NOT NULL,
    id_traccia integer NOT NULL,
    num_ascolti integer DEFAULT 0,
    fascia_oraria character varying(16) COLLATE pg_catalog."default",
    CONSTRAINT ascolto_pkey PRIMARY KEY (id_ascolto),
    CONSTRAINT fk1 FOREIGN KEY (id_utente)
        REFERENCES public.utente (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk2 FOREIGN KEY (id_traccia)
        REFERENCES public.traccia (id_track) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)


--
-- CREAZIONE TABELLA ASCOLTO_COVER
--


CREATE TABLE IF NOT EXISTS public.ascolto_cover
(
    id_ascoltoc integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 25 MINVALUE 25 MAXVALUE 100000 CACHE 1 ),
    id_utente integer NOT NULL,
    id_cover integer NOT NULL,
    num_ascolti integer DEFAULT 0,
    fascia_oraria character varying(16) COLLATE pg_catalog."default",
    CONSTRAINT ascolto_cover_pkey PRIMARY KEY (id_ascoltoc),
    CONSTRAINT ascolto_cover_id_cover_fkey FOREIGN KEY (id_cover)
        REFERENCES public.cover (id_cover) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT ascolto_cover_id_utente_fkey FOREIGN KEY (id_utente)
        REFERENCES public.utente (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)



























