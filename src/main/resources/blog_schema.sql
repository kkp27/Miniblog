CREATE TABLE user
(
	id PRIMARY KEY,
	email VARCHAR(30) NOT NULL,
	username VARCHAR(30) NOT NULL,
	password VARCHAR(100) NOT NULL,
	confirmPassword VARCHAR(100) NOT NULL
);

CREATE TABLE blog
(
	id PRIMARY KEY,
	blogTitle VARCHAR(100) NOT NULL,
	blogAuthor VARCHAR(30) NOT NULL,
	blogPost TEXT NOT NULL
	createdDate DATE NOT NULL,
	lastModifiedDate DATE NOT NULL,
);
