package com.pragyan.repository;


import com.pragyan.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    List<Enrollment> findByUserId(Long userId);
    Optional<Enrollment> findByRazorpayOrderId(String orderId);
}
