package com.github.quytm.likec4

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

object LikeC4FileType : LanguageFileType(LikeC4Language) {
    override fun getName(): String = "LikeC4"

    override fun getDescription(): String = "LikeC4 language file"

    override fun getDefaultExtension(): String = "c4"

    override fun getIcon(): Icon = LikeC4Icons.LikeC4
}
