CREATE TABLE news(
    header varchar2(255) not null,
    content varchar2(1200),
    post_date date,
    image varchar2(255));

CREATE TABLE Users(
    username varchar2(255) not null,
    firstname varchar2(255),
    last_name varchar2(255),
    password varchar2(255)
);
CREATE TABLE buy_log(
    username varchar2(255) not null,
    date_bought date,
    medicine_name varchar2(255) not null,
    quantity_bought number(5,0),
    tot_price number(20,0)
    );

CREATE TABLE cart_table(
    username varchar2(255) not null,
    medicine_name varchar2(255) not null,
    image varchar2(255),
    price number(10,0),
    vendor_code number(8,0),
    barcode number(20,0),
    availability number(5,0),
    quantity  number(5,0),
    totalprice number(20,0)
    );

CREATE TABLE medicines(
    medicine_name varchar2(255) not null,
    image varchar2(255),
    price number(10,0),
    vendor_code number(8,0),
    barcode number(20,0),
    availability number(5,0)
);

CREATE TABLE recent_medicines(
    medicine_name varchar2(255) not null,
    image varchar2(255),
    price number(10,0),
    vendor_code number(8,0),
    barcode number(20,0),
    availability number(5,0),
    date_bought date
);


CREATE TABLE featured_medicines(
    medicine_name varchar2(255) not null,
    image varchar2(255),
    price number(10,0),
    vendor_code number(8,0),
    barcode number(20,0),
    availability number(5,0),
    number_bought number
    );