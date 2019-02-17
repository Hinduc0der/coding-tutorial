import io.kotlintest.shouldBe
import io.kotlintest.shouldEqual
import io.kotlintest.shouldNotBe
import io.kotlintest.specs.FeatureSpec


class BasicFunctionalTests : FeatureSpec( {
    feature("performance per N hours") {
        val n_hours = 2.0
        scenario("Developer and Tester performance") {
            val devel = Developer(n_hours)
            val qa = Tester(n_hours)
            devel.bugCount() shouldBe 12.0
            qa.bugKill() shouldBe 6.0
            devel.bugCount() shouldBe 6 * n_hours
            qa.bugKill() shouldBe 3 * n_hours
        }
        scenario("Tester hook all bugs") {
            val devel = Developer(1.0)
            val qa = Tester(n_hours)
            devel.bugCount() shouldBe qa.bugKill()
            qa.bugKill() shouldBe devel.bugCount()
        }
        scenario("Tester hook 1/2") {
            val devel = Developer(1.0)
            val qa = Tester(1.0)
            devel.bugCount() shouldBe 2 * qa.bugKill()
            qa.bugKill() shouldBe devel.bugCount() / 2
        }
        scenario("Two Tester vs One Developer") {
            val devel = Developer(8.0)
            val qa1 = Tester(8.0)
            val qa2 = Tester(8.0)
            devel.bugCount() shouldBe qa2.bugKill() + qa1.bugKill()
            devel.bugCount() shouldBe qa1.bugKill() + qa1.bugKill()
            devel.bugCount() shouldBe qa2.bugKill() + qa2.bugKill()
        }
        scenario("work < 0") {
            val devel = Developer(-8.0)
            val qa1 = Tester(-97.0)
            val qa2 = Tester(-3.0)
            devel.bugCount() shouldBe qa2.bugKill() + qa1.bugKill()
            devel.bugCount() shouldBe qa1.bugKill() + qa1.bugKill()
            devel.bugCount() shouldBe qa2.bugKill() + qa2.bugKill()
        }
    }
})