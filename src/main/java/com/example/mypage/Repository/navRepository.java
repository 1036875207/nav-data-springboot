package com.example.mypage.Repository;

import com.example.mypage.Entity.Navigation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface navRepository extends JpaRepository<Navigation,Integer> {

    @Override
    List<Navigation> findAll();

    List<Navigation> findByIschild(int i);
}
