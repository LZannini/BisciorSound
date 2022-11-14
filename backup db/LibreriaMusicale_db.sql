PGDMP         9            
    z            LibreriaMusicale_db    14.4    14.4 6    ;           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            <           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            =           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            >           1262    16394    LibreriaMusicale_db    DATABASE     q   CREATE DATABASE "LibreriaMusicale_db" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Italian_Italy.1252';
 %   DROP DATABASE "LibreriaMusicale_db";
                postgres    false            �            1255    33066    controllo_password()    FUNCTION     �  CREATE FUNCTION public.controllo_password() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
DECLARE
    pass_word utente.password%type;
BEGIN
	SELECT utente.password INTO pass_word
	FROM utente
	WHERE utente.password = NEW.password;

	IF(LENGTH(pass_word) < 6) THEN
	RAISE EXCEPTION 'La password deve contenere almeno 6 caratteri!'
		USING HINT = 'Inserisci una password più lunga.';
	END IF;
RETURN NULL;
END;

$$;
 +   DROP FUNCTION public.controllo_password();
       public          postgres    false            �            1255    33034    controllo_preferiti_cover()    FUNCTION     �  CREATE FUNCTION public.controllo_preferiti_cover() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
DECLARE 

BEGIN

IF EXISTS(
    SELECT *
    FROM preferiti_cover AS p1, preferiti_cover AS p2
    WHERE p1.id_utente = p2.id_utente AND p1.id_cover = p2.id_cover AND p1.id_preferito <> p2.id_preferito
)THEN
RAISE EXCEPTION 'La cover è già presente nei preferiti!';
END IF;

RETURN NULL;
END;

$$;
 2   DROP FUNCTION public.controllo_preferiti_cover();
       public          postgres    false            �            1255    33035    controllo_preferiti_traccia()    FUNCTION     �  CREATE FUNCTION public.controllo_preferiti_traccia() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
DECLARE 

BEGIN

IF EXISTS(
    SELECT *
    FROM preferiti_traccia AS p1, preferiti_traccia AS p2
    WHERE p1.id_utente = p2.id_utente AND p1.id_traccia = p2.id_traccia and p1.id_preferito <> p2.id_preferito
)THEN
RAISE EXCEPTION 'La traccia è già presente nei preferiti!';
END IF;

RETURN NULL;
END;

