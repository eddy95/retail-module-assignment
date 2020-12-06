DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `username` varchar(18) NOT NULL,
  `role` varchar(18) NOT NULL,
  `user_registered_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

ALTER TABLE `user`
  ADD PRIMARY KEY (`username`);