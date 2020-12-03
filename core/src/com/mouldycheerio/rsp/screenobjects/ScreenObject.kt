package com.mouldycheerio.rsp.screenobjects

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont

abstract class ScreenObject(var tex: Texture, var x: Int, var y: Int, var w: Int, var h: Int) {

	val label = "";

	fun render(batch: SpriteBatch, font: BitmapFont) {
		batch.draw(tex, x.toFloat(), y.toFloat(), w.toFloat(), h.toFloat());
		
		if (label.length > 0) {
			font.draw(
				batch,
				label,
				x.toFloat(), y.toFloat()
			)
		}
	}

	public fun translate(dx: Int, dy: Int) {
		x += dx;
		y += dy;
	}

	public fun isColliding(px: Int, py: Int): Boolean {
		return px > x && px < x + w && py > y && py < y + h;
	}

}