package xor.newvecmat.vec.i;

import xor.newvecmat.vec.b.BVecN;



public abstract class IVecN extends IVec<IVecN, BVecN> {

	@Override
	public IVecN clone() {
		final int size = dim();
		int[] data = new int[size];
		for (int i = 0; i < size; i++) {
			data[i] = get(i);
		}
		return new IRVecN(data);
	}

	@Override
	protected IVecN _new() {
		return new IRVecN(dim());
	}

}
