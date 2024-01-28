/*
 * This file is generated by jOOQ.
 */
package your.generated.package_.tables;


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

import your.generated.package_.Keys;
import your.generated.package_.Public;
import your.generated.package_.tables.CarJn.CarJnPath;
import your.generated.package_.tables.records.PersonJnRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class PersonJn extends TableImpl<PersonJnRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.person_jn</code>
     */
    public static final PersonJn PERSON_JN = new PersonJn();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PersonJnRecord> getRecordType() {
        return PersonJnRecord.class;
    }

    /**
     * The column <code>public.person_jn.id</code>.
     */
    public final TableField<PersonJnRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.person_jn.name</code>.
     */
    public final TableField<PersonJnRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>public.person_jn.age</code>.
     */
    public final TableField<PersonJnRecord, Integer> AGE = createField(DSL.name("age"), SQLDataType.INTEGER, this, "");

    private PersonJn(Name alias, Table<PersonJnRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private PersonJn(Name alias, Table<PersonJnRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>public.person_jn</code> table reference
     */
    public PersonJn(String alias) {
        this(DSL.name(alias), PERSON_JN);
    }

    /**
     * Create an aliased <code>public.person_jn</code> table reference
     */
    public PersonJn(Name alias) {
        this(alias, PERSON_JN);
    }

    /**
     * Create a <code>public.person_jn</code> table reference
     */
    public PersonJn() {
        this(DSL.name("person_jn"), null);
    }

    public <O extends Record> PersonJn(Table<O> path, ForeignKey<O, PersonJnRecord> childPath, InverseForeignKey<O, PersonJnRecord> parentPath) {
        super(path, childPath, parentPath, PERSON_JN);
    }

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    public static class PersonJnPath extends PersonJn implements Path<PersonJnRecord> {
        public <O extends Record> PersonJnPath(Table<O> path, ForeignKey<O, PersonJnRecord> childPath, InverseForeignKey<O, PersonJnRecord> parentPath) {
            super(path, childPath, parentPath);
        }
        private PersonJnPath(Name alias, Table<PersonJnRecord> aliased) {
            super(alias, aliased);
        }

        @Override
        public PersonJnPath as(String alias) {
            return new PersonJnPath(DSL.name(alias), this);
        }

        @Override
        public PersonJnPath as(Name alias) {
            return new PersonJnPath(alias, this);
        }

        @Override
        public PersonJnPath as(Table<?> alias) {
            return new PersonJnPath(alias.getQualifiedName(), this);
        }
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public Identity<PersonJnRecord, Long> getIdentity() {
        return (Identity<PersonJnRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<PersonJnRecord> getPrimaryKey() {
        return Keys.PERSON_JN_PK;
    }

    private transient CarJnPath _carJn;

    /**
     * Get the implicit to-many join path to the <code>public.car_jn</code>
     * table
     */
    public CarJnPath carJn() {
        if (_carJn == null)
            _carJn = new CarJnPath(this, null, Keys.CAR_JN__FK_CAR_PERSON.getInverseKey());

        return _carJn;
    }

    @Override
    public PersonJn as(String alias) {
        return new PersonJn(DSL.name(alias), this);
    }

    @Override
    public PersonJn as(Name alias) {
        return new PersonJn(alias, this);
    }

    @Override
    public PersonJn as(Table<?> alias) {
        return new PersonJn(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public PersonJn rename(String name) {
        return new PersonJn(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public PersonJn rename(Name name) {
        return new PersonJn(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public PersonJn rename(Table<?> name) {
        return new PersonJn(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PersonJn where(Condition condition) {
        return new PersonJn(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PersonJn where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PersonJn where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PersonJn where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public PersonJn where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public PersonJn where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public PersonJn where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public PersonJn where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PersonJn whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PersonJn whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}