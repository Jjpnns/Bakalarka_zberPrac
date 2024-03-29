package com.example.bakalarka_zberprac.Repository;

import com.example.bakalarka_zberprac.entity.UcitelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ucitelRepository extends JpaRepository<UcitelEntity, Integer> {
  UcitelEntity findByLogin(String login);


}
