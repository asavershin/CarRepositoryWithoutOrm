/*
 * This file is generated by jOOQ.
 */
package your.generated.package_;


import org.jooq.ForeignKey;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;

import your.generated.package_.tables.AutoserviceRef;
import your.generated.package_.tables.CarJn;
import your.generated.package_.tables.Databasechangeloglock;
import your.generated.package_.tables.PersonJn;
import your.generated.package_.tables.records.AutoserviceRefRecord;
import your.generated.package_.tables.records.CarJnRecord;
import your.generated.package_.tables.records.DatabasechangeloglockRecord;
import your.generated.package_.tables.records.PersonJnRecord;


/**
 * A class modelling foreign key relationships and constraints of tables in
 * public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<AutoserviceRefRecord> AUTOSERVICE_REF_PK = Internal.createUniqueKey(AutoserviceRef.AUTOSERVICE_REF, DSL.name("autoservice_ref_pk"), new TableField[] { AutoserviceRef.AUTOSERVICE_REF.ID }, true);
    public static final UniqueKey<CarJnRecord> CAR_JN_EVP_KEY = Internal.createUniqueKey(CarJn.CAR_JN, DSL.name("car_jn_evp_key"), new TableField[] { CarJn.CAR_JN.EVP }, true);
    public static final UniqueKey<CarJnRecord> CAR_JN_PK = Internal.createUniqueKey(CarJn.CAR_JN, DSL.name("car_jn_pk"), new TableField[] { CarJn.CAR_JN.ID }, true);
    public static final UniqueKey<DatabasechangeloglockRecord> DATABASECHANGELOGLOCK_PKEY = Internal.createUniqueKey(Databasechangeloglock.DATABASECHANGELOGLOCK, DSL.name("databasechangeloglock_pkey"), new TableField[] { Databasechangeloglock.DATABASECHANGELOGLOCK.ID }, true);
    public static final UniqueKey<PersonJnRecord> PERSON_JN_PK = Internal.createUniqueKey(PersonJn.PERSON_JN, DSL.name("person_jn_pk"), new TableField[] { PersonJn.PERSON_JN.ID }, true);

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<CarJnRecord, AutoserviceRefRecord> CAR_JN__FK_CAR_AUTOSERVICE = Internal.createForeignKey(CarJn.CAR_JN, DSL.name("fk_car_autoservice"), new TableField[] { CarJn.CAR_JN.AUTOSERVICE_ID }, Keys.AUTOSERVICE_REF_PK, new TableField[] { AutoserviceRef.AUTOSERVICE_REF.ID }, true);
    public static final ForeignKey<CarJnRecord, PersonJnRecord> CAR_JN__FK_CAR_PERSON = Internal.createForeignKey(CarJn.CAR_JN, DSL.name("fk_car_person"), new TableField[] { CarJn.CAR_JN.PERSON_ID }, Keys.PERSON_JN_PK, new TableField[] { PersonJn.PERSON_JN.ID }, true);
}