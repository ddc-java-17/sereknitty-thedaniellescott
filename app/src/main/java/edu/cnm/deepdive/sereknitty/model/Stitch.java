package edu.cnm.deepdive.sereknitty.model;

import edu.cnm.deepdive.sereknitty.R;

public enum Stitch {


// TODO: 3/24/2024 Apply my images for the knitting symbols to the correct stitch.

  KNIT("K"),
  PURL("P"),
  KNIT_2_TOGETHER("K2tog"),
  SLIP_SLIP_KNIT("SSK"),
  PURL_2_TOGETHER("P2tog"),
  SLIP_SLIP_PURL("SSP"),
  YARN_OVER("YO"),
  MAKE_1_RIGHT("M1R"),
  MAKE_1_LEFT("M1L"),
  KNIT_3_TOGETHER("K3tog"),
  PURL_3_TOGETHER("P3tog"),
  CENTER_DOUBLE_DECREASE("CDD");

  private final String shorthandAlphaNum;

  Stitch(String shorthandAlphaNum) {
    this.shorthandAlphaNum = shorthandAlphaNum;
  }

  public String shorthandAlphaNum() {
    return shorthandAlphaNum;
  }

}
