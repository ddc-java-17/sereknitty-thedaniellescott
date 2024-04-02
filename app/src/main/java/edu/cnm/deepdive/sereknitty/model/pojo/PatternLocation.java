package edu.cnm.deepdive.sereknitty.model.pojo;

import androidx.room.ColumnInfo;
import androidx.room.Relation;
import edu.cnm.deepdive.sereknitty.model.entity.Pattern;
import edu.cnm.deepdive.sereknitty.model.entity.Row;
import edu.cnm.deepdive.sereknitty.model.entity.RowStitch;

/**
 * This POJO is a class that allows for a multi-table join allowing me to recall the {@code row} and
 * {@code stitch} associated with a particular {@link Pattern} instance. It is not entity, but it
 * allows for more complicated queries without complicated SQL code.
 */
public class PatternLocation extends Pattern {

  @ColumnInfo(name = "current_stitch_id")
  private long currentStitchId;

  @Relation(parentColumn = "current_row_id", entityColumn = "row_id")
  private Row currentRow;

  @Relation(parentColumn = "current_stitch_id", entityColumn = "row_stitch_id")
  private RowStitch currentStitch;

  /**
   * This getter gets the {@code currentStitchId} associated with a particular {@link Pattern}.
   */
  public long getCurrentStitchId() {
    return currentStitchId;
  }

  /**
   * This setter sets the {@code currentStitchId} associated with a particular {@link Pattern}.
   */
  public void setCurrentStitchId(long currentStitchId) {
    this.currentStitchId = currentStitchId;
  }

  /**
   * This getter gets the {@code currentRow} associated with a particular {@link Pattern}.
   */
  public Row getCurrentRow() {
    return currentRow;
  }

  /**
   * This setter sets the {@code currentRow} associated with a particular {@link Pattern}.
   */
  public void setCurrentRow(Row currentRow) {
    this.currentRow = currentRow;
  }

  /**
   * This getter gets the {@code currentStitch} associated with a particular {@link Pattern}.
   */
  public RowStitch getCurrentStitch() {
    return currentStitch;
  }

  /**
   * This setter sets the {@code currentStitch} associated with a particular {@link Pattern}.
   */
  public void setCurrentStitch(RowStitch currentStitch) {
    this.currentStitch = currentStitch;
  }
}
