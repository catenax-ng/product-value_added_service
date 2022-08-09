package com.catenax.valueaddedservice.repository;

import com.catenax.valueaddedservice.domain.CompanyUser;
import com.catenax.valueaddedservice.domain.DataSource;
import com.catenax.valueaddedservice.domain.Range;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data SQL repository for the Range entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RangeRepository extends JpaRepository<Range, Long> {

    List<Range> findByCompanyUser(CompanyUser companyUser);

    @Modifying
    @Query("update Range u set u.value = ?1 where u.id = ?2")
    void setValueForRange(Integer value, Long RangeId);
}
