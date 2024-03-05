package edu.cnm.deepdive.sereknitty.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import java.util.LinkedList;
import java.util.List;

@Entity(
    tableName = "pattern_manager",
    indices = {
        @Index(value = "user_id", unique = true)
    },
    foreignKeys = @ForeignKey(entity = User.class,
        childColumns = "user_id",
        parentColumns = "user_id",
        onDelete = ForeignKey.CASCADE))
public class PatternManager {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "pattern_manager_id")
  private long id;

  @ColumnInfo(name = "user_id", index = true)
  private long userId;


  @ColumnInfo(name = "location_id")
  private long locationId;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }
}
