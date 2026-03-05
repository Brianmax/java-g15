-- on delete cascade

create table users(
    id serial PRIMARY KEY,
    name varchar(50) not null
);

create table orders(
    id serial PRIMARY KEY,
    id_user_fk int,
    order_date date,
    FOREIGN KEY (id_user_fk) REFERENCES users(id) ON DELETE CASCADE
);

insert into users (name) values ('John Doe');
insert into users (name) values ('Jane Smith');
insert into users (name) values ('Alice Johnson');
insert into orders (id_user_fk, order_date) values (1, '2024-06-01');
insert into orders (id_user_fk, order_date) values (1, '2024-06-02');
insert into orders (id_user_fk, order_date) values (2, '2024-06-03');
select * from users;
select * from orders;

delete from users where id = 1;

-- on delete set null

create table profesor(
    id serial PRIMARY KEY,
    name varchar(50) not null
);

create table cursos(
    id serial PRIMARY KEY,
    id_profesor_fk int,
    course_name varchar(50),
    FOREIGN KEY (id_profesor_fk) REFERENCES profesor(id) ON DELETE SET NULL
);

insert into profesor (name) values ('Dr. Smith');
insert into profesor (name) values ('Dr. Johnson');
insert into profesor (name) values ('Dr. Brown');

insert into cursos (id_profesor_fk, course_name) values (1, 'Mathematics');
insert into cursos (id_profesor_fk, course_name) values (1, 'Physics');
insert into cursos (id_profesor_fk, course_name) values (2, 'Chemistry');
select * from profesor;
select * from cursos;

delete from profesor where id = 1;

-- on delete set default
create table roles(
    id serial PRIMARY KEY,
    role_name varchar(50) not null
);

create table employees(
    id serial PRIMARY KEY,
    id_role_fk int,
    employee_name varchar(50),
    FOREIGN KEY (id_role_fk) REFERENCES roles(id) ON DELETE SET DEFAULT
);

insert into roles (role_name) values ('Manager');
insert into roles (role_name) values ('Developer');
insert into roles (role_name) values ('Designer');

insert into employees (id_role_fk, employee_name) values (1, 'Alice');
insert into employees (id_role_fk, employee_name) values (2, 'Bob');
insert into employees (id_role_fk, employee_name) values (3, 'Charlie');
select * from roles;
select * from employees;

DELETE FROM roles WHERE id = 1;


create table categories(
    id serial PRIMARY KEY,
    category_name varchar(50) not null
);

create table products(
    id serial PRIMARY KEY,
    id_category_fk int,
    product_name varchar(50),
    FOREIGN KEY (id_category_fk) REFERENCES categories(id)
);

insert into categories (category_name) values ('Electronics');
insert into categories (category_name) values ('Clothing');
insert into categories (category_name) values ('Books');

insert into products (id_category_fk, product_name) values (1, 'Smartphone');
insert into products (id_category_fk, product_name) values (1, 'Laptop');
insert into products (id_category_fk, product_name) values (2, 'T-shirt');
insert into products (id_category_fk, product_name) values (3, 'Novel');
select * from categories;
select * from products;

select * from categories JOIN products ON products.id_category_fk = categories.id;
-- errro al intentar eliminar la categoría 1 debido a la restricción de clave foránea
-- existen productos que hacen referencia a la categoría 1, por lo tanto no se puede eliminar
delete from categories where id = 1; -- error

-- eliminamos los productos que hacen referencia a la categoría 1
delete from products where id_category_fk = 1;

-- intentamos nuevamente eliminar la categoría 1
delete from categories where id = 1;

create DATABASE test_on_delete;