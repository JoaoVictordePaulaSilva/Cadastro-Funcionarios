-- Criar a tabela Funcionario
CREATE TABLE Funcionario (
    id INT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cargo VARCHAR(50) NOT NULL,
    departamento VARCHAR(50),
    estilocontrato VARCHAR(20) NOT NULL,
    salario DOUBLE NOT NULL
);

-- Criar a tabela departamentozinhos
CREATE TABLE departamentozinhos (
    nome_departamentozinho VARCHAR(50) PRIMARY KEY
);

-- Criar a tabela departamento
CREATE TABLE departamento (
    nome_departamento VARCHAR(50),
    lista_funcionarios TEXT,
    FOREIGN KEY (nome_departamento) REFERENCES departamentozinhos(nome_departamentozinho)
);
