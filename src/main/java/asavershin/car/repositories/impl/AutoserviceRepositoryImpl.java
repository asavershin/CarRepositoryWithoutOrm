package asavershin.car.repositories.impl;

import asavershin.car.dao.entities.Autoservice;
import asavershin.car.repositories.AutoserviceRepository;
import lombok.RequiredArgsConstructor;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import your.generated.package_.tables.AutoserviceRef;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AutoserviceRepositoryImpl implements AutoserviceRepository {

    private final DSLContext dsl;

    @Override
    public Autoservice save(Autoservice autoservice) {
        return dsl.insertInto(AutoserviceRef.AUTOSERVICE_REF)
                .set(dsl.newRecord(AutoserviceRef.AUTOSERVICE_REF, autoservice))
                .returning()
                .fetchOne()
                .into(Autoservice.class);
    }

    @Override
    public Autoservice update(Autoservice autoservice) {
        return null;
    }

    @Override
    public Autoservice findById(Long id) {
        return null;
    }

    @Override
    public List<Autoservice> findAll(Condition condition) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }
}
