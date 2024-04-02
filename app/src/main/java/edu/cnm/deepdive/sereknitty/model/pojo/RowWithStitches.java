package edu.cnm.deepdive.sereknitty.model.pojo;

import androidx.room.ColumnInfo;
import androidx.room.Relation;
import edu.cnm.deepdive.sereknitty.model.entity.Pattern;
import edu.cnm.deepdive.sereknitty.model.entity.Row;
import edu.cnm.deepdive.sereknitty.model.entity.RowStitch;
import java.util.List;

/**
 * This POJO is a class that allows for a multi-table join allowing me to recall the
 * {@code stitches} associated with a particular {@link Row} instance. It is not entity, but it
 * allows for more complicated queries without complicated SQL code.
 */
public class RowWithStitches {

  @ColumnInfo(name = "row_id")
  private long id;

  @ColumnInfo(name = "current_stitch_id", index = true)
  private long currentStitchId;

  @ColumnInfo(name = "pattern_id", index = true)
  private long patternId;

  @Relation(entityColumn = "row_id", parentColumn = "row_id")
  private List<RowStitch> stitches;

  /**
   * Gets the id for a particular {@link Row}.
   */
  public long getId() {
    return id;
  }

  /**
   * Sets the id for a particular {@link Row}.
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Gets the currentStitchId for a particular {@link Row}
   */
  public long getCurrentStitchId() {
    return currentStitchId;
  }

  /**
   * Gets the currentStitchId for a particular {@link Row}.
   */
  public void setCurrentStitchId(long currentStitchId) {
    this.currentStitchId = currentStitchId;
  }

  /**
   * Gets the id for a particular {@link Pattern}.
   */
  public long getPatternId() {
    return patternId;
  }

  /**
   * Sets the id for a particular {@link Pattern}.
   */
  public void setPatternId(long patternId) {
    this.patternId = patternId;
  }

  /**
   * This getter gets the {@link List} of stitches associated with a particular {@link Row}.
   */
  public List<RowStitch> getStitches() {
    return stitches;
  }

  /**
   * This setter sets the {@link List} of stitches associates with a particular {@link Row}.
   */
  public void setStitches(List<RowStitch> stitches) {
    this.stitches = stitches;
  }
}
