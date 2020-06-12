/* TODO:: PORT IT TO JAVA-8+
* http://www.java2s.com/Tutorials/Java/Java_Date_Time/index.htm
* https://docs.oracle.com/javase/tutorial/datetime/TOC.html
*/
package com.powertamil.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtils {

    protected static final String TAMIL_YEAR = "வருடம்";
    protected static final String TAMIL_MONTH = "மாதம்";
    protected static final String TAMIL_DAY = "நாள்";
    protected static final String TAMIL_HOUR = "மணி";
    protected static final String TAMIL_MIN = "நிமிடம்";
    protected static final String TAMIL_SEC = "நொடி";

    protected static final String TAMIL_TODAY = "இன்று";
    protected static final String TAMIL_YESTERDAY = "நேற்று";
    protected static final String TAMIL_TOMORROW = "நாளை";


    public static long now() {
        return new Date().getTime();
    }

    /**
     * Time converted to display string
     *
     * @param timeStamp In seconds
     */
    public static String formatTime(long timeStamp, boolean simple) {
        if (timeStamp == 0) return "";

        Calendar input = Calendar.getInstance();
        input.setTimeInMillis(timeStamp);
        String time = (new SimpleDateFormat("HH:mm:ss")).format(input.getTime());
        String date = (new SimpleDateFormat(
                "yyyy"
                        + "MM" + TAMIL_MONTH
                        + "dd" + TAMIL_DAY)).format(input.getTime());
        Calendar calendar = Calendar.getInstance();
        //Current time before input time
        if (!calendar.after(input)) {
            return date;
        }

        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        if (calendar.before(input)) {
            return String.format("%s %s", TAMIL_TODAY, simple ? "" : time);
        }
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        if (calendar.before(input)) {
            return String.format("%s %s", TAMIL_YESTERDAY, simple ? "" : time);
        }

        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        if (!simple && calendar.before(input)) {
            date = (new SimpleDateFormat(
                    "MM" + "TIME_MONTH"
                            + "dd" + "TIME_DAY")).format(input.getTime());
        }
        return String.format("%s %s", date, simple ? "" : time);
    }

    /**
     * Time converted to display string
     *
     * @param timeStamp In seconds
     */
    public static String formatTimeNoMillisecond(long timeStamp) {
        if (timeStamp == 0) return "";

        Calendar input = Calendar.getInstance();
        input.setTimeInMillis(timeStamp);
        input.getFirstDayOfWeek();
        String date = (new SimpleDateFormat(
                "yyyy "
                        + " MM " + TAMIL_MONTH
                        + " dd " + TAMIL_DAY)).format(input.getTime());
        return date;
    }

    /**
     * Determine the current date is the day of the week -1 is converted to one
     */

    public static String intForString(String pTime) {
        if (pTime == null) {
            return "";
        }

        int i = dayForWeek(pTime);
        String week = "";
        switch (i) {
            case 1:
                week = "1";
                break;
            case 2:
                week = "2";
                break;
            case 3:
                week = "3";
                break;
            case 4:
                week = "4";
                break;
            case 5:
                week = "5";
                break;
            case 6:
                week = "6";
                break;
            case 7:
                week = "7";
                break;
            default:
                break;
        }
        return week;
    }

    /**
     * Determine the current date is the day of the week
     */
    @SuppressWarnings("SimpleDateFormat")
    public static int dayForWeek(String pTime) {
        if (pTime == null) {
            return 0;
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(format.parse(pTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int dayForWeek = 0;
        if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            dayForWeek = 7;
        } else {
            dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
        }
        return dayForWeek;
    }

    /**
     * Convert millisecond value to time - with Tamil characters
     */
    @SuppressWarnings("SimpleDateFormat")
    public static String getDate2(String date) {
        if (date == null) {
            return "";
        }
        long ms = Long.parseLong(date);
        SimpleDateFormat formatter = new SimpleDateFormat("MM "+ TAMIL_MONTH + " dd "+ TAMIL_DAY);// Initialize the Formatter conversion format。
        String hms = formatter.format(ms);
        return hms;
    }

    /**
     * Convert millisecond value to time - with Tamil characters
     */
    @SuppressWarnings("SimpleDateFormat")
    public static String getDateTamil(String date) {
        if (date == null) {
            return "";
        }
        long ms = Long.parseLong(date);
        SimpleDateFormat formatter = new SimpleDateFormat("Yyyy "+
                "MM " +TAMIL_MONTH +
                "dd "+ TAMIL_DAY);// Initialize the Formatter conversion format
        String hms = formatter.format(ms);
        return hms;
    }

    /**
     * Convert millisecond value to time
     */
    @SuppressWarnings("SimpleDateFormat")
    public static String getDate(String date) {
        if (date == null) {
            return "";
        }
        long ms = Long.parseLong(date);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");// Initialize the Formatter conversion format。
        String hms = formatter.format(ms);
        return hms;
    }


    /**
     * Convert millisecond value to time---HH:mm
     */
    @SuppressWarnings("SimpleDateFormat")
    public static String getMinDate(String date) {
        if (date == null) {
            return "";
        }
        long ms = Long.parseLong(date);
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");// Initialize the Formatter conversion format。
        String hms = formatter.format(ms);
        return hms;
    }

    public static String timeStamp2Date(String seconds) {
        if (seconds == null || seconds.isEmpty() || seconds.equals("null")) {
            return "";
        }
        String format = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(Long.valueOf(seconds + "000")));
    }

    /**
     * Millisecond value converted to time --- MM month dd day HH: mm
     */
    @SuppressWarnings("SimpleDateFormat")
    public static String getMonthDate(String date) {
        if (date == null) {
            return "";
        }
        long ms = Long.parseLong(date);
        SimpleDateFormat formatter = new SimpleDateFormat("MM month dd day HH:mm");// Initialize the Formatter conversion format。
        String hms = formatter.format(ms);
        return hms;
    }

    /**
     * Convert the day of the week based on the provided timestamp
     *
     * @param timeStamp
     * @return
     */
    public static String getWeek(long timeStamp) {
        int mydate = 0;
        String week = null;
        Calendar cd = Calendar.getInstance();
        cd.setTime(new Date(timeStamp));
        mydate = cd.get(Calendar.DAY_OF_WEEK);
        // Get the specified date into a day of the week
        if (mydate == 1) {
            week = "Sunday";
        } else if (mydate == 2) {
            week = "on Monday";
        } else if (mydate == 3) {
            week = "on Tuesday";
        } else if (mydate == 4) {
            week = "on Wednesday";
        } else if (mydate == 5) {
            week = "Thursday";
        } else if (mydate == 6) {
            week = "Friday";
        } else if (mydate == 7) {
            week = "on Saturday";
        }
        return week;
    }

    /**
     * Get the timestamp of the first day of the month
     */
    public static long getMonthFirstDay() {
        Calendar calendar = Calendar.getInstance();// Get the current date
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);// Set to number 1, the current date is the first day of the month
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        System.out.println(calendar.getTimeInMillis());

        return calendar.getTimeInMillis();
    }

    /**
     * Time value converted to milliseconds
     */
    @SuppressWarnings("SimpleDateFormat")
    public static long getLongDate(String date) {
        if (date == null) {
            return 0;
        }
        long s = 0;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");// Initialize the Formatter conversion format。
        try {
            s = formatter.parse(date).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return s;
    }

    /**
     * Convert precise time values to milliseconds
     */
    @SuppressWarnings("SimpleDateFormat")
    public static long getLongTrueDate(String date) {
        if (date == null) {
            return 0;
        }
        long s = 0;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");// Initialize the Formatter conversion format。
        try {
            s = formatter.parse(date).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return s;
    }

    /**
     * Current time day
     */
    @SuppressWarnings("SimpleDateFormat")
    public static String getCurrentDay() {
        long ms = System.currentTimeMillis();
        SimpleDateFormat formatter = new SimpleDateFormat("dd");// Initialize the Formatter conversion format。
        String hms = formatter.format(ms);
        return hms;
    }

    /**
     * Current time hour
     */
    @SuppressWarnings("SimpleDateFormat")
    public static String getCurrentHour() {
        long ms = System.currentTimeMillis();
        SimpleDateFormat formatter = new SimpleDateFormat("HH");// Initialize the Formatter conversion format。
        String hms = formatter.format(ms);
        return hms;
    }

    /**
     * Current time minute
     */
    @SuppressWarnings("SimpleDateFormat")
    public static String getCurrentMin() {
        long ms = System.currentTimeMillis();
        SimpleDateFormat formatter = new SimpleDateFormat("mm");// Initialize the Formatter conversion format。
        String hms = formatter.format(ms);
        return hms;
    }

    /**
     * Current time month
     */
    @SuppressWarnings("SimpleDateFormat")
    public static String getCurrentMonth() {
        long ms = System.currentTimeMillis();
        SimpleDateFormat formatter = new SimpleDateFormat("MM");// Initialize the Formatter conversion format。
        String hms = formatter.format(ms);
        return hms;
    }

    /**
     * Current time year
     */
    @SuppressWarnings("SimpleDateFormat")
    public static String getCurrentYear() {
        long ms = System.currentTimeMillis();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");// Initialize the Formatter conversion format。
        String hms = formatter.format(ms);
        return hms;
    }

    /**
     * How many days are there in the current month?
     */
    @SuppressWarnings("SimpleDateFormat")
    public static String[] getDays(String year, String month) {
        String[] days = null;
        int y = Integer.parseInt(year);
        int m = Integer.parseInt(month);
        if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) {
            days = new String[31];
            for (int i = 0; i < 31; i++) {
                days[i] = (i + 1) + "day";
            }
            return days;
        } else if (m == 4 || m == 6 || m == 9 || m == 11) {
            days = new String[30];
            for (int i = 0; i < 30; i++) {
                days[i] = (i + 1) + "day";
            }
            return days;
        } else if (m == 2) {
            if ((y % 100 == 0 && y % 400 == 0) || (y % 100 != 0 && y % 4 == 0)) {
                days = new String[29];
                for (int i = 0; i < 29; i++) {
                    days[i] = (i + 1) + "day";
                }
                return days;
            } else {
                days = new String[28];
                for (int i = 0; i < 28; i++) {
                    days[i] = (i + 1) + "day";
                }
                return days;
            }
        }
        return days;
    }
}