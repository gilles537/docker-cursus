package be.pxl.gilles.courseapi.repositories;

import be.pxl.gilles.courseapi.models.Bike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BikeRepository extends JpaRepository<Bike, Long> {

}
