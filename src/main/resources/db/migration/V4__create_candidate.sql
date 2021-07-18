CREATE TABLE `candidate` (
                            `id` INT NOT NULL AUTO_INCREMENT,
                            `name` VARCHAR(45) NOT NULL DEFAULT '',
                            `bi` VARCHAR(19) NOT NULL DEFAULT '',
                            `address` VARCHAR(45) NOT NULL DEFAULT '',
                            `birth` VARCHAR(10) NOT NULL DEFAULT '',
                            `email` VARCHAR(45) NOT NULL DEFAULT '',
                            `phone` VARCHAR(13) NOT NULL DEFAULT '',
                            `rating` INT NOT NULL DEFAULT 0,
                            `technical_area` VARCHAR(255) NOT NULL DEFAULT '',
                            `job_interview_date` VARCHAR(10) NOT NULL DEFAULT '',
                            `obs` VARCHAR(255) DEFAULT '',
                            `skills` VARCHAR(255) DEFAULT '',
                            PRIMARY KEY (`id`)
);

INSERT INTO candidate (name, bi, address, birth, email, phone, rating, technical_area, job_interview_date, obs, skills)
VALUES ("Vander", "bi12", "Ilha do Cabo", "13-04-1998", "v@gmail.com","936930630",10, "Development", "01-04-2022",'','Java,SQL,Javascript,php')