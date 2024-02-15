package asavershin.car.services;

import asavershin.car.handlers.localexceptions.EntityNotFoundException;
import asavershin.car.repositories.AutoserviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import asavershin.car.entities.AutoserviceEntity;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AutoserviceService {
    private final AutoserviceRepository autoserviceRepository;

    public AutoserviceEntity createAutoservice(AutoserviceEntity autoservice){
        return autoserviceRepository.insert(autoservice);
    }

    public AutoserviceEntity getAutoservice(Long autoserviceId) throws EntityNotFoundException {
        return autoserviceRepository.findById(autoserviceId).orElseThrow(()->new EntityNotFoundException("Салон с Id "+autoserviceId+" не найден"));
    }

    @Transactional
    public void deleteAutoservice(Long autoserviceId){
        autoserviceRepository.delete(autoserviceId);
    }

    @Transactional
    public AutoserviceEntity updateAutoservice(AutoserviceEntity authoservice) throws EntityNotFoundException {
        return autoserviceRepository.update(authoservice);
    }
}
