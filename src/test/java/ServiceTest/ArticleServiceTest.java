package ServiceTest;

import com.blog.model.ArticleCustom;
import com.blog.service.ArticleService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import DaoTest.BaseJunit4Test;

import java.util.List;

/**
 *
 * Created by Black on 2016/7/24.
 */
public class ArticleServiceTest extends BaseJunit4Test {
    @Autowired
    private ArticleService articleService;

    @Before
    public void before() throws Exception {
    }
    @Test
    public void testInjections(){
       Assert.assertNotNull(articleService);
    }

    @Test
    public void testSelectArticleByCid() throws Exception {
        List<ArticleCustom> articles = articleService.selectArticleByCid(1);
        for (ArticleCustom ac : articles){
            System.out.println(ac.getCategoryName());
            System.out.println(ac);
        }
    }

    @After
    public void after() throws Exception {
    }
}
