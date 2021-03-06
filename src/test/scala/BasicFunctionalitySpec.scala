import org.junit.runner.RunWith
import org.specs2.mutable.Specification
import org.joda.time.DateTime

import com.github.nscala_time.time.Imports._
import org.specs2.runner.JUnitRunner

@RunWith(classOf[JUnitRunner])
object BasicFunctionalitySpec extends Specification {

  // [Note] Importing Implicits._ is required at com.github.nscala_time.time package

  "DateTime.now" should {
    val now: DateTime = DateTime.now
    "== DateTime.now" in {
      now must ===(now)
    }
    "< DateTime.now + 1.hours" in {
      (now plusHours 1) isAfter now must ===(true)
    }
  }

  "DateTime" should {
    "have setters" in {
      val actual = DateTime.parse("2012-01-01T01:01:01.123+0900")
        .year.apply(2013) // TODO cannot call #year(2013)
        .month(3)
        .day(2)
        .hour(7)
        .minute(8)
        .second(9)
      val expected = DateTime.parse("2013-03-02T07:08:09.123+0900")
      actual must ===(expected)
    }
  }

}
