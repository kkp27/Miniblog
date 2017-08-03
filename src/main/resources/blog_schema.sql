CREATE TABLE blog
(
	id int PRIMARY KEY
	blogTitle VARCHAR(100) NOT NULL,
	blogAuthor VARCHAR(30) NOT NULL,
	blogPost TEXT NOT NULL
	createdDate DATE NOT NULL,
	lastModifiedDate DATE NOT NULL,
);
