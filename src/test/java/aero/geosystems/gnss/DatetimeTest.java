package aero.geosystems.gnss;

import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: aimozg
 * Date: 21.02.14
 * Time: 16:15
 */
public class DatetimeTest {
	private Datetime dt0;
	private Datetime dt4;
	private Datetime dt12;
	private Datetime dt16;

	@Before
	public void createDt() {
		dt0 = new Datetime(2001, 2, 3, 0, 5, 6, 78);
		dt4 = new Datetime(2001, 2, 3, 4, 5, 6, 78);
		dt12 = new Datetime(2001, 2, 3, 12, 5, 6, 78);
		dt16 = new Datetime(2001, 2, 3, 16, 5, 6, 78);
	}

	@Test
	public void testNegative() {
		String fmt = "YYYY-MM-DD HH:mm:ss.ccc";
		assertEquals("1970-01-01 00:00:00.000",new Datetime(0L).format(fmt));
		assertEquals("1969-12-31 23:59:59.999",new Datetime(-1L).format(fmt));
	}

	@Test
	public void testDow() {
		assertEquals("Jan 1 2000",Datetime.SZ_SATURDAY,new Datetime(2000,1,1).dayOfWeekSZ());
	}

	@Test
	public void testDoy() {
		assertEquals("Jan 1", 1, new Datetime(2000, 1, 1).dayOfYear());
		assertEquals("Jan 31", 31, new Datetime(2000, 1, 31).dayOfYear());
		assertEquals("Feb 1", 31 + 1, new Datetime(2000, 2, 1).dayOfYear());
		assertEquals("Mar 1 leap", 31 + 29 + 1, new Datetime(2000, 3, 1).dayOfYear());
		assertEquals("Mar 1 non-leap", 31 + 28 + 1, new Datetime(2001, 3, 1).dayOfYear());
		assertEquals("Dec 31 leap", 366, new Datetime(2000, 12, 31).dayOfYear());
		assertEquals("Dec 31 non-leap", 365, new Datetime(2001, 12, 31).dayOfYear());
	}

	@Test
	public void testTz() throws ParseException {
		Datetime dt = new Datetime(2001, 2, 3, 4, 5, 6);
		String fmt = "YYYY-MM-DD HH:mm:ss \\U\\T\\CzUU:uu";
		assertEquals("2001-02-03 04:05:06 UTC+00:00",dt.format(fmt));
		assertEquals(dt,Datetime.parse(fmt,dt.format(fmt)));
		assertEquals("2001-02-03 04:05:06 UTC+00:00",dt.format(fmt,0));
		assertEquals(dt,Datetime.parse(fmt,dt.format(fmt,0)));
		assertEquals("2001-02-03 04:35:06 UTC+00:30",dt.format(fmt,0,30));
		assertEquals(dt,Datetime.parse(fmt,dt.format(fmt,0,30)));
		assertEquals("2001-02-03 03:35:06 UTC-00:30",dt.format(fmt,0,-30));
		assertEquals(dt,Datetime.parse(fmt,dt.format(fmt,0,-30)));
		assertEquals("2001-02-03 16:05:06 UTC+12:00",dt.format(fmt,12));
		assertEquals(dt,Datetime.parse(fmt,dt.format(fmt,12)));
		assertEquals("2001-02-02 16:05:06 UTC-12:00",dt.format(fmt,-12));
		assertEquals(dt,Datetime.parse(fmt,dt.format(fmt,-12)));
	}

