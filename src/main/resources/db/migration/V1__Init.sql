CREATE DATABASE IF NOT EXISTS `s4dx_db`;
USE `s4dx_db`;


-- ************************************** "x_device"
CREATE TABLE `x_device`
(
    `id`             INT          NOT NULL AUTO_INCREMENT,
    `manufacture_id` VARCHAR(100),
    `hardware_state` VARCHAR(100) NOT NULL,
    `hcp_id`         INT(100)     DEFAULT NULL,
    PRIMARY KEY (`id`)
);
-- ************************************** "hcp"
CREATE TABLE `hcp`
(
    `id`        INT(100) NOT NULL AUTO_INCREMENT,
    `hcp_id`    VARCHAR(100),
    `street`    VARCHAR(200),
    `city`      VARCHAR(100),
    `city_code` VARCHAR(100),
    `name`      VARCHAR(100),
    PRIMARY KEY (`id`)
);

ALTER TABLE `x_device`
    ADD CONSTRAINT `x_device_fk0` FOREIGN KEY (`hcp_id`) REFERENCES `hcp` (`id`);

-- *************** Initial-Data ****************;


INSERT INTO `hcp`
VALUES (18, 'Schäfer', 'Sredzkistr. 67', 'Berlin', '10405', 'Schäfer'),
       (19, 'Buschhaus', 'Prenzlauer Allee 217', 'Berlin', '10405', 'Buschhaus'),
       (20, 'Falsafi Amin', 'Kolmarer Str. 1', 'Berlin', '10405', 'Falsafi Amin'),
       (21, 'Fink', 'Marienburger Str. 3-4', 'Berlin', '10405', 'Fink'),
       (22, 'Fischer', 'Jablonskistr. 16', 'Berlin', '10405', 'Fischer'),
       (23, 'Glaunsinger', 'Danziger Str. 78 b', 'Berlin', '10405', 'Glaunsinger'),
       (24, 'Jürgens', 'Prenzlauer Allee 19', 'Berlin', '10405', 'Jürgens'),
       (25, 'Knobloch', 'Winsstr. 45', 'Berlin', '10405', 'Knobloch'),
       (26, 'Krüger', 'Kollwitzstr. 14', 'Berlin', '10405', 'Krüger'),
       (27, 'Kubo', 'Sredzkistr. 47', 'Berlin', '10405', 'Kubo'),
       (28, 'Lammerschmidt', 'Winsstr. 40', 'Berlin', '10405', 'Lammerschmidt'),
       (29, 'Pomrenke', 'Greifswalder Str. 5', 'Berlin', '10405', 'Pomrenke'),
       (30, 'Schafranka', 'Immanuelkirchstr. 30', 'Berlin', '10405', 'Schafranka'),
       (31, 'Scholz', 'Chodowieckistr. 15', 'Berlin', '10405', 'Scholz'),
       (32, 'Schreen', 'Winsstr. 56', 'Berlin', '10405', 'Schreen'),
       (33, 'Wagner', 'Greifswalder Str. 23', 'Berlin', '10405', 'Wagner'),
       (34, 'Wullkopf', 'Prenzlauer Allee 187', 'Berlin', '10405', 'Wullkopf'),
       (35, '1', 'street', 'Berlin', '10405', '1');


INSERT INTO `x_device`
VALUES (1, 'X1', 'ASSIGNED', 18),
       (2, 'X2', 'ASSIGNED', 19),
       (3, 'X3', 'ASSIGNED', 20),
       (4, 'X4', 'ASSIGNED', 20),
       (5, 'X5', 'ASSIGNED', 25),
       (6, 'X6', 'UNASSIGNED', NULL);


