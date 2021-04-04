package test;

import java.util.Calendar;

/**
 * @author hjz
 * @version 1.0
 * @date 2021/3/31 22:50
 */
public class fuck {
    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();//可用于1970年后操作日期用
        for (int year = 1999; year < 10000; year += 100) {
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, 11);//12月  只有月份是0开始的，0对应1月
            calendar.set(Calendar.DAY_OF_MONTH, 31);
            System.out.println(year + " " + calendar.get(Calendar.DAY_OF_WEEK));
            if (calendar.get(Calendar.DAY_OF_WEEK) == 1) {//1：星期天 2：星期一 外国人的第一天是星期天
                break;
            }
        }

        int week = 4;//为了方便求模，0代表星期一，1999年12月31是星期五，初始化4
//		int[] data1 = new int[] {-1,31,28,31,30,31,30,31,31,30,31,30,31};
//		int[] data2 = new int[] {-1,31,29,31,30,31,30,31,31,30,31,30,31};//闰年天数

        for (int year = 2099; year <= 9999; year += 100) {
            if ((year % 100 != 0 && year % 4 == 0) || year % 400 == 0)
                week = (week + 366) % 7;
            else
                week = (week + 365) % 7;
            System.out.println(year + " " + week);
        }
    }
}
