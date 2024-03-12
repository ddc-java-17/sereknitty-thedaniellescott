package edu.cnm.deepdive.sereknitty.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import java.util.LinkedList;
import java.util.List;

/**
 * PatternManager stores and retrieves information for the user.
 */

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

  @ColumnInfo(name = "user_id")
  private long userId;

  @ColumnInfo(name = "location_id")
  private long locationId;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public long getLocationId() {
    return locationId;
  }

  public void setLocationId(long locationId) {
    this.locationId = locationId;
  }
}
