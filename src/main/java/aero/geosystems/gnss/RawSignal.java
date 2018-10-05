package aero.geosystems.gnss;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: aimozg
 * Date: 20.12.10
 * Time: 15:49
 */
public enum RawSignal {
	GPS_L1_CA(SatSystem.GPS, 1, 'C', GnssConstants.GPS_L1_FREQUENCY),
	GPS_L1C_DP(SatSystem.GPS, 1, 'X', GnssConstants.GPS_L1_FREQUENCY),
	GPS_L1_PY(SatSystem.GPS, 1, 'P', GnssConstants.GPS_L1_FREQUENCY),
	GPS_L2_C(SatSystem.GPS, 2, 'C', GnssConstants.GPS_L2_FREQUENCY),
	GPS_L2C_M(SatSystem.GPS, 2, 'S', GnssConstants.GPS_L2_FREQUENCY),
	GPS_L2C_L(SatSystem.GPS, 2, 'L', GnssConstants.GPS_L2_FREQUENCY),
	GPS_L2C_ML(SatSystem.GPS, 2, 'X', GnssConstants.GPS_L2_FREQUENCY),
	GPS_L2_PY_DIRECT(SatSystem.GPS, 2, 'P', GnssConstants.GPS_L2_FREQUENCY),
	GPS_L2_PY_CROSS(SatSystem.GPS, 2, 'W', GnssConstants.GPS_L2_FREQUENCY),
	GPS_L2_PY_CORRELATED(SatSystem.GPS, 2, 'W', GnssConstants.GPS_L2_FREQUENCY),
	GPS_L5_Q(SatSystem.GPS, 5, 'Q', GnssConstants.GPS_L5_FREQUENCY),
	GPS_L5_IQ(SatSystem.GPS,5,'X', GnssConstants.GPS_L5_FREQUENCY),
	GLO_L1_CA(SatSystem.GLONASS, 1, 'C', GnssConstants.GLO_L1_FREQUENCY_0, GnssConstants.GLO_L1_FREQ_STEP),
	GLO_L1_P(SatSystem.GLONASS, 1, 'P', GnssConstants.GLO_L1_FREQUENCY_0, GnssConstants.GLO_L1_FREQ_STEP),
	GLO_L2_CA(SatSystem.GLONASS, 2, 'C', GnssConstants.GLO_L2_FREQUENCY_0, GnssConstants.GLO_L2_FREQ_STEP),
	GLO_L2_P(SatSystem.GLONASS, 2, 'P', GnssConstants.GLO_L2_FREQUENCY_0, GnssConstants.GLO_L2_FREQ_STEP),
	GLO_L3_IQ(SatSystem.GLONASS, 3, 'X', GnssConstants.GLO_L3_FREQUENCY),
	GAL_E1A(SatSystem.GALILEO, 1, 'A', GnssConstants.GAL_E1_FREQUENCY),
	GAL_E1B(SatSystem.GALILEO, 1, 'B', GnssConstants.GAL_E1_FREQUENCY),
	GAL_E1C(SatSystem.GALILEO, 1, 'C', GnssConstants.GAL_E1_FREQUENCY),
	GAL_E1BC(SatSystem.GALILEO, 1, 'X', GnssConstants.GAL_E1_FREQUENCY),
	GAL_E1ABC(SatSystem.GALILEO, 1, 'Z', GnssConstants.GAL_E1_FREQUENCY),
	GAL_E5a_Q(SatSystem.GALILEO, 5, 'Q', GnssConstants.GAL_E5a_FREQUENCY),
	GAL_E5a_IQ(SatSystem.GALILEO, 5, 'X', GnssConstants.GAL_E5a_FREQUENCY),
	GAL_E5b_Q(SatSystem.GALILEO, 7, 'Q', GnssConstants.GAL_E5b_FREQUENCY),
	GAL_E5b_I(SatSystem.GALILEO, 7, 'I', GnssConstants.GAL_E5b_FREQUENCY),
	GAL_E5b_IQ(SatSystem.GALILEO, 7, 'X', GnssConstants.GAL_E5b_FREQUENCY),
	GAL_AltBOC_Q(SatSystem.GALILEO, 8, 'Q', GnssConstants.GAL_E5_FREQUENCY),
	QZSS_L1CA(SatSystem.QZSS, 1, 'C', GnssConstants.QZSS_L1_FREQUENCY),
	QZSS_L1C_DP(SatSystem.QZSS, 1, 'X', GnssConstants.QZSS_L1_FREQUENCY),
	QZSS_L1SAIF(SatSystem.QZSS, 1, 'Z', GnssConstants.QZSS_L1_FREQUENCY),
	QZSS_L2C_M(SatSystem.QZSS, 2, 'S', GnssConstants.QZSS_L2_FREQUENCY),
	QZSS_L2C_L(SatSystem.QZSS, 2, 'L', GnssConstants.QZSS_L2_FREQUENCY),
	QZSS_L2C_ML(SatSystem.QZSS, 2, 'X', GnssConstants.QZSS_L2_FREQUENCY),
	QZSS_L5Q(SatSystem.QZSS, 5, 'Q', GnssConstants.QZSS_L5_FREQUENCY),
	QZSS_L5_IQ(SatSystem.QZSS, 5, 'X', GnssConstants.QZSS_L5_FREQUENCY),
	SBAS_L1CA(SatSystem.SBAS, 1, 'C', GnssConstants.SBAS_L1_FREQUENCY),
	SBAS_L5I(SatSystem.SBAS, 5, 'I', GnssConstants.SBAS_L5_FREQUENCY),
	BDS_B1D1(SatSystem.BDS, 1, 'I', GnssConstants.BDS_B1_FREQUENCY),
	BDS_B2D1(SatSystem.BDS, 7, 'I', GnssConstants.BDS_B2_FREQUENCY),
	BDS_B1D2(SatSystem.BDS, 1, 'I', GnssConstants.BDS_B1_FREQUENCY),
	BDS_B2D2(SatSystem.BDS, 7, 'I', GnssConstants.BDS_B2_FREQUENCY),
	BDS_B3D1(SatSystem.BDS, 6, 'I', GnssConstants.BDS_B3_FREQUENCY),
	BDS_B3D2(SatSystem.BDS, 6, 'I', GnssConstants.BDS_B3_FREQUENCY),
	OmniSTAR(SatSystem.SBAS, 1, 'C', GnssConstants.SBAS_L1_FREQUENCY);
	public final SatSystem gnss;
	public final int bandIdx;
	public final char attr;// observation attribute according to RINEX 3.02
	public final double frequency;
	public final double frequencyStep;
	public static final Set<RawSignal> P_CODE = Collections.unmodifiableSet(EnumSet.of(
			GPS_L1_PY,
			GPS_L2_PY_DIRECT, GPS_L2_PY_CROSS, GPS_L2_PY_CORRELATED,
			GLO_L1_P,
			GLO_L2_P
	));
	public static final Set<RawSignal> CA_CODE = Collections.unmodifiableSet(EnumSet.of(
			GPS_L1_CA,
			GPS_L2_C, GPS_L2C_L, GPS_L2C_M, GPS_L2C_ML,
			GLO_L1_CA,
			GLO_L2_CA,
			GAL_E1A, GAL_E1B, GAL_E1C, GAL_E1BC, GAL_E1ABC,
			SBAS_L1CA
	));

