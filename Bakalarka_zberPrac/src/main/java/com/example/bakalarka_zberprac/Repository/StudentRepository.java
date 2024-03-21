package com.example.bakalarka_zberprac.Repository;

import com.example.bakalarka_zberprac.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

  StudentEntity findStudentEntityByOsCisloSt(Integer osobneCislo);



}
