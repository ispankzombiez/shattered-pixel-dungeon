package com.shatteredpixel.shatteredpixeldungeon.effects;

import com.watabou.utils.Callback;
import com.watabou.utils.PointF;

import java.util.List;

public class LightningLarge extends Lightning {

	public LightningLarge(int from, int to, Callback callback) {
		super(from, to, callback);
	}

	public LightningLarge(PointF from, int to, Callback callback) {
		super(from, to, callback);
	}

	public LightningLarge(int from, PointF to, Callback callback) {
		super(from, to, callback);
	}

	public LightningLarge(PointF from, PointF to, Callback callback) {
		super(from, to, callback);
	}

	public LightningLarge(List<Arc> arcs, Callback callback) {
		super(arcs, callback);
	}
}
