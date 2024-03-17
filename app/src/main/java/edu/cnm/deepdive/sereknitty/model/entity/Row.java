package edu.cnm.deepdive.sereknitty.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
    tableName = "row",
    indices =
    @Index(value = "row_id"),
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

}
