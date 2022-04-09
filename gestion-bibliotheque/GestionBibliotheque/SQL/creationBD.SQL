/**
* MINIPROJET : Gestion d'une bibliotheque
*/ 


DROP TABLE IF EXISTS EmpruntThese;
DROP TABLE IF EXISTS EmprunteExemplaire;
DROP TABLE IF EXISTS exemplaire;
DROP TABLE IF EXISTS MotsClesLivre;
DROP TABLE IF EXISTS MotsCles; 
DROP TABLE IF EXISTS livre;  
DROP TABLE IF EXISTS document;  

DROP TABLE IF EXISTS enseignant;  
DROP TABLE IF EXISTS etudiant;  
DROP TABLE IF EXISTS usager;  

DROP TABLE IF EXISTS these;  


CREATE TABLE IF NOT EXISTS usager (

    cin         VARCHAR(8)                  , 
    nom         VARCHAR(25)     NOT NULL    ,
    prenom      VARCHAR(25)     NOT NULL    , 
    email       VARCHAR(50)                 , 
    numTel      VARCHAR(10)                 , 
    CONSTRAINT
        pk_cin
        PRIMARY KEY (cin)


)ENGINE = innoDB; 

CREATE TABLE IF NOT EXISTS enseignant (

    cin         VARCHAR(8)                  , 
    grade       VARCHAR(20)                 , 
    CONSTRAINT
        pk_enseignant_cin
        PRIMARY KEY (cin), 
    CONSTRAINT
        fk_enseignant_cin
        FOREIGN KEY(cin) 
        REFERENCES usager(CIN)
            
)ENGINE = innoDB; 

CREATE TABLE IF NOT EXISTS etudiant (

    cin         VARCHAR(10)                  , 
    adresse       VARCHAR(100)                 , 
    CONSTRAINT
        pk_etudiant_cin
        PRIMARY KEY (cin), 
    CONSTRAINT
        fk_etudiant_cin
        FOREIGN KEY(cin) 
        REFERENCES usager(CIN)
            
)ENGINE = innoDB; 

CREATE TABLE IF NOT EXISTS document (

    titre                   VARCHAR(100)                  ,  
    CONSTRAINT
        pk_Document_Titre
        PRIMARY KEY (Titre)
            
)ENGINE = innoDB; 

CREATE TABLE IF NOT EXISTS livre (

    ISBN            VARCHAR(20)          , 
    Titre           VARCHAR(100)          , 
    DateEdition     DATE                 , 
    Resume          TEXT                 ,
    CONSTRAINT
        pk_livre_ISBN
        PRIMARY KEY (ISBN), 
    CONSTRAINT
        fk_livre_cin
        FOREIGN KEY(Titre) 
        REFERENCES document(titre)
            
)ENGINE = innoDB; 

CREATE TABLE IF NOT EXISTS exemplaire (

    numInvantaire           VARCHAR(12)                  , 
    ISBN                    VARCHAR(13)                 , 
    etat                    VARCHAR(20)                 , 
    CONSTRAINT
        pk_exemplaire_numInvantaire
        PRIMARY KEY (numInvantaire), 
    CONSTRAINT
        fk_exemplaire_numInvantaire
        FOREIGN KEY(numInvantaire) 
        REFERENCES livre(ISBN)
            
)ENGINE = innoDB; 

CREATE TABLE IF NOT EXISTS these (

    Titre                             VARCHAR(30)                  , 
    DateSoutenance                    DATE                         , 
    CONSTRAINT
        pk_these_Titre
        PRIMARY KEY (Titre)
            
)ENGINE = innoDB; 

CREATE TABLE IF NOT EXISTS EmprunteExemplaire (

    CIN                              VARCHAR(8)                  , 
    numInvantaire                    VARCHAR(12)                 , 
    dateEmprunt                      DATE                        , 
    dateRelence                      DATE                        , 
    dateRetour                      DATE                        , 
    CONSTRAINT
        pk_EmprunteExemplaire_cin_numInvantaire_dateEmprunt
        PRIMARY KEY (CIN, numInvantaire, dateEmprunt), 
    CONSTRAINT
        fk_EmprunteExemplaire_cin
        FOREIGN KEY(CIN) 
        REFERENCES etudiant(CIN), 
    CONSTRAINT
        fk_EmprunteExemplaire_numInvantaire
        FOREIGN KEY(numInvantaire) 
        REFERENCES exemplaire(numInvantaire)

            
)ENGINE = innoDB; 

CREATE TABLE IF NOT EXISTS EmpruntThese (

    CIN                              VARCHAR(8)                  , 
    titre                            VARCHAR(100)                 , 
    dateEmprunt                      DATE                        , 
    dateRelence                      DATE                        , 
    dateRetour                       DATE                        , 
    CONSTRAINT
        pk_EmpruntThese_cin_titre_dateEmprunt
        PRIMARY KEY (CIN, titre, dateEmprunt), 
    CONSTRAINT
        fk_EmpruntThese_cin
        FOREIGN KEY(CIN) 
        REFERENCES etudiant(CIN), 
    CONSTRAINT
        fk_EmpruntThese_numInvantaire
        FOREIGN KEY(titre) 
        REFERENCES these(titre)

            
)ENGINE = innoDB; 

CREATE TABLE IF NOT EXISTS MotsCles (

    mot                              VARCHAR(15)                  , 
    CONSTRAINT
        pk_MotsCles_mot
        PRIMARY KEY (mot)

            
)ENGINE = innoDB; 

CREATE TABLE IF NOT EXISTS MotsClesLivre (

    ISBN                              VARCHAR(13)                  , 
    mot                               VARCHAR(15)                  , 
    CONSTRAINT
        pk_MotsClesLivre_ISBN_mot
        PRIMARY KEY (ISBN, mot), 

    CONSTRAINT
        fk_MotsClesLivre_ISBN
        FOREIGN KEY (ISBN)
        REFERENCES livre(ISBN),

    CONSTRAINT
        fk_MotsClesLivre_mot
        FOREIGN KEY (mot)
        REFERENCES MotsCles(mot) 

            
)ENGINE = innoDB; 

CREATE TABLE IF NOT EXISTS Auteur (

    id                                INT                   AUTO_INCREMENT    , 
    nom                               VARCHAR(25)                  , 
    prenom                            VARCHAR(25)                  , 
    CONSTRAINT
        pk_Auteur_id
        PRIMARY KEY (id) 
            
)ENGINE = innoDB; 