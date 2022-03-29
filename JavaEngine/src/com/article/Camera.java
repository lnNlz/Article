package com.article;

import com.article.math.Vec3F;
import com.article.math.matrix.ProjectionMatrix;

public final class Camera {
	private static final Camera camera = new Camera();
	
	public static float FOV = ProjectionMatrix.DEFAULT_FIELD_OF_VIEW;
	
	// TODO: CLEAN
	// Transform
	public Vec3F position = new Vec3F(0.0F, 0.0F, 0.0F);
	public Vec3F rotation = new Vec3F(0.0F, 0.0F, 0.0F);
	
	// Lighting direction
	public Vec3F direction = new Vec3F(0.0F, 0.0F, -1.0F);
	
	// Up direction
	public Vec3F up = new Vec3F(0.0F, 1.0F, 0.0F);
	
	// View direction
	public Vec3F view = new Vec3F(0.0F, 0.0F, 1.0F);
	
	/**
	 * @return
	 * - A camera class {@code instance}
	 */
	public static Camera get() {
		return camera;
	}
}