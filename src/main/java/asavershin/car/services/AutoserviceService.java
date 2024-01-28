package asavershin.car.services;

import asavershin.car.repositories.AutoserviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import asavershin.car.dao.entities.Autoservice;
@Service
@RequiredArgsConstructor
public class AutoserviceService {
    private final AutoserviceRepository autoserviceRepository;

    public Autoservice createAutoservice(Autoservice autoservice){
        return autoserviceRepository.save(autoservice);
    }

//    public Autoservice getAutoservice(Long autoserviceId) {
//        Autoservice autoservice = autoserviceRepository.findAutoserviceById(autoserviceId);
//        if(autoservice == null){
//            throw new NotFoundException("Салон с Id "+autoserviceId+" не найден");
//        }
//        return autoservice;
//    }
//
//    @Transactional
//    public void deleteAutoservice(Long autoserviceId){
//        var autoservice = autoserviceRepository.findAutoserviceById(autoserviceId);
//        if(autoservice==null){
//            throw  new NotFoundException("Автосервиса с id " + autoserviceId + " нет");
//        }
//        autoservice.getCars().forEach(car -> car.setAutoservice(null));
//        autoserviceRepository.delete(autoservice);
//    }
//
//    @Transactional
//    public Autoservice updateAutoservice(Long autoserviceId, String name,
//                                                 String address, String country) {
//        Autoservice autoservice = autoserviceRepository.findAutoserviceById(autoserviceId);
//        if(autoservice == null){
//            throw new NotFoundException("Салон с Id "+autoserviceId+" не найден");
//        }
//        autoservice.setName(name);
//        autoservice.setAddress(address);
//        autoservice.setCountry(country);
//        return autoserviceRepository.save(autoservice);
//    }
}
