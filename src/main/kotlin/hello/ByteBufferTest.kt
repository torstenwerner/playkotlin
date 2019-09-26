package hello

import java.nio.ByteBuffer
import java.nio.charset.StandardCharsets

data class MyData(val id: Long, val value: Double, val description: String)

fun toByteArray(data: MyData): ByteArray {

    val descriptionBytes = data.description.toByteArray()
    val capacity = Long.SIZE_BYTES + 8 /* java.lang.Double.BYTES */ + Int.SIZE_BYTES + descriptionBytes.size

    val buffer = ByteBuffer.allocate(capacity)

    buffer.putLong(data.id)
    buffer.putDouble(data.value)
    buffer.putInt(descriptionBytes.size)
    buffer.put(descriptionBytes)

    buffer.flip()

    return ByteArray(buffer.remaining()).apply {
        buffer.get(this)
    }
}

fun fromByteArray(bytes: ByteArray): MyData {

    val buffer = ByteBuffer.wrap(bytes)

    val id = buffer.getLong()
    val value = buffer.getDouble()
    val descriptionLength = buffer.getInt()
    val description = ByteArray(descriptionLength).run {
        buffer.get(this)
        toString(StandardCharsets.UTF_8)
    }

    return MyData(id, value, description)
}

fun main() {

    val dataIn = MyData(26, 3.14, "Hello Wörld!")
    val bytes = toByteArray(dataIn)
    val dataOut = fromByteArray(bytes)
    println("bytes: ${bytes.size}, matches: ${dataIn == dataOut}, out: ${dataOut}")
}
