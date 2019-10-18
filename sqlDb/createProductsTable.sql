CREATE TABLE products (uniqueID char(10), name char(50), manufacturer char(50),
                                       countryOfOrigin char(50), description char(150), unitPurchasePrice float,
                                       unitPrice float, discounts float, adjustments float,
                                       credits float, deductions float, specialOffers char(50),
                                       currency char(10), itemsInStockInt int, itemsInStockDecimal float,
                                       quantityInStock float, needToReorder int, measurementUnit char(10),
                                       specialMentions char(150), length float, width float, depth float, height float,
                                       weight float, sizeMeasurementUnit char(15), weightMeasurementUnit char(15));


DROP TABLE products;
