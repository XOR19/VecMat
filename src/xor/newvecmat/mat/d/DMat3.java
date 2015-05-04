package xor.newvecmat.mat.d;

import xor.newvecmat.vec.d.DVec;
import xor.newvecmat.vec.d.DVec3;

public abstract class DMat3 extends DMat<DMat3, DMat3, DVec3> {

	@Override
	public int n() {
		return 3;
	}

	@Override
	public int m() {
		return 3;
	}

	@Override
	protected DVec3 getRow(int m) {
		return new RowDVec3(m);
	}

	@Override
	protected DVec3 getColumn(int n) {
		return new ColumnDVec3(n);
	}

	@Override
	public DMat3 mul(DMat3 v) {
		final double t00 = get(0, 0);
		final double t10 = get(1, 0);
		final double t20 = get(2, 0);
		final double t01 = get(0, 1);
		final double t11 = get(1, 1);
		final double t21 = get(2, 1);
		final double t02 = get(0, 2);
		final double t12 = get(1, 2);
		final double t22 = get(2, 2);
		final double v00 = v.get(0, 0);
		final double v10 = v.get(1, 0);
		final double v20 = v.get(2, 0);
		final double v01 = v.get(0, 1);
		final double v11 = v.get(1, 1);
		final double v21 = v.get(2, 1);
		final double v02 = v.get(0, 2);
		final double v12 = v.get(1, 2);
		final double v22 = v.get(2, 2);
		double[] mat = new double[9];
		mat[0] = t00 * v00 + t01 * v10 + t02 * v20;
		mat[1] = t10 * v00 + t11 * v10 + t12 * v20;
		mat[2] = t20 * v00 + t21 * v10 + t22 * v20;
		mat[3] = t00 * v01 + t01 * v11 + t02 * v21;
		mat[4] = t10 * v01 + t11 * v11 + t12 * v21;
		mat[5] = t20 * v01 + t21 * v11 + t22 * v21;
		mat[6] = t00 * v02 + t01 * v12 + t02 * v22;
		mat[7] = t10 * v02 + t11 * v12 + t12 * v22;
		mat[8] = t20 * v02 + t21 * v12 + t22 * v22;
		return new DRMat3(mat);
	}

	@Override
	public DVec3 mul(DVec3 v) {
		final double t00 = get(0, 0);
		final double t10 = get(1, 0);
		final double t20 = get(2, 0);
		final double t01 = get(0, 1);
		final double t11 = get(1, 1);
		final double t21 = get(2, 1);
		final double t02 = get(0, 2);
		final double t12 = get(1, 2);
		final double t22 = get(2, 2);
		final double x = v.get(0);
		final double y = v.get(1);
		final double z = v.get(2);
		final double xx = t00 * x + t10 * y + t20 * z;
		final double yy = t01 * x + t11 * y + t21 * z;
		final double zz = t02 * x + t12 * y + t22 * z;
		return DVec.DVec3(xx, yy, zz);
	}

	@Override
	public DMat3 pow(int y) {
		if(y==0)
			return Mat3();
		DMat3 m = this;
		for(int i=1; i<y; i++){
			m = m.mul(this);
		}
		return m;
	}

	@Override
	public DMat3 transpose() {
		return new TransposeMat3();
	}

	@Override
	public DMat3 invert() {
		final double t00 = get(0, 0);
		final double t10 = get(1, 0);
		final double t20 = get(2, 0);
		final double t01 = get(0, 1);
		final double t11 = get(1, 1);
		final double t21 = get(2, 1);
		final double t02 = get(0, 2);
		final double t12 = get(1, 2);
		final double t22 = get(2, 2);
		final double m1 = t11 * t22 - t21 * t12;
		final double m2 = -t10 * t22 + t12 * t20;
		final double m3 = t10 * t21 - t11 * t20;
		final double det = t00 * m1 + t01 * m2 + t02 * m3;
		final double invdet = 1 / det;
		double[] mat = new double[9];
		mat[0] = m1 * invdet;
		mat[1] = -(t01 * t22 - t02 * t21) * invdet;
		mat[2] = (t01 * t12 - t02 * t11) * invdet;
		mat[3] = m2 * invdet;
		mat[4] = (t00 * t22 - t02 * t20) * invdet;
		mat[5] = -(t00 * t12 - t10 * t02) * invdet;
		mat[6] = m3 * invdet;
		mat[7] = -(t00 * t21 - t20 * t01) * invdet;
		mat[8] = (t00 * t11 - t10 * t01) * invdet;
		return new DRMat3(mat);
	}

