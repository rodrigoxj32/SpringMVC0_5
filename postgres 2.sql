/*==============================================================*/
/* DBMS name:      PostgreSQL 9.x                               */
/* Created on:     20/11/2016 10:25:15 a. m.                    */
/*==============================================================*/


/*==============================================================*/
/* Table: ADUANA                                                */
/*==============================================================*/
create table ADUANA (
   ID_ADUANA            INT4                 not null,
   ID_PAIS              INT4                 null,
   NOMBRE_ADUANA        CHAR(100)            not null,
   CODIGO_ADUANA        CHAR(100)            not null,
   constraint PK_ADUANA primary key (ID_ADUANA)
);

/*==============================================================*/
/* Index: ADUANA_PK                                             */
/*==============================================================*/
create unique index ADUANA_PK on ADUANA (
ID_ADUANA
);

/*==============================================================*/
/* Index: PAIS_ADUANA_FK                                        */
/*==============================================================*/
create  index PAIS_ADUANA_FK on ADUANA (
ID_PAIS
);

/*==============================================================*/
/* Table: ARANCEL                                               */
/*==============================================================*/
create table ARANCEL (
   ID_ARANCEL           INT4                 not null,
   ID_TIPOARANCEL       INT4                 null,
   PRECIO_ARANCEL       CHAR(10)             not null,
   constraint PK_ARANCEL primary key (ID_ARANCEL)
);

/*==============================================================*/
/* Index: ARANCEL_PK                                            */
/*==============================================================*/
create unique index ARANCEL_PK on ARANCEL (
ID_ARANCEL
);

/*==============================================================*/
/* Index: TIPOARANCEL_ARANCEL_FK                                */
/*==============================================================*/
create  index TIPOARANCEL_ARANCEL_FK on ARANCEL (
ID_TIPOARANCEL
);

/*==============================================================*/
/* Table: CATALOGOPAGOS                                         */
/*==============================================================*/
create table CATALOGOPAGOS (
   ID_CATPAGOS          INT4                 not null,
   CODIGO_CATPAGOS      CHAR(100)            not null,
   CLASIFICACION_CATPAGOS CHAR(100)            not null,
   constraint PK_CATALOGOPAGOS primary key (ID_CATPAGOS)
);

/*==============================================================*/
/* Index: CATALOGOPAGOS_PK                                      */
/*==============================================================*/
create unique index CATALOGOPAGOS_PK on CATALOGOPAGOS (
ID_CATPAGOS
);

/*==============================================================*/
/* Table: DEPARTAMENTO                                          */
/*==============================================================*/
create table DEPARTAMENTO (
   ID_DEPT              INT4                 not null,
   ID_PAIS              INT4                 null,
   CODIGO_DEPT          CHAR(100)            not null,
   NOMBRE_DEPT          CHAR(100)            not null,
   constraint PK_DEPARTAMENTO primary key (ID_DEPT)
);

/*==============================================================*/
/* Index: DEPARTAMENTO_PK                                       */
/*==============================================================*/
create unique index DEPARTAMENTO_PK on DEPARTAMENTO (
ID_DEPT
);

/*==============================================================*/
/* Index: PAIS_DEPT_FK                                          */
/*==============================================================*/
create  index PAIS_DEPT_FK on DEPARTAMENTO (
ID_PAIS
);

/*==============================================================*/
/* Table: FORMARANCELARIO_PROD                                  */
/*==============================================================*/
create table FORMARANCELARIO_PROD (
   ID_PROD              INT4                 not null,
   ID_FORMARANCELARIO   INT4                 not null,
   constraint PK_FORMARANCELARIO_PROD primary key (ID_PROD, ID_FORMARANCELARIO)
);

/*==============================================================*/
/* Index: FORMARANCELARIO_PROD_PK                               */
/*==============================================================*/
create unique index FORMARANCELARIO_PROD_PK on FORMARANCELARIO_PROD (
ID_PROD,
ID_FORMARANCELARIO
);

/*==============================================================*/
/* Index: FORMARANCELARIO_PROD2_FK                              */
/*==============================================================*/
create  index FORMARANCELARIO_PROD2_FK on FORMARANCELARIO_PROD (
ID_FORMARANCELARIO
);

/*==============================================================*/
/* Index: FORMARANCELARIO_PROD_FK                               */
/*==============================================================*/
create  index FORMARANCELARIO_PROD_FK on FORMARANCELARIO_PROD (
ID_PROD
);

