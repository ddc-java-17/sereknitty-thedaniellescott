package edu.cnm.deepdive.sereknitty.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(
    tableName = "row_stitch",
    foreignKeys = @ForeignKey(entity = Row.class,
        parentColumns = "row_id",
        childColumns = "row_id")
)
public class RowStitch {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "row_stitch_id")
  private long id;

  @ColumnInfo(name = "row_id", index = true)
  private long rowId;

  @ColumnInfo(name = "ordinal_position", index = true)
  private int ordinalPosition;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getRowId() {
    return rowId;
  }

  public void setRowId(long rowId) {
    this.rowId = rowId;
  }

  public int getOrdinalPosition() {
    return ordinalPosition;
  }

  public void setOrdinalPosition(int ordinalPosition) {
    this.ordinalPosition = ordinalPosition;
  }
}
