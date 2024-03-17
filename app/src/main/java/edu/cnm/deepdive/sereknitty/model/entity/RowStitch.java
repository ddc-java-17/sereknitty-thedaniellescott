package edu.cnm.deepdive.sereknitty.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity(
    tableName = "row_stitch",
    foreignKeys = @ForeignKey(entity = Row.class,
        parentColumns = "row_id",
        childColumns = "row_id")
)
public class RowStitch {

  @ColumnInfo(name = "stitch_name")
  private String name;

  @ColumnInfo(name = "row_id")
  private long id;

  @ColumnInfo(name = "ordinal_position")
  private int ordinalPosition;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public int getOrdinalPosition() {
    return ordinalPosition;
  }

  public void setOrdinalPosition(int ordinalPosition) {
    this.ordinalPosition = ordinalPosition;
  }
}