/*==============================================================*/
/* Table: FORMEXPOR_PAGO                                        */
/*==============================================================*/
create table FORMEXPOR_PAGO (
   ID_PAGO              INT4                 not null,
   ID_FORMEXPOR         INT4                 not null,
   constraint PK_FORMEXPOR_PAGO primary key (ID_PAGO, ID_FORMEXPOR)
);

/*==============================================================*/
/* Index: FORMEXPOR_PAGO_PK                                     */
/*==============================================================*/
create unique index FORMEXPOR_PAGO_PK on FORMEXPOR_PAGO (
ID_PAGO,
ID_FORMEXPOR
);

/*==============================================================*/
/* Index: FORMEXPOR_PAGO2_FK                                    */
/*==============================================================*/
create  index FORMEXPOR_PAGO2_FK on FORMEXPOR_PAGO (
ID_FORMEXPOR
);

/*==============================================================*/
/* Index: FE_PAGO_FK                                            */
/*==============================================================*/
create  index FE_PAGO_FK on FORMEXPOR_PAGO (
ID_PAGO
);

/*==============================================================*/
/* Table: FORMEXPOR_PAIS                                        */
/*==============================================================*/
create table FORMEXPOR_PAIS (
   ID_PAIS              INT4                 not null,
   ID_FORMEXPOR         INT4                 not null,
   constraint PK_FORMEXPOR_PAIS primary key (ID_PAIS, ID_FORMEXPOR)
);

/*==============================================================*/
/* Index: FORMEXPOR_PAIS_PK                                     */
/*==============================================================*/
create unique index FORMEXPOR_PAIS_PK on FORMEXPOR_PAIS (
ID_PAIS,
ID_FORMEXPOR
);

/*==============================================================*/
/* Index: FORMEXPOR_PAIS2_FK                                    */
/*==============================================================*/
create  index FORMEXPOR_PAIS2_FK on FORMEXPOR_PAIS (
ID_FORMEXPOR
);

/*==============================================================*/
/* Index: FE_PA_FK                                              */
/*==============================================================*/
create  index FE_PA_FK on FORMEXPOR_PAIS (
ID_PAIS
);

/*==============================================================*/
/* Table: FORMULARIOARANCELARIO                                 */
/*==============================================================*/
create table FORMULARIOARANCELARIO (
   ID_FORMARANCELARIO   INT4                 not null,
   ID_USUARIO           INT4                 null,
   CODARANCELARIO_FORMARANCELARIO CHAR(100)            not null,
   constraint PK_FORMULARIOARANCELARIO primary key (ID_FORMARANCELARIO)
);

/*==============================================================*/
/* Index: FORMULARIOARANCELARIO_PK                              */
/*==============================================================*/
create unique index FORMULARIOARANCELARIO_PK on FORMULARIOARANCELARIO (
ID_FORMARANCELARIO
);

/*==============================================================*/
/* Index: USUARIO_FORMRANCELARIO_FK                             */
/*==============================================================*/
create  index USUARIO_FORMRANCELARIO_FK on FORMULARIOARANCELARIO (
ID_USUARIO
);

/*==============================================================*/
/* Table: FORMULARIOEXPORTACION                                 */
/*==============================================================*/
create table FORMULARIOEXPORTACION (
   ID_FORMEXPOR         INT4                 not null,
   ID_USUARIO           INT4                 null,
   ID_TRANSP            INT4                 null,
   CODIGO_FORMEXPOR     CHAR(100)            not null,
   ORIGEN_FORMEXPOR     CHAR(100)            not null,
   INSTANCIAS_FORMEXPOR CHAR(100)            not null,
   OBSERVACIONES_FORMEXPOR CHAR(100)            not null,
   FECHA_FORMEXPOR      DATE                 not null,
   constraint PK_FORMULARIOEXPORTACION primary key (ID_FORMEXPOR)
);

/*==============================================================*/
/* Index: FORMULARIOEXPORTACION_PK                              */
/*==============================================================*/
create unique index FORMULARIOEXPORTACION_PK on FORMULARIOEXPORTACION (
ID_FORMEXPOR
);

/*==============================================================*/
/* Index: FORMEXPOR_USUARIO_FK                                  */
/*==============================================================*/
create  index FORMEXPOR_USUARIO_FK on FORMULARIOEXPORTACION (
ID_USUARIO
);

/*==============================================================*/
/* Index: TRANS_FORMEXPOR_FK                                    */
/*==============================================================*/
create  index TRANS_FORMEXPOR_FK on FORMULARIOEXPORTACION (
ID_TRANSP
);

