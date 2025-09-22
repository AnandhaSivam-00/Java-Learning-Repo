import Application.App;
import Application.Controller.SearchController;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest(classes = App.class)
@AutoConfigureMockMvc
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private SearchController searchController;

    @Test
    public void testGetSearchFormat1() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/cats").param("amount", "50"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("50"));
    }


    @Test
    public void testGetSearchFormat2() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/cats").param("amount", "100"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("100"));
    }
    @Test
    public void testGetSearchFormatAndAmount1() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/cats").param("format", "gif").param("orderBy", "new"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0]").value("gif"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1]").value("new"));
    }
    @Test
    public void testGetSearchFormatAndAmount2() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/cats").param("format", "png").param("orderBy", "old"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0]").value("png"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1]").value("old"));
    }
}