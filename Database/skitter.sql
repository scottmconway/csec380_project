CREATE DATABASE skitter IF NOT EXISTS;
USE skitter;

CREATE TABLE user (
    user_id INT,
    username VARCHAR(20),
    displayname VARCHAR(30),
    sessionid INT,
    profile_image_url VARCHAR(200),
    PRIMARY KEY (user_id)
);

CREATE TABLE follow (
    follow_id INT,
    followed_id INT,
    follower_id INT,
    PRIMARY KEY (follow_id),
    FOREIGN KEY (followed_id) REFERENCES user(user_id)
);

CREATE TABLE skit (
    skit_id INT,
    user_id INT,
    parent_id INT,
    content VARCHAR(140),
    post_date DATETIME,
    PRIMARY KEY (skit_id),
    FOREIGN KEY (user_id) REFERENCES user(user_id),
    FOREIGN KEY (parent_id) REFERENCES skit(skit_id)
)