/*==============================================================*/
/* Table: MUNICIPIO                                             */
/*==============================================================*/
create table MUNICIPIO (
   ID_MUNICIPIO         INT4                 not null,
   ID_DEPT              INT4                 null,
   NOMBRE_MUNICIPIO     CHAR(100)            not null,
   CODIGO_MUNICIPIO     CHAR(100)            not null,
   constraint PK_MUNICIPIO primary key (ID_MUNICIPIO)
);

/*==============================================================*/
/* Index: MUNICIPIO_PK                                          */
/*==============================================================*/
create unique index MUNICIPIO_PK on MUNICIPIO (
ID_MUNICIPIO
);

/*==============================================================*/
/* Index: DEPT_MUNICIPIO_FK                                     */
/*==============================================================*/
create  index DEPT_MUNICIPIO_FK on MUNICIPIO (
ID_DEPT
);

/*==============================================================*/
/* Table: OTROSFORMULARIOS                                      */
/*==============================================================*/
create table OTROSFORMULARIOS (
   ID_OTROSFORM         INT4                 not null,
   ID_USUARIO           INT4                 null,
   constraint PK_OTROSFORMULARIOS primary key (ID_OTROSFORM)
);

/*==============================================================*/
/* Index: OTROSFORMULARIOS_PK                                   */
/*==============================================================*/
create unique index OTROSFORMULARIOS_PK on OTROSFORMULARIOS (
ID_OTROSFORM
);

/*==============================================================*/
/* Index: USUARIO_OTROSFORM_FK                                  */
/*==============================================================*/
create  index USUARIO_OTROSFORM_FK on OTROSFORMULARIOS (
ID_USUARIO
);

/*==============================================================*/
/* Table: PAGO                                                  */
/*==============================================================*/
create table PAGO (
   ID_PAGO              INT4                 not null,
   ID_CATPAGOS          INT4                 null,
   ID_TIPOPAGO          INT4                 null,
   CODIGO_PAGO          CHAR(100)            not null,
   PRECIO_PAGO          CHAR(100)            not null,
   constraint PK_PAGO primary key (ID_PAGO)
);

/*==============================================================*/
/* Index: PAGO_PK                                               */
/*==============================================================*/
create unique index PAGO_PK on PAGO (
ID_PAGO
);

/*==============================================================*/
/* Index: PAGO_CATPAGO_FK                                       */
/*==============================================================*/
create  index PAGO_CATPAGO_FK on PAGO (
ID_CATPAGOS
);

/*==============================================================*/
/* Index: PAGO_TIPOPAGO_FK                                      */
/*==============================================================*/
create  index PAGO_TIPOPAGO_FK on PAGO (
ID_TIPOPAGO
);

/*==============================================================*/
/* Table: PAIS                                                  */
/*==============================================================*/
create table PAIS (
   ID_PAIS              INT4                 not null,
   ID_PAGO              INT4                 null,
   CODIGO_AREA_PAIS     INT4                 not null,
   CODIGO_PAIS          CHAR(100)            not null,
   NOMBRE_PAIS          CHAR(100)            not null,
   constraint PK_PAIS primary key (ID_PAIS)
);

/*==============================================================*/
/* Index: PAIS_PK                                               */
/*==============================================================*/
create unique index PAIS_PK on PAIS (
ID_PAIS
);

/*==============================================================*/
/* Index: PAIS_PAGO_FK                                          */
/*==============================================================*/
create  index PAIS_PAGO_FK on PAIS (
ID_PAGO
);

/*==============================================================*/
/* Table: PERFILEXPORTADOR                                      */
/*==============================================================*/
create table PERFILEXPORTADOR (
   ID_PERFILEXPOR       INT4                 not null,
   CODIGO_PERFILEXPOR   CHAR(100)            not null,
   DOMICILIO_PERFILEXPOR CHAR(255)            not null,
   IDTRIBUTARIO_PERFILEXPOR CHAR(15)             not null,
   constraint PK_PERFILEXPORTADOR primary key (ID_PERFILEXPOR)
);

/*==============================================================*/
/* Index: PERFILEXPORTADOR_PK                                   */
/*==============================================================*/
create unique index PERFILEXPORTADOR_PK on PERFILEXPORTADOR (
ID_PERFILEXPOR
);

