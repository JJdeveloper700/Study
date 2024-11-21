package com.example.ex1120_JPA.repository;


import java.util.List;

import org.checkerframework.checker.units.qual.m;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ex1120_JPA.entity.Memo;

import jakarta.transaction.Transactional;

public interface MemoRepository extends JpaRepository<Memo,Long> {
	
	
	
	List<Memo>findByMnoBetweenOrderByMnoDesc(Long from,Long to);
	Page<Memo>findByMnoBetween(Long from,Long to, Pageable pageable);
	
	void deleteMemoByMnoLessThan(Long mno);
	
	/*JPQL*/
	 @Query("SELECT m FROM Memo m")   //"SELECT m FROM Memo m" From 뒤에 오는 이름이 테이블이 아니라 객체(앤티티)다. 테이블이 될려면 tbl_memo가 되어야 한다. 
	 List<Memo>getList();
	 
	 @Query("SELECT m FROM Memo m WHERE m.mno = :mno") //: 클론이 있으면 파라미터를 처리 함. //
	 Memo getMemo(@Param("mno")Long mno);
	 
	 @Query("SELECT COUNT(*)FROM Memo")
	 int getCount(); 
	 
	 @Query("SELECT m FROM Memo m.memoText LIKE :keyword")
	 List<Memo> getListWithKeyword(@Param("keyword")String keyword);
	 
	 @Query("SELECT m FROM Memo m.memoText LIKE CONCAT('%':keyword,'%')")
	 List<Memo> getListWithKeyword2(@Param("keyword")String keyword);
	
	 @Transactional
	 @Modifying
	 @Query("UPDATE Memo m SET m.memoText = :#{#param.memoText}, m.writer = :#{param.writer}WHERE m.mno=:#{param.mno}")
	 int updateMemo(@Param("param")Memo memo);
	 
	 @Transactional
	 @Modifying
	 @Query("INSERT INTO Memo m(m.memoText, m.writer)VALUES (:#{#param.memoText}, :#{#param.writer})")
	 int insertMemo(@Param("param")Memo memo);
	 
	 @Transactional
	 @Modifying
	 @Query("DELETE FROM Memo m WHERE m.mno = ?1")
	 int deleteMemo(Long mno); 
	 
	 
	 //Native Query 
	 @Query(value="SELECT * FROM tbl_memo",nativeQuery=true)
	 List<Memo>getListNative();
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
