package edu.cnm.deepdive.sereknitty.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import java.time.Instant;

@Entity(
    tableName = "stitch_location",
    indices = {
        @Index(value = "stitch_location_id"),
        @Index(value = "created"),
        @Index(value = "modified")
    },
    foreignKeys = @ForeignKey(
        entity = PatternManager.class,
        parentColumns = "pattern_manager_id",
        childColumns = "pattern_manager_id",
        onDelete = ForeignKey.CASCADE
    )
)
public class StitchLocation {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "stitch_location_id")
  private long id;

  @NonNull
  @ColumnInfo(name = "created")
  private Instant created;

  @NonNull
  @ColumnInfo(name = "modified")
  private Instant modified;

/*  @NonNull
  @ColumnInfo(name = "location")
  private long[] location;

 */

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @NonNull
  public Instant getCreated() {
    return created;
  }

  public void setCreated(@NonNull Instant created) {
    this.created = created;
  }

  @NonNull
  public Instant getModified() {
    return modified;
  }

  public void setModified(@NonNull Instant modified) {
    this.modified = modified;
  }

  /*
  @NonNull
  public long[] getContent() {
    return location;
  }

  public void setContent(@NonNull long[] location) {
    this.location = location;
  }

   */
}
