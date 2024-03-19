package edu.cnm.deepdive.sereknitty.model.pojo;

import androidx.room.ColumnInfo;
import androidx.room.Relation;
import edu.cnm.deepdive.sereknitty.model.entity.Pattern;
import edu.cnm.deepdive.sereknitty.model.entity.Row;
import edu.cnm.deepdive.sereknitty.model.entity.RowStitch;

public class PatternLocation extends Pattern {

  @ColumnInfo(name = "current_stitch_id")
  private long currentStitchId;

  @Relation(parentColumn = "current_row_id", entityColumn = "row_id")
  private Row currentRow;

  @Relation(parentColumn = "current_stitch_id", entityColumn = "row_stitch_id")
  private RowStitch currentStitch;

  public long getCurrentStitchId() {
    return currentStitchId;
  }

  public void setCurrentStitchId(long currentStitchId) {
    this.currentStitchId = currentStitchId;
  }

  public Row getCurrentRow() {
    return currentRow;
  }

  public void setCurrentRow(Row currentRow) {
    this.currentRow = currentRow;
  }

  public RowStitch getCurrentStitch() {
    return currentStitch;
  }

  public void setCurrentStitch(RowStitch currentStitch) {
    this.currentStitch = currentStitch;
  }
}
