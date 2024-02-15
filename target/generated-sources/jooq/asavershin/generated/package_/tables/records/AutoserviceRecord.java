/*
 * This file is generated by jOOQ.
 */
package asavershin.generated.package_.tables.records;


import asavershin.generated.package_.tables.Autoservice;

import org.jooq.Record1;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class AutoserviceRecord extends UpdatableRecordImpl<AutoserviceRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.autoservice.autoservice_id</code>.
     */
    public void setAutoserviceId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.autoservice.autoservice_id</code>.
     */
    public Integer getAutoserviceId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.autoservice.autoservice_address</code>.
     */
    public void setAutoserviceAddress(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.autoservice.autoservice_address</code>.
     */
    public String getAutoserviceAddress() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.autoservice.autoservice_country</code>.
     */
    public void setAutoserviceCountry(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.autoservice.autoservice_country</code>.
     */
    public String getAutoserviceCountry() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.autoservice.autoservice_name</code>.
     */
    public void setAutoserviceName(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.autoservice.autoservice_name</code>.
     */
    public String getAutoserviceName() {
        return (String) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached AutoserviceRecord
     */
    public AutoserviceRecord() {
        super(Autoservice.AUTOSERVICE);
    }

    /**
     * Create a detached, initialised AutoserviceRecord
     */
    public AutoserviceRecord(Integer autoserviceId, String autoserviceAddress, String autoserviceCountry, String autoserviceName) {
        super(Autoservice.AUTOSERVICE);

        setAutoserviceId(autoserviceId);
        setAutoserviceAddress(autoserviceAddress);
        setAutoserviceCountry(autoserviceCountry);
        setAutoserviceName(autoserviceName);
        resetChangedOnNotNull();
    }
}
