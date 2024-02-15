/*
 * This file is generated by jOOQ.
 */
package asavershin.generated.package_.tables;


import asavershin.generated.package_.Keys;
import asavershin.generated.package_.Public;
import asavershin.generated.package_.tables.Car.CarPath;
import asavershin.generated.package_.tables.records.AutoserviceRecord;

import java.util.Collection;

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
public class Autoservice extends TableImpl<AutoserviceRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.autoservice</code>
     */
    public static final Autoservice AUTOSERVICE = new Autoservice();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<AutoserviceRecord> getRecordType() {
        return AutoserviceRecord.class;
    }

    /**
     * The column <code>public.autoservice.autoservice_id</code>.
     */
    public final TableField<AutoserviceRecord, Integer> AUTOSERVICE_ID = createField(DSL.name("autoservice_id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.autoservice.autoservice_address</code>.
     */
    public final TableField<AutoserviceRecord, String> AUTOSERVICE_ADDRESS = createField(DSL.name("autoservice_address"), SQLDataType.VARCHAR(50).nullable(false), this, "");

    /**
     * The column <code>public.autoservice.autoservice_country</code>.
     */
    public final TableField<AutoserviceRecord, String> AUTOSERVICE_COUNTRY = createField(DSL.name("autoservice_country"), SQLDataType.VARCHAR(50).nullable(false), this, "");

    /**
     * The column <code>public.autoservice.autoservice_name</code>.
     */
    public final TableField<AutoserviceRecord, String> AUTOSERVICE_NAME = createField(DSL.name("autoservice_name"), SQLDataType.VARCHAR(50).nullable(false), this, "");

    private Autoservice(Name alias, Table<AutoserviceRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private Autoservice(Name alias, Table<AutoserviceRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>public.autoservice</code> table reference
     */
    public Autoservice(String alias) {
        this(DSL.name(alias), AUTOSERVICE);
    }

    /**
     * Create an aliased <code>public.autoservice</code> table reference
     */
    public Autoservice(Name alias) {
        this(alias, AUTOSERVICE);
    }

    /**
     * Create a <code>public.autoservice</code> table reference
     */
    public Autoservice() {
        this(DSL.name("autoservice"), null);
    }

    public <O extends Record> Autoservice(Table<O> path, ForeignKey<O, AutoserviceRecord> childPath, InverseForeignKey<O, AutoserviceRecord> parentPath) {
        super(path, childPath, parentPath, AUTOSERVICE);
    }

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    public static class AutoservicePath extends Autoservice implements Path<AutoserviceRecord> {
        public <O extends Record> AutoservicePath(Table<O> path, ForeignKey<O, AutoserviceRecord> childPath, InverseForeignKey<O, AutoserviceRecord> parentPath) {
            super(path, childPath, parentPath);
        }
        private AutoservicePath(Name alias, Table<AutoserviceRecord> aliased) {
            super(alias, aliased);
        }

        @Override
        public AutoservicePath as(String alias) {
            return new AutoservicePath(DSL.name(alias), this);
        }

        @Override
        public AutoservicePath as(Name alias) {
            return new AutoservicePath(alias, this);
        }

        @Override
        public AutoservicePath as(Table<?> alias) {
            return new AutoservicePath(alias.getQualifiedName(), this);
        }
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public Identity<AutoserviceRecord, Integer> getIdentity() {
        return (Identity<AutoserviceRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<AutoserviceRecord> getPrimaryKey() {
        return Keys.AUTOSERVICE_PKEY;
    }

    private transient CarPath _car;

    /**
     * Get the implicit to-many join path to the <code>public.car</code> table
     */
    public CarPath car() {
        if (_car == null)
            _car = new CarPath(this, null, Keys.CAR__FK_CAR_AUTOSERVICE.getInverseKey());

        return _car;
    }

    @Override
    public Autoservice as(String alias) {
        return new Autoservice(DSL.name(alias), this);
    }

    @Override
    public Autoservice as(Name alias) {
        return new Autoservice(alias, this);
    }

    @Override
    public Autoservice as(Table<?> alias) {
        return new Autoservice(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Autoservice rename(String name) {
        return new Autoservice(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Autoservice rename(Name name) {
        return new Autoservice(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Autoservice rename(Table<?> name) {
        return new Autoservice(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Autoservice where(Condition condition) {
        return new Autoservice(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Autoservice where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Autoservice where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Autoservice where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Autoservice where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Autoservice where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Autoservice where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Autoservice where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Autoservice whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Autoservice whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}