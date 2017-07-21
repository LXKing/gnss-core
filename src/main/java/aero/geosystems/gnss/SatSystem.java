package aero.geosystems.gnss;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;

/**
 * Created by IntelliJ IDEA.
 * User: aimozg
 * Date: 04.05.13
 * Time: 17:16
 */
public enum SatSystem {
	GPS(32, 1, 37, "GPS", 'G'),
	GLONASS(24, 38, 62, "GLO", 'R'),
	GALILEO(30, 71, 119, "GAL", 'E'),
	SBAS(120, 142, "SBS", 'S'),
	QZSS(3, 193, 197, "QZS", 'J'),
	BDS(35, 211, 250, "BDS", 'C');
	public final int min1Id;
	public final int max1Id;
	public final int min2Id;
	public final int max2Id;
	public final int numSats;
	@NotNull
	public final String threeLetterName;
	/**
	 * 1-char code acccording to RINEX 3.02
	 */
	public final char charCode;


	public boolean hasId(int id) {
		return (id >= 0) && (min1Id <= id && id <= max1Id) || (min2Id <= id && id <= max2Id);
	}

	public int numSats() {
		return numSats;
	}

	/**
	 * 1..NUMSATS -> min1Id..max1Id,min2Id..max2Id
	 */
	public int indexToId(int index) {
		int id = index - 1 + min1Id;
		if (id > max1Id) id = index - 1 - (max1Id + 1 - min1Id) + min2Id;
		return id;
	}

	/**
	 * min1Id..max1Id,min2Id..max2Id -> 1..NUMSATS
	 */
	public int idToIndex(int id) {
		if (id > max1Id) return id + 1 + (max1Id + 1 - min1Id) - min2Id;
		return id + 1 - min1Id;
	}

	SatSystem(int numSats, int minId, int maxId, String threeLetterName, char charCode) {
		this(numSats, minId, maxId, -2, -1, threeLetterName, charCode);
	}

	SatSystem(int minId, int maxId, String threeLetterName, char charCode) {
		this(-1, minId, maxId, -2, -1, threeLetterName, charCode);
	}

	SatSystem(int numSats, int min1Id, int max1Id, int min2Id, int max2Id, @NotNull String threeLetterName, char charCode) {
		this.min1Id = min1Id;
		this.max1Id = max1Id;
		this.min2Id = min2Id;
		this.max2Id = max2Id;
		if (numSats < 0) {
			this.numSats = max1Id - min1Id + 1 + ((min2Id >= 0 && max2Id >= 0) ? (max2Id - min2Id + 1) : 0);
		} else {
			this.numSats = numSats;
		}
		this.threeLetterName = threeLetterName;
		this.charCode = charCode;
	}

	public static final int count = values().length;

	public static boolean isValidId(short id) {
		return byId(id) != null;
	}

	@Nullable
	public static SatSystem byId(int id) {
		for (SatSystem satSystem : values()) {
			if (satSystem.hasId(id)) return satSystem;
		}
		return null;
	}

	@Nullable
	public static SatSystem byCharCode(char c) {
		for (SatSystem gnss : values()) {
			if (gnss.charCode == c) return gnss;
		}
		return null;
	}

	public static EnumSet<SatSystem> fromOneCharString(@NotNull String s) {
		if ("*".equals(s)) return EnumSet.allOf(SatSystem.class);
		EnumSet<SatSystem> rslt = EnumSet.noneOf(SatSystem.class);
		for (int i = 0; i<s.length(); i++) {
			SatSystem gnss = byCharCode(s.charAt(i));
			if (gnss!=null) rslt.add(gnss);
		}
		return rslt;
	}

	public static final int totalNumSats;
	public static final int totalMaxId;
	static {
		int n = 0;
		int maxid = 0;
		for (SatSystem system : values()) {
			n += system.numSats;
			maxid = Math.max(maxid,Math.max(system.max1Id,system.max2Id));
		}
		totalNumSats = n;
		totalMaxId = maxid;
	}
}
