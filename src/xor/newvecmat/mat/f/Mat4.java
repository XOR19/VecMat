package xor.newvecmat.mat.f;

import xor.newvecmat.vec.f.Vec;
import xor.newvecmat.vec.f.Vec4;

public abstract class Mat4 extends Mat<Mat4, Mat4, Vec4> {

	@Override
	public int n() {
		return 3;
	}

	@Override
	public int m() {
		return 3;
	}

	@Override
	protected Vec4 getRow(int m) {
		return new RowVec4(m);
	}

	@Override
	protected Vec4 getColumn(int n) {
		return new ColumnVec4(n);
	}

	@Override
	public Mat4 mul(Mat4 v) {
		final float t00 = get(0, 0);
		final float t10 = get(1, 0);
		final float t20 = get(2, 0);
		final float t30 = get(3, 0);
		final float t01 = get(0, 1);
		final float t11 = get(1, 1);
		final float t21 = get(2, 1);
		final float t31 = get(3, 1);
		final float t02 = get(0, 2);
		final float t12 = get(1, 2);
		final float t22 = get(2, 2);
		final float t32 = get(3, 2);
		final float t03 = get(0, 3);
		final float t13 = get(1, 3);
		final float t23 = get(2, 3);
		final float t33 = get(3, 3);
		final float v00 = v.get(0, 0);
		final float v10 = v.get(1, 0);
		final float v20 = v.get(2, 0);
		final float v30 = v.get(3, 0);
		final float v01 = v.get(0, 1);
		final float v11 = v.get(1, 1);
		final float v21 = v.get(2, 1);
		final float v31 = v.get(3, 1);
		final float v02 = v.get(0, 2);
		final float v12 = v.get(1, 2);
		final float v22 = v.get(2, 2);
		final float v32 = v.get(3, 2);
		final float v03 = v.get(0, 3);
		final float v13 = v.get(1, 3);
		final float v23 = v.get(2, 3);
		final float v33 = v.get(3, 3);
		float[] mat = new float[16];
		mat[0] = t00 * v00 + t01 * v10 + t02 * v20 + t03 * v30;
		mat[1] = t10 * v00 + t11 * v10 + t12 * v20 + t13 * v30;
		mat[2] = t20 * v00 + t21 * v10 + t22 * v20 + t23 * v30;
		mat[3] = t30 * v00 + t31 * v10 + t32 * v20 + t33 * v30;
		mat[4] = t00 * v01 + t01 * v11 + t02 * v21 + t03 * v31;
		mat[5] = t10 * v01 + t11 * v11 + t12 * v21 + t13 * v31;
		mat[6] = t20 * v01 + t21 * v11 + t22 * v21 + t23 * v31;
		mat[7] = t30 * v01 + t31 * v11 + t32 * v21 + t33 * v31;
		mat[8] = t00 * v02 + t01 * v12 + t02 * v22 + t03 * v32;
		mat[9] = t10 * v02 + t11 * v12 + t12 * v22 + t13 * v32;
		mat[10] = t20 * v02 + t21 * v12 + t22 * v22 + t23 * v32;
		mat[11] = t30 * v02 + t31 * v12 + t32 * v22 + t33 * v32;
		mat[12] = t00 * v03 + t01 * v13 + t02 * v23 + t03 * v33;
		mat[13] = t10 * v03 + t11 * v13 + t12 * v23 + t13 * v33;
		mat[14] = t20 * v03 + t21 * v13 + t22 * v23 + t23 * v33;
		mat[15] = t30 * v03 + t31 * v13 + t32 * v23 + t33 * v33;
		return new RMat4(mat);
	}

