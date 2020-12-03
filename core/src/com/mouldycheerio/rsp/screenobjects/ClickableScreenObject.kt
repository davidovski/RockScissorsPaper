package com.mouldycheerio.rsp.screenobjects

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.Texture

abstract class ClickableScreenObject(tex: Texture, x: Int, y: Int, w: Int, h: Int) : ScreenObject(tex, x, y, w, h), Clickable {
}