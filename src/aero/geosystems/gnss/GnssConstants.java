package aero.geosystems.gnss;

/**
 * Created by IntelliJ IDEA.
 * User: aimozg
 * Date: 10.03.11
 * Time: 15:09
 */
public class GnssConstants {

	/**
	 * м^3/c^2
	 */
	public static final double MU_M = 3.986005e14;
	public static final double OMEGA_DOT_E = 0.000072921151467;
	public static final double C = 299792458;
	public static final double F = -2.0 * Math.sqrt(MU_M) / C;


	/*
	 * Константы ГЛОНАСС
	 */

	/**
	 * Константа гравитацоннного поля Земли, m^3/c^2
	 */
	public static final double MU = 3.986004418E14;

	/**
	 * Коэффициент при второй зональной гармонике разложения геопотенциала в ряд по сферическим функциям
	 */
	public static final double C_20 = 1.08262575E-3;

	/**
	 * Константа гравитационного поля Луны, m^3/c^2  (в ИКД ГЛОНАСС rus, вероятно, опечатка)
	 */
	public static final double MU_L = 4.902835E3;

	/**
	 * Константа гравитационного поля Солнца, m^3/c^2
	 */
	public static final double MU_S = 1.325263E11;

	/**
	 * Экваториальный радиус Земли, m
	 */
	public static final double A_e = 6.378136E6;

	/**
	 * угловая скорость вращения Земли, рад/c
	 */
	public static final double OMEGA_EARTH = 7.292115E-5;
	/**
	 * Частота сигнала GPS L1, Гц
	 */
	public static final long GPS_L1_FREQUENCY = 1575420000L;
	/**
	 * Частота сигнала GPS L2, Гц
	 */
	public static final long GPS_L2_FREQUENCY = 1227600000L;
	public static final long GPS_L5_FREQUENCY = 1176450000L;
	/**
	 * Центральная частота сигнала ГЛОНАСС L1, Гц
	 */
	public static final long GLO_L1_FREQUENCY_0 = 1602000000L;
	/**
	 * Шаг частоты ГЛОНАСС L1, Гц
	 */
	public static final long GLO_L1_FREQ_STEP = 562500L;
	/**
	 * Минимальная частота ГЛОНАСС L1, Гц
	 */
	public static final long GLO_L1_FREQUENCY_MIN = GLO_L1_FREQUENCY_0-7*GLO_L1_FREQ_STEP;
	/**
	 * Центральная частота сигнала ГЛОНАСС L2, Гц
	 */
	public static final long GLO_L2_FREQUENCY_0 = 1246000000L;
	/**
	 * Шаг частоты ГЛОНАСС L2, Гц
	 */
	public static final long GLO_L2_FREQ_STEP = 437500L;
	/**
	 * Минимальная частота ГЛОНАСС L2, Гц
	 */
	public static final long GLO_L2_FREQUENCY_MIN = GLO_L2_FREQUENCY_0-7*GLO_L2_FREQ_STEP;
	public static final long GLO_L3_FREQUENCY = 1202025000L;
	public static final long GAL_E1_FREQUENCY = 1575420000L;
	public static final long GAL_E2_FREQUENCY = 1278750000L;
	public static final long GAL_E5_FREQUENCY = 1191795000L;
	public static final long GAL_E5a_FREQUENCY = 1176450000L;
	public static final long GAL_E5b_FREQUENCY = 1207140000L;
	public static final long QZSS_L1_FREQUENCY = 1575420000L;
	public static final long QZSS_L2_FREQUENCY = 1227600000L;
	public static final long QZSS_L5_FREQUENCY = 1176450000L;
	public static final long QZSS_LEX_FREQUENCY = 1278750000L;
	public static final long BDS_B1_FREQUENCY = 1561098000L;
	public static final long BDS_B2_FREQUENCY = 1207140000L;
	public static final long BDS_B3_FREQUENCY = 1268520000L;
	public static final long SBAS_L1_FREQUENCY = 1575420000L;
	public static final long SBAS_L5_FREQUENCY = 1176450000L;

	/**
	 * Частота ГЛОНАСС L1, Гц
	 *
	 * @param fidx Относительный номер частоты (-7..+7)
	 */
	public static long gloFreqL1(int fidx) {
		return GLO_L1_FREQUENCY_0 + fidx * GLO_L1_FREQ_STEP;
	}

	/**
	 * Частота ГЛОНАСС L2, Гц
	 *
	 * @param fidx Относительный номер частоты (-7..+7)
	 */
	public static long gloFreqL2(int fidx) {
		return GLO_L2_FREQUENCY_0 + fidx * GLO_L2_FREQ_STEP;
	}

	/**
	 * Длина волны ГЛОНАСС L1, м
	 *
	 * @param fidx Относительный номер частоты (-7..+7)
	 */
	public static double gloWaveL1(int fidx) {
		return C / gloFreqL1(fidx);
	}

	/**
	 * Длина волны ГЛОНАСС L2, м
	 *
	 * @param fidx Относительный номер частоты (-7..+7)
	 */
	public static double gloWaveL2(int fidx) {
		return C / gloFreqL2(fidx);
	}

	/**
	 * Длина волны GPS L1, м
	 */
	public static final double GPS_L1_WAVELENGTH = C / GPS_L1_FREQUENCY;
	/**
	 * Длина волны GPS L2, м
	 */
	public static final double GPS_L2_WAVELENGTH = C / GPS_L2_FREQUENCY;
	public static final double GPS_L5_WAVELENGTH = C / GPS_L5_FREQUENCY;
	public static final double GAL_E1_WAVELENGTH = C / GAL_E1_FREQUENCY;
	public static final double GAL_E2_WAVELENGTH = C / GAL_E2_FREQUENCY;
	public static final double GAL_E5_WAVELENGTH = C / GAL_E5_FREQUENCY;
	public static final double GAL_E5a_WAVELENGTH = C / GAL_E5a_FREQUENCY;
	public static final double GAL_E5b_WAVELENGTH = C / GAL_E5b_FREQUENCY;
	public static final double QZSS_L1_WAVELENGTH = C / QZSS_L1_FREQUENCY;
	public static final double QZSS_L2_WAVELENGTH = C / QZSS_L2_FREQUENCY;
	public static final double QZSS_L5_WAVELENGTH = C / QZSS_L5_FREQUENCY;
	public static final double QZSS_LEX_WAVELENGTH = C / QZSS_LEX_FREQUENCY;
	public static final double BDS_B1_WAVELENGTH = C / BDS_B1_FREQUENCY;
	public static final double BDS_B2_WAVELENGTH = C / BDS_B2_FREQUENCY;
	public static final double BDS_B3_WAVELENGTH = C / BDS_B3_FREQUENCY;
}
