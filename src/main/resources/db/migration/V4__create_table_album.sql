CREATE TABLE Album (
    id_album INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(500),
    descricao VARCHAR(500),
    id_categoria INT,
    id_artista INT,
    valor DECIMAL(10, 2) NOT NULL,
    quantidade INT,
    FOREIGN KEY (id_categoria) REFERENCES Categoria(id_categoria),
    FOREIGN KEY (id_artista) REFERENCES Artista(id_artista)
);