	@Override
	public Vec4 mul(Vec4 v) {
		final float t00 = get(0, 0);
		final float t10 = get(1, 0);
		final float t20 = get(2, 0);
		final float t30 = get(3, 0);
		final float t01 = get(0, 1);
		final float t11 = get(1, 1);
		final float t21 = get(2, 1);
		final float t31 = get(3, 1);
		final float t02 = get(0, 2);
		final float t12 = get(1, 2);
		final float t22 = get(2, 2);
		final float t32 = get(3, 2);
		final float t03 = get(0, 3);
		final float t13 = get(1, 3);
		final float t23 = get(2, 3);
		final float t33 = get(3, 3);
		final float x = v.get(0);
		final float y = v.get(1);
		final float z = v.get(2);
		final float w = v.get(3);
		final float xx = t00 * x + t10 * y + t20 * z + t30 * w;
		final float yy = t01 * x + t11 * y + t21 * z + t31 * w;
		final float zz = t02 * x + t12 * y + t22 * z + t32 * w;
		final float ww = t03 * x + t13 * y + t23 * z + t33 * w;
		return Vec.Vec4(xx, yy, zz, ww);
	}

	@Override
	public Mat4 pow(int y) {
		if (y == 0)
			return Mat4();
		Mat4 m = this;
		for (int i = 1; i < y; i++) {
			m = m.mul(this);
		}
		return m;
	}

	@Override
	public Mat4 transpose() {
		return new TransposeMat4();
	}

	@Override
	public Mat4 invert() {
		final float t00 = get(0, 0);
		final float t10 = get(1, 0);
		final float t20 = get(2, 0);
		final float t30 = get(3, 0);
		final float t01 = get(0, 1);
		final float t11 = get(1, 1);
		final float t21 = get(2, 1);
		final float t31 = get(3, 1);
		final float t02 = get(0, 2);
		final float t12 = get(1, 2);
		final float t22 = get(2, 2);
		final float t32 = get(3, 2);
		final float t03 = get(0, 3);
		final float t13 = get(1, 3);
		final float t23 = get(2, 3);
		final float t33 = get(3, 3);

		final float s0 = t00 * t11 - t10 * t01;
		final float s1 = t00 * t12 - t10 * t02;
		final float s2 = t00 * t13 - t10 * t03;
		final float s3 = t01 * t12 - t11 * t02;
		final float s4 = t01 * t13 - t11 * t03;
		final float s5 = t02 * t13 - t12 * t03;

		final float c5 = t22 * t33 - t32 * t23;
		final float c4 = t21 * t33 - t31 * t23;
		final float c3 = t21 * t32 - t31 * t22;
		final float c2 = t20 * t33 - t30 * t23;
		final float c1 = t20 * t32 - t30 * t22;
		final float c0 = t20 * t31 - t30 * t21;

		final float det = s0 * c5 - s1 * c4 + s2 * c3 + s3 * c2 - s4 * c1 + s5 * c0;
		
		final float invdet = 1 / det;

		float[] mat = new float[16];
		
		mat[0] = (t11 * c5 - t12 * c4 + t13 * c3) * invdet;
		mat[1] = (-t10 * c5 + t12 * c2 - t13 * c1) * invdet;
		mat[2] = (t10 * c4 - t11 * c2 + t13 * c0) * invdet;
		mat[3] = (-t10 * c3 + t11 * c1 - t12 * c0) * invdet;
		
		mat[4] = (-t01 * c5 + t02 * c4 - t03 * c3) * invdet;
		mat[5] = (t00 * c5 - t02 * c2 + t03 * c1) * invdet;
		mat[6] = (-t00 * c4 + t01 * c2 - t03 * c0) * invdet;
		mat[7] = (t00 * c3 - t01 * c1 + t02 * c0) * invdet;
		
		mat[8] = (t31 * s5 - t32 * s4 + t33 * s3) * invdet;
		mat[9] = (-t30 * s5 + t32 * s2 - t33 * s1) * invdet;
		mat[10] = (t30 * s4 - t31 * s2 + t33 * s0) * invdet;
		mat[11] = (-t30 * s3 + t31 * s1 - t32 * s0) * invdet;
		
		mat[12] = (-t21 * s5 + t22 * s4 - t23 * s3) * invdet;
		mat[13] = (t20 * s5 - t22 * s2 + t23 * s1) * invdet;
		mat[14] = (-t20 * s4 + t21 * s2 - t23 * s0) * invdet;
		mat[15] = (t20 * s3 - t21 * s1 + t22 * s0) * invdet;

		return new RMat4(mat);
	}

