package com.emitrahelp.emitrahelp.repository;
import com.emitrahelp.emitrahelp.entity.ServicePost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServicePostRepository extends JpaRepository<ServicePost, Long> {
//     Custom query to filter by categry and city
    @Query("SELECT sp FROM ServicePost sp WHERE (:category IS NULL OR sp.category = :category) AND (:city IS NULL OR sp.city = :city)")
    List<ServicePost> findByCategoryAndCity(String category, String city);
    List<ServicePost> findByCityName(String cityName);
    List<ServicePost> findByEmail(String email);

}
