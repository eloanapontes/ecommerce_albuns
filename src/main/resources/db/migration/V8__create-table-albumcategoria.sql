CREATE TABLE album_categoria (
    id_album INT NOT NULL,
    id_categoria INT NOT NULL,
    PRIMARY KEY (id_album, id_categoria),
    FOREIGN KEY (id_album) REFERENCES Album(id_album),
    FOREIGN KEY (id_categoria) REFERENCES Categoria(id_categoria)
);
