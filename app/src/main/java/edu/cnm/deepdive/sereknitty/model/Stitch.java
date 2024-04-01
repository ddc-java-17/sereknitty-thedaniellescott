package edu.cnm.deepdive.sereknitty.model;

import edu.cnm.deepdive.sereknitty.R;

/**
 * This is an {@link Enum} that holds a list of stitches. In knitting, a stitch
 * is the basic building block. A {@link edu.cnm.deepdive.sereknitty.model.entity.Row} is made up of many stitches, and this {@link Enum}
 * represents all the stitches my app uses at the moment. Think of this class like a stitch
 * dictionary.
 */
public enum Stitch {

  KNIT("K", 0),
  PURL("P", R.drawable.purl),
  KNIT_2_TOGETHER("K2tog", R.drawable.knit_2_together),
  SLIP_SLIP_KNIT("SSK", R.drawable.slip_slip_knit),
  PURL_2_TOGETHER("P2tog", R.drawable.purl_2_together),
  SLIP_SLIP_PURL("SSP", R.drawable.slip_slip_purl),
  YARN_OVER("YO", R.drawable.yarn_over),
  MAKE_1_RIGHT("M1R", R.drawable.make_1_right),
  MAKE_1_LEFT("M1L", R.drawable.make_1_left),
  KNIT_3_TOGETHER("K3tog", R.drawable.knit_3_together),
  PURL_3_TOGETHER("P3tog", R.drawable.purl_3_together),
  CENTER_DOUBLE_DECREASE("CDD", R.drawable.center_double_decrease);

  private final String shorthandAlphaNum;
  private final int image;

  /**
   * This constructor initializes all the fields and their assets.
   *
   * @param shorthandAlphaNum {@link String} shorthand for the stitch.
   * @param drawableId {@link int} representing the image for the symbolic shorthand for the stitch.
   */
  Stitch(String shorthandAlphaNum, int drawableId) {
    this.shorthandAlphaNum = shorthandAlphaNum;
    this.image = drawableId;
  }

  /**
   * This getter returns the alphanumeric shorthand for the stitches.
   *
   * @return shorthandAlphaNum
   */
  public String shorthandAlphaNum() {
    return shorthandAlphaNum;
  }

  /**
   * This getter returns the drawable image that will show the symbolic shorthand for the stitches.
   *
   * @return image
   */
  public int getImage() {
    return image;
  }
}
