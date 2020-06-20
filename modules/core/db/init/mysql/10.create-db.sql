-- begin JTATEST_BOOK
create table JTATEST_BOOK (
    ID varchar(32),
    VERSION integer not null,
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    DELETE_TS datetime(3),
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    ARCHIVED boolean,
    --
    primary key (ID)
)^
-- end JTATEST_BOOK
