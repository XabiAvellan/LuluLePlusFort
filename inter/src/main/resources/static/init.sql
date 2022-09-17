CREATE TABLE commande
(
    id INT PRIMARY KEY NOT NULL,
    date_commande DATE,
    emmeteur_commande VARCHAR(100)
);

INSERT INTO commande VALUES (1, '2000-08-10', 'Xabi Avellan');
INSERT INTO commande VALUES (2, '2022-05-03', 'Lucas Pinto');