	@Test
	public void testParse() throws ParseException {


		Datetime dt = new Datetime(2001, 2, 3, 4, 5, 6, 789);
		String fmt = "YYYYMMDDHHmmssccc";
		assertEquals(dt, Datetime.parse(fmt, dt.format(fmt)));
		assertEquals(dt,new Datetime(dt.getTime()));

		dt = new Datetime(2001, 2, 3, 4, 5, 6, 789);
		fmt = "YYYY-MM-DD HH:mm:ss.ccc";
		assertEquals(dt, Datetime.parse(fmt, dt.format(fmt)));
		assertEquals(dt,new Datetime(dt.getTime()));

		dt = new Datetime(2001, 2, 3, 4, 5, 6, 78);
		fmt = "YYYY-MM-DD HH:mm:ss.C";
		assertEquals(dt, Datetime.parse(fmt, dt.format(fmt)));
		assertEquals(dt,new Datetime(dt.getTime()));

		dt = new Datetime(2001, 2, 3);
		fmt = "YYY MM DD";
		assertEquals(dt, Datetime.parse(fmt, dt.format(fmt)));
		assertEquals(dt,new Datetime(dt.getTime()));

		dt = new Datetime(999, 2, 3);
		fmt = "YYY MM DD";
		assertEquals(dt, Datetime.parse(fmt, dt.format(fmt)));
		assertEquals(dt,new Datetime(dt.getTime()));

		dt = new Datetime(2069, 2, 3, 4, 5, 6, 780);
		fmt = "YY-M-D H:m:s.cc";
		assertEquals(dt, Datetime.parse(fmt, dt.format(fmt)));
		assertEquals(dt,new Datetime(dt.getTime()));

		dt = new Datetime(1970, 2, 3, 14, 15, 16, 700);
		fmt = "YY-M-D H:m:s.c";
		assertEquals(dt, Datetime.parse(fmt, dt.format(fmt)));
		assertEquals(dt,new Datetime(dt.getTime()));

		dt = new Datetime(2001, 10, 11);
		fmt = "YYYY MMMM DD";
		assertEquals(dt, Datetime.parse(fmt, dt.format(fmt)));
		assertEquals(dt,new Datetime(dt.getTime()));

		dt = new Datetime(2001, 11, 12);
		fmt = "YYYY MMM DD";
		assertEquals(dt, Datetime.parse(fmt, dt.format(fmt)));
		assertEquals(dt,new Datetime(dt.getTime()));

		dt = new Datetime(2001, 2, 10);
		fmt = "YYYY DDDD";
		assertEquals(dt, Datetime.parse(fmt, dt.format(fmt)));
		assertEquals(dt,new Datetime(dt.getTime()));

		dt = new Datetime(2001, 2, 10);
		fmt = "YYYY DDD";
		assertEquals(dt, Datetime.parse(fmt, dt.format(fmt)));
		assertEquals(dt,new Datetime(dt.getTime()));

		dt = new Datetime(2001, 2, 10, 13, 14, 0);
		fmt = "YYYY MM DD HH:mm pp";
		assertEquals(dt, Datetime.parse(fmt, dt.format(fmt)));
		assertEquals(dt,new Datetime(dt.getTime()));

		dt = new Datetime(2001, 2, 10, 13, 14, 0);
		fmt = "YYYY MM DD H:mm p";
		assertEquals(dt, Datetime.parse(fmt, dt.format(fmt)));
		assertEquals(dt,new Datetime(dt.getTime()));

		dt = new Datetime(2001, 2, 10, 13, 14, 0);
		fmt = "YYYY MM DD h:mm PP";
		assertEquals(dt, Datetime.parse(fmt, dt.format(fmt)));
		assertEquals(dt,new Datetime(dt.getTime()));

		dt = new Datetime(2001, 2, 10, 13, 14, 0);
		fmt = "YYYY MM DD h:mm P";
		assertEquals(dt, Datetime.parse(fmt, dt.format(fmt)));
		assertEquals(dt,new Datetime(dt.getTime()));
	}