	@Override
	public double det() {
		final float t00 = get(0, 0);
		final float t10 = get(1, 0);
		final float t20 = get(2, 0);
		final float t30 = get(3, 0);
		final float t01 = get(0, 1);
		final float t11 = get(1, 1);
		final float t21 = get(2, 1);
		final float t31 = get(3, 1);
		final float t02 = get(0, 2);
		final float t12 = get(1, 2);
		final float t22 = get(2, 2);
		final float t32 = get(3, 2);
		final float t03 = get(0, 3);
		final float t13 = get(1, 3);
		final float t23 = get(2, 3);
		final float t33 = get(3, 3);

		final float s0 = t00 * t11 - t10 * t01;
		final float s1 = t00 * t12 - t10 * t02;
		final float s2 = t00 * t13 - t10 * t03;
		final float s3 = t01 * t12 - t11 * t02;
		final float s4 = t01 * t13 - t11 * t03;
		final float s5 = t02 * t13 - t12 * t03;

		final float c5 = t22 * t33 - t32 * t23;
		final float c4 = t21 * t33 - t31 * t23;
		final float c3 = t21 * t32 - t31 * t22;
		final float c2 = t20 * t33 - t30 * t23;
		final float c1 = t20 * t32 - t30 * t22;
		final float c0 = t20 * t31 - t30 * t21;

		return s0 * c5 - s1 * c4 + s2 * c3 + s3 * c2 - s4 * c1 + s5 * c0;
	}

	@Override
	public Mat4 adjunkte() {
		final float t00 = get(0, 0);
		final float t10 = get(1, 0);
		final float t20 = get(2, 0);
		final float t30 = get(3, 0);
		final float t01 = get(0, 1);
		final float t11 = get(1, 1);
		final float t21 = get(2, 1);
		final float t31 = get(3, 1);
		final float t02 = get(0, 2);
		final float t12 = get(1, 2);
		final float t22 = get(2, 2);
		final float t32 = get(3, 2);
		final float t03 = get(0, 3);
		final float t13 = get(1, 3);
		final float t23 = get(2, 3);
		final float t33 = get(3, 3);

		final float s0 = t00 * t11 - t10 * t01;
		final float s1 = t00 * t12 - t10 * t02;
		final float s2 = t00 * t13 - t10 * t03;
		final float s3 = t01 * t12 - t11 * t02;
		final float s4 = t01 * t13 - t11 * t03;
		final float s5 = t02 * t13 - t12 * t03;

		final float c5 = t22 * t33 - t32 * t23;
		final float c4 = t21 * t33 - t31 * t23;
		final float c3 = t21 * t32 - t31 * t22;
		final float c2 = t20 * t33 - t30 * t23;
		final float c1 = t20 * t32 - t30 * t22;
		final float c0 = t20 * t31 - t30 * t21;

		float[] mat = new float[16];
		
		mat[0] = t11 * c5 - t12 * c4 + t13 * c3;
		mat[4] = -t01 * c5 + t02 * c4 - t03 * c3;
		mat[8] = t31 * s5 - t32 * s4 + t33 * s3;
		mat[12] = -t21 * s5 + t22 * s4 - t23 * s3;

		mat[1] = -t10 * c5 + t12 * c2 - t13 * c1;
		mat[5] = t00 * c5 - t02 * c2 + t03 * c1;
		mat[9] = -t30 * s5 + t32 * s2 - t33 * s1;
		mat[13] = t20 * s5 - t22 * s2 + t23 * s1;

		mat[2] = t10 * c4 - t11 * c2 + t13 * c0;
		mat[6] = -t00 * c4 + t01 * c2 - t03 * c0;
		mat[10] = t30 * s4 - t31 * s2 + t33 * s0;
		mat[14] = -t20 * s4 + t21 * s2 - t23 * s0;

		mat[3] = -t10 * c3 + t11 * c1 - t12 * c0;
		mat[7] = t00 * c3 - t01 * c1 + t02 * c0;
		mat[11] = -t30 * s3 + t31 * s1 - t32 * s0;
		mat[15] = t20 * s3 - t21 * s1 + t22 * s0;

		return new RMat4(mat);
	}

