package com.example.mytest3;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.mytest3.entity.Memo;
import com.example.mytest3.repository.MemoRepository;
@SpringBootTest
class MemoRepositoryTest {
	@Autowired
	MemoRepository memoRepository;
	
	@Test
	void testInsert() {
		Memo memo= new Memo(1L,"제목1","내용1","관리자"); 
		memoRepository.save(memo); //엔티티에 있는 값을 넣어준다

	}

}
