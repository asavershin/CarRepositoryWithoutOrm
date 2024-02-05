package asavershin.car.dao.entities;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
public class Autoservice {
    private Long id;
    private String name;
    private String address;
    private String country;

    public static class Builder {
        private Long id;
        private String name;
        private String address;
        private String country;

        public Builder() {
            // Установите значения по умолчанию, если необходимо
        }

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setCountry(String country) {
            this.country = country;
            return this;
        }

        public Autoservice build() {
            var autoservice = new Autoservice();
            autoservice.id = this.id;
            autoservice.name = this.name;
            autoservice.address = this.address;
            autoservice.country = this.country;
            return autoservice;
        }
    }
}
