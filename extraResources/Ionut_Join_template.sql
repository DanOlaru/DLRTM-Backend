use DLRTM_DB;

SELECT c.clientID, c.`name`, pc.cardNumber, pc.nameOnCard
FROM clients c
join paymentCards pc on pc.clientID = c.clientID
join creditCards