-- Inserting data into 'Rola' table
INSERT INTO Rola (nazwa) VALUES ('Administrator');
INSERT INTO Rola (nazwa) VALUES ('Menadżer');
INSERT INTO Rola (nazwa) VALUES ('Użytkownik');

-- Inserting data into 'Jednostka_czasu' table
INSERT INTO Jednostka_czasu (nazwa) VALUES ('Dzień');
INSERT INTO Jednostka_czasu (nazwa) VALUES ('Tydzień');
INSERT INTO Jednostka_czasu (nazwa) VALUES ('Miesiąc');

-- Inserting data into 'Uzytkownik' table
INSERT INTO Uzytkownik (nazwa_uzytkownika, haslo, imie, nazwisko, data_urodzenia, Rola_id)
VALUES ('admin', 123456, 'Jan', 'Kowalski', '1980-01-01', 1);
INSERT INTO Uzytkownik (nazwa_uzytkownika, haslo, imie, nazwisko, data_urodzenia, Rola_id)
VALUES ('mjackson', 234567, 'Michael', 'Jackson', '1990-02-02', 2);
INSERT INTO Uzytkownik (nazwa_uzytkownika, haslo, imie, nazwisko, data_urodzenia, Rola_id)
VALUES ('awilliams', 345678, 'Anna', 'Williams', '1995-03-15', 3);

-- Inserting data into 'Administrator' table
INSERT INTO Administrator (data_utworzenia)
VALUES ('2024-12-29');

-- Inserting data into 'Menadzer' table
INSERT INTO Menadzer (Uzytkownik_id, nazwa_firmy)
VALUES (2, 'TechCorp');

-- Inserting data into 'Grupa' table
INSERT INTO Grupa (menadzer_id, data_utworzenia, opis)
VALUES (2, '2024-12-29', 'Grupa zarządzająca projektem');
INSERT INTO Grupa (menadzer_id, data_utworzenia, opis)
VALUES (2, '2024-12-29', 'Grupa testująca');

-- Inserting data into 'Przynaleznosc' table
INSERT INTO Przynaleznosc (Uzytkownik_id, Grupa_id, data_dolaczenia, nazwa_uzytkownika_w_grupie)
VALUES (3, 1, '2024-12-29', 'Anna Williams - Grupa zarządzająca');
INSERT INTO Przynaleznosc (Uzytkownik_id, Grupa_id, data_dolaczenia, nazwa_uzytkownika_w_grupie)
VALUES (1, 2, '2024-12-29', 'Jan Kowalski - Grupa testująca');

-- Inserting data into 'Nawyk' table
INSERT INTO Nawyk (nazwa, czestotliwosc, data_rozpoczecia, JednostkaCzasu_id, interwal, opis)
VALUES ('Ćwiczenia fizyczne', 3, '2024-12-29', 1, 7, 'Ćwiczenia fizyczne 3 razy w tygodniu');
INSERT INTO Nawyk (nazwa, czestotliwosc, data_rozpoczecia, JednostkaCzasu_id, interwal, opis)
VALUES ('Czytanie książek', 1, '2024-12-29', 2, 30, 'Czytanie książek przez 30 dni');

-- Inserting data into 'Przypisanie_nawyku' table
INSERT INTO Przypisanie_nawyku (Nawyk_id, Uzytkownik_id, Grupa_id)
VALUES (1, 3, 1);
INSERT INTO Przypisanie_nawyku (Nawyk_id, Uzytkownik_id, Grupa_id)
VALUES (2, 1, 2);

