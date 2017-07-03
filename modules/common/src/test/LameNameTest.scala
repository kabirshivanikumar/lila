package lila.common

import org.specs2.mutable.Specification

class LameNameTest extends Specification {

  "disallow" should {
    "separated titles" in {
      LameName("fm-foo") must beTrue
      LameName("fm_foo") must beTrue
      LameName("wgm-foo") must beTrue
      LameName("wcm_foo") must beTrue
      LameName("gmFoobar") must beTrue
      LameName("gm007") must beTrue
      LameName("GmFoo") must beTrue
    }
    "uppercase titles" in {
      LameName("GMfoo") must beTrue
      LameName("IMfoo") must beTrue
      LameName("WFMfoo") must beTrue
      LameName("WIMfoo") must beTrue
      LameName("1Mfoo") must beTrue
    }
    "gross" in {
      LameName("Shiz") must beTrue
      LameName("Sh1z") must beTrue
      LameName("douchebag") must beTrue
      LameName("d0uchebag") must beTrue
      LameName("urcunt-blah") must beTrue
      LameName("urcuntblah") must beTrue
    }
  }
  "allow" should {
    "good stuff" in {
      LameName("joey") must beFalse
      LameName("gmfoo") must beFalse
      LameName("g-foo") must beFalse
      LameName("g_foo") must beFalse
      LameName("g-foo") must beFalse
      LameName("agm-foo") must beFalse
      LameName("atf90") must beFalse
      LameName("a_b") must beFalse
    }
  }
}
