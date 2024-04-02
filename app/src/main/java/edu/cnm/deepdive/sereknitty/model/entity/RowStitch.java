package edu.cnm.deepdive.sereknitty.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

/**
 * This class represents the stitches that make up a {@link Row}
 */
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

  /**
   * Gets the id for a particular {@link RowStitch}.
   */
  public long getId() {
    return id;
  }

  /**
   * Sets the id for a particular {@link RowStitch}.
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Gets the id for a particular {@link Row}.
   */
  public long getRowId() {
    return rowId;
  }

  /**
   * Sets the id for a particular {@link Row}.
   */
  public void setRowId(long rowId) {
    this.rowId = rowId;
  }

  /**
   * Gets the ordinal position for a particular {@link RowStitch}.
   */
  public int getOrdinalPosition() {
    return ordinalPosition;
  }

  /**
   * Sets the ordinal position for a particular {@link RowStitch}.
   */
  public void setOrdinalPosition(int ordinalPosition) {
    this.ordinalPosition = ordinalPosition;
  }
}
