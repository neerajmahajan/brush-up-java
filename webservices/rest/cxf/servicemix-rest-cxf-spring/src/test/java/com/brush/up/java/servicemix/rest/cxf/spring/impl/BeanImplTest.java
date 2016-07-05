package com.brush.up.java.servicemix.rest.cxf.spring.impl;

import junit.framework.TestCase;
import com.brush.up.java.servicemix.rest.cxf.spring.Bean;

public class BeanImplTest extends TestCase {

    public void testBeanIsABean() {
	Bean aBean = new BeanImpl();
        assertTrue(aBean.isABean());
    }

}