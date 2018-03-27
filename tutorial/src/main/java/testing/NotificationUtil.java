package testing;
/**
 *  @author: 	Ryan K K Lam
 *  @date:      2018年3月27日 下午11:13:11
 *  @Links: 	https://github.com/ryankklam
 *  @Email: 	ryan4299899@126.com
 *
 */
public class NotificationUtil {
	
	public NotificationUtil() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getNotifyDate() {
		System.out.println("HardCode country:CN, holidayArea:BEI,Date:20180327,isRollForward:true");
		return DateUtility.adjustToWorkingDate("CN", "BEI",20180327, true);
	}

	public int getNotifyDateWithHolidayCode(String countryCode,String holidayArea,int date,boolean isRollForward){
		System.out.println("getNotifyDateWithHolidayCode!");
		return DateUtility.adjustToWorkingDate(countryCode, holidayArea,date, isRollForward);
	}
     
 }