/*==============================================================*/
/* Table: PRODUCTO                                              */
/*==============================================================*/
create table PRODUCTO (
   ID_PROD              INT4                 not null,
   ID_PAIS              INT4                 null,
   PAI_ID_PAIS          INT4                 null,
   ID_ARANCEL           INT4                 null,
   NOMBRE_PROD          CHAR(100)            not null,
   PESO_PROD            FLOAT8               not null,
   constraint PK_PRODUCTO primary key (ID_PROD)
);

/*==============================================================*/
/* Index: PRODUCTO_PK                                           */
/*==============================================================*/
create unique index PRODUCTO_PK on PRODUCTO (
ID_PROD
);

/*==============================================================*/
/* Index: RUMBO_FK                                              */
/*==============================================================*/
create  index RUMBO_FK on PRODUCTO (
ID_PAIS
);

/*==============================================================*/
/* Index: PROVIENE_FK                                           */
/*==============================================================*/
create  index PROVIENE_FK on PRODUCTO (
PAI_ID_PAIS
);

/*==============================================================*/
/* Index: ARANCEL_PROD_FK                                       */
/*==============================================================*/
create  index ARANCEL_PROD_FK on PRODUCTO (
ID_ARANCEL
);

/*==============================================================*/
/* Table: TIPOARANCEL                                           */
/*==============================================================*/
create table TIPOARANCEL (
   ID_TIPOARANCEL       INT4                 not null,
   DESCRIPCION_TIPOARANCEL CHAR(255)            not null,
   CLASIFICACION_TIPOARANCEL CHAR(100)            not null,
   CODIGO_TIPOARANCEL   CHAR(100)            not null,
   constraint PK_TIPOARANCEL primary key (ID_TIPOARANCEL)
);

/*==============================================================*/
/* Index: TIPOARANCEL_PK                                        */
/*==============================================================*/
create unique index TIPOARANCEL_PK on TIPOARANCEL (
ID_TIPOARANCEL
);

/*==============================================================*/
/* Table: TIPOPAGO                                              */
/*==============================================================*/
create table TIPOPAGO (
   ID_TIPOPAGO          INT4                 not null,
   CODIGO_TIPOPAGO      CHAR(100)            not null,
   NOMBRE_TIPOPAGO      CHAR(100)            not null,
   DESCRIPCION_TIPOPAGO CHAR(255)            not null,
   constraint PK_TIPOPAGO primary key (ID_TIPOPAGO)
);

/*==============================================================*/
/* Index: TIPOPAGO_PK                                           */
/*==============================================================*/
create unique index TIPOPAGO_PK on TIPOPAGO (
ID_TIPOPAGO
);

/*==============================================================*/
/* Table: TIPOPRODUCTO                                          */
/*==============================================================*/
create table TIPOPRODUCTO (
   ID_TIPOPRO           INT4                 not null,
   DESCRIPCION_TIPOPRO  CHAR(255)            not null,
   CLASIFICACION_TIPOPRO CHAR(100)            not null,
   CODIGO_TIPOPRO       CHAR(20)             not null,
   constraint PK_TIPOPRODUCTO primary key (ID_TIPOPRO)
);

/*==============================================================*/
/* Index: TIPOPRODUCTO_PK                                       */
/*==============================================================*/
create unique index TIPOPRODUCTO_PK on TIPOPRODUCTO (
ID_TIPOPRO
);

/*==============================================================*/
/* Table: TIPOPROD_PROD                                         */
/*==============================================================*/
create table TIPOPROD_PROD (
   ID_PROD              INT4                 not null,
   ID_TIPOPRO           INT4                 not null,
   constraint PK_TIPOPROD_PROD primary key (ID_PROD, ID_TIPOPRO)
);

/*==============================================================*/
/* Index: TIPOPROD_PROD_PK                                      */
/*==============================================================*/
create unique index TIPOPROD_PROD_PK on TIPOPROD_PROD (
ID_PROD,
ID_TIPOPRO
);

/*==============================================================*/
/* Index: TIPOPROD_PROD2_FK                                     */
/*==============================================================*/
create  index TIPOPROD_PROD2_FK on TIPOPROD_PROD (
ID_TIPOPRO
);

/*==============================================================*/
/* Index: TIPOPROD_PROD_FK                                      */
/*==============================================================*/
create  index TIPOPROD_PROD_FK on TIPOPROD_PROD (
ID_PROD
);

/*==============================================================*/
/* Table: TIPOTRANSPORTE                                        */
/*==============================================================*/
create table TIPOTRANSPORTE (
   ID_TIPOTRANS         INT4                 not null,
   CLASIFICACION_TIPOTRANS CHAR(100)            not null,
   PESO_TIPOTRANS       FLOAT8               not null,
   constraint PK_TIPOTRANSPORTE primary key (ID_TIPOTRANS)
);

/*==============================================================*/
/* Index: TIPOTRANSPORTE_PK                                     */
/*==============================================================*/
create unique index TIPOTRANSPORTE_PK on TIPOTRANSPORTE (
ID_TIPOTRANS
);

/*==============================================================*/
/* Table: TIPOUSUARIO                                           */
/*==============================================================*/
create table TIPOUSUARIO (
   ID_TIPOUSUARIO       INT4                 not null,
   CODIGO_TIPOUSUARIO   CHAR(100)            not null,
   NOMBRE_TIPOUSUARIO   CHAR(100)            not null,
   DESCRIPCIO_TIPOUSUARIO CHAR(255)            not null,
   constraint PK_TIPOUSUARIO primary key (ID_TIPOUSUARIO)
);

/*==============================================================*/
/* Index: TIPOUSUARIO_PK                                        */
/*==============================================================*/
create unique index TIPOUSUARIO_PK on TIPOUSUARIO (
ID_TIPOUSUARIO
);

/*==============================================================*/
/* Table: TRANSPORTE                                            */
/*==============================================================*/
create table TRANSPORTE (
   ID_TRANSP            INT4                 not null,
   ID_TIPOTRANS         INT4                 null,
   NOMBRE_TRANSP        CHAR(100)            not null,
   DESCRIPCION_TRANSP   CHAR(255)            not null,
   constraint PK_TRANSPORTE primary key (ID_TRANSP)
);

/*==============================================================*/
/* Index: TRANSPORTE_PK                                         */
/*==============================================================*/
create unique index TRANSPORTE_PK on TRANSPORTE (
ID_TRANSP
);

/*==============================================================*/
/* Index: TRANS_TIPOTRANS_FK                                    */
/*==============================================================*/
create  index TRANS_TIPOTRANS_FK on TRANSPORTE (
ID_TIPOTRANS
);

/*==============================================================*/
/* Table: USUARIO                                               */
/*==============================================================*/
create table USUARIO (
   ID_USUARIO           INT4                 not null,
   ID_TIPOUSUARIO       INT4                 null,
   ID_PERFILEXPOR       INT4                 null,
   NOMBRE_USUARIO       CHAR(100)            not null,
   PASSWORD_USUARIO     CHAR(20)             not null,
   constraint PK_USUARIO primary key (ID_USUARIO)
);

/*==============================================================*/
/* Index: USUARIO_PK                                            */
/*==============================================================*/
create unique index USUARIO_PK on USUARIO (
ID_USUARIO
);

/*==============================================================*/
/* Index: USUARIO_TIPOUSUARIO_FK                                */
/*==============================================================*/
create  index USUARIO_TIPOUSUARIO_FK on USUARIO (
ID_TIPOUSUARIO
);

/*==============================================================*/
/* Index: USUARIO_PERFILEXPOR2_FK                               */
/*==============================================================*/
create  index USUARIO_PERFILEXPOR2_FK on USUARIO (
ID_PERFILEXPOR
);

alter table ADUANA
   add constraint FK_ADUANA_PAIS_ADUA_PAIS foreign key (ID_PAIS)
      references PAIS (ID_PAIS)
      on delete restrict on update restrict;

alter table ARANCEL
   add constraint FK_ARANCEL_TIPOARANC_TIPOARAN foreign key (ID_TIPOARANCEL)
      references TIPOARANCEL (ID_TIPOARANCEL)
      on delete restrict on update restrict;

alter table DEPARTAMENTO
   add constraint FK_DEPARTAM_PAIS_DEPT_PAIS foreign key (ID_PAIS)
      references PAIS (ID_PAIS)
      on delete restrict on update restrict;

alter table FORMARANCELARIO_PROD
   add constraint FK_FORMARAN_FORMARANC_PRODUCTO foreign key (ID_PROD)
      references PRODUCTO (ID_PROD)
      on delete restrict on update restrict;

alter table FORMARANCELARIO_PROD
   add constraint FK_FORMARAN_FORMARANC_FORMULAR foreign key (ID_FORMARANCELARIO)
      references FORMULARIOARANCELARIO (ID_FORMARANCELARIO)
      on delete restrict on update restrict;

alter table FORMEXPOR_PAGO
   add constraint FK_FORMEXPO_FE_PAGO_PAGO foreign key (ID_PAGO)
      references PAGO (ID_PAGO)
      on delete restrict on update restrict;

