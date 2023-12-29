package com.example.spring3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FamilyRepository extends JpaRepository<FamilyDB,Integer>
{
    @Query(value = "SELECT * FROM family where name=?1",nativeQuery=true)
    List<FamilyDB> findByName(String name);

    @Modifying
    @Query(value = "INSERT INTO family (name) VALUES (?1)", nativeQuery = true)
    void insertName(String name);

}
// SELECT * FROM family