package common;

import common.util.BeanUtils;

/**
 * @author pkx
 * @date 2016-06-07
 */
public class BeanUtilTest {

    public static void main(String[] args) throws Exception{
        BeanUtilTest beanUtilTest = new BeanUtilTest();
        BeanUtils beanUtils = new BeanUtils();
        beanUtilTest.beanTool(beanUtils, User.class);
        //beanUtilTest.beanTool(beanUtils, People.class);
       // beanUtilTest.beanTool(beanUtils, Admin.class);
    }
    
    /**
     * 根据bean生成相应的文件
     * @param beanUtils
     * @param c
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public void beanTool(BeanUtils beanUtils ,Class c)throws Exception{
        beanUtils.createBeanDao(c);
        beanUtils.createBeanDaoImpl(c);
        beanUtils.createBeanService(c);
        beanUtils.createBeanServiceImpl(c);
    }
}