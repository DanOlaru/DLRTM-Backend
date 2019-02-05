/*Create Database*/
CREATE DATABASE dlrtimeDB;

/************************TABLES*******************************/

/*Table Client*/
CREATE TABLE Client (

    ClientId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    
	FirstName varchar(255) NOT NULL,
	MiddleName varchar(255),
	LastName varchar(255) NOT NULL,
	NickName varchar(255),
	Alias varchar(255),
	
	HomePhone varchar(20) NOT NULL,
	AreaCodeHomePhone varchar(20) NOT NULL,
	BusinessPhone varchar(20),
	AreaCodeBusinessPhone varchar(20),
	AlternatePhone varchar(20),
	AreaCodeAlternatePhone varchar(20),
	MobilePhone varchar(20),
	AreaCodeMobilePhone varchar(20),
	PrimaryContactPhone varchar(20),
	AreaCodePrimaryContactPhone varchar(20),
	
	EmailAddress varchar(40) NOT NULL,
	AlternateEmailAddress varchar(40),
	
	BillingFullAddress varchar(255) NOT NULL,
	BillingAddStreetName varchar(255) NOT NULL,
	BillingAddCity varchar(255) NOT NULL, 
	BillingAddProvince varchar(255) NOT NULL,
	BillingAddZipCode varchar(255) NOT NULL,
	BillingAddCountry varchar(255) NOT NULL,
	BillingAddLatitude double,
	BillingAddLongitude double,
	
	ShippingFullAddress varchar(255),
	ShippingAddStreetName varchar(255),
	ShippingAddCity varchar(255),
	ShippingAddProvince varchar(255),
	ShippingAddZipCode varchar(255),
	ShippingAddCountry varchar(255),
	ShippingAddLatitude double,
	ShippingAddLongitude double,
	
	AlternateFullAddress varchar(255),
	AlternateAddStreetName varchar(255),
	AlternateAddCity varchar(255),
	AlternateAddProvince varchar(255),
	AlternateAddZipCode varchar(255),
	AlternateAddCountry varchar(255),
	AlternateAddLatitude double,
	AlternateAddLongitude double,
	
	DeliveryFullAddress varchar(255) NOT NULL,
	DeliveryAddStreetName varchar(255) NOT NULL,
	DeliveryAddCity varchar(255) NOT NULL,
	DeliveryAddProvince varchar(255) NOT NULL,
	DeliveryAddZipCode varchar(255) NOT NULL,
	DeliveryAddCountry varchar(255) NOT NULL,
	DeliveryAddLatitude double,
	DeliveryAddLongitude double,
	
	CardNumber varchar(255) NOT NULL,
	NameOnCard varchar(255) NOT NULL,
	CardExpirationDate Date NOT NULL,
	CardVerificationNumber varchar(255) NOT NULL,
	
	AlternateCardNumber varchar(255),
	AlternateCardnameOnCard varchar(255),
	AlternateCardExpirationDate Date,
	AlternateCardVerificationNumber varchar(255),
	
	Urgency float, /*I think that it is an attribute of the transaction*/
	ClientValue float,
	Status varchar(255),
	
    SpecialMentions varchar(255),
	
	ReferenceCode varchar(255),
	Revision varchar(255)
);

/*Table Product*/
CREATE TABLE Product (

	ProductId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    
	Name varchar(255) NOT NULL ,
	Manufacturer varchar(255),
	CountryOfOrigin varchar(255),
	Description varchar(500),
	
	UnitePrice double NOT NULL ,
	Discount double,
	Adjustments double,
	Credit double,
	Deduction double,
	SpecialOffer varchar(255),
	
	ProductItemsInStockInt int,
	ProductItemsInStockDecimal float,
	ProductQuantityInStock float,
	ProductMeasurementUnit varchar(255),
	
	SpecialMention varchar(255)
);

/*Transaction*/
CREATE TABLE Transaction (
	TransactionId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	Client int NOT NULL ,
	DateTransaction Date,
	
	CONSTRAINT FK_ClientTransaction FOREIGN KEY (Client) REFERENCES Client(ClientId)
);

/*Transaction_Product*/
CREATE TABLE TransactionProduct (
	Transaction int, 
	Product int,
	QuantityProduct int,
	
	CONSTRAINT PK_TransactionProduct PRIMARY KEY (Transaction, Product),
	
	CONSTRAINT FK_Transaction FOREIGN KEY (Transaction) REFERENCES Transaction(TransactionId),
	CONSTRAINT FK_Product FOREIGN KEY (Product) REFERENCES Product(ProductId)
);


/************************QUERIES*******************************/

/*Select transactions performed by a client */
SELECT TransactionId FROM Transaction WHERE Client='1234'; 