	/*
	YYYY -> String.format("%04d",year())
	YYY -> String.valueOf(year())
	YY -> String.valueOf(year()%100)
	MMMM - January..December <br/>
	MMM - Jan..Dec <br/>
	MM -> String.format("%02d",month()-FIRST_MONTH+1)
	M -> String.valueOf(month()-FIRST_MONTH+1)
	DDDD -> String.format("%03d",dayOfYear())
	DDD -> String.valueOf(dayOfYear())
	DD -> String.format("%02d",day()-FIRST_DAY_OF_MONTH+1)
	D -> String.valueOf(day()-FIRST_DAY_OF_MONTH+1)
	HH -> String.format("%02d",hour24())
	H -> String.valueOf(hour24())
	hh -> String.format("%02d",hour12())
	h -> String.valueOf(hour12())
	PP -> isAM()?"A.M.":"P.M."
	P -> isAM()?"AM.":"PM."
	pp -> isAM()?"a.m.":"p.m."
	p -> isAM()?"am":"pm"
	mm -> String.format("%02d",min())
	m -> String.valueOf(min())
	ss -> String.format("%02d",sec())
	s -> String.valueOf(sec())
	ccc -> String.format("%03d",milli())
	cc -> String.format("%02d",milli()/10)
	c -> String.format("%01d",milli()/100)
	C -> String.valueOf(milli()) */
	@Test
	public void testFormat() {
		//dt4 = new Datetime(2001y,2m,3d,4h,5m,6s,78ms);
		assertEquals("" +
						("\\ " +
								"20011 YYYYY " +
								"2001 YYYY " +
								"2001 YYY " +
								"01 YY " +
								"1 Y " +
								"February2 MMMMM " +
								"February MMMM " +
								"Feb MMM " +
								"02 MM " +
								"2 M " +
								"0343 DDDDD " +
								"034 DDDD " +
								"34 DDD " +
								"03 DD " +
								"3 D " +
								"044 HHH " +
								"04 HH " +
								"4 H " +
								"044 hhh " +
								"04 hh " +
								"4 h " +
								"A.M.AM PPP " +
								"A.M. PP " +
								"AM P " +
								"a.m.am ppp " +
								"a.m. pp " +
								"am p " +
								"055 mmm " +
								"05 mm " +
								"5 m " +
								"066 sss " +
								"06 ss " +
								"6 s " +
								"0781 cccc " +
								"078 ccc " +
								"08 cc " +
								"1 c " +
								"7878 CC " +
								"78 C " +
								"SaturdaySat WWW " +
								"Saturday WW " +
								"Sat W"),
				dt4.format("\\\\ " +
						"YYYYY \\Y\\Y\\Y\\Y\\Y " +
						"YYYY \\Y\\Y\\Y\\Y " +
						"YYY \\Y\\Y\\Y " +
						"YY \\Y\\Y " +
						"Y \\Y " +
						"MMMMM \\M\\M\\M\\M\\M " +
						"MMMM \\M\\M\\M\\M " +
						"MMM \\M\\M\\M " +
						"MM \\M\\M " +
						"M \\M " +
						"DDDDD \\D\\D\\D\\D\\D " +
						"DDDD \\D\\D\\D\\D " +
						"DDD \\D\\D\\D " +
						"DD \\D\\D " +
						"D \\D " +
						"HHH \\H\\H\\H " +
						"HH \\H\\H " +
						"H \\H " +
						"hhh \\h\\h\\h " +
						"hh \\h\\h " +
						"h \\h " +
						"PPP \\P\\P\\P " +
						"PP \\P\\P " +
						"P \\P " +
						"ppp \\p\\p\\p " +
						"pp \\p\\p " +
						"p \\p " +
						"mmm \\m\\m\\m " +
						"mm \\m\\m " +
						"m \\m " +
						"sss \\s\\s\\s " +
						"ss \\s\\s " +
						"s \\s " +
						"cccc \\c\\c\\c\\c " +
						"ccc \\c\\c\\c " +
						"cc \\c\\c " +
						"c \\c " +
						"CC \\C\\C " +
						"C \\C " +
						"WWW \\W\\W\\W " +
						"WW \\W\\W " +
						"W \\W")
		);
		assertEquals("" + (
						"" +
								"00 0 12 12 A.M. AM a.m. am"),
				dt0.format("" +
						"HH H hh h PP P pp p")
		);
		assertEquals("" + (
						"" +
								"12 12 12 12 P.M. PM p.m. pm"),
				dt12.format("" +
						"HH H hh h PP P pp p")
		);
		assertEquals("" + (
						"" +
								"16 16 04 4 P.M. PM p.m. pm"),
				dt16.format("" +
						"HH H hh h PP P pp p")
		);
	}

	@Test
	public void testParseZ() throws ParseException {
		String oformat = "YYYY-MM-DDTHH:mm:ss";
		String iformat = "YYYY-MM-DDTHH:mm:sszUU:uu";
		String dts = dt0.format(oformat) + "-01:02";
		Datetime dt02 = Datetime.parse(iformat, dts);
		assertEquals(dt02.hour(), dt0.hour() + 1);
		assertEquals(dt02.min(), dt0.min() + 2);
	}
}
