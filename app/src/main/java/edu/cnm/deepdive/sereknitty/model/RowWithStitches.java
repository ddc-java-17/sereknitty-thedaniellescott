package edu.cnm.deepdive.sereknitty.model;

import androidx.room.Relation;
import edu.cnm.deepdive.sereknitty.model.entity.Row;
import edu.cnm.deepdive.sereknitty.model.entity.RowStitch;
import java.util.List;

public class RowWithStitches extends Row {

  @Relation(entityColumn = "row_id", parentColumn = "row_id")
  private List<RowStitch> stitches;

  public List<RowStitch> getStitches() {
    return stitches;
  }

  public void setStitches(List<RowStitch> stitches) {
    this.stitches = stitches;
  }
}
