package edu.cnm.deepdive.sereknitty.model;

import androidx.room.Relation;
import edu.cnm.deepdive.sereknitty.model.entity.Pattern;
import java.util.List;

public class PatternWithRows extends Pattern {

  @Relation(entityColumn = "pattern_id", parentColumn = "pattern_id")
  private List<RowWithStitches> rows;

  public List<RowWithStitches> getRows() {
    return rows;
  }

  public void setRows(List<RowWithStitches> rows) {
    this.rows = rows;
  }
}
