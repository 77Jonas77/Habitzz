-- Wstawienie ról
INSERT INTO rola (nazwa) VALUES ('Administrator');
INSERT INTO rola (nazwa) VALUES ('Manager');
INSERT INTO rola (nazwa) VALUES ('User');

-- Wstawienie jednostek czasu
INSERT INTO jednostka_czasu (nazwa) VALUES ('Day');
INSERT INTO jednostka_czasu (nazwa) VALUES ('Week');
INSERT INTO jednostka_czasu (nazwa) VALUES ('Month');

-- Wstawienie użytkowników
INSERT INTO uzytkownik (nazwa_uzytkownika, haslo, imie, nazwisko, data_urodzenia, rola_id)
VALUES ('admin', "123456", 'John', 'Doe', '1980-01-01', 1);
INSERT INTO uzytkownik (nazwa_uzytkownika, haslo, imie, nazwisko, data_urodzenia, rola_id)
VALUES ('mjackson', "234567", 'Michael', 'Jackson', '1990-02-02', 2);
INSERT INTO uzytkownik (nazwa_uzytkownika, haslo, imie, nazwisko, data_urodzenia, rola_id)
VALUES ('awilliams', "345678", 'Anna', 'Williams', '1995-03-15', 3);

-- Wstawienie administratora
INSERT INTO administrator (data_utworzenia)
VALUES ('2024-12-29');

-- Wstawienie menadżera
INSERT INTO menadzer (uzytkownik_id, nazwa_firmy)
VALUES (2, 'TechCorp');

-- Wstawienie grup
INSERT INTO grupa (menadzer_id, data_utworzenia, nazwa_grupy, opis)
VALUES (2, '2024-12-29', "Grupa PM",'Project management group');
INSERT INTO grupa (menadzer_id, data_utworzenia, nazwa_grupy, opis)
VALUES (2, '2024-12-29',"Testing Group", 'Testing group');

-- Wstawienie przynależności do grup
INSERT INTO uzytkownik_grupa (uzytkownik_id, grupa_id, data_dolaczenia, nazwa_uzytkownika_w_grupie)
VALUES (3, 1, '2024-12-29', 'Anna Williams - Project management group');
INSERT INTO uzytkownik_grupa (uzytkownik_id, grupa_id, data_dolaczenia, nazwa_uzytkownika_w_grupie)
VALUES (1, 2, '2024-12-29', 'Jan Kowalski - Testing group');

-- Wstawienie nawyków
INSERT INTO nawyk (nazwa, czestotliwosc, jednostka_czasu_id, interwal, opis)
VALUES ('Physical exercise', 3, 1, 7, 'Physical exercise 3 times a week');
INSERT INTO nawyk (nazwa, czestotliwosc, jednostka_czasu_id, interwal, opis)
VALUES ('Reading books', 1, 2, 30, 'Reading books for 30 days');

-- Wstawienie przypisania nawyków do użytkowników
INSERT INTO nawyk_uzytkownik (uzytkownik_id, nawyk_id, data_rozpoczecia)
VALUES (3, 1, '2024-12-29');
INSERT INTO nawyk_uzytkownik (uzytkownik_id, nawyk_id, data_rozpoczecia)
VALUES (1, 2, '2024-12-29');

-- Wstawienie przypisania nawyków do grup
INSERT INTO nawyk_grupa (nawyk_id, grupa_id, data_rozpoczecia)
VALUES (1, 1, '2024-12-29');
INSERT INTO nawyk_grupa (nawyk_id, grupa_id, data_rozpoczecia)
VALUES (2, 2, '2024-12-29');
