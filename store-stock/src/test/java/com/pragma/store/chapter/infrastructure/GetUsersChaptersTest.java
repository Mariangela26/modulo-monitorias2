package com.pragma.store.chapter.infrastructure;

import com.pragma.store.common.infraestructura.error.ChapterIdInvalid;
import com.pragma.store.common.infraestructura.error.FilterNoValid;
import com.pragma.store.common.response.ObjectResponse;
import com.pragma.store.databuilder.chapter.UsersChapterConsultTestDataBuilder;
import com.pragma.store.databuilder.chapter.UsersChapterFilterCommandTestDataBuilder;
import com.pragma.store.databuilder.chapter.UsersChapterFilterConsultTestDataBuilder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Locale;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GetUsersChaptersTest {

    public static final String RUTA_CONTROLADOR = "/chapter/users";
    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String AUTHORIZATION_HEADER_TOKEN = "eyJraWQiOiJlcERtUHA2TUdnVVNtWFN6RktoV2VjcVRLQ0NJUWVHT0t3ZDlTOWdkV3RzPSIsImFsZy" +
            "I6IlJTMjU2In0.eyJhdF9oYXNoIjoiZnozQy1tMHVFZFQ3cmVGWW9sUWl1dyIsInN1YiI6IjBiMjY0OGU0LTBkYWMtNDQ0Yy1iODUxLTdlMmI3NzEzOTljNSIsImNv" +
            "Z25pdG86Z3JvdXBzIjpbInVzLWVhc3QtMV9Ud3N5d2ZySURfR29vZ2xlIl0sImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwiaXNzIjoiaHR0cHM6XC9cL2NvZ25pdG8taW" +
            "RwLnVzLWVhc3QtMS5hbWF6b25hd3MuY29tXC91cy1lYXN0LTFfVHdzeXdmcklEIiwiY29nbml0bzp1c2VybmFtZSI6Ikdvb2dsZV8xMDM1NjI4MTIxMTY0NjkxNTgz" +
            "NDMiLCJhdWQiOiI1OXJ0aTAxNDlzbGhpdmN2dDNnZjFxMTUyYyIsImlkZW50aXRpZXMiOlt7InVzZXJJZCI6IjEwMzU2MjgxMjExNjQ2OTE1ODM0MyIsInByb3ZpZG" +
            "VyTmFtZSI6Ikdvb2dsZSIsInByb3ZpZGVyVHlwZSI6Ikdvb2dsZSIsImlzc3VlciI6bnVsbCwicHJpbWFyeSI6InRydWUiLCJkYXRlQ3JlYXRlZCI6IjE2MjM0Mjc3" +
            "ODIzNjUifV0sInRva2VuX3VzZSI6ImlkIiwiYXV0aF90aW1lIjoxNjMxNzMwNjcyLCJuYW1lIjoiWyU3Qm1ldGFkYXRhJTNEJTdCcHJpbWFyeSUzRHRydWUlMkMrc2" +
            "91cmNlJTNEJTdCdHlwZSUzRFBST0ZJTEUlMkMraWQlM0QxMDM1NjI4MTIxMTY0NjkxNTgzNDMlN0QlN0QlMkMrZGlzcGxheU5hbWUlM0RKdWFuK0FuZHIlQzMlQTlz" +
            "K0Z1ZW50ZXMrTGFndWFkbyUyQytmYW1pbHlOYW1lJTNERnVlbnRlcytMYWd1YWRvJTJDK2dpdmVuTmFtZSUzREp1YW4rQW5kciVDMyVBOXMlMkMrZGlzcGxheU5hbW" +
            "VMYXN0Rmlyc3QlM0RGdWVudGVzK0xhZ3VhZG8lMkMrSnVhbitBbmRyJUMzJUE5cyUyQyt1bnN0cnVjdHVyZWROYW1lJTNESnVhbitBbmRyJUMzJUE5cytGdWVudGVz" +
            "K0xhZ3VhZG8lN0QsICU3Qm1ldGFkYXRhJTNEJTdCc291cmNlJTNEJTdCdHlwZSUzRERPTUFJTl9QUk9GSUxFJTJDK2lkJTNEMTAzNTYyODEyMTE2NDY5MTU4MzQzJT" +
            "dEJTdEJTJDK2Rpc3BsYXlOYW1lJTNESnVhbitBbmRyJUMzJUE5cytGdWVudGVzK0xhZ3VhZG8lMkMrZmFtaWx5TmFtZSUzREZ1ZW50ZXMrTGFndWFkbyUyQytnaXZl" +
            "bk5hbWUlM0RKdWFuK0FuZHIlQzMlQTlzJTJDK2Rpc3BsYXlOYW1lTGFzdEZpcnN0JTNESnVhbitBbmRyJUMzJUE5cytGdWVudGVzK0xhZ3VhZG8lMkMrdW5zdHJ1Y3" +
            "R1cmVkTmFtZSUzREp1YW4rQW5kciVDMyVBOXMrRnVlbnRlcytMYWd1YWRvJTdEXSIsImV4cCI6MTYzMTgxNjU5NiwiaWF0IjoxNjMxODEyOTk2LCJlbWFpbCI6Imp1" +
            "YW4uZnVlbnRlc0BwcmFnbWEuY29tLmNvIn0.JK5uvTBj1-qWOrfjIdySvdKRVbagckHENQGAmhy8rcPZEjdnGkOvrIBplH8lXI7sM10ebdJYARZMsVmArvhJOgTroz" +
            "NcjWl2XDgvh2cUjSpWJKwjAFhIfAAhSTatfUUOneYHCbFijjvohMsgJhhGCN67sK9FPscSdPFAH_XGS11CGPzL9G1M1otxFsrjo9SCJnlrt6R2p4C1SWEwIIeDqLH" +
            "f2B5BHW6i1x9MJNf-8VXmWUcXGhGHwhE8KcvHgvEdZ26qiT3YKGXF3XL77Fl9t-91VCZgn6fb3SLMd0GcP1G7EtgACVgEMIHyjuUG0jGAnJd5LhPnfcOXJzdfaxS11w";
    @MockBean
    HandlerGetUsersChapter handlerGetUsersChapter;

    @Autowired
    private MockMvc mvc;

    @Test
    void testExecuteGetUsersChapters() throws Exception{
        List<UsersChapterConsult> usersChapterConsults = List.of(
                new UsersChapterConsultTestDataBuilder().buildUserChapterConsult());
        UsersChapterFilterConsult usersChapterFilterConsult = new UsersChapterFilterConsultTestDataBuilder()
                .buildUsersChapterFilterConsult();
        usersChapterFilterConsult.setData(new ObjectResponse<>(usersChapterConsults));
        UsersChapterFilterCommand usersChapterFilterCommand = new UsersChapterFilterCommandTestDataBuilder()
                .buildUsersChapterFilterCommand();
        UriComponents uri = UriComponentsBuilder
                .fromPath(RUTA_CONTROLADOR)
                .build();
        when(handlerGetUsersChapter.execute(usersChapterFilterCommand, new Locale("es")))
                .thenReturn(usersChapterFilterConsult);

        mvc.perform(MockMvcRequestBuilders.get(uri.toUriString())
                        .param("pageNumber", String.valueOf(usersChapterFilterCommand.getPageNumber()))
                        .param("allElements", String.valueOf(usersChapterFilterCommand.getAllElements()))
                        .param("assessmentDateAsc", String.valueOf(usersChapterFilterCommand.getAssessmentDateAsc()))
                        .param("chapterId", String.valueOf(usersChapterFilterCommand.getChapterId()))
                        .header(AUTHORIZATION_HEADER, AUTHORIZATION_HEADER_TOKEN)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void testExecuteGetUsersChaptersInvalidChapterId() throws Exception{
        UsersChapterFilterCommand usersChapterFilterCommand = new UsersChapterFilterCommandTestDataBuilder()
                .buildUsersChapterFilterCommand();
        usersChapterFilterCommand.setChapterId(null);
        UriComponents uri = UriComponentsBuilder
                .fromPath(RUTA_CONTROLADOR)
                .build();
        when(handlerGetUsersChapter.execute(usersChapterFilterCommand, new Locale("es")))
                .thenThrow(new ChapterIdInvalid("chapter invalido"));

        mvc.perform(MockMvcRequestBuilders.get(uri.toUriString())
                        .param("pageNumber", String.valueOf(usersChapterFilterCommand.getPageNumber()))
                        .param("allElements", String.valueOf(usersChapterFilterCommand.getAllElements()))
                        .param("assessmentDateAsc", String.valueOf(usersChapterFilterCommand.getAssessmentDateAsc()))
                        .param("chapterId", String.valueOf(usersChapterFilterCommand.getChapterId()))
                        .header(AUTHORIZATION_HEADER, AUTHORIZATION_HEADER_TOKEN)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void testExecuteGetUsersChaptersInvalidParameters() throws Exception{
        UsersChapterFilterCommand usersChapterFilterCommand = new UsersChapterFilterCommandTestDataBuilder()
                .buildUsersChapterFilterCommand();
        usersChapterFilterCommand.setAllElements(null);
        UriComponents uri = UriComponentsBuilder
                .fromPath(RUTA_CONTROLADOR)
                .build();
        when(handlerGetUsersChapter.execute(usersChapterFilterCommand, new Locale("es")))
                .thenThrow(new FilterNoValid("parametros invalidos"));

        mvc.perform(MockMvcRequestBuilders.get(uri.toUriString())
                        .param("pageNumber", String.valueOf(usersChapterFilterCommand.getPageNumber()))
                        .param("allElements", String.valueOf(usersChapterFilterCommand.getAllElements()))
                        .param("assessmentDateAsc", String.valueOf(usersChapterFilterCommand.getAssessmentDateAsc()))
                        .param("chapterId", String.valueOf(usersChapterFilterCommand.getChapterId()))
                        .header(AUTHORIZATION_HEADER, AUTHORIZATION_HEADER_TOKEN)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andDo(MockMvcResultHandlers.print());
    }
}
