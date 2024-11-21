package com.example.ex1120_JPA.repository;



import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ex1120_JPA.entity.Memo;

@SpringBootTest
class MemoRepositoryTest {

	@Autowired
	MemoRepository memoRepository; 
	
	@Test
	void testNativeQuery() {
		List<Memo> list = memoRepository.getListNative();
		for(Memo memo :list) {
			System.out.println(memo);
		}
	}
	
	//@Test
	@Query("SELECT m FROM Memo m")
	void getList() {
		
	}
	//@Test
	@Query("SELECT m FROM Memo m WHERE m.mno = :mno")
	void getMemo(@Param("mno")Long mno) {
		
	}
	
	
	
	//@Test
	//void testInsertDummies() {
		
		//for(int i = 1; i<=100; i++) {
			//Memo memo = Memo.builder()
					//.memoText("Sample...." +i)
					//.build(); 
			//memoRepository.save(memo);
			
		//}
		//IntStream.range(101, 200).forEach(i->{
			//Memo memo = Memo.builder().memoText("Sample...."+i).build(); 
			//memoRepository.save(memo);
		//});
		
		
		//}
	
	
	
	
	
	
	
	//@Commit
	//@Transactional
	//@Test
	void testDeleteQueryMethod() {
		memoRepository.deleteMemoByMnoLessThan(10L);
	}
	
	
	
	//@Test
	void testSort() {
		Sort sort1 = Sort.by("mno").descending(); 
		Sort sort2 = Sort.by("memoText").ascending(); 
		Sort sortAll= sort1.and(sort2); 
		
		Pageable pageable = PageRequest.of(0, 10, sort1); 
		
		Page<Memo>result = memoRepository.findAll(pageable); 
		
		result.get().forEach(memo->{
			System.out.println(memo);
		});
	}
	
	
	
	//@Test
	void testPageDefault() {
		//1페이지 10개 
		Pageable pageable = PageRequest.of(0, 10); 
		Page<Memo> result = memoRepository.findAll(pageable); 
		System.out.println(result);
		System.out.println("------------------------------------");
		System.out.println("Total page:"+ result.getTotalPages()); //총 페이지수 
		System.out.println("Total count:"+ result.getTotalElements());//전체 갯수
		System.out.println("Page Number:"+ result.getNumber());// 현재 페이지번호 (0부터 10까지)
		System.out.println("Page Size:"+ result.getSize());//페이지 당 데이터 개수
		System.out.println("has next page:"+ result.hasNext());//다음 페이지 존재 여부 
		System.out.println("first Page?:"+ result.isFirst());//첫번째 페이지
		
		
		System.out.println("-------------------------------------------------------------------");
		
		for(Memo memo:result.getContent()) {
			System.out.println(memo);
		}
	}
     //select from limit=========== select from 
	
	
	//page 숫자가 나옴.... 
	
	
	
	//@Test
	void testQueryMethodWithPageable() {
		Pageable pageable = PageRequest.of(0, 10, Sort.by("mno")); 
		Page<Memo>result = memoRepository.findByMnoBetween(10L, 50L,pageable); 
		result.get().forEach(memo->System.out.println(memo));
	
	}
	//@Test
	void testQueryMethod1() {
		List<Memo> list = memoRepository.findByMnoBetweenOrderByMnoDesc(120L, 130L);
				
		for(Memo memo : list) {
			System.out.println(memo);
		}
	}
	
	
	
	//@Test
	void testDelete() {
		Long mno = 100L; 
		
		memoRepository.deleteById(mno);
	}
	
	
	
	
	// @Test
	void testSelect() {
		Long mno = 100L; 
		
		Optional<Memo> result = memoRepository.findById(mno); 
		
		if(result.isPresent()) {
			Memo memo = result.get(); 
			System.out.println(memo);
		}
	}
	
	//@Test
	void testSelectAll() {
		
		Long mno = 100L;
		
		List<Memo>memoList = memoRepository.findAll(); 
		
		for(Memo memo : memoList) {
			System.out.println(memo);
		}
	
		memoRepository.findAll(); 
	}
	//@Test
	void testUpdate() {
		Memo memo = Memo.builder().mno(100L).memoText("Update Text").build(); 
		System.out.println(memoRepository.save(memo));
	
	
	
	
	}
		
		
		
	
	
	/*게시글내용에 특정 단어가 포함된 게시글 조회하기 	
	List<Board> findByContentContaining(String keyword); 
	제목에 특정 단어가 포함된 게시글의 개수 조회하기 
	long countByTitieContaining(String keyword); 
	지정된 문자열로 시작하는 게시글 찾기 
	List<Board> findByTitleStartingWith(String prefix); 
	지정된 문자열로 끝나는 항목찾기 
	List<Board> findByTitleEndingWith(String suffix); 
	N개의 상위 항목 조회하기
	List<Board> findTop3ByWriterOrderByRegDateDesc(String writer);*/
	

	
	
}

	

