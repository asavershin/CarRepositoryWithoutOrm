/*
 * This file is generated by jOOQ.
 */
package your.generated.package_.tables.records;


import org.jooq.Record1;
import org.jooq.impl.UpdatableRecordImpl;

import your.generated.package_.tables.PersonJn;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class PersonJnRecord extends UpdatableRecordImpl<PersonJnRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.person_jn.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.person_jn.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.person_jn.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.person_jn.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.person_jn.age</code>.
     */
    public void setAge(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.person_jn.age</code>.
     */
    public Integer getAge() {
        return (Integer) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached PersonJnRecord
     */
    public PersonJnRecord() {
        super(PersonJn.PERSON_JN);
    }

    /**
     * Create a detached, initialised PersonJnRecord
     */
    public PersonJnRecord(Long id, String name, Integer age) {
        super(PersonJn.PERSON_JN);

        setId(id);
        setName(name);
        setAge(age);
        resetChangedOnNotNull();
    }
}
