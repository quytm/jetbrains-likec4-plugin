package com.github.quytm.likec4

import com.intellij.lang.Language

object LikeC4Language : Language("LikeC4") {
    private fun readResolve(): Any = LikeC4Language
    override fun getDisplayName(): String = "LikeC4"
}
