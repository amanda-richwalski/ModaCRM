insert into java302.users (first_name, last_name, password, email, phone_number, active) values ('Zach', 'Smith', 'abc123', 'zsmith@smoothie.com', '1234567890', true);
insert into java302.users (first_name, last_name, password, email, phone_number, active) values ('Julie', 'Williams', 'def456', 'jwilliams@smoothie.com', '1234561234', true);
insert into java302.users (first_name, last_name, password, email, phone_number, active) values ('Sven', 'Bjergson', 'lol123', 'sbjergson@smoothie.com', '1234564321', true);
insert into java302.users (first_name, last_name, password, email, phone_number, active) values ('Allison', 'Johns', 'password123', 'ajohns@smoothie.com', '1234565566', true);
insert into java302.users (first_name, last_name, password, email, phone_number, active) values ('Michael', 'Pabst', 'pbr123', 'mpabst@smoothie.com', '1234561289', true);
insert into java302.users (first_name, last_name, password, email, phone_number, active) values ('David', 'Anderson', 'dave123', 'danderson@smoothie.com', '1234165346', true);
insert into java302.users (first_name, last_name, password, email, phone_number, active) values ('Dana', 'Carter', 'fox123', 'dcarter@smoothie.com', '1234162146', true);
insert into java302.users (first_name, last_name, password, email, phone_number, active) values ('Ashley', 'Weston', 'wes123', 'aweston@smoothie.com', '1234165379', true);
insert into java302.users (first_name, last_name, password, email, phone_number, active) values ('Jason', 'Fredrick', 'pass123', 'jfredrick@smoothie.com', '1234165346', true);
insert into java302.users (first_name, last_name, password, email, phone_number, active) values ('Evelynn', 'Rogers', 'eve123', 'erogers@smoothie.com', '1234166269', true);

insert into java302.user_roles (user_id, role) values ((select id from java302.users where email = 'zsmith@smoothie.com'), 'USER');
insert into java302.user_roles (user_id, role) values ((select id from java302.users where email = 'jwilliams@smoothie.com'), 'USER');
insert into java302.user_roles (user_id, role) values ((select id from java302.users where email = 'sbjergson@smoothie.com'), 'USER');
insert into java302.user_roles (user_id, role) values ((select id from java302.users where email = 'ajohns@smoothie.com'), 'USER');
insert into java302.user_roles (user_id, role) values ((select id from java302.users where email = 'mpabst@smoothie.com'), 'USER');
insert into java302.user_roles (user_id, role) values ((select id from java302.users where email = 'danderson@smoothie.com'), 'USER');
insert into java302.user_roles (user_id, role) values ((select id from java302.users where email = 'dcarter@smoothie.com'), 'USER');
insert into java302.user_roles (user_id, role) values ((select id from java302.users where email = 'aweston@smoothie.com'), 'USER');
insert into java302.user_roles (user_id, role) values ((select id from java302.users where email = 'jfredrick@smoothie.com'), 'USER');
insert into java302.user_roles (user_id, role) values ((select id from java302.users where email = 'erogers@smoothie.com'), 'ADMIN');


insert into java302.contacts (first_name, last_name, email, phone_number, active, user_id) values ('Summer', 'Blakes', 'SummerSBlakes@jourrapide.com', '9734838030', true, (select id from java302.users where email = 'jfredrick@smoothie.com'));
insert into java302.contacts (first_name, last_name, email, phone_number, active, user_id) values ('Herbert', 'Malone', 'HerbertMMalone@armyspy.com', '2625328237', true, (select id from java302.users where email = 'danderson@smoothie.com'));
insert into java302.contacts (first_name, last_name, email, phone_number, active, user_id) values ('John', 'Hathaway', 'JohnRHathaway@teleworm.us', '7249661769', true, (select id from java302.users where email = 'danderson@smoothie.com'));
insert into java302.contacts (first_name, last_name, email, phone_number, active, user_id) values ('Brandon', 'Young', 'BrandonHYoung@jourrapide.com', '8142635623', true, (select id from java302.users where email = 'ajohns@smoothie.com'));
insert into java302.contacts (first_name, last_name, email, phone_number, active, user_id) values ('James', 'Harmon', 'JamesSHarmon@jourrapide.com', '9713273709', true, (select id from java302.users where email = 'dcarter@smoothie.com'));
insert into java302.contacts (first_name, last_name, email, phone_number, active, user_id) values ('Patrice', 'Gress', 'PatriceAGress@teleworm.us', '6105661496', true, (select id from java302.users where email = 'sbjergson@smoothie.com'));
insert into java302.contacts (first_name, last_name, email, phone_number, active, user_id) values ('Charles', 'Redd', 'CharlesERedd@rhyta.com', '8043816085', true, (select id from java302.users where email = 'jwilliams@smoothie.com'));
insert into java302.contacts (first_name, last_name, email, phone_number, active, user_id) values ('Ashley', 'Weston', 'aweston@smoothie.com', '1234165379', true, (select id from java302.users where email = 'jwilliams@smoothie.com'));
insert into java302.contacts (first_name, last_name, email, phone_number, active, user_id) values ('Jason', 'Fredrick', 'jfredrick@smoothie.com', '1234165346', true, (select id from java302.users where email = 'zsmith@smoothie.com'));
insert into java302.contacts (first_name, last_name, email, phone_number, active, user_id) values ('Evelynn', 'Rogers', 'erogers@smoothie.com', '1234166269', true, (select id from java302.users where email = 'zsmith@smoothie.com'));

