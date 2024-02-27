package edu.cnm.deepdive.sereknitty.model;

import java.util.ArrayList;
import java.util.List;

public class Pattern extends Project {

  private final String name;
  private final List<Row> rows;
// file type?

  public Pattern(String id, Pattern pattern, int currentRow, int currentPositionInRow, String name,
      List<Row> rows) {
    super(id, pattern, currentRow, currentPositionInRow);
    this.name = name;
    this.rows = rows;
  }

  // TODO: 2/12/2024  Figure out how to display a picture the user submits or takes.

}
