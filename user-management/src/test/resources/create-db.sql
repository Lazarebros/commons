--
-- Table structure for tables
--
DROP TABLE IF EXISTS users;

CREATE TABLE `users` (
  `user_id` bigint(20) NOT NULL,
  `user_name` varchar(10) NOT NULL,
  `password` varchar(64) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
   PRIMARY KEY (user_id)
);
ALTER TABLE `users` ADD UNIQUE KEY `UC_Users` (`user_name`) USING BTREE;
