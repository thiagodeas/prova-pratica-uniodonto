-- Usando LEFT JOIN
SELECT p.pess_id, p.Nome 
FROM Pessoa p
LEFT JOIN Fisica f ON p.pess_id = f.fisc_pessoa
WHERE f.fisc_pessoa IS NULL;

-- Usando NOT EXISTS
SELECT p.pess_id, p.Nome 
FROM Pessoa p
WHERE NOT EXISTS (
    SELECT 1 
    FROM Fisica f 
    WHERE f.fisc_pessoa = p.pess_id
);