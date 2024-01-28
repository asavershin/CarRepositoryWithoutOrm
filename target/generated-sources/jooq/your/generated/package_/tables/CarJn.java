/*
 * This file is generated by jOOQ.
 */
package your.generated.package_.tables;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.InverseForeignKey;
import org.jooq.Name;
import org.jooq.Path;
import org.jooq.PlainSQL;
import org.jooq.QueryPart;
import org.jooq.Record;
import org.jooq.SQL;
import org.jooq.Schema;
import org.jooq.Select;
import org.jooq.Stringly;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;

import your.generated.package_.Keys;
import your.generated.package_.Public;
import your.generated.package_.tables.AutoserviceRef.AutoserviceRefPath;
import your.generated.package_.tables.PersonJn.PersonJnPath;
import your.generated.package_.tables.records.CarJnRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class CarJn extends TableImpl<CarJnRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.car_jn</code>
     */
    public static final CarJn CAR_JN = new CarJn();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CarJnRecord> getRecordType() {
        return CarJnRecord.class;
    }

    /**
     * The column <code>public.car_jn.id</code>.
     */
    public final TableField<CarJnRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.car_jn.release_date</code>.
     */
    public final TableField<CarJnRecord, LocalDate> RELEASE_DATE = createField(DSL.name("release_date"), SQLDataType.LOCALDATE.nullable(false), this, "");

    /**
     * The column <code>public.car_jn.color</code>.
     */
    public final TableField<CarJnRecord, String> COLOR = createField(DSL.name("color"), SQLDataType.VARCHAR(10).nullable(false), this, "");

    /**
     * The column <code>public.car_jn.model</code>.
     */
    public final TableField<CarJnRecord, String> MODEL = createField(DSL.name("model"), SQLDataType.VARCHAR(15).nullable(false), this, "");

    /**
     * The column <code>public.car_jn.evp</code>.
     */
    public final TableField<CarJnRecord, Long> EVP = createField(DSL.name("evp"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.car_jn.created_at</code>.
     */
    public final TableField<CarJnRecord, LocalDateTime> CREATED_AT = createField(DSL.name("created_at"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "");

    /**
     * The column <code>public.car_jn.last_updated_at</code>.
     */
    public final TableField<CarJnRecord, LocalDateTime> LAST_UPDATED_AT = createField(DSL.name("last_updated_at"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "");

    /**
     * The column <code>public.car_jn.person_id</code>.
     */
    public final TableField<CarJnRecord, Long> PERSON_ID = createField(DSL.name("person_id"), SQLDataType.BIGINT, this, "");

    /**
     * The column <code>public.car_jn.autoservice_id</code>.
     */
    public final TableField<CarJnRecord, Long> AUTOSERVICE_ID = createField(DSL.name("autoservice_id"), SQLDataType.BIGINT, this, "");

    private CarJn(Name alias, Table<CarJnRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private CarJn(Name alias, Table<CarJnRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>public.car_jn</code> table reference
     */
    public CarJn(String alias) {
        this(DSL.name(alias), CAR_JN);
    }

    /**
     * Create an aliased <code>public.car_jn</code> table reference
     */
    public CarJn(Name alias) {
        this(alias, CAR_JN);
    }

    /**
     * Create a <code>public.car_jn</code> table reference
     */
    public CarJn() {
        this(DSL.name("car_jn"), null);
    }

    public <O extends Record> CarJn(Table<O> path, ForeignKey<O, CarJnRecord> childPath, InverseForeignKey<O, CarJnRecord> parentPath) {
        super(path, childPath, parentPath, CAR_JN);
    }

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    public static class CarJnPath extends CarJn implements Path<CarJnRecord> {
        public <O extends Record> CarJnPath(Table<O> path, ForeignKey<O, CarJnRecord> childPath, InverseForeignKey<O, CarJnRecord> parentPath) {
            super(path, childPath, parentPath);
        }
        private CarJnPath(Name alias, Table<CarJnRecord> aliased) {
            super(alias, aliased);
        }

        @Override
        public CarJnPath as(String alias) {
            return new CarJnPath(DSL.name(alias), this);
        }

        @Override
        public CarJnPath as(Name alias) {
            return new CarJnPath(alias, this);
        }

        @Override
        public CarJnPath as(Table<?> alias) {
            return new CarJnPath(alias.getQualifiedName(), this);
        }
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public Identity<CarJnRecord, Long> getIdentity() {
        return (Identity<CarJnRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<CarJnRecord> getPrimaryKey() {
        return Keys.CAR_JN_PK;
    }

    @Override
    public List<UniqueKey<CarJnRecord>> getUniqueKeys() {
        return Arrays.asList(Keys.CAR_JN_EVP_KEY);
    }

    @Override
    public List<ForeignKey<CarJnRecord, ?>> getReferences() {
        return Arrays.asList(Keys.CAR_JN__FK_CAR_PERSON, Keys.CAR_JN__FK_CAR_AUTOSERVICE);
    }

    private transient PersonJnPath _personJn;

    /**
     * Get the implicit join path to the <code>public.person_jn</code> table.
     */
    public PersonJnPath personJn() {
        if (_personJn == null)
            _personJn = new PersonJnPath(this, Keys.CAR_JN__FK_CAR_PERSON, null);

        return _personJn;
    }

    private transient AutoserviceRefPath _autoserviceRef;

    /**
     * Get the implicit join path to the <code>public.autoservice_ref</code>
     * table.
     */
    public AutoserviceRefPath autoserviceRef() {
        if (_autoserviceRef == null)
            _autoserviceRef = new AutoserviceRefPath(this, Keys.CAR_JN__FK_CAR_AUTOSERVICE, null);

        return _autoserviceRef;
    }

    @Override
    public CarJn as(String alias) {
        return new CarJn(DSL.name(alias), this);
    }

    @Override
    public CarJn as(Name alias) {
        return new CarJn(alias, this);
    }

    @Override
    public CarJn as(Table<?> alias) {
        return new CarJn(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public CarJn rename(String name) {
        return new CarJn(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public CarJn rename(Name name) {
        return new CarJn(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public CarJn rename(Table<?> name) {
        return new CarJn(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public CarJn where(Condition condition) {
        return new CarJn(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public CarJn where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public CarJn where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public CarJn where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public CarJn where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public CarJn where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public CarJn where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public CarJn where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public CarJn whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public CarJn whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}