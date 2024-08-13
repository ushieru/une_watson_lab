INSERT INTO author(id, name) VALUES
  (1, 'Alejandra Pizarnik'),
  (2, 'Juan Rulfo'),
  (3, 'Rosario Castellanos');

INSERT INTO book(id, title, author_id) VALUES
  (1, 'Árbol de Diana', 1),
  (2, 'La tierra más ajena', 1),
  (3, 'Pedro Páramo', 2),
  (4, 'El llano en llamas', 2),
  (5, 'Balún Canán', 3),
  (6, 'Poesía no eres tú', 3);

INSERT INTO hardware(id, name, quantity) VALUES
  (1, 'Proyector', 2);