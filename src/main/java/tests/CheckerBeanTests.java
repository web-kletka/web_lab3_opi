package tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.roma.beans.CheckerBean;

public class CheckerBeanTests {
    @Test
    public void badDataTest(){
        CheckerBean checkerBean = new CheckerBean();
        checkerBean.check("asd", "ass", "sada", "qwe");
    }
}
