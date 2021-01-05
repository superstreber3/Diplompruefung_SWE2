# Aufgaben

1. Erweitere die Klasse *Apartment* mit einem *boolean rented*
   1. Erweitere auch die Klasse *Database* mit dem neuen Attribut
   2. Erweitere auch die Klasse *TestDataProvider* mit dem neuen Attribut
2. Implementiere folgende Methoden in der Klasse *PropertyService*. Verwende streams (java.util.stream) wenn möglich
   1. *getAllFreeApartments* soll eine Liste aller Apartments zurückgeben, die nicht vermietet sind.
   2. *getAllPropertiesInCity* soll eine Liste aller Properties zurückgeben die in der gegebenen Stadt sind.
   3. *getAllApartmentsSortedByNumberOfRooms* soll eine Liste aller Apartments zurückgeben, sortiert nach der totalen Anzahl Zimmer. Wenn zwei Apartments die selbe Anzahl Zimmer haben, soll noch das *rented* Attribut verglichen werden.
3. Schreibe Unit Tests für die implementierten Methoden in der Klasse *PropertyServiceTest*
