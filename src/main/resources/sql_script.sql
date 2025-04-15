CREATE TABLE product (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(255) NOT NULL,
    price DECIMAL(19, 4) NOT NULL
);

CREATE TABLE my_order (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    customer_name VARCHAR(255) NOT NULL,
    total_price DECIMAL(19, 4) NOT NULL
);

CREATE TABLE order_products (
    order_id UUID NOT NULL,
    product_id UUID NOT NULL
);

INSERT INTO public.product (id, name, price) VALUES ('777f1de4-c2a4-498b-b425-c39ac1914a36', 'Молоко', 12.12);
INSERT INTO public.product (id, name, price) VALUES ('b3df0541-6e73-4ca7-8307-57af2dc40735', 'Шоколад', 51.01);
INSERT INTO public.product (id, name, price) VALUES ('f7ddf14a-1ed0-42d0-b71a-5fb49173777a', 'Хлеб', 8.10);

INSERT INTO public.my_order (id, customer_name, total_price) VALUES ('58cc0c91-884c-4b8f-aabd-dcea91a4785a', 'Дмитрий', 51.01);
INSERT INTO public.my_order (id, customer_name, total_price) VALUES ('569b8bdb-a6e4-4036-a25a-c30fbc06129b', 'Василий', 114.14);
INSERT INTO public.my_order (id, customer_name, total_price) VALUES ('bb969968-de4d-4cbb-9a07-5e3cde25fc8f', 'Дмитрий', 8.10);

INSERT INTO public.order_products (order_id, product_id) VALUES ('58cc0c91-884c-4b8f-aabd-dcea91a4785a', 'b3df0541-6e73-4ca7-8307-57af2dc40735');
INSERT INTO public.order_products (order_id, product_id) VALUES ('569b8bdb-a6e4-4036-a25a-c30fbc06129b', 'b3df0541-6e73-4ca7-8307-57af2dc40735');
INSERT INTO public.order_products (order_id, product_id) VALUES ('569b8bdb-a6e4-4036-a25a-c30fbc06129b', '777f1de4-c2a4-498b-b425-c39ac1914a36');
INSERT INTO public.order_products (order_id, product_id) VALUES ('569b8bdb-a6e4-4036-a25a-c30fbc06129b', 'b3df0541-6e73-4ca7-8307-57af2dc40735');
INSERT INTO public.order_products (order_id, product_id) VALUES ('bb969968-de4d-4cbb-9a07-5e3cde25fc8f', 'f7ddf14a-1ed0-42d0-b71a-5fb49173777a');
