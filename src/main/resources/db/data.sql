INSERT INTO rola (nazwa) VALUES ('Administrator');
INSERT INTO rola (nazwa) VALUES ('Manager');
INSERT INTO rola (nazwa) VALUES ('User');

INSERT INTO jednostka_czasu (nazwa) VALUES ('Day');
INSERT INTO jednostka_czasu (nazwa) VALUES ('Week');
INSERT INTO jednostka_czasu (nazwa) VALUES ('Month');

INSERT INTO uzytkownik (nazwa_uzytkownika, haslo, imie, nazwisko, data_urodzenia, rola_id)
VALUES ('admin', 123456, 'John', 'Doe', '1980-01-01', 1);
INSERT INTO uzytkownik (nazwa_uzytkownika, haslo, imie, nazwisko, data_urodzenia, rola_id)
VALUES ('mjackson', 234567, 'Michael', 'Jackson', '1990-02-02', 2);
INSERT INTO uzytkownik (nazwa_uzytkownika, haslo, imie, nazwisko, data_urodzenia, rola_id)
VALUES ('awilliams', 345678, 'Anna', 'Williams', '1995-03-15', 3);

INSERT INTO administrator (data_utworzenia)
VALUES ('2024-12-29');

INSERT INTO menadzer (uzytkownik_id, nazwa_firmy)
VALUES (2, 'TechCorp');

INSERT INTO grupa (menadzer_id, data_utworzenia, opis)
VALUES (2, '2024-12-29', 'Project management group');
INSERT INTO grupa (menadzer_id, data_utworzenia, opis)
VALUES (2, '2024-12-29', 'Testing group');

INSERT INTO przynaleznosc (uzytkownik_id, grupa_id, data_dolaczenia, nazwa_uzytkownika_w_grupie)
VALUES (3, 1, '2024-12-29', 'Anna Williams - Project management group');
INSERT INTO przynaleznosc (uzytkownik_id, grupa_id, data_dolaczenia, nazwa_uzytkownika_w_grupie)
VALUES (1, 2, '2024-12-29', 'Jan Kowalski - Testing group');

INSERT INTO nawyk (nazwa, czestotliwosc, data_rozpoczecia, jednostkaczasu_id, interwal, opis)
VALUES ('Physical exercise', 3, '2024-12-29', 1, 7, 'Physical exercise 3 times a week');
INSERT INTO nawyk (nazwa, czestotliwosc, data_rozpoczecia, jednostkaczasu_id, interwal, opis)
VALUES ('Reading books', 1, '2024-12-29', 2, 30, 'Reading books for 30 days');


INSERT INTO przypisanie_nawyku (nawyk_id, uzytkownik_id, grupa_id)
VALUES (1, 3, 1);
INSERT INTO przypisanie_nawyku (nawyk_id, uzytkownik_id, grupa_id)
VALUES (2, 1, 2);

