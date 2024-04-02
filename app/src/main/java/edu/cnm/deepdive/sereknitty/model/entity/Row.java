package edu.cnm.deepdive.sereknitty.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

/**
 * This entity represents a row in a {@link Pattern}.
 */
@Entity(
    tableName = "row",
    indices = {
        @Index(value = "row_id")},
    foreignKeys = {@ForeignKey(entity = Pattern.class,
        parentColumns = "pattern_id",
        childColumns = "pattern_id",
        onDelete = ForeignKey.CASCADE),
        @ForeignKey(entity = RowStitch.class,
            parentColumns = "row_stitch_id",
            childColumns = "current_stitch_id",
            onDelete = ForeignKey.CASCADE)}
)
public class Row {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "row_id")
  private long id;

  @ColumnInfo(name = "current_stitch_id", index = true)
  private Long currentStitchId;

  @ColumnInfo(name = "pattern_id", index = true)
  private long patternId;

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
  public Long getCurrentStitchId() {
    return currentStitchId;
  }

  /**
   * Gets the currentStitchId for a particular {@link Row}.
   */
  public void setCurrentStitchId(Long currentStitchId) {
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
}