	@Override
	public double det() {
		final double t00 = get(0, 0);
		final double t10 = get(1, 0);
		final double t20 = get(2, 0);
		final double t01 = get(0, 1);
		final double t11 = get(1, 1);
		final double t21 = get(2, 1);
		final double t02 = get(0, 2);
		final double t12 = get(1, 2);
		final double t22 = get(2, 2);
		return t00 * (t11 * t22 - t21 * t12) - t01 * (t10 * t22 - t12 * t20) + t02 * (t10 * t21 - t11 * t20);
	}

	@Override
	public DMat3 adjunkte() {
		final double t00 = get(0, 0);
		final double t10 = get(1, 0);
		final double t20 = get(2, 0);
		final double t01 = get(0, 1);
		final double t11 = get(1, 1);
		final double t21 = get(2, 1);
		final double t02 = get(0, 2);
		final double t12 = get(1, 2);
		final double t22 = get(2, 2);
		double[] mat = new double[9];
		mat[0] = t11 * t22 - t12 * t21;
		mat[1] = t12 * t20 - t10 * t22;
		mat[2] = t10 * t21 - t11 * t20;
		mat[3] = t02 * t21 - t01 * t22;
		mat[4] = t00 * t22 - t02 * t20;
		mat[5] = t01 * t20 - t00 * t21;
		mat[6] = t01 * t12 - t02 * t11;
		mat[7] = t02 * t10 - t00 * t12;
		mat[8] = t00 * t11 - t01 * t10;
		return new DRMat3(mat);
	}

	@Override
	public DMat3 clone() {
		double[] mat = new double[9];
		mat[0] = get(0, 0);
		mat[1] = get(1, 0);
		mat[2] = get(2, 0);
		mat[3] = get(0, 1);
		mat[4] = get(1, 1);
		mat[5] = get(2, 1);
		mat[6] = get(0, 2);
		mat[7] = get(1, 2);
		mat[8] = get(2, 2);
		return new DRMat3(mat);
	}

	@Override
	protected DMat3 _new() {
		return new DRMat3();
	}

	private class RowDVec3 extends DVec3 {

		private final int m;

		RowDVec3(int m) {
			this.m = m;
		}

		@Override
		public double x() {
			return DMat3.this.get(m, 0);
		}

		@Override
		public void x(double x) {
			DMat3.this.set(m, 0, x);
		}

		@Override
		public double y() {
			return DMat3.this.get(m, 1);
		}

		@Override
		public void y(double y) {
			DMat3.this.set(m, 1, y);
		}
		
		@Override
		public double z() {
			return DMat3.this.get(m, 2);
		}

		@Override
		public void z(double y) {
			DMat3.this.set(m, 2, y);
		}

		@Override
		public double get(int i) {
			return DMat3.this.get(m, i);
		}

		@Override
		public void set(int i, double v) {
			DMat3.this.set(m, i, v);
		}

	}

	private class ColumnDVec3 extends DVec3 {

		private final int n;

		ColumnDVec3(int n) {
			this.n = n;
		}

		@Override
		public double x() {
			return DMat3.this.get(0, n);
		}

		@Override
		public void x(double x) {
			DMat3.this.set(0, n, x);
		}

		@Override
		public double y() {
			return DMat3.this.get(1, n);
		}

		@Override
		public void y(double y) {
			DMat3.this.set(1, n, y);
		}
		
		@Override
		public double z() {
			return DMat3.this.get(2, n);
		}

		@Override
		public void z(double y) {
			DMat3.this.set(2, n, y);
		}

		@Override
		public double get(int i) {
			return DMat3.this.get(i, n);
		}

		@Override
		public void set(int i, double v) {
			DMat3.this.set(i, n, v);
		}

	}

	private class TransposeMat3 extends DMat3 {

		@Override
		public double get(int m, int n) {
			return DMat3.this.get(n, m);
		}

		@Override
		public void set(int m, int n, double v) {
			DMat3.this.set(n, m, v);
		}

		@Override
		public DMat3 transpose() {
			return DMat3.this;
		}

	}

}
