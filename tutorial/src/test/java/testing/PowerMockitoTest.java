package testing;
/**
 *  @author: 	Ryan K K Lam
 *  @date:      2018年3月27日 下午11:20:29
 *  @Links: 	https://github.com/ryankklam
 *  @Email: 	ryan4299899@126.com
 *
 */

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)  //1.
@PrepareForTest({DateUtility.class}) //2.
public class PowerMockitoTest {
 
 
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    
	@Test
	public void test_PowerMock_staticMethod_Mock() {

		NotificationUtil spyLogUtil = PowerMockito.spy(new NotificationUtil());

		PowerMockito.mockStatic(DateUtility.class);// 3.Mock静态类
		PowerMockito.when(DateUtility.adjustToWorkingDate(Mockito.anyString(), Mockito.eq("BEI"), Mockito.anyInt(),//need to use Mockito.eq() as all parm must be matcher if 1 of them is matcher
				Mockito.anyBoolean())).thenReturn(19851226);// 4.预设静态类返回值 , when holiday area code = BEI then return mock value 19851226
		
		//perform
		int response = spyLogUtil.getNotifyDateWithHolidayCode("CN", "BEI",20150313,true);
		Assert.assertEquals(19851226, response);//return the mock value 19851226 instead of actual default value 19001231 

		response = spyLogUtil.getNotifyDateWithHolidayCode("CN", "GZH",20150313,true);
		Assert.assertEquals(0, response);//holiday area code GZH as parm , haven't stub the return. Since it's a MOCK object , nothing will execute , return 0 
		
	}
    
    @Test
    public void test_PowerMock_staticMethod_Spy()  {

	   NotificationUtil spyLogUtil = PowerMockito.spy(new NotificationUtil());
	   
	   PowerMockito.spy(DateUtility.class); //spy the static class

//	   BDDMockito.given(DateUtility.adjustToWorkingDate("CN", "BEI",20150313,true)).willReturn(19860130);//stub return for spy objects , need to use given(XXX.method(YYY)).willReturn(value);
	   BDDMockito.given(DateUtility.adjustToWorkingDate(Mockito.anyString(), Mockito.eq("BEI"),Mockito.anyInt(),Mockito.anyBoolean())).willReturn(19860130);//stub return for spy objects , need to use given(XXX.method(YYY)).willReturn(value);
       int response = spyLogUtil.getNotifyDateWithHolidayCode("CN", "BEI",20150313,true);
       Assert.assertEquals(19860130,response);
        
       response = spyLogUtil.getNotifyDateWithHolidayCode("CN", "GZH",20150313,true);
       Assert.assertEquals(19001231,response);//holiday area code GZH as parm , haven't stub the return. Since it's a SPY object , it will execute the actual logic, return default 19001231 
    }
}
