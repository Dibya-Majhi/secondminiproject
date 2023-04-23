package in.dibya.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.dibya.entity.CourseEntity;

public interface CourseRepo extends JpaRepository<CourseEntity,Integer> {

}
