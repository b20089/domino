/*create table [user]では動かない，[users]に変更*/

CREATE TABLE room (
  id IDENTITY PRIMARY KEY,
  dominos INT NOT NULL
);
CREATE TABLE users (
  id IDENTITY PRIMARY KEY,
  roomId INT
);