	private static final RawSignal[] values = values();

	@NotNull
	public static int[] bands() {
		return new int[]{1, 2, 5, 6, 7, 8, 0};
	}

	@Nullable
	@Contract(pure = true)
	public static RawSignal forIdx(int idx) {
		if (idx < 0 || idx >= values.length) return null;
		return values[idx];
	}

	RawSignal(SatSystem gnss, int band, char attr, double frequency) {
		this(gnss,band,attr,frequency,0);
	}
	RawSignal(SatSystem gnss, int band, char attr, double frequency, double frequencyStep) {
		this.gnss = gnss;
		this.frequency = frequency;
		if (band == 0) bandIdx = bands().length;
		else this.bandIdx = Arrays.binarySearch(bands(), 0, bands().length - 1, band) + 1;
		this.attr = attr;
		this.frequencyStep = frequencyStep;
	}

	@Contract(pure = true)
	public double frequency(int fqidx) {
		return frequency+fqidx*frequencyStep;
	}
	@Contract(pure = true)
	public double wavelength(int fqidx) {
		return GnssConstants.C/frequency(fqidx);
	}
	@Contract(pure = true)
	public int nominalBand() {
		if (bandIdx <= 0 || bandIdx > bands().length) return 0;
		return bands()[bandIdx-1];
	}
}
