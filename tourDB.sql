USE tour;

#SELECT * FROM tour.order;

#SELECT iduser
#FROM user
#WHERE login = 'qaz';

#SELECT iduser FROM tour.user WHERE login = 'qaz';

#SELECT *
#FROM tour, hotel, transport
#WHERE idhotel = hotel_id AND idtransport = transport_id;

#SELECT
#tour.name,
#hotel.country, hotel.city, hotel.name, hotel.star, hotel.meal, hotel.person,
#tour.night,
#ransport.type,
#our.cost, tour.hot
#FROM tour, hotel, transport
#WHERE idhotel = hotel_id AND idtransport = transport_id;

SELECT
hotel.country, hotel.city, hotel.name, hotel.star, hotel.meal, hotel.person,
tour.night,
transport.type,
tour.cost, tour.hot
FROM tour, hotel, transport
WHERE idhotel = hotel_id AND idtransport = transport_id AND country = 'Spain';