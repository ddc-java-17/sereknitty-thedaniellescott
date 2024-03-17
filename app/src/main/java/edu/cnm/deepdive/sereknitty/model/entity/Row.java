package edu.cnm.deepdive.sereknitty.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
    tableName = "row",
    indices = {
    @Index(value = "row_id"),
    @Index(value = "current_row_id", unique = true),
    @Index(value = "current_stitch_id", unique = true)},
    foreignKeys = @ForeignKey(entity = Pattern.class,
        parentColumns = "pattern_id",
        childColumns = "pattern_id",
        onDelete = ForeignKey.CASCADE)
)
public class Row {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "row_id")
  private long id;

  @ColumnInfo(name = "current_row_id")
  private long currentRow;

  @ColumnInfo(name = "current_stitch_id")
  private long currentStitch;

  @ColumnInfo(name = "pattern_id", index = true)
  private long patternId;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getCurrentRow() {
    return currentRow;
  }

  public void setCurrentRow(long currentRow) {
    this.currentRow = currentRow;
  }

  public long getCurrentStitch() {
    return currentStitch;
  }

  public void setCurrentStitch(long currentStitch) {
    this.currentStitch = currentStitch;
  }

  public long getPatternId() {
    return patternId;
  }

  public void setPatternId(long patternId) {
    this.patternId = patternId;
  }
}