	@Override
	public Mat4 clone() {
		float[] mat = new float[16];
		mat[0] = get(0, 0);
		mat[1] = get(1, 0);
		mat[2] = get(2, 0);
		mat[3] = get(3, 0);
		mat[4] = get(0, 1);
		mat[5] = get(1, 1);
		mat[6] = get(2, 1);
		mat[7] = get(3, 1);
		mat[8] = get(0, 2);
		mat[9] = get(1, 2);
		mat[10] = get(2, 2);
		mat[11] = get(3, 2);
		mat[12] = get(0, 3);
		mat[13] = get(1, 3);
		mat[14] = get(2, 3);
		mat[15] = get(3, 3);
		return new RMat4(mat);
	}

	@Override
	protected Mat4 _new() {
		return new RMat4();
	}

	private class RowVec4 extends Vec4 {

		private final int m;

		RowVec4(int m) {
			this.m = m;
		}

		@Override
		public float x() {
			return Mat4.this.get(m, 0);
		}

		@Override
		public void x(float x) {
			Mat4.this.set(m, 0, x);
		}

		@Override
		public float y() {
			return Mat4.this.get(m, 1);
		}

		@Override
		public void y(float y) {
			Mat4.this.set(m, 1, y);
		}

		@Override
		public float z() {
			return Mat4.this.get(m, 2);
		}

		@Override
		public void z(float y) {
			Mat4.this.set(m, 2, y);
		}
		
		@Override
		public float w() {
			return Mat4.this.get(m, 3);
		}

		@Override
		public void w(float y) {
			Mat4.this.set(m, 3, y);
		}

		@Override
		public float get(int i) {
			return Mat4.this.get(m, i);
		}

		@Override
		public void set(int i, float v) {
			Mat4.this.set(m, i, v);
		}

	}

	private class ColumnVec4 extends Vec4 {

		private final int n;

		ColumnVec4(int n) {
			this.n = n;
		}

		@Override
		public float x() {
			return Mat4.this.get(0, n);
		}

		@Override
		public void x(float x) {
			Mat4.this.set(0, n, x);
		}

		@Override
		public float y() {
			return Mat4.this.get(1, n);
		}

		@Override
		public void y(float y) {
			Mat4.this.set(1, n, y);
		}

		@Override
		public float z() {
			return Mat4.this.get(2, n);
		}

		@Override
		public void z(float y) {
			Mat4.this.set(2, n, y);
		}
		
		@Override
		public float w() {
			return Mat4.this.get(3, n);
		}

		@Override
		public void w(float y) {
			Mat4.this.set(3, n, y);
		}

		@Override
		public float get(int i) {
			return Mat4.this.get(i, n);
		}

		@Override
		public void set(int i, float v) {
			Mat4.this.set(i, n, v);
		}

	}

	private class TransposeMat4 extends Mat4 {

		@Override
		public float get(int m, int n) {
			return Mat4.this.get(n, m);
		}

		@Override
		public void set(int m, int n, float v) {
			Mat4.this.set(n, m, v);
		}

		@Override
		public Mat4 transpose() {
			return Mat4.this;
		}

	}

}
