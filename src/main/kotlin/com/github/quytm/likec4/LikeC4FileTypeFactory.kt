package com.github.quytm.likec4

import com.intellij.openapi.fileTypes.FileTypeConsumer
import com.intellij.openapi.fileTypes.FileTypeFactory

class LikeC4FileTypeFactory : FileTypeFactory() {
    override fun createFileTypes(consumer: FileTypeConsumer) {
        consumer.consume(LikeC4FileType, "c4;likec4;like-c4")
    }
}
