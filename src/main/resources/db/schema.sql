-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2024-12-29 14:56:43.452
--

-- tables
-- Table: Administrator
CREATE TABLE Administrator (
                               id int  NOT NULL AUTO_INCREMENT,
                               data_utworzenia date  NOT NULL,
                               CONSTRAINT Administrator_pk PRIMARY KEY (id)
);

-- Table: Grupa
CREATE TABLE Grupa (
                       id int  NOT NULL AUTO_INCREMENT,
                       menadzer_id int  NOT NULL,
                       data_utworzenia date  NOT NULL,
                       opis varchar(200)  NULL,
                       CONSTRAINT Grupa_pk PRIMARY KEY (id)
);

-- Table: Jednostka_czasu
CREATE TABLE Jednostka_czasu (
                                 id int  NOT NULL AUTO_INCREMENT,
                                 nazwa nvarchar(20)  NOT NULL,
                                 CONSTRAINT Jednostka_czasu_pk PRIMARY KEY (id)
);

-- Table: Menadzer
CREATE TABLE Menadzer (
                          Uzytkownik_id int  NOT NULL,
                          nazwa_firmy nvarchar(50)  NOT NULL,
                          CONSTRAINT Menadzer_pk PRIMARY KEY (Uzytkownik_id)
);

-- Table: Nawyk
CREATE TABLE Nawyk (
                       id int  NOT NULL AUTO_INCREMENT,
                       nazwa nvarchar(50)  NOT NULL,
                       czestotliwosc int  NOT NULL,
                       data_rozpoczecia date  NOT NULL,
                       JednostkaCzasu_id int  NOT NULL,
                       interwal int  NOT NULL,
                       opis varchar(100)  NULL,
                       CONSTRAINT Nawyk_pk PRIMARY KEY (id)
);

-- Table: Przynaleznosc
CREATE TABLE Przynaleznosc (
                               Uzytkownik_id int  NOT NULL,
                               Grupa_id int  NOT NULL,
                               data_dolaczenia date  NOT NULL,
                               nazwa_uzytkownika_w_grupie nvarchar(50)  NULL,
                               CONSTRAINT Przynaleznosc_pk PRIMARY KEY (Uzytkownik_id,Grupa_id)
);

-- Table: Przypisanie_nawyku
CREATE TABLE Przypisanie_nawyku (
                                    id int  NOT NULL AUTO_INCREMENT,
                                    Nawyk_id int  NOT NULL,
                                    Uzytkownik_id int  NULL,
                                    Grupa_id int  NULL,
                                    CONSTRAINT Przypisanie_nawyku_pk PRIMARY KEY (id)
);

-- Table: Rola
CREATE TABLE Rola (
                      id int  NOT NULL AUTO_INCREMENT,
                      nazwa nvarchar(30)  NOT NULL,
                      CONSTRAINT Rola_pk PRIMARY KEY (id)
);

-- Table: Uzytkownik
CREATE TABLE Uzytkownik (
                            id int  NOT NULL AUTO_INCREMENT,
                            nazwa_uzytkownika nvarchar(50)  NOT NULL,
                            haslo int  NOT NULL,
                            imie nvarchar(50)  NOT NULL,
                            nazwisko nvarchar(50)  NOT NULL,
                            data_urodzenia date  NOT NULL,
                            Rola_id int  NOT NULL,
                            CONSTRAINT Uzytkownik_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: Administrator_Uzytkownik (table: Administrator)
ALTER TABLE Administrator ADD CONSTRAINT Administrator_Uzytkownik FOREIGN KEY Administrator_Uzytkownik (id)
    REFERENCES Uzytkownik (id);

-- Reference: Grupa_Menadzer (table: Grupa)
ALTER TABLE Grupa ADD CONSTRAINT Grupa_Menadzer FOREIGN KEY Grupa_Menadzer (menadzer_id)
    REFERENCES Menadzer (Uzytkownik_id);

-- Reference: Menadzer_Uzytkownik (table: Menadzer)
ALTER TABLE Menadzer ADD CONSTRAINT Menadzer_Uzytkownik FOREIGN KEY Menadzer_Uzytkownik (Uzytkownik_id)
    REFERENCES Uzytkownik (id);

-- Reference: Nawyk_JednostkaCzasu (table: Nawyk)
ALTER TABLE Nawyk ADD CONSTRAINT Nawyk_JednostkaCzasu FOREIGN KEY Nawyk_JednostkaCzasu (JednostkaCzasu_id)
    REFERENCES Jednostka_czasu (id);

-- Reference: Przynaleznosc_Grupa (table: Przynaleznosc)
ALTER TABLE Przynaleznosc ADD CONSTRAINT Przynaleznosc_Grupa FOREIGN KEY Przynaleznosc_Grupa (Grupa_id)
    REFERENCES Grupa (id);

-- Reference: Przynaleznosc_Uzytkownik (table: Przynaleznosc)
ALTER TABLE Przynaleznosc ADD CONSTRAINT Przynaleznosc_Uzytkownik FOREIGN KEY Przynaleznosc_Uzytkownik (Uzytkownik_id)
    REFERENCES Uzytkownik (id);

-- Reference: PrzypisanieNawyku_Grupa (table: Przypisanie_nawyku)
ALTER TABLE Przypisanie_nawyku ADD CONSTRAINT PrzypisanieNawyku_Grupa FOREIGN KEY PrzypisanieNawyku_Grupa (Grupa_id)
    REFERENCES Grupa (id);

-- Reference: PrzypisanieNawyku_Nawyk (table: Przypisanie_nawyku)
ALTER TABLE Przypisanie_nawyku ADD CONSTRAINT PrzypisanieNawyku_Nawyk FOREIGN KEY PrzypisanieNawyku_Nawyk (Nawyk_id)
    REFERENCES Nawyk (id);

-- Reference: PrzypisanieNawyku_Uzytkownik (table: Przypisanie_nawyku)
ALTER TABLE Przypisanie_nawyku ADD CONSTRAINT PrzypisanieNawyku_Uzytkownik FOREIGN KEY PrzypisanieNawyku_Uzytkownik (Uzytkownik_id)
    REFERENCES Uzytkownik (id);

-- Reference: Uzytkownik_Rola (table: Uzytkownik)
ALTER TABLE Uzytkownik ADD CONSTRAINT Uzytkownik_Rola FOREIGN KEY Uzytkownik_Rola (Rola_id)
    REFERENCES Rola (id);

-- GRANT ALL PRIVILEGES ON HabitzzDb.* TO 'user'@'%' IDENTIFIED BY 'password';
-- FLUSH PRIVILEGES;

-- End of file.

