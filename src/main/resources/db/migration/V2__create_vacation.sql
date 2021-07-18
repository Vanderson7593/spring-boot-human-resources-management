CREATE TABLE `vacation` (
                            `id` INT NOT NULL AUTO_INCREMENT,
                            `employee_id` INT NOT NULL,
                            `start` VARCHAR(10) NOT NULL DEFAULT '',
                            `end` VARCHAR(10) NOT NULL DEFAULT '',
                            PRIMARY KEY (`id`)
);

ALTER TABLE `vacation` ADD CONSTRAINT `vacation_fk0` FOREIGN KEY (`employee_id`) REFERENCES `employee`(`id`);

INSERT INTO vacation (employee_id, start, end)
VALUES (1, "04-04-2021", "04-05-2021")