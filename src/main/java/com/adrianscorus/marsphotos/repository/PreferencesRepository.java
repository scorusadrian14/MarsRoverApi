package com.adrianscorus.marsphotos.repository;

import com.adrianscorus.marsphotos.dto.HomeDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreferencesRepository  extends JpaRepository<HomeDto,Long> {

    HomeDto findByUserId(Long userId);
}
