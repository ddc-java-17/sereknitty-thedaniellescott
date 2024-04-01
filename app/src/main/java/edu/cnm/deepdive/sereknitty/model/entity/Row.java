package edu.cnm.deepdive.sereknitty.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

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

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Long getCurrentStitchId() {
    return currentStitchId;
  }

  public void setCurrentStitchId(Long currentStitchId) {
    this.currentStitchId = currentStitchId;
  }

  public long getPatternId() {
    return patternId;
  }

  public void setPatternId(long patternId) {
    this.patternId = patternId;
  }
}
