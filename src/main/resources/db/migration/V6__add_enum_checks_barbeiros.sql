ALTER TABLE barbeiros
    ADD CONSTRAINT chk_especialidade
        CHECK (especialidade IN ('DEGRADE', 'BARBA', 'NAVALHA', 'INFANTIL'));

ALTER TABLE barbeiros
    ADD CONSTRAINT chk_nivel
        CHECK (nivel IN ('JUNIOR', 'PLENO', 'SENIOR'));