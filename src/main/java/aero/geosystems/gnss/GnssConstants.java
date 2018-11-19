package aero.geosystems.gnss;

/**
 * Created by IntelliJ IDEA.
 * User: aimozg
 * Date: 10.03.11
 * Time: 15:09
 */
public class GnssConstants {

	/**
	 * Earth gravitational constant (GPS) [m^3/s^2]
	 */
	public static final double MU_M = 3.986005e14;
	/**
	 * Earth angular velocity (GPS) [rad/s]
	 */
	public static final double OMEGA_DOT_E = 0.000072921151467;
	/**
	 * Speed of light [m/s]
	 */
	public static final double C = 299792458;
	public static final double F = -2.0 * Math.sqrt(MU_M) / C;


	/*
	 * GLONASS constants
	 */

	/**
	 * Earth gravitational constant (GLONASS) [m^3/s^2]
	 */
	public static final double MU = 3.986004418E14;

	/**
	 * 2nd zonal harmonic of geopotential (GLONASS)
	 */
	public static final double C_20 = 1.08262575E-3;

	/**
	 * Lunar gravitational constant (GLONASS) [m^3/s^2]
	 */
	public static final double MU_L = 4.902835E3;

	/**
	 * Solar gravitational constant (GLONASS) [m^3/s^2]
	 */
	public static final double MU_S = 1.325263E11;

	/**
	 * Earth equatorial radius (GLONASS) [m]
	 */
	public static final double A_e = 6.378136E6;

	/**
	 * Earth angular velocity (GLONASS) [rad/s]
	 */
	public static final double OMEGA_EARTH = 7.292115E-5;
	/**
	 * GPS L1 Frequency [Hz]
	 */
	public static final long GPS_L1_FREQUENCY = 1575420000L;
	/**
	 * GPS L2 Frequency [Hz]
	 */
	public static final long GPS_L2_FREQUENCY = 1227600000L;
	public static final long GPS_L5_FREQUENCY = 1176450000L;
	/**
	 * GLONASS L1 central frequency [Hz]
	 */
	public static final long GLO_L1_FREQUENCY_0 = 1602000000L;
	/**
	 * GLONASS L1 frequency step [Hz]
	 */
	public static final long GLO_L1_FREQ_STEP = 562500L;
	/**
	 * GLONASS L1 minimal frequency [Hz]
	 */
	public static final long GLO_L1_FREQUENCY_MIN = GLO_L1_FREQUENCY_0-7*GLO_L1_FREQ_STEP;
	/**
	 * GLONASS L2 central frequency [Hz]
	 */
	public static final long GLO_L2_FREQUENCY_0 = 1246000000L;
	/**
	 * GLONASS L2 frequency step [Hz]
	 */
	public static final long GLO_L2_FREQ_STEP = 437500L;
	/**
	 * GLONASS L2 minimal frequency [Hz]
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
	 * GLONASS L1 frequency [Hz]
	 *
	 * @param fidx Relative frequency index (-7..+7)
	 */
	public static long gloFreqL1(int fidx) {
		return GLO_L1_FREQUENCY_0 + fidx * GLO_L1_FREQ_STEP;
	}

	/**
	 * GLONASS L2 frequency [Hz]
	 *
	 * @param fidx Relative frequency index (-7..+7)
	 */
	public static long gloFreqL2(int fidx) {
		return GLO_L2_FREQUENCY_0 + fidx * GLO_L2_FREQ_STEP;
	}

	/**
	 * GLONASS L1 wavelength [m]
	 *
	 * @param fidx Relative frequency index (-7..+7)
	 */
	public static double gloWaveL1(int fidx) {
		return C / gloFreqL1(fidx);
	}

	/**
	 * GLOBASS L2 wavelength [m]
	 *
	 * @param fidx Relative frequency index (-7..+7)
	 */
	public static double gloWaveL2(int fidx) {
		return C / gloFreqL2(fidx);
	}

	/**
	 * GPS L1 wavelength [m]
	 */
	public static final double GPS_L1_WAVELENGTH = C / GPS_L1_FREQUENCY;
	/**
	 * GPS L2 wavelength [m]
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
