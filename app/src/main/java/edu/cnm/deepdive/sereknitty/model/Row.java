package edu.cnm.deepdive.sereknitty.model;

import java.util.LinkedList;
import java.util.List;

public class Row {

  private final List<Stitch> stitch;

  public Row() {
    stitch = new List<>();
    // Row = List <Stitches>, but in a way that the compiler understands.
  }

  public addStitch(Stitch stitch) {
    this.stitch.add(stitch);
  }

  public List<Stitch> getStitch() {
    return stitch;
  }

}
