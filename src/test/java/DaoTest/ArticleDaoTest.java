package DaoTest;

import com.blog.dao.ArticleDao;
import com.blog.model.ArticleCustom;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 *
 * Created by Black on 2016/7/24.
 */
public class ArticleDaoTest extends BaseJunit4Test {
    @Autowired
    private ArticleDao articleDao;

    @Before
    public void before() throws Exception {
    }
    @Test
    public void testInjections(){
       Assert.assertNotNull(articleDao);
    }

    @Test
    public void testSelectArticleByCid() throws Exception {
        List<ArticleCustom> articleCustoms = articleDao.findArticleByCid(1);
        for (ArticleCustom ac : articleCustoms){
            System.out.println(ac.getCategoryName());
            System.out.println(ac);
        }
    }

    @After
    public void after() throws Exception {
    }
}
