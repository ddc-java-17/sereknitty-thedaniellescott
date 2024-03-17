package edu.cnm.deepdive.sereknitty.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import java.time.Instant;
import java.util.UUID;

@Entity(
    tableName = "pattern",
    indices = {
        @Index(value = "pattern_id"),
        @Index(value = "created"),
        @Index(value = "modified")
    },
    foreignKeys = {@ForeignKey(entity = User.class,
        parentColumns = "user_id",
        childColumns = "user_id",
        onDelete = ForeignKey.CASCADE),
        @ForeignKey(entity = Row.class,
            parentColumns = "current_row_id",
            childColumns = "current_row_id",
            onDelete = ForeignKey.CASCADE),
        @ForeignKey(entity = Row.class,
            parentColumns = "current_stitch_id",
            childColumns = "current_stitch_id",
            onDelete = ForeignKey.CASCADE)}
)
public class Pattern {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "pattern_id")
  private Long id;

  @ColumnInfo(name = "external_key")
  private UUID key;

  @NonNull
  @ColumnInfo(name = "created")
  private Instant created;

  @NonNull
  @ColumnInfo(name = "modified")
  private Instant modified;

  @ColumnInfo(name = "pattern_name")
  private String patternName;

  @ColumnInfo(name = "user_id", index = true)
  private long userId;



  public long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public UUID getKey() {
    return key;
  }

  public void setKey(UUID key) {
    this.key = key;
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

  public String getPatternName() {
    return patternName;
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public void setPatternName(String patternName) {
    this.patternName = patternName;
  }

}
