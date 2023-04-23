package com.zerock.guestbook.service;

import com.zerock.guestbook.dto.GuestbookDTO;
import com.zerock.guestbook.dto.PageRequestDTO;
import com.zerock.guestbook.dto.PageResultDTO;
import com.zerock.guestbook.entity.Guestbook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GuestbookServiceImplTest {

    @Autowired
    GuestbookService service;

    @Test
    public void testRegister() {
        GuestbookDTO dto = GuestbookDTO.builder()
                .title("Sample Title...")
                .content("Sample Content...")
                .writer("Sample Writer...")
                .build();

        System.out.println(service.register(dto));
    }

    @Test
    public void testList() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .build();

        PageResultDTO<GuestbookDTO, Guestbook> result = service.getList(pageRequestDTO);

        System.out.println("PREV: " + result.isPrev());
        System.out.println("NEXT: " + result.isNext());
        System.out.println("TOTAL: " + result.getTotalPage());

        System.out.println("-----------------------------------");
        for (GuestbookDTO dto : result.getDtoList()) {
            System.out.println(dto);
        }

        System.out.println("-----------------------------------");
        result.getPageList().forEach(i -> System.out.println(i));
    }
}