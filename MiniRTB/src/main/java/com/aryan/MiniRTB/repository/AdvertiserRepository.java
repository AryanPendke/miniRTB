package com.aryan.MiniRTB.repository;
import com.aryan.MiniRTB.entity.Advertiser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertiserRepository extends JpaRepository<Advertiser, Long> {
    boolean existsByName(String name);
}
