package edu.cnm.deepdive.sereknitty.model;

import java.util.LinkedList;
import java.util.List;

/**
 * This class represents a row in knitting. In knitting, a row is made up of stitches, and a
 * knitted work is made up of many rows. In this program, a {@link Row} is made up of any given
 * number of {@code stitch} from the {@link Stitch} {@link Enum}.
 */
public class Row {

  private final List<Stitch> stitch;

  /**
   *
   * @param stitch
   */
  Row(List<Stitch> stitch) {
    this.stitch = stitch;
  }

}
