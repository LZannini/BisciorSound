PGDMP         *            
    z            LibreriaMusicale_db    14.4    14.4 *    -           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            .           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            /           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            0           1262    16394    LibreriaMusicale_db    DATABASE     q   CREATE DATABASE "LibreriaMusicale_db" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Italian_Italy.1252';
 %   DROP DATABASE "LibreriaMusicale_db";
                postgres    false            �            1255    24794    checkusername()    FUNCTION     ,  CREATE FUNCTION public.checkusername() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
DECLARE
username VARCHAR(32);
username_admin VARCHAR(32);

BEGIN
	SELECT utente.username INTO username
	FROM utente
	WHERE utente.username = NEW.username AND utente.admin = 'false';

	SELECT utente.username INTO username_admin
	FROM utente
	WHERE utente.admin = 'true';
	
	IF(username = username_admin AND username IS NOT NULL) THEN
	RAISE EXCEPTION 'Errore! Username non disponibile.'
    USING HINT = 'Inserisci un nuovo nome utente.';
	END IF;
RETURN NULL;
END;

$$;
 &   DROP FUNCTION public.checkusername();
       public          postgres    false            �            1255    24791    mostra_tracce()    FUNCTION     �   CREATE FUNCTION public.mostra_tracce() RETURNS void
    LANGUAGE plpgsql
    AS $$
DECLARE             

track_name traccia.nome%TYPE;

BEGIN

	SELECT traccia.nome into track_name
	FROM traccia
	ORDER BY traccia.nome;
     
END;

