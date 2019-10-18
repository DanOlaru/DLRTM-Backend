use dlrtm_db;

drop table clients;

/* older */

CREATE TABLE clients (uniqueID varchar(45) NOT NULL, name varchar(255), homePhone varchar(45),
                businessPhone varchar(45), alternatePhone varchar(45), mobilePhone varchar(45),
                primaryContactPhone varchar(45), primaryEmail varchar(255), alternateEmail varchar(255),
                billingAddress varchar(255), shippingAddress varchar(255), alternateAddress varchar(255),
                deliveryAddress varchar(255), cardInfo varchar(255), alternateCardInfo varchar(255),
                selectedPaymentMethod varchar(255),
                clientUrgency float, clientValue float, clientStatus varchar(255), clientSpecialMentions varchar(255),
                PRIMARY KEY (uniqueID));


/* newer */

CREATE TABLE clients (clientID varchar(45) NOT NULL, name varchar(255), homePhone varchar(45),
                businessPhone varchar(45), alternatePhone varchar(45), mobilePhone varchar(45),
                primaryContactPhone varchar(45), primaryEmail varchar(255), alternateEmail varchar(255),
                billingAddress varchar(255), shippingAddress varchar(255), alternateAddress varchar(255),
                deliveryAddress varchar(255), clientUrgency float, clientValue float, clientStatus varchar(255),
                clientSpecialMentions varchar(255),
                PRIMARY KEY (clientID));