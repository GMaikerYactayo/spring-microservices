-- Crear datos de prueba para la tabla orders
INSERT INTO orders (id, customer_name, total_amount, created_at)
VALUES
    (1, 'Cliente 1', 100.50, '2022-06-01 08:00:00'),
    (2, 'Cliente 2', 150.75, '2022-06-02 09:30:00'),
    (3, 'Cliente 3', 200.00, '2022-06-03 10:45:00'),
    (4, 'Cliente 4', 250.25, '2022-06-04 11:15:00'),
    (5, 'Cliente 5', 300.50, '2022-06-05 12:00:00');

-- Crear datos de prueba para la tabla order_details
INSERT INTO order_details (id, order_id, product_id, quantity, price)
VALUES
    (1, 1, 1, 2, 20.50),
    (2, 1, 2, 1, 15.75),
    (3, 2, 3, 3, 30.00),
    (4, 3, 4, 1, 25.25),
    (5, 4, 5, 2, 50.50);