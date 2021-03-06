DROP TABLE Soluzione;
DROP TABLE Sessione;
DROP TABLE Messaggio;
DROP TABLE Proposta;
DROP TABLE SistemaCifratura;
DROP TABLE Studente;

CREATE TABLE Studente (
    id          int PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    nickname    varchar(20),
    password    varchar(32),
    nome        varchar(20),
    cognome     varchar(20)
);

CREATE TABLE SistemaCifratura (
    id          int PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    creatore    int,
    metodo      varchar(20),
    chiave      varchar(20),
    eliminato   boolean DEFAULT false,
    FOREIGN KEY (creatore) REFERENCES Studente(id)
);

CREATE TABLE Proposta (
    id          int PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    stato       varchar(20),
    notificata  boolean,
    proponente  int,
    partner     int,
    sdc         int,
    FOREIGN KEY (proponente) REFERENCES Studente(id),
    FOREIGN KEY (partner) REFERENCES Studente(id),
    FOREIGN KEY (sdc) REFERENCES SistemaCifratura(id)
);

CREATE TABLE Messaggio (
    id              int PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    mittente        int,
    destinatario    int,
    testo           varchar(32672),
    testoCifrato    varchar(32672),
    lingua          varchar(20),
    titolo          varchar(40),
    bozza           boolean,
    letto           boolean,
    sdc             int,
    eliminatoMitt   boolean DEFAULT false,
    eliminatoDest   boolean DEFAULT false,
    FOREIGN KEY (mittente) REFERENCES Studente(id),
    FOREIGN KEY (destinatario) REFERENCES Studente(id),
    FOREIGN KEY (sdc) REFERENCES SistemaCifratura(id) ON DELETE CASCADE
);

CREATE TABLE Sessione (
    id              int PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    proprietario    int,
    messaggio	    int,
    albero          blob,
    FOREIGN KEY (proprietario) REFERENCES Studente(id),
    FOREIGN KEY (messaggio) REFERENCES Messaggio(id)
);

CREATE TABLE Soluzione (
    id              int PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    creatore	    int,
    messaggio	    int,
    mappatura       varchar(200),
    FOREIGN KEY (creatore) REFERENCES Studente(id),
    FOREIGN KEY (messaggio) REFERENCES Messaggio(id)
);

INSERT INTO Studente (nickname, password, nome, cognome) VALUES
    ('claudia', 'claudia', 'Claudia', 'Bianchi'),
    ('viviana', 'viviana', 'Viviana', 'Rossi'),
    ('marco', 'marco', 'Marco', 'Verdi'),
    ('giovanna', 'giovanna', 'Giovanna', 'Blu'),
    ('ale', 'ale', 'Alessandro', 'Viola'),
    ('mattiav', 'mattiav', 'Mattia', 'Vagoni'),
    ('mattiac', 'mattiac', 'Mattia', 'Carboni');

INSERT INTO SistemaCifratura (creatore, metodo, chiave, eliminato) VALUES
    (1, 'parolachiave','cipolla', false),
    (4, 'cesare','3', false),
    (1, 'pseudocasuale','55', false),
    (1, 'cesare','10', false),
    (1, 'parolachiave','pallacanestro', false),
    (1, 'cesare','11', false);

INSERT INTO Proposta (stato, notificata, proponente, partner, sdc) VALUES
    ('accepted', true, 1, 2, 1),
    ('accepted', true, 4, 1, 2),
    ('accepted', false, 1, 5, 3),
    ('expired', true, 1, 3, 4),
    ('accepted', true, 1, 6, 6),
    ('accepted', false, 3, 1, 5);
       
INSERT INTO Messaggio (mittente, destinatario, testo, testoCifrato, lingua, titolo, bozza, letto, sdc) VALUES
    (1, 2, 'fede', 'alol', 'Italiano', 'Un titolo a caso', true, False, 1),
    (2, 1, 'ciao pietro', 'pecmneltrm', 'Italiano', 'Saluti', False, False, 1);
