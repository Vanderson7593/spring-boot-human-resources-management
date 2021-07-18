CREATE TABLE `absense` (
                            `id` INT NOT NULL AUTO_INCREMENT,
                            `employee_id` INT NOT NULL,
                            `date` VARCHAR(10) NOT NULL DEFAULT '',
                            PRIMARY KEY (`id`)
);

ALTER TABLE `absense` ADD CONSTRAINT `absense_fk0` FOREIGN KEY (`employee_id`) REFERENCES `employee`(`id`);

INSERT INTO absense (employee_id, date) VALUES (1, "04-08-2021");
INSERT INTO absense (employee_id, date) VALUES (1, "04-12-2021");
INSERT INTO absense (employee_id, date) VALUES (1, "04-14-2021");