$$;
 &   DROP FUNCTION public.mostra_tracce();
       public          postgres    false            �            1259    16395    album    TABLE     �   CREATE TABLE public.album (
    nome_album character varying(32) NOT NULL,
    artista character varying(32) NOT NULL,
    anno_uscita integer NOT NULL
);
    DROP TABLE public.album;
       public         heap    postgres    false            �            1259    24844    ascolto_cover    TABLE     �   CREATE TABLE public.ascolto_cover (
    id_ascoltoc integer NOT NULL,
    id_utente integer NOT NULL,
    id_cover integer NOT NULL,
    num_ascolti integer,
    fascia_oraria character varying(16)
);
 !   DROP TABLE public.ascolto_cover;
       public         heap    postgres    false            �            1259    24797    ascolto_traccia    TABLE     �   CREATE TABLE public.ascolto_traccia (
    id_ascolto integer NOT NULL,
    id_utente integer,
    id_traccia integer,
    num_ascolti integer DEFAULT 0,
    fascia_oraria character varying(16)
);
 #   DROP TABLE public.ascolto_traccia;
       public         heap    postgres    false            �            1259    24598    cover    TABLE     '  CREATE TABLE public.cover (
    autore character varying(32),
    anno_nascita integer NOT NULL,
    anno_rivisitazione integer NOT NULL,
    nome character varying(32) NOT NULL,
    album character varying(32),
    id_cover integer NOT NULL,
    traccia_originale integer DEFAULT 0 NOT NULL
);
    DROP TABLE public.cover;
       public         heap    postgres    false            �            1259    24607 	   preferiti    TABLE     c   CREATE TABLE public.preferiti (
    id_utente integer NOT NULL,
    id_traccia integer NOT NULL
);
    DROP TABLE public.preferiti;
       public         heap    postgres    false            �            1259    24629    preferiti_cover    TABLE     g   CREATE TABLE public.preferiti_cover (
    id_utente integer NOT NULL,
    id_cover integer NOT NULL
);
 #   DROP TABLE public.preferiti_cover;
       public         heap    postgres    false            �            1259    16401    traccia    TABLE     �   CREATE TABLE public.traccia (
    id_track integer NOT NULL,
    autore character varying(32) NOT NULL,
    versione integer NOT NULL,
    nome character varying(32) NOT NULL,
    album character varying(32) NOT NULL
);
    DROP TABLE public.traccia;
       public         heap    postgres    false            �            1259    16404    utente    TABLE     �   CREATE TABLE public.utente (
    user_id integer NOT NULL,
    username character varying(32) NOT NULL,
    password character varying(20) NOT NULL,
    admin boolean DEFAULT false NOT NULL
);
    DROP TABLE public.utente;
       public         heap    postgres    false            �            1259    24620    utente_user_id_seq    SEQUENCE     �   ALTER TABLE public.utente ALTER COLUMN user_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.utente_user_id_seq
    START WITH 17
    INCREMENT BY 1
    MINVALUE 17
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    211            "          0    16395    album 
   TABLE DATA           A   COPY public.album (nome_album, artista, anno_uscita) FROM stdin;
    public          postgres    false    209   �4       *          0    24844    ascolto_cover 
   TABLE DATA           e   COPY public.ascolto_cover (id_ascoltoc, id_utente, id_cover, num_ascolti, fascia_oraria) FROM stdin;
    public          postgres    false    217   Q6       )          0    24797    ascolto_traccia 
   TABLE DATA           h   COPY public.ascolto_traccia (id_ascolto, id_utente, id_traccia, num_ascolti, fascia_oraria) FROM stdin;
    public          postgres    false    216   7       %          0    24598    cover 
   TABLE DATA           s   COPY public.cover (autore, anno_nascita, anno_rivisitazione, nome, album, id_cover, traccia_originale) FROM stdin;
    public          postgres    false    212   �8       &          0    24607 	   preferiti 
   TABLE DATA           :   COPY public.preferiti (id_utente, id_traccia) FROM stdin;
    public          postgres    false    213   �9       (          0    24629    preferiti_cover 
   TABLE DATA           >   COPY public.preferiti_cover (id_utente, id_cover) FROM stdin;
    public          postgres    false    215   �:       #          0    16401    traccia 
   TABLE DATA           J   COPY public.traccia (id_track, autore, versione, nome, album) FROM stdin;
    public          postgres    false    210   �:       $          0    16404    utente 
   TABLE DATA           D   COPY public.utente (user_id, username, password, admin) FROM stdin;
    public          postgres    false    211   '=       1           0    0    utente_user_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.utente_user_id_seq', 43, true);
          public          postgres    false    214            �           2606    16413    utente AUTO_INCREMENT 
   CONSTRAINT     Z   ALTER TABLE ONLY public.utente
    ADD CONSTRAINT "AUTO_INCREMENT" PRIMARY KEY (user_id);
 A   ALTER TABLE ONLY public.utente DROP CONSTRAINT "AUTO_INCREMENT";
       public            postgres    false    211            ~           2606    16409    album album_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.album
    ADD CONSTRAINT album_pkey PRIMARY KEY (nome_album);
 :   ALTER TABLE ONLY public.album DROP CONSTRAINT album_pkey;
       public            postgres    false    209            �           2606    24848     ascolto_cover ascolto_cover_pkey 
   CONSTRAINT     g   ALTER TABLE ONLY public.ascolto_cover
    ADD CONSTRAINT ascolto_cover_pkey PRIMARY KEY (id_ascoltoc);
 J   ALTER TABLE ONLY public.ascolto_cover DROP CONSTRAINT ascolto_cover_pkey;
       public            postgres    false    217            �           2606    24802    ascolto_traccia ascolto_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.ascolto_traccia
    ADD CONSTRAINT ascolto_pkey PRIMARY KEY (id_ascolto);
 F   ALTER TABLE ONLY public.ascolto_traccia DROP CONSTRAINT ascolto_pkey;
       public            postgres    false    216            �           2606    24628    cover cover_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.cover
    ADD CONSTRAINT cover_pkey PRIMARY KEY (id_cover);
 :   ALTER TABLE ONLY public.cover DROP CONSTRAINT cover_pkey;
       public            postgres    false    212            �           2606    16411    traccia traccia_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.traccia
    ADD CONSTRAINT traccia_pkey PRIMARY KEY (id_track);
 >   ALTER TABLE ONLY public.traccia DROP CONSTRAINT traccia_pkey;
       public            postgres    false    210            �           2606    24604 	   cover uni 
   CONSTRAINT     L   ALTER TABLE ONLY public.cover
    ADD CONSTRAINT uni UNIQUE (anno_nascita);
 3   ALTER TABLE ONLY public.cover DROP CONSTRAINT uni;
       public            postgres    false    212            �           2606    16415    utente utente_username_key 
   CONSTRAINT     Y   ALTER TABLE ONLY public.utente
    ADD CONSTRAINT utente_username_key UNIQUE (username);
 D   ALTER TABLE ONLY public.utente DROP CONSTRAINT utente_username_key;
       public            postgres    false    211            �           2606    24854 )   ascolto_cover ascolto_cover_id_cover_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.ascolto_cover
    ADD CONSTRAINT ascolto_cover_id_cover_fkey FOREIGN KEY (id_cover) REFERENCES public.cover(id_cover);
 S   ALTER TABLE ONLY public.ascolto_cover DROP CONSTRAINT ascolto_cover_id_cover_fkey;
       public          postgres    false    217    3206    212            �           2606    24849 *   ascolto_cover ascolto_cover_id_utente_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.ascolto_cover
    ADD CONSTRAINT ascolto_cover_id_utente_fkey FOREIGN KEY (id_utente) REFERENCES public.utente(user_id);
 T   ALTER TABLE ONLY public.ascolto_cover DROP CONSTRAINT ascolto_cover_id_utente_fkey;
       public          postgres    false    3202    217    211            �           2606    24814 	   cover fk1    FK CONSTRAINT     z   ALTER TABLE ONLY public.cover
    ADD CONSTRAINT fk1 FOREIGN KEY (traccia_originale) REFERENCES public.traccia(id_track);
 3   ALTER TABLE ONLY public.cover DROP CONSTRAINT fk1;
       public          postgres    false    212    3200    210            �           2606    24819    ascolto_traccia fk1    FK CONSTRAINT     z   ALTER TABLE ONLY public.ascolto_traccia
    ADD CONSTRAINT fk1 FOREIGN KEY (id_utente) REFERENCES public.utente(user_id);
 =   ALTER TABLE ONLY public.ascolto_traccia DROP CONSTRAINT fk1;
       public          postgres    false    216    3202    211            �           2606    24824    ascolto_traccia fk2    FK CONSTRAINT     }   ALTER TABLE ONLY public.ascolto_traccia
    ADD CONSTRAINT fk2 FOREIGN KEY (id_traccia) REFERENCES public.traccia(id_track);
 =   ALTER TABLE ONLY public.ascolto_traccia DROP CONSTRAINT fk2;
       public          postgres    false    216    3200    210            �           2606    24637 -   preferiti_cover preferiti_cover_id_cover_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.preferiti_cover
    ADD CONSTRAINT preferiti_cover_id_cover_fkey FOREIGN KEY (id_cover) REFERENCES public.cover(id_cover);
 W   ALTER TABLE ONLY public.preferiti_cover DROP CONSTRAINT preferiti_cover_id_cover_fkey;
       public          postgres    false    215    3206    212            �           2606    24632 .   preferiti_cover preferiti_cover_id_utente_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.preferiti_cover
    ADD CONSTRAINT preferiti_cover_id_utente_fkey FOREIGN KEY (id_utente) REFERENCES public.utente(user_id);
 X   ALTER TABLE ONLY public.preferiti_cover DROP CONSTRAINT preferiti_cover_id_utente_fkey;
       public          postgres    false    211    215    3202            �           2606    24615 #   preferiti preferiti_id_traccia_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.preferiti
    ADD CONSTRAINT preferiti_id_traccia_fkey FOREIGN KEY (id_traccia) REFERENCES public.traccia(id_track);
 M   ALTER TABLE ONLY public.preferiti DROP CONSTRAINT preferiti_id_traccia_fkey;
       public          postgres    false    213    3200    210            �           2606    24610 "   preferiti preferiti_id_utente_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.preferiti
    ADD CONSTRAINT preferiti_id_utente_fkey FOREIGN KEY (id_utente) REFERENCES public.utente(user_id);
 L   ALTER TABLE ONLY public.preferiti DROP CONSTRAINT preferiti_id_utente_fkey;
       public          postgres    false    3202    211    213            �           2606    16426    traccia traccia_album_fkey    FK CONSTRAINT        ALTER TABLE ONLY public.traccia
    ADD CONSTRAINT traccia_album_fkey FOREIGN KEY (album) REFERENCES public.album(nome_album);
 D   ALTER TABLE ONLY public.traccia DROP CONSTRAINT traccia_album_fkey;
       public          postgres    false    209    210    3198            "   G  x�]��NA��3OQoz!�$r\@�� z�Rw+[wfj�Yt}�>/�l<���4��6�~��	��Ža
Պ��r�'#*]f:��@7%KP3O�`��ʒd�����v�oՂ]�����N�
9Rt�,;�QL��� r��-�=a]ʫ�{y��b�1lm�����~�ٙ�twp~/��^��XKk/OB��`��P�1�	U\���;ߐʏ\0�GsC��_�,PRL���Ϙ�(�K��q���!��u�C�C�p�P)
�y�:�t��@�K��C�����E-��"��dLC��1�=�XԶ�l�uz�zZ�/����      *   �   x�e��!����@�8��u��?Gm�Dҝ�p`����_���d����.z/e�������f��,�I���R�Æ��*�XEeW���a+P�kY<�<R
��*ܮV�vXc�P��B�n�2o4���.γ2�r�+OjL������!�����C@g����ICo��G�Pup���.�� p�X�      )   �  x�mT�q1{{�H� l���_G��!s���H�������<��$�����3����S���/P��hܐ?L���[a^o^��.�9�x�k~,�Gp��9"�n~��n܁�h�]��4�,0NF6Vi��^�
zí;����
n~Agv+K�	k�I͉�I����zPK�~r��5��?�s.Y�mKũum�H!w}`�F�DxH�Հ�lf�B��MFE�ӄՇ����ʕ�*v�(�����k..l�kU�g4��e�ϝ�;�r��N<ss9�/h������!��[_�P5E��|q��F�,&餙3rkM�Ś7&�������j�B)X$EPK��զ��H]��l��!w�����rLo<��������i���~��{�b�\z�4u��D�c;\�rsG��׌/H�n����J����z��      %     x�]�MN�0��ϧx�M�I��*�U�R���M7&y!�]�n%��9�v����|�M�i 㕱�g�D�KXX�[�u����^���+V?�j�dc���d��t�w����83���8�T����j
�L���eK-c}��aM�pĤ�f�҈�9��a �{g;�}��(9��{�[�5iMW*��}��-�ye�lm��h�0ȩF\�*O�<��~-P%����UϽ��OVg��NA�1�> �j.      &   �   x�5��0C�0L��.��>G��/RdlP�T,t����Ȋ����=,ɘ9B���ی�S9I�6nb�#�#�#/#7."�T����d���cx�zk�C����Ӄ� ��>���Z�hSt�kϰl�������#%      (   I   x�%���0��a�^4t��?G��>��B+]��Hs��yy>ζy�_��ӊ�!�#
Shj�ɆuX�'�?cj�      #   ;  x�u�Mr�0���)�]��H����N&��Q���t�J�Ś"<��=M��9r�B�"��l4��xJa�=�hY���\Z�k
%�σ,����n`Xs�y�.�D��������²3'p��b��%\m�[v�6�3�G8�v��,��Ķdf-�`�2z�r�d��x��H�pY[ϵj��b�B	���
/*һȹ�5+�������_�Z ׺�6/��mӲ�oNa�-�	��Ι�L<>����ܺFR��x[kb�v�fq8d�'��>I����kz�¸�#��fŁ��l�vE���?�H{�4=�9�D�5��"�t+�I�;��V8��m
õ-��j?�RE��+�-��ޓ��Ռ����5$�D���|N�1�t�kqj8�ǵ֬���<�ORh�lM0���޼1��l����R�W��[ŕ`S���5��76>���(1�`O����&�8���7��l&K,9��N��&=��j�m>��n"��/B������J��oع.r]<��?^ǅ�P	�.!�+���v�s��*�]T�=���DA�ۑ1���V`      $     x�-��n�0�ϓ����%�Vj/�C�z@���8�#۴���Co�ٝ�oJL����"�s�Y�w1�,�#�9jg�آ׆������^n��N(Z�=��m��=�!',�}�FkFyr�?���i�$��)��^��Z�S����N�+;���3�E�����a��cS���GL��v]���s�A�3?	+�����߼(N �/�H�`�{�����V�Ѻ�C4 d5�dV�'|d��Fv����UU�$�Ť��0u��k��t$X�b�5��%˲?&�u�     