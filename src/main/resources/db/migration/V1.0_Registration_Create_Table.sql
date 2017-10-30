CREATE TABLE `classroom`.`registration` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `studendid` VARCHAR(24) NULL DEFAULT NULL, `username` VARCHAR(24) NULL DEFAULT NULL,
  `firstname` VARCHAR(48) NULL DEFAULT NULL,`lastname` VARCHAR(48) NULL DEFAULT NULL,`emailid` VARCHAR(48) NULL DEFAULT NULL,
  `password` VARCHAR(48) NULL,`created_date` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;
  
  CREATE TABLE `digimags`.`academicwiki` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `articlename` VARCHAR(24) NULL DEFAULT NULL, `studentname` VARCHAR(24) NULL DEFAULT NULL,
  `pdfname` VARCHAR(48) NULL DEFAULT NULL,`link` VARCHAR(48) NULL DEFAULT NULL,`resource` VARCHAR(48) NULL DEFAULT NULL,
  `created_date` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;
  
  
    CREATE TABLE `digimags`.`platform` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `discussionName` VARCHAR(128) NULL DEFAULT NULL, `firstname` VARCHAR(24) NULL DEFAULT NULL,
  `lastname` VARCHAR(48) NULL DEFAULT NULL,`tags` VARCHAR(48) NULL DEFAULT NULL,
  `created_date` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;
  
  CREATE TABLE `digimags`.`platformDiscussion` (
  `id` bigint(20) NOT NULL,
  `order` int(3) NOT NULL,
  `value` varchar(1024) NOT NULL,
  `component_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `IX_epub_content_property_component_id` (`component_id`),
  CONSTRAINT `FK_epub_content_property_component_id` FOREIGN KEY (`component_id`) REFERENCES `digimags`.`platform` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;