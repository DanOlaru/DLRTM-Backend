
drop table paymentCards;

CREATE TABLE paymentCards (cardID varchar(15), cardNumber varchar(45), nameOnCard varchar(255),
                cardExpirationDate varchar(45), CVC varchar(10), clientID varchar(45),
                PRIMARY KEY (cardID), FOREIGN KEY (clientID) REFERENCES clients(clientID));


SELECT * FROM DLRTM_DB.paymentCards;