$$;
 4   DROP FUNCTION public.controllo_preferiti_traccia();
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
    artista character varying(32),
    anno_uscita integer NOT NULL
);
    DROP TABLE public.album;
       public         heap    postgres    false            �            1259    24844    ascolto_cover    TABLE     �   CREATE TABLE public.ascolto_cover (
    id_ascoltoc integer NOT NULL,
    id_utente integer NOT NULL,
    id_cover integer NOT NULL,
    num_ascolti integer DEFAULT 0,
    fascia_oraria character varying(16)
);
 !   DROP TABLE public.ascolto_cover;
       public         heap    postgres    false            �            1259    24797    ascolto_traccia    TABLE     �   CREATE TABLE public.ascolto_traccia (
    id_ascolto integer NOT NULL,
    id_utente integer NOT NULL,
    id_traccia integer NOT NULL,
    num_ascolti integer DEFAULT 0,
    fascia_oraria character varying(16)
);
 #   DROP TABLE public.ascolto_traccia;
       public         heap    postgres    false            �            1259    24598    cover    TABLE     &  CREATE TABLE public.cover (
    autore character varying(32) NOT NULL,
    anno_nascita integer NOT NULL,
    anno_rivisitazione integer NOT NULL,
    nome character varying(32) NOT NULL,
    album character varying(32),
    id_cover integer NOT NULL,
    traccia_originale integer NOT NULL
);
    DROP TABLE public.cover;
       public         heap    postgres    false            �            1259    24629    preferiti_cover    TABLE     �   CREATE TABLE public.preferiti_cover (
    id_utente integer NOT NULL,
    id_cover integer NOT NULL,
    id_preferito integer NOT NULL
);
 #   DROP TABLE public.preferiti_cover;
       public         heap    postgres    false            �            1259    33057     preferiti_cover_id_preferito_seq    SEQUENCE     �   ALTER TABLE public.preferiti_cover ALTER COLUMN id_preferito ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.preferiti_cover_id_preferito_seq
    START WITH 26
    INCREMENT BY 1
    MINVALUE 26
    MAXVALUE 100000
    CACHE 1
);
            public          postgres    false    215            �            1259    24607    preferiti_traccia    TABLE     �   CREATE TABLE public.preferiti_traccia (
    id_utente integer NOT NULL,
    id_traccia integer NOT NULL,
    id_preferito integer NOT NULL
);
 %   DROP TABLE public.preferiti_traccia;
       public         heap    postgres    false            �            1259    33062 "   preferiti_traccia_id_preferito_seq    SEQUENCE     �   ALTER TABLE public.preferiti_traccia ALTER COLUMN id_preferito ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.preferiti_traccia_id_preferito_seq
    START WITH 54
    INCREMENT BY 1
    MINVALUE 54
    MAXVALUE 100000
    CACHE 1
);
            public          postgres    false    213            �            1259    16401    traccia    TABLE     �   CREATE TABLE public.traccia (
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
    START WITH 20
    INCREMENT BY 1
    MINVALUE 20
    MAXVALUE 100000000
    CACHE 1
);
            public          postgres    false    211            .          0    16395    album 
   TABLE DATA           A   COPY public.album (nome_album, artista, anno_uscita) FROM stdin;
    public          postgres    false    209   UG       6          0    24844    ascolto_cover 
   TABLE DATA           e   COPY public.ascolto_cover (id_ascoltoc, id_utente, id_cover, num_ascolti, fascia_oraria) FROM stdin;
    public          postgres    false    217   �H       5          0    24797    ascolto_traccia 
   TABLE DATA           h   COPY public.ascolto_traccia (id_ascolto, id_utente, id_traccia, num_ascolti, fascia_oraria) FROM stdin;
    public          postgres    false    216   oI       1          0    24598    cover 
   TABLE DATA           s   COPY public.cover (autore, anno_nascita, anno_rivisitazione, nome, album, id_cover, traccia_originale) FROM stdin;
    public          postgres    false    212   @K       4          0    24629    preferiti_cover 
   TABLE DATA           L   COPY public.preferiti_cover (id_utente, id_cover, id_preferito) FROM stdin;
    public          postgres    false    215   PL       2          0    24607    preferiti_traccia 
   TABLE DATA           P   COPY public.preferiti_traccia (id_utente, id_traccia, id_preferito) FROM stdin;
    public          postgres    false    213   �L       /          0    16401    traccia 
   TABLE DATA           J   COPY public.traccia (id_track, autore, versione, nome, album) FROM stdin;
    public          postgres    false    210   �M       0          0    16404    utente 
   TABLE DATA           D   COPY public.utente (user_id, username, password, admin) FROM stdin;
    public          postgres    false    211   P       ?           0    0     preferiti_cover_id_preferito_seq    SEQUENCE SET     O   SELECT pg_catalog.setval('public.preferiti_cover_id_preferito_seq', 31, true);
          public          postgres    false    218            @           0    0 "   preferiti_traccia_id_preferito_seq    SEQUENCE SET     Q   SELECT pg_catalog.setval('public.preferiti_traccia_id_preferito_seq', 77, true);
          public          postgres    false    219            A           0    0    utente_user_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.utente_user_id_seq', 30, true);
          public          postgres    false    214            �           2606    16413    utente AUTO_INCREMENT 
   CONSTRAINT     Z   ALTER TABLE ONLY public.utente
    ADD CONSTRAINT "AUTO_INCREMENT" PRIMARY KEY (user_id);
 A   ALTER TABLE ONLY public.utente DROP CONSTRAINT "AUTO_INCREMENT";
       public            postgres    false    211            �           2606    16409    album album_pkey 
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
       public            postgres    false    216            �           2606    33025    utente conun 
   CONSTRAINT     K   ALTER TABLE ONLY public.utente
    ADD CONSTRAINT conun UNIQUE (username);
 6   ALTER TABLE ONLY public.utente DROP CONSTRAINT conun;
       public            postgres    false    211            �           2606    24628    cover cover_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.cover
    ADD CONSTRAINT cover_pkey PRIMARY KEY (id_cover);
 :   ALTER TABLE ONLY public.cover DROP CONSTRAINT cover_pkey;
       public            postgres    false    212            �           2606    33056 $   preferiti_cover preferiti_cover_pkey 
   CONSTRAINT     l   ALTER TABLE ONLY public.preferiti_cover
    ADD CONSTRAINT preferiti_cover_pkey PRIMARY KEY (id_preferito);
 N   ALTER TABLE ONLY public.preferiti_cover DROP CONSTRAINT preferiti_cover_pkey;
       public            postgres    false    215            �           2606    16411    traccia traccia_pkey 
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
       public            postgres    false    211            �           2620    33067    utente controlla_password    TRIGGER     {   CREATE TRIGGER controlla_password AFTER INSERT ON public.utente FOR EACH ROW EXECUTE FUNCTION public.controllo_password();
 2   DROP TRIGGER controlla_password ON public.utente;
       public          postgres    false    211    234            �           2620    33036 )   preferiti_cover controllo_preferiti_cover    TRIGGER     �   CREATE TRIGGER controllo_preferiti_cover AFTER INSERT ON public.preferiti_cover FOR EACH ROW EXECUTE FUNCTION public.controllo_preferiti_cover();
 B   DROP TRIGGER controllo_preferiti_cover ON public.preferiti_cover;
       public          postgres    false    215    221            �           2620    33037 -   preferiti_traccia controllo_preferiti_traccia    TRIGGER     �   CREATE TRIGGER controllo_preferiti_traccia AFTER INSERT ON public.preferiti_traccia FOR EACH ROW EXECUTE FUNCTION public.controllo_preferiti_traccia();
 F   DROP TRIGGER controllo_preferiti_traccia ON public.preferiti_traccia;
       public          postgres    false    213    225            �           2606    24854 )   ascolto_cover ascolto_cover_id_cover_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.ascolto_cover
    ADD CONSTRAINT ascolto_cover_id_cover_fkey FOREIGN KEY (id_cover) REFERENCES public.cover(id_cover);
 S   ALTER TABLE ONLY public.ascolto_cover DROP CONSTRAINT ascolto_cover_id_cover_fkey;
       public          postgres    false    3212    212    217            �           2606    24849 *   ascolto_cover ascolto_cover_id_utente_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.ascolto_cover
    ADD CONSTRAINT ascolto_cover_id_utente_fkey FOREIGN KEY (id_utente) REFERENCES public.utente(user_id);
 T   ALTER TABLE ONLY public.ascolto_cover DROP CONSTRAINT ascolto_cover_id_utente_fkey;
       public          postgres    false    217    3206    211            �           2606    24814 	   cover fk1    FK CONSTRAINT     z   ALTER TABLE ONLY public.cover
    ADD CONSTRAINT fk1 FOREIGN KEY (traccia_originale) REFERENCES public.traccia(id_track);
 3   ALTER TABLE ONLY public.cover DROP CONSTRAINT fk1;
       public          postgres    false    212    3204    210            �           2606    24819    ascolto_traccia fk1    FK CONSTRAINT     z   ALTER TABLE ONLY public.ascolto_traccia
    ADD CONSTRAINT fk1 FOREIGN KEY (id_utente) REFERENCES public.utente(user_id);
 =   ALTER TABLE ONLY public.ascolto_traccia DROP CONSTRAINT fk1;
       public          postgres    false    211    216    3206            �           2606    24824    ascolto_traccia fk2    FK CONSTRAINT     }   ALTER TABLE ONLY public.ascolto_traccia
    ADD CONSTRAINT fk2 FOREIGN KEY (id_traccia) REFERENCES public.traccia(id_track);
 =   ALTER TABLE ONLY public.ascolto_traccia DROP CONSTRAINT fk2;
       public          postgres    false    210    216    3204            �           2606    33019 	   cover fk2    FK CONSTRAINT     n   ALTER TABLE ONLY public.cover
    ADD CONSTRAINT fk2 FOREIGN KEY (album) REFERENCES public.album(nome_album);
 3   ALTER TABLE ONLY public.cover DROP CONSTRAINT fk2;
       public          postgres    false    209    212    3202            �           2606    24637 -   preferiti_cover preferiti_cover_id_cover_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.preferiti_cover
    ADD CONSTRAINT preferiti_cover_id_cover_fkey FOREIGN KEY (id_cover) REFERENCES public.cover(id_cover);
 W   ALTER TABLE ONLY public.preferiti_cover DROP CONSTRAINT preferiti_cover_id_cover_fkey;
       public          postgres    false    3212    215    212            �           2606    24632 .   preferiti_cover preferiti_cover_id_utente_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.preferiti_cover
    ADD CONSTRAINT preferiti_cover_id_utente_fkey FOREIGN KEY (id_utente) REFERENCES public.utente(user_id);
 X   ALTER TABLE ONLY public.preferiti_cover DROP CONSTRAINT preferiti_cover_id_utente_fkey;
       public          postgres    false    211    3206    215            �           2606    24615 +   preferiti_traccia preferiti_id_traccia_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.preferiti_traccia
    ADD CONSTRAINT preferiti_id_traccia_fkey FOREIGN KEY (id_traccia) REFERENCES public.traccia(id_track);
 U   ALTER TABLE ONLY public.preferiti_traccia DROP CONSTRAINT preferiti_id_traccia_fkey;
       public          postgres    false    213    210    3204            �           2606    24610 *   preferiti_traccia preferiti_id_utente_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.preferiti_traccia
    ADD CONSTRAINT preferiti_id_utente_fkey FOREIGN KEY (id_utente) REFERENCES public.utente(user_id);
 T   ALTER TABLE ONLY public.preferiti_traccia DROP CONSTRAINT preferiti_id_utente_fkey;
       public          postgres    false    3206    213    211            �           2606    16426    traccia traccia_album_fkey    FK CONSTRAINT        ALTER TABLE ONLY public.traccia
    ADD CONSTRAINT traccia_album_fkey FOREIGN KEY (album) REFERENCES public.album(nome_album);
 D   ALTER TABLE ONLY public.traccia DROP CONSTRAINT traccia_album_fkey;
       public          postgres    false    3202    210    209            .   A  x�]�Mn�0���)�@q �,�PPt�f��4�]9mz�n{.V[T����O�{o6<�,B�G��[s(쑌jr�ˢ!�-ܕ�Xx"s�E�e#��<�����^���l�}�p&��݉"�i�RE��\�fdC�{�zºt����9wZ�]�9Q���C�p.�#�ѷ�P�o���w$�k拰�]��3$n1�~g%Ū�?ƪ�L��c2�3CM��ގe����:�,;���?:�+��/b����`�Y�'cRG��)�#�x�]��zK�����b؁�M��"R�}W�0�R~ ���      6   �   x�mQ��0{�Sd��|w��?GI����x8&Ƨ��G�y=��-�˖8U%
�1�8���`��Bg$�	����L�L�e��U�F�Sd�blMl ��-E���L�|G��/��PV�Y(��Rtb�Y��7�������1��8=6o�Y��YJ��g7.��δ^� ��=ȼ��K)?[�      5   �  x�mTA�$!<[���"��[���X2��X������Zi��Zj�����S��!��Y�0�Owп�:<J��W�� ������1x�E$8��;���:�睝�Y$�l�8��@�=�Jd�';���gwfm��;��DO���Ya�r��&��Az��rn��#r����9�xc�c3��q�)��|^������;.'�[DG5��[aS��;Ƅ�Q��؜�{A�)�\Aen����I��LeG�Ýł���F7f�Ԡ.����Hc�܇2?�o��S���Nk��h��i���*eR�~���1�,g��
C?�.�{`�2��O��47�ˢJ��65���&��:eq6����36%Ie��-g��
����IK�ُ�o5h 0��I0�����ƤegIS�P���ƾ�A�kQsM]��I�6��e�׉�l!����"]E�w����y��wm      1      x�]�Mn�0���S���b�вD� *�����n�dB�:62�G�9z���?�Y��{�JM=��>�e 2^���ȶ��o���L�_�����RN�V�p��پ'�{g[�}�d�$2X�u�7���"���J�ap�lu�A�`ˠS���F8�op���T-�e=&w�q@��@�8p�ب}�1�'����]�S9��;v��d�a��BټuR5�F�	\��t�ed&�\��|!����������)e�} ��o�      4   o   x���0B�0L�|w��s�H�,b�P|���NL�Ų66��6.��ǝ�a8�g�vh{�ZԿ}�~*ݺTz���F��8��B�6�}�����P;ܨ�����G      2   �   x��э!��bN@`{y��qc$�c�`����q5K����j�8`�k2�bͩ��b>��s	�y�e2��H�~�����lYW�Z:�irna��*�6y
��yU�	��!2��J�z��3�-���+�2����=v���Op^Y��0W����Td��=KF������K�k}� � ��L�V� [��0oϸ�m�zL�o��� k�q���V��"��>�      /   ;  x�u�Mr�0���)�]��H����N&��Q���t�J�Ś"<��=M��9r�B�"��l4��xJa�=�hY���\Z�k
%�σ,����n`Xs�y�.�D��������²3'p��b��%\m�[v�6�3�G8�v��,��Ķdf-�`�2z�r�d��x��H�pY[ϵj��b�B	���
/*һȹ�5+�������_�Z ׺�6/��mӲ�oNa�-�	��Ι�L<>����ܺFR��x[kb�v�fq8d�'��>I����kz�¸�#��fŁ��l�vE���?�H{�4=�9�D�5��"�t+�I�;��V8��m
õ-��j?�RE��+�-��ޓ��Ռ����5$�D���|N�1�t�kqj8�ǵ֬���<�ORh�lM0���޼1��l����R�W��[ŕ`S���5��76>���(1�`O����&�8���7��l&K,9��N��&=��j�m>��n"��/B������J��oع.r]<��?^ǅ�P	�.!�+���v�s��*�]T�=���DA�ۑ1���V`      0   '  x�-��n�0����T��pm��rh��JhcY�`d;i����'��;;��Ȳ�0MY���
�yYL#@���	b�Vi*k��=�us����|F��ŚQyw�+������T`!��:X�F�3�ϐ&�$��:k��u�*��"�A�VE���TZ���G����R7@d"��%Zz�!�'�4Q�0*k_;I��F�<������K� �#-FsV�t�os�mBt��y0v"�I�o��EO�.�T�D�#��)p�]QVQ�1)�M`p�����
�#e(�%5�=X^)<�^���yK���`|�     