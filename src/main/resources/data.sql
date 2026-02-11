-- Insert into publishers
insert into publishers (date_created, date_updated, address, contact_details, name)
values (now(), now(), 'www.sonymusic.com', 'One of the biggest music publishers in the world', 'Sony Music'),
       (now(), now(), 'www.studio100.be', 'They know every Belgian artist you need to know', 'Studio100');

-- Insert into genres
insert into genres (date_created, date_updated, name, description)
values (now(), now(), 'Metal', 'Music with a bang'),
       (now(), now(), 'Jazz', 'Experimental music');