-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2024-12-29 14:56:43.452
--

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
                       data_utworzenia date  NOT NULL,
                       opis varchar(200)  NULL,
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
                       data_rozpoczecia date  NOT NULL,
                       jednostkaczasu_id int  NOT NULL,
                       interwal int  NOT NULL,
                       opis varchar(100)  NULL,
                       CONSTRAINT nawyk_pk PRIMARY KEY (id)
);

-- Table: przynaleznosc
CREATE TABLE przynaleznosc (
                               uzytkownik_id int  NOT NULL,
                               grupa_id int  NOT NULL,
                               data_dolaczenia date  NOT NULL,
                               nazwa_uzytkownika_w_grupie nvarchar(50)  NULL,
                               CONSTRAINT przynaleznosc_pk PRIMARY KEY (uzytkownik_id,grupa_id)
);

-- Table: przypisanie_nawyku
CREATE TABLE przypisanie_nawyku (
                                    id int  NOT NULL AUTO_INCREMENT,
                                    nawyk_id int  NOT NULL,
                                    uzytkownik_id int  NULL,
                                    grupa_id int  NULL,
                                    CONSTRAINT przypisanie_nawyku_pk PRIMARY KEY (id)
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
                            haslo int  NOT NULL,
                            imie nvarchar(50)  NOT NULL,
                            nazwisko nvarchar(50)  NOT NULL,
                            data_urodzenia date  NOT NULL,
                            rola_id int  NOT NULL,
                            CONSTRAINT uzytkownik_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: administrator_uzytkownik (table: administrator)
ALTER TABLE administrator ADD CONSTRAINT administrator_uzytkownik FOREIGN KEY administrator_uzytkownik (id)
    REFERENCES uzytkownik (id);

-- Reference: grupa_menadzer (table: grupa)
ALTER TABLE grupa ADD CONSTRAINT grupa_menadzer FOREIGN KEY grupa_menadzer (menadzer_id)
    REFERENCES menadzer (uzytkownik_id);

-- Reference: menadzer_uzytkownik (table: menadzer)
ALTER TABLE menadzer ADD CONSTRAINT menadzer_uzytkownik FOREIGN KEY menadzer_uzytkownik (uzytkownik_id)
    REFERENCES uzytkownik (id);

-- Reference: nawyk_jednostkaczasu (table: nawyk)
ALTER TABLE nawyk ADD CONSTRAINT nawyk_jednostkaczasu FOREIGN KEY nawyk_jednostkaczasu (jednostkaczasu_id)
    REFERENCES jednostka_czasu (id);

-- Reference: przynaleznosc_grupa (table: przynaleznosc)
ALTER TABLE przynaleznosc ADD CONSTRAINT przynaleznosc_grupa FOREIGN KEY przynaleznosc_grupa (grupa_id)
    REFERENCES grupa (id);

-- Reference: przynaleznosc_uzytkownik (table: przynaleznosc)
ALTER TABLE przynaleznosc ADD CONSTRAINT przynaleznosc_uzytkownik FOREIGN KEY przynaleznosc_uzytkownik (uzytkownik_id)
    REFERENCES uzytkownik (id);

-- Reference: przypisannenawyku_grupa (table: przypisanie_nawyku)
ALTER TABLE przypisanie_nawyku ADD CONSTRAINT przypisannenawyku_grupa FOREIGN KEY przypisannenawyku_grupa (grupa_id)
    REFERENCES grupa (id);

-- Reference: przypisannenawyku_nawyku (table: przypisanie_nawyku)
ALTER TABLE przypisanie_nawyku ADD CONSTRAINT przypisannenawyku_nawyku FOREIGN KEY przypisannenawyku_nawyku (nawyk_id)
    REFERENCES nawyk (id);

-- Reference: przypisannenawyku_uzytkownik (table: przypisanie_nawyku)
ALTER TABLE przypisanie_nawyku ADD CONSTRAINT przypisannenawyku_uzytkownik FOREIGN KEY przypisannenawyku_uzytkownik (uzytkownik_id)
    REFERENCES uzytkownik (id);

-- Reference: uzytkownik_rola (table: uzytkownik)
ALTER TABLE uzytkownik ADD CONSTRAINT uzytkownik_rola FOREIGN KEY uzytkownik_rola (rola_id)
    REFERENCES rola (id);

-- GRANT ALL PRIVILEGES ON habitzzdb.* TO 'user'@'%' IDENTIFIED BY 'password';
-- FLUSH PRIVILEGES;

-- End of file.