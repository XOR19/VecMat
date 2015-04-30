package xor.newvecmat;

import java.util.List;

import xor.newvecmat.vec.Vec_numeric;
import xor.newvecmat.vec.b.BVec;

public final class Utils {

	private Utils() {
	}

	public static final boolean CHECKS = true;

	public static final int getIndex(char c) {
		switch (c) {
		case 'x':
		case 'r':
		case 's':
			return 0;
		case 'y':
		case 'g':
		case 't':
			return 1;
		case 'z':
		case 'b':
		case 'p':
			return 2;
		case 'w':
		case 'a':
		case 'q':
			return 3;
		}
		return -1;
	}

	public static void fill(List<Number> f, Object[] obj) {
		for (Object o : obj) {
			if (o instanceof Number) {
				f.add((Number) o);
			} else if (o instanceof Vec_numeric<?, ?, ?>) {
				Vec_numeric<?, ?, ?> v = (Vec_numeric<?, ?, ?>) o;
				final int size = v.dim();
				for (int j = 0; j < size; j++) {
					f.add(v.getW(j));
				}
			} else {
				throw new IllegalArgumentException("Bad object");
			}
		}
	}
	
	public static void fillB(List<Boolean> f, Object[] obj) {
		for (Object o : obj) {
			if (o instanceof Boolean) {
				f.add((Boolean) o);
			} else if (o instanceof BVec<?>) {
				BVec<?> v = (BVec<?>) o;
				final int size = v.dim();
				for (int j = 0; j < size; j++) {
					f.add(v.getW(j));
				}
			} else {
				throw new IllegalArgumentException("Bad object");
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public static <R> R unchecked(Object o) {
		return (R) o;
	}

}
