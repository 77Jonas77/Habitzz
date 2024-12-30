-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2024-12-29 23:47:53.342

-- tables
-- Table: administrator
CREATE TABLE administrator (
                               id int  NOT NULL AUTO_INCREMENT,
                               data_utworzenia date  NOT NULL,
                               CONSTRAINT administrator_pk PRIMARY KEY (id)
);

-- Table: grupa
CREATE TABLE grupa (
                       id int  NOT NULL AUTO_INCREMENT,
                       menadzer_id int  NOT NULL,
                       nazwa_grupy nvarchar(50)  NOT NULL,
                       data_utworzenia date  NOT NULL,
                       opis nvarchar(200)  NULL,
                       CONSTRAINT grupa_pk PRIMARY KEY (id)
);

-- Table: jednostka_czasu
CREATE TABLE jednostka_czasu (
                                 id int  NOT NULL AUTO_INCREMENT,
                                 nazwa nvarchar(20)  NOT NULL,
                                 CONSTRAINT jednostka_czasu_pk PRIMARY KEY (id)
);

-- Table: menadzer
CREATE TABLE menadzer (
                          uzytkownik_id int  NOT NULL,
                          nazwa_firmy nvarchar(50)  NOT NULL,
                          CONSTRAINT menadzer_pk PRIMARY KEY (uzytkownik_id)
);

-- Table: nawyk
CREATE TABLE nawyk (
                       id int  NOT NULL AUTO_INCREMENT,
                       nazwa nvarchar(50)  NOT NULL,
                       czestotliwosc int  NOT NULL,
                       jednostka_czasu_id int  NOT NULL,
                       interwal int  NOT NULL,
                       opis varchar(100)  NULL,
                       CONSTRAINT nawyk_pk PRIMARY KEY (id)
);

-- Table: nawyk_grupa
CREATE TABLE nawyk_grupa (
                             nawyk_id int  NOT NULL,
                             grupa_id int  NOT NULL,
                             data_rozpoczecia date  NOT NULL,
                             data_zakonczenia date  NULL,
                             CONSTRAINT nawyk_grupa_pk PRIMARY KEY (nawyk_id,grupa_id)
);

-- Table: nawyk_uzytkownik
CREATE TABLE nawyk_uzytkownik (
                                  uzytkownik_id int  NOT NULL,
                                  nawyk_id int  NOT NULL,
                                  data_zakonczenia date  NULL,
                                  data_rozpoczecia date  NOT NULL,
                                  CONSTRAINT nawyk_uzytkownik_pk PRIMARY KEY (uzytkownik_id,nawyk_id)
);

-- Table: rola
CREATE TABLE rola (
                      id int  NOT NULL AUTO_INCREMENT,
                      nazwa nvarchar(30)  NOT NULL,
                      CONSTRAINT rola_pk PRIMARY KEY (id)
);

-- Table: uzytkownik
CREATE TABLE uzytkownik (
                            id int  NOT NULL AUTO_INCREMENT,
                            nazwa_uzytkownika nvarchar(50)  NOT NULL,
                            haslo nvarchar(50)  NOT NULL,
                            imie nvarchar(50)  NOT NULL,
                            nazwisko nvarchar(50)  NOT NULL,
                            data_urodzenia date  NOT NULL,
                            rola_id int  NOT NULL,
                            CONSTRAINT uzytkownik_pk PRIMARY KEY (id)
);

-- Table: uzytkownik_grupa
CREATE TABLE uzytkownik_grupa (
                                  uzytkownik_id int  NOT NULL,
                                  grupa_id int  NOT NULL,
                                  data_dolaczenia date  NOT NULL,
                                  nazwa_uzytkownika_w_grupie nvarchar(50)  NULL,
                                  CONSTRAINT uzytkownik_grupa_pk PRIMARY KEY (uzytkownik_id,grupa_id)
);

-- foreign keys
-- Reference: Administrator_Uzytkownik (table: administrator)
ALTER TABLE administrator ADD CONSTRAINT Administrator_Uzytkownik FOREIGN KEY Administrator_Uzytkownik (id)
    REFERENCES uzytkownik (id);

-- Reference: Grupa_Menadzer (table: grupa)
ALTER TABLE grupa ADD CONSTRAINT Grupa_Menadzer FOREIGN KEY Grupa_Menadzer (menadzer_id)
    REFERENCES menadzer (uzytkownik_id);

-- Reference: Menadzer_Uzytkownik (table: menadzer)
ALTER TABLE menadzer ADD CONSTRAINT Menadzer_Uzytkownik FOREIGN KEY Menadzer_Uzytkownik (uzytkownik_id)
    REFERENCES uzytkownik (id);

-- Reference: Nawyk_JednostkaCzasu (table: nawyk)
ALTER TABLE nawyk ADD CONSTRAINT Nawyk_JednostkaCzasu FOREIGN KEY Nawyk_JednostkaCzasu (jednostka_czasu_id)
    REFERENCES jednostka_czasu (id);

-- Reference: Przynaleznosc_Grupa (table: uzytkownik_grupa)
ALTER TABLE uzytkownik_grupa ADD CONSTRAINT Przynaleznosc_Grupa FOREIGN KEY Przynaleznosc_Grupa (grupa_id)
    REFERENCES grupa (id);

-- Reference: Przynaleznosc_Uzytkownik (table: uzytkownik_grupa)
ALTER TABLE uzytkownik_grupa ADD CONSTRAINT Przynaleznosc_Uzytkownik FOREIGN KEY Przynaleznosc_Uzytkownik (uzytkownik_id)
    REFERENCES uzytkownik (id);

-- Reference: Uzytkownik_Rola (table: uzytkownik)
ALTER TABLE uzytkownik ADD CONSTRAINT Uzytkownik_Rola FOREIGN KEY Uzytkownik_Rola (rola_id)
    REFERENCES rola (id);

-- Reference: nawykGrupa_grupa (table: nawyk_grupa)
ALTER TABLE nawyk_grupa ADD CONSTRAINT nawykGrupa_grupa FOREIGN KEY nawykGrupa_grupa (grupa_id)
    REFERENCES grupa (id);

-- Reference: nawykGrupa_nawyk (table: nawyk_grupa)
ALTER TABLE nawyk_grupa ADD CONSTRAINT nawykGrupa_nawyk FOREIGN KEY nawykGrupa_nawyk (nawyk_id)
    REFERENCES nawyk (id);

-- Reference: nawykUzytkownik_nawyk (table: nawyk_uzytkownik)
ALTER TABLE nawyk_uzytkownik ADD CONSTRAINT nawykUzytkownik_nawyk FOREIGN KEY nawykUzytkownik_nawyk (nawyk_id)
    REFERENCES nawyk (id);

-- Reference: nawykUzytkownik_uzytkownik (table: nawyk_uzytkownik)
ALTER TABLE nawyk_uzytkownik ADD CONSTRAINT nawykUzytkownik_uzytkownik FOREIGN KEY nawykUzytkownik_uzytkownik (uzytkownik_id)
    REFERENCES uzytkownik (id);

-- End of file.

