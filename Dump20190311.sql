CREATE DATABASE  IF NOT EXISTS `code_school` ;

DROP TABLE IF EXISTS `exercise`;
CREATE TABLE `exercise` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `description` text,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
INSERT INTO `exercise` VALUES (7,'DB','Add data to database.'),(8,'Maven','build maven project'),(9,'Spring','reserch about spring'),(10,'For','create for loop');

DROP TABLE IF EXISTS `user_group`;
CREATE TABLE `user_group` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
INSERT INTO `user_group` VALUES (1,'KraJee003'),(3,'ProJs001'),(4,'WarJee001'),(2,'WroPyt002');

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(245) DEFAULT NULL,
  `user_group_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `user_group_id_idx` (`user_group_id`),
  CONSTRAINT `user_group_id` FOREIGN KEY (`user_group_id`) REFERENCES `user_group` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
INSERT INTO `users` VALUES (13,'Pete','pete@mail.com','$2a$10$DQXvLXvGib8p.sSoAMh0ve2FTrML4Tc0qedZW1lDCBb0BXOmew5Ie',1),(14,'Jack','jack@gmail.com','$2a$10$LMPsFbnIIdcH1/n0NDXFieY0aaGMhrgvud4sJDKbAvZ5Q17szl3Gu',1),(15,'Kate','kate002@hotmail.com','$2a$10$HmXezmAOl6JhGYIkV9fgWOOZG2hFP07EVHFcO1iF3Fg2Qlm2awPEi',2),(16,'Ben','bigben@gmail.com','$2a$10$Mf7xRC9FdKGbRL6U764jquMw5h8yvEWPKuFyeuRNHN1RZWdch92XK',3),(17,'Ann','annna@gmail.com','$2a$10$T6v5xhg4S5m4.GBu59lUCu2F1lIxrERI2m4.8vE9T0TZk4rwthsBa',2);

DROP TABLE IF EXISTS `solution`;
CREATE TABLE `solution` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `created` datetime NOT NULL,
  `updated` datetime DEFAULT NULL,
  `description` text,
  `exercise_id` int(11) unsigned NOT NULL,
  `users_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `users_id_idx` (`users_id`),
  KEY `exercise_id_idx` (`exercise_id`),
  CONSTRAINT `exercise_id` FOREIGN KEY (`exercise_id`) REFERENCES `exercise` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `users_id` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
INSERT INTO `solution` VALUES (12,'2019-02-10 15:17:55','2019-02-14 15:20:41','SELECT * FROM...',7,13),(13,'2019-02-10 15:18:12','0000-00-00 00:00:00','',10,13),(14,'2019-02-10 15:18:19','2019-02-15 15:20:41','for (User user:users)',10,17),(15,'2019-02-10 15:18:26','2019-02-10 15:20:41','mvn clean',8,15),(16,'2019-02-10 15:18:35','2019-02-17 15:20:41','Do some hard coding....',9,16);



