package edu.cnm.deepdive.sereknitty.model;

import java.util.LinkedList;
import java.util.List;

public class Row {

  private final List<Stitch> stitch;

  Row(List<Stitch> stitch) {
    this.stitch = stitch;
  }

    /*

    // Row = List <Stitches>, but in a way that the compiler understands.
    //Maybe Stream.toArray of user input? (plus a few other steps obviously!)
  }

  public addStitch(Stitch stitch) {
    this.stitch.add(stitch);
  }

  public List<Stitch> getStitch() {
    return stitch;
  }
*/

}
