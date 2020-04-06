package test;

import org.junit.Test;
import utils.JdbcUtils;

public class JdbcUtilsText {
    @Test
    public void testJdbcUtils(){
        System.out.println(JdbcUtils.getConnection());
    }
}
