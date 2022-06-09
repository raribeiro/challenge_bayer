/* CADASTRO DE SEQUENCIAS PARA INSERTS */

CREATE SEQUENCE SQ_MUNI
START WITH 1
INCREMENT BY 1
MAXVALUE 999
NOCACHE
NOCYCLE;

CREATE SEQUENCE SQ_EST
START WITH 1
INCREMENT BY 1
MAXVALUE 999
NOCACHE
NOCYCLE;

CREATE SEQUENCE SQ_REG
START WITH 1
INCREMENT BY 1
MAXVALUE 999
NOCACHE
nocycle;

CREATE SEQUENCE SQ_NM_DOEN
START WITH 1
INCREMENT BY 1
MAXVALUE 999
NOCACHE
nocycle;

/* INSERT DAS REGIÕES */

INSERT INTO t_nm_regiao (
    id_regiao,
    nm_regiao
) VALUES (
    sq_reg.NEXTVAL,
    'Norte'
);

INSERT INTO t_nm_regiao (
    id_regiao,
    nm_regiao
) VALUES (
    sq_reg.NEXTVAL,
    'Nordeste'
);

INSERT INTO t_nm_regiao (
    id_regiao,
    nm_regiao
) VALUES (
    sq_reg.NEXTVAL,
    'Centro-Oeste'
);

INSERT INTO t_nm_regiao (
    id_regiao,
    nm_regiao
) VALUES (
    sq_reg.NEXTVAL,
    'Sudeste'
);

INSERT INTO t_nm_regiao (
    id_regiao,
    nm_regiao
) VALUES (
    sq_reg.NEXTVAL,
    'Sul'
);


/* INSERT TIPOS DE DOENÇAS */

insert into t_tipo_doenca (id_doenca, nm_doenca) values (SQ_NM_DOEN.NEXTVAL, 'Zica');
insert into t_tipo_doenca (id_doenca, nm_doenca) values (SQ_NM_DOEN.NEXTVAL, 'Dengue');
insert into t_tipo_doenca (id_doenca, nm_doenca) values (SQ_NM_DOEN.NEXTVAL, 'Malaria');


/* INSERT ESTADOS */

insert into t_nm_estado (id_estado, nm_estado, t_nm_regiao_id_regiao) values (SQ_EST.NEXTVAL, 'São Paulo', 4);
insert into t_nm_estado (id_estado, nm_estado, t_nm_regiao_id_regiao) values (SQ_EST.NEXTVAL, 'Rio de Jneiro', 4);
insert into t_nm_estado (id_estado, nm_estado, t_nm_regiao_id_regiao) values (SQ_EST.NEXTVAL, 'Porto Alegre', 4);


/* INSERT MUNICIPIOS */

insert into t_nm_muni (id_municipio, nm_municipio, t_nm_estado_id_estado, id_regiao) values (SQ_MUNI.NEXTVAL, 'Campinas', 1, 4);
insert into t_nm_muni (id_municipio, nm_municipio, t_nm_estado_id_estado, id_regiao) values (SQ_MUNI.NEXTVAL, 'Jundiaí', 1, 4);
insert into t_nm_muni (id_municipio, nm_municipio, t_nm_estado_id_estado, id_regiao) values (SQ_MUNI.NEXTVAL, 'Porto Alegre', 1, 4);

/* INSERT REGISTROS DE DOENÇAS */

INSERT INTO t_reg_doenca (
    id_reg,
    dt_ocorrencia,
    t_tipo_doenca_id_doenca,
    t_nm_muni_id_municipio,
    cs_not,
    cs_conf    
) VALUES (
    sq_reg.NEXTVAL,
    TO_DATE('08/06/2022', 'DD/MM/YYYY'),
    1,
    1,
    1,
    1
);

INSERT INTO t_reg_doenca (
    id_reg,
    dt_ocorrencia,
    t_tipo_doenca_id_doenca,
    t_nm_muni_id_municipio,
    cs_not,
    cs_conf   
) VALUES (
    sq_reg.NEXTVAL,
    TO_DATE('07/06/2022', 'DD/MM/YYYY'),
    2,
    2,
    1,
    0    
);


INSERT INTO t_reg_doenca (
    id_reg,
    dt_ocorrencia,
    t_tipo_doenca_id_doenca,
    t_nm_muni_id_municipio,
    cs_not,
    cs_conf   
) VALUES (
    sq_reg.NEXTVAL,
    TO_DATE('07/06/2022', 'DD/MM/YYYY'),
    2,
    2,
    1,
    0    
);


/* SELECT QUE EXIBE REGISTROS DE DENÇAS POR REGIAO E DATA MENSAL */

select
    d.nm_doenca Doença,
    r.dt_ocorrencia Data,
    r.cs_not Notificação,
    r.cs_conf Confimação,
    m.nm_municipio Cidade,
    e.nm_estado Estado,
    reg.nm_regiao Região
from 
    t_reg_doenca r
join 
    t_nm_muni m
on
    m.id_municipio = r.t_nm_muni_id_municipio
join
    t_tipo_doenca d
on
    r.t_tipo_doenca_id_doenca = d.id_doenca
join 
    t_nm_estado e
on
    e.id_estado = m.t_nm_estado_id_estado
and
    e.t_nm_regiao_id_regiao = 4
join 
    t_nm_regiao reg
on
    reg.id_regiao = 4
WHERE
    r.dt_ocorrencia
BETWEEN
    TO_DATE('1','MM')
AND
    TO_DATE('12','MM');


/* SELECT QUE EXIBE REGISTROS APENAS POR DATA MENSAL */
select
    d.nm_doenca Doença,
    r.dt_ocorrencia Data,
    r.cs_not Notificação,
    r.cs_conf Confimação,
    m.nm_municipio Cidade,
    e.nm_estado Estado,
    reg.nm_regiao Região
from 
    t_reg_doenca r
join 
    t_nm_muni m
on
    m.id_municipio = r.t_nm_muni_id_municipio
join
    t_tipo_doenca d
on
    r.t_tipo_doenca_id_doenca = d.id_doenca
join 
    t_nm_estado e
on
    e.id_estado = m.t_nm_estado_id_estado
join
    t_nm_regiao reg
on
    e.t_nm_regiao_id_regiao = reg.id_regiao
WHERE
    r.dt_ocorrencia
BETWEEN
    TO_DATE('6','MM')
AND
    TO_DATE('12','MM');