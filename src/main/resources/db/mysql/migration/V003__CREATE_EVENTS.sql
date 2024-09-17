CREATE TABLE IF NOT EXISTS `events`
(
    id        BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    text      VARCHAR(80),
    client_id BIGINT                            NOT NULL,
    start     DATETIME,
    end       DATETIME
) ENGINE = InnoDB
  DEFAULT CHARSET = UTF8MB4;