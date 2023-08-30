package com.example.demo.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Usermodel;
import jakarta.transaction.Transactional;
@Repository
public interface Userrepo extends JpaRepository<Usermodel, Integer>{
	@Query(value="select * from User where userid=:s or name=:sn",nativeQuery = true)
	public List<Usermodel> getcustinfo(@Param ("s") int userid,@Param("sn") String name);
	@Modifying
	@Transactional
	@Query(value="delete from User where userid=:s",nativeQuery = true)
	public Integer deletecustinfo(@Param ("s")int userid);
	@Modifying
	@Transactional
	@Query(value="update User set userid=?1 where userid=?2",nativeQuery = true)
	public int updatecustinfo(int newId,int oldId);
}