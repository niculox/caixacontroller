CREATE TABLE IF NOT EXISTS CLIENT(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    cpf VARCHAR(255) NOT NULL UNIQUE,
    phone VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS ENTRY(
    id INT AUTO_INCREMENT,
    client_id INT,
    amount DECIMAL(10, 2) NOT NULL,
    date VARCHAR(10) NOT NULL,
    entry_type VARCHAR(255) NOT NULL,
    description TEXT,
    FOREIGN KEY (client_id) REFERENCES Client(id)
);

CREATE TABLE IF NOT EXISTS ATM_SYSTEM(
    caixaAtual float,
    caixaInicial float,
    caixaFinal float
);