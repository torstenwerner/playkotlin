package hello

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class HelloTest {
    @Test
    fun `a very trivial sample test`() {
        assertThat(1 + 1).isEqualTo(2)
    }
}
