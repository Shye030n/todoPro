package com.orgpgm.todopro.mapper;

import com.orgpgm.todopro.dto.TodoDTO;
import com.orgpgm.todopro.service.TodoService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mariadb.jdbc.plugin.codec.LocalDateCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.Date;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TodoMapperTest {
    @Autowired(required = false) // 주입할 수 있는 빈이 없더라도 정상적으로 애플리케이션을 실행하도록.
    //@Autowired(required = true)  주입할 수 있는 빈이 없으면 애플리케이션이 실행할 때 에러 발생.
    private TodoMapper todoMapper;
    // 이 클래스에서 TodoMapper.java에서 만든 getTime()메서드를 사용하기 위해
    // 클래스를 갖고와서 todoMapper라 클래스 선언
    // ! 선언만 함 !
    private TodoService todoService; //클래스 객체 생성 = 클래스 선언


    @Test
    public void testGetTime(){
        log.info(todoMapper.getTime());
        //정보기록지(todoMapper의 getTime을 호출
        // ! 사용함
    }

    @Test
    public void testInsert() throws Exception{
        TodoDTO dto=new TodoDTO();
        dto.setTitle("목제");
        dto.setDueDate(LocalDate.now());
        dto.setWriter("작가");
        //todoService.register((dto));
        //todoMapper.insert(dto);

    }
}