alter table FORMEXPOR_PAGO
   add constraint FK_FORMEXPO_FORMEXPOR_PAGO foreign key (ID_FORMEXPOR)
      references FORMULARIOEXPORTACION (ID_FORMEXPOR)
      on delete restrict on update restrict;

alter table FORMEXPOR_PAIS
   add constraint FK_FORMEXPO_FE_PA_PAIS foreign key (ID_PAIS)
      references PAIS (ID_PAIS)
      on delete restrict on update restrict;

alter table FORMEXPOR_PAIS
   add constraint FK_FORMEXPO_FORMEXPOR_PAIS foreign key (ID_FORMEXPOR)
      references FORMULARIOEXPORTACION (ID_FORMEXPOR)
      on delete restrict on update restrict;

alter table FORMULARIOARANCELARIO
   add constraint FK_FORMULAR_USUARIO_F_USUARIO foreign key (ID_USUARIO)
      references USUARIO (ID_USUARIO)
      on delete restrict on update restrict;

alter table FORMULARIOEXPORTACION
   add constraint FK_FORMULAR_FORMEXPOR_USUARIO foreign key (ID_USUARIO)
      references USUARIO (ID_USUARIO)
      on delete restrict on update restrict;

alter table FORMULARIOEXPORTACION
   add constraint FK_FORMULAR_TRANS_FOR_TRANSPOR foreign key (ID_TRANSP)
      references TRANSPORTE (ID_TRANSP)
      on delete restrict on update restrict;

alter table MUNICIPIO
   add constraint FK_MUNICIPI_DEPT_MUNI_DEPARTAM foreign key (ID_DEPT)
      references DEPARTAMENTO (ID_DEPT)
      on delete restrict on update restrict;

alter table OTROSFORMULARIOS
   add constraint FK_OTROSFOR_USUARIO_O_USUARIO foreign key (ID_USUARIO)
      references USUARIO (ID_USUARIO)
      on delete restrict on update restrict;

alter table PAGO
   add constraint FK_PAGO_PAGO_CATP_CATALOGO foreign key (ID_CATPAGOS)
      references CATALOGOPAGOS (ID_CATPAGOS)
      on delete restrict on update restrict;

alter table PAGO
   add constraint FK_PAGO_PAGO_TIPO_TIPOPAGO foreign key (ID_TIPOPAGO)
      references TIPOPAGO (ID_TIPOPAGO)
      on delete restrict on update restrict;

alter table PAIS
   add constraint FK_PAIS_PAIS_PAGO_PAGO foreign key (ID_PAGO)
      references PAGO (ID_PAGO)
      on delete restrict on update restrict;

alter table PRODUCTO
   add constraint FK_PRODUCTO_ARANCEL_P_ARANCEL foreign key (ID_ARANCEL)
      references ARANCEL (ID_ARANCEL)
      on delete restrict on update restrict;

alter table PRODUCTO
   add constraint FK_PRODUCTO_PROVIENE_PAIS foreign key (PAI_ID_PAIS)
      references PAIS (ID_PAIS)
      on delete restrict on update restrict;

alter table PRODUCTO
   add constraint FK_PRODUCTO_RUMBO_PAIS foreign key (ID_PAIS)
      references PAIS (ID_PAIS)
      on delete restrict on update restrict;

alter table TIPOPROD_PROD
   add constraint FK_TIPOPROD_TIPOPROD__PRODUCTO foreign key (ID_PROD)
      references PRODUCTO (ID_PROD)
      on delete restrict on update restrict;

alter table TIPOPROD_PROD
   add constraint FK_TIPOPROD_TIPOPROD__TIPOPROD foreign key (ID_TIPOPRO)
      references TIPOPRODUCTO (ID_TIPOPRO)
      on delete restrict on update restrict;

alter table TRANSPORTE
   add constraint FK_TRANSPOR_TRANS_TIP_TIPOTRAN foreign key (ID_TIPOTRANS)
      references TIPOTRANSPORTE (ID_TIPOTRANS)
      on delete restrict on update restrict;

alter table USUARIO
   add constraint FK_USUARIO_USUARIO_P_PERFILEX foreign key (ID_PERFILEXPOR)
      references PERFILEXPORTADOR (ID_PERFILEXPOR)
      on delete restrict on update restrict;

alter table USUARIO
   add constraint FK_USUARIO_USUARIO_T_TIPOUSUA foreign key (ID_TIPOUSUARIO)
      references TIPOUSUARIO (ID_TIPOUSUARIO)
      on delete restrict on update restrict;

