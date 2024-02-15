/*
 * This file is generated by jOOQ.
 */
package asavershin.generated.package_.tables;


import asavershin.generated.package_.Keys;
import asavershin.generated.package_.Public;
import asavershin.generated.package_.tables.Autoservice.AutoservicePath;
import asavershin.generated.package_.tables.Person.PersonPath;
import asavershin.generated.package_.tables.records.CarRecord;

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


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class Car extends TableImpl<CarRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.car</code>
     */
    public static final Car CAR = new Car();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CarRecord> getRecordType() {
        return CarRecord.class;
    }

    /**
     * The column <code>public.car.car_id</code>.
     */
    public final TableField<CarRecord, Integer> CAR_ID = createField(DSL.name("car_id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.car.car_release_date</code>.
     */
    public final TableField<CarRecord, LocalDate> CAR_RELEASE_DATE = createField(DSL.name("car_release_date"), SQLDataType.LOCALDATE.nullable(false), this, "");

    /**
     * The column <code>public.car.car_color</code>.
     */
    public final TableField<CarRecord, String> CAR_COLOR = createField(DSL.name("car_color"), SQLDataType.VARCHAR(10).nullable(false), this, "");

    /**
     * The column <code>public.car.car_model</code>.
     */
    public final TableField<CarRecord, String> CAR_MODEL = createField(DSL.name("car_model"), SQLDataType.VARCHAR(15).nullable(false), this, "");

    /**
     * The column <code>public.car.car_evp</code>.
     */
    public final TableField<CarRecord, Long> CAR_EVP = createField(DSL.name("car_evp"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.car.car_created_at</code>.
     */
    public final TableField<CarRecord, LocalDateTime> CAR_CREATED_AT = createField(DSL.name("car_created_at"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field(DSL.raw("CURRENT_TIMESTAMP"), SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.car.car_last_updated_at</code>.
     */
    public final TableField<CarRecord, LocalDateTime> CAR_LAST_UPDATED_AT = createField(DSL.name("car_last_updated_at"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field(DSL.raw("CURRENT_TIMESTAMP"), SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.car.person_id</code>.
     */
    public final TableField<CarRecord, Long> PERSON_ID = createField(DSL.name("person_id"), SQLDataType.BIGINT, this, "");

    /**
     * The column <code>public.car.autoservice_id</code>.
     */
    public final TableField<CarRecord, Long> AUTOSERVICE_ID = createField(DSL.name("autoservice_id"), SQLDataType.BIGINT, this, "");

    private Car(Name alias, Table<CarRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private Car(Name alias, Table<CarRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>public.car</code> table reference
     */
    public Car(String alias) {
        this(DSL.name(alias), CAR);
    }

    /**
     * Create an aliased <code>public.car</code> table reference
     */
    public Car(Name alias) {
        this(alias, CAR);
    }

    /**
     * Create a <code>public.car</code> table reference
     */
    public Car() {
        this(DSL.name("car"), null);
    }

    public <O extends Record> Car(Table<O> path, ForeignKey<O, CarRecord> childPath, InverseForeignKey<O, CarRecord> parentPath) {
        super(path, childPath, parentPath, CAR);
    }

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    public static class CarPath extends Car implements Path<CarRecord> {
        public <O extends Record> CarPath(Table<O> path, ForeignKey<O, CarRecord> childPath, InverseForeignKey<O, CarRecord> parentPath) {
            super(path, childPath, parentPath);
        }
        private CarPath(Name alias, Table<CarRecord> aliased) {
            super(alias, aliased);
        }

        @Override
        public CarPath as(String alias) {
            return new CarPath(DSL.name(alias), this);
        }

        @Override
        public CarPath as(Name alias) {
            return new CarPath(alias, this);
        }

        @Override
        public CarPath as(Table<?> alias) {
            return new CarPath(alias.getQualifiedName(), this);
        }
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public Identity<CarRecord, Integer> getIdentity() {
        return (Identity<CarRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<CarRecord> getPrimaryKey() {
        return Keys.CAR_PKEY;
    }

    @Override
    public List<UniqueKey<CarRecord>> getUniqueKeys() {
        return Arrays.asList(Keys.CAR_CAR_EVP_KEY);
    }

    @Override
    public List<ForeignKey<CarRecord, ?>> getReferences() {
        return Arrays.asList(Keys.CAR__FK_CAR_PERSON, Keys.CAR__FK_CAR_AUTOSERVICE);
    }

    private transient PersonPath _person;

    /**
     * Get the implicit join path to the <code>public.person</code> table.
     */
    public PersonPath person() {
        if (_person == null)
            _person = new PersonPath(this, Keys.CAR__FK_CAR_PERSON, null);

        return _person;
    }

    private transient AutoservicePath _autoservice;

    /**
     * Get the implicit join path to the <code>public.autoservice</code> table.
     */
    public AutoservicePath autoservice() {
        if (_autoservice == null)
            _autoservice = new AutoservicePath(this, Keys.CAR__FK_CAR_AUTOSERVICE, null);

        return _autoservice;
    }

    @Override
    public Car as(String alias) {
        return new Car(DSL.name(alias), this);
    }

    @Override
    public Car as(Name alias) {
        return new Car(alias, this);
    }

    @Override
    public Car as(Table<?> alias) {
        return new Car(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Car rename(String name) {
        return new Car(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Car rename(Name name) {
        return new Car(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Car rename(Table<?> name) {
        return new Car(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Car where(Condition condition) {
        return new Car(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Car where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Car where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Car where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Car where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Car where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Car where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Car where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Car whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Car whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}