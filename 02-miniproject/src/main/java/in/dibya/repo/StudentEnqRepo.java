package in.dibya.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import in.dibya.entity.StudentEnqEntity;

public interface StudentEnqRepo extends JpaRepository<StudentEnqEntity,Integer>{

}
