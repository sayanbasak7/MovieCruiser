create database if not exists movieCruiser;
use movieCruiser;

/*MOVIES*/
INSERT INTO `moviecruiser`.`movies` (`mo_id`, `mo_title`, `mo_box_office`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('1', 'Avatar', '2787965087', '1', '2019-03-15', 'Science fiction', '1');
INSERT INTO `moviecruiser`.`movies` (`mo_id`, `mo_title`, `mo_box_office`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('2', 'The Avengers', '1518812988', '1', '2019-12-23', 'SuperHero', '0');
INSERT INTO `moviecruiser`.`movies` (`mo_id`, `mo_title`, `mo_box_office`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('3', 'Titanic', '2187463944', '1', '2019-08-21', 'Romance', '0');
INSERT INTO `moviecruiser`.`movies` (`mo_id`, `mo_title`, `mo_box_office`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('4', 'Jurassic World', '1671713208', '0', '2019-07-02', 'Science Fiction', '1');
INSERT INTO `moviecruiser`.`movies` (`mo_id`, `mo_title`, `mo_box_office`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('5', 'Avengers:End Game', '2750760348', '1', '2020-11-02', 'SuperHero', '1');


/*USER*/
INSERT INTO `moviecruiser`.`user` (`us_id`, `us_name`) VALUES ('1', 'Ethan');
INSERT INTO `moviecruiser`.`user` (`us_id`, `us_name`) VALUES ('2', 'Hunt');


/*Favorite Details*/
INSERT INTO `moviecruiser`.`favorites`(ft_us_id,ft_mo_id) values (1,1);
INSERT INTO `moviecruiser`.`favorites`(ft_us_id,ft_mo_id) values (1,2);
INSERT INTO `moviecruiser`.`favorites`(ft_us_id,ft_mo_id) values (1,3);
INSERT INTO `moviecruiser`.`favorites`(ft_us_id,ft_mo_id) VALUES (1,4);


/*View Movie Admin*/
select mo_id, mo_title, mo_box_office,mo_active, mo_date_of_launch, mo_genre, mo_has_teaser 
from movieCruiser.movies;


/*View Movie Customer */
select mo_id, mo_title, mo_box_office,mo_active, mo_date_of_launch, mo_genre, mo_has_teaser 
from movieCruiser.movies 
where mo_active = '1'
and 
mo_date_of_launch>(select curdate());


/*Edit Movies*/
select mo_id, mo_title, mo_box_office,mo_active, mo_date_of_launch, mo_genre, mo_has_teaser 
from movieCruiser.movies 
where 
mo_id='1';

update movieCruiser.movies
set
mo_title='GodFather',
mo_box_office='30000000',
mo_active='0',
mo_date_of_launch='1969-07-07',
mo_genre='Drama',
mo_has_teaser='0'
where mo_id='1';

select *from movieCruiser.movies;

/*Add to favorites*/

INSERT INTO `moviecruiser`.`favoites`(ft_us_id,ft_mo_id) values (1,1);
INSERT INTO `moviecruiser`.`favoites`(ft_us_id,ft_mo_id) values (1,2);
INSERT INTO `moviecruiser`.`favoites`(ft_us_id,ft_mo_id) values (1,3);
INSERT INTO `moviecruiser`.`favorites`(ft_us_id,ft_mo_id) VALUES (1,4);



/*View Favorites*/
select mo_id, mo_title, mo_box_office,mo_active, mo_date_of_launch, mo_genre, mo_has_teaser 
from movieCruiser.movies
inner join movieCruiser.favorites as Favorites on
favorites.ft_mo_id=movies.mo_id
where ft_us_id=1;


/*Total favorites*/
select count(mo_id) as Total_favorites
from movieCruiser.movies
inner join movieCruiser.favorites on
favorites.ft_mo_id=movies.mo_id
where ft_us_id=1;

/*Remove Favorites*/
use movieCruiser;
delete from  favorites
where
favorites.ft_us_id=1
and
favorites.ft_mo_id=1;
