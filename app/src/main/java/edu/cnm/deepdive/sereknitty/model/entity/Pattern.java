package edu.cnm.deepdive.sereknitty.model.entity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
        @Index(value = "pattern_id", unique = true),
        @Index(value = "created"),
        @Index(value = "modified"),
        @Index(value = "pattern_name")
    },
    foreignKeys = {@ForeignKey(entity = User.class,
        parentColumns = "user_id",
        childColumns = "user_id",
        onDelete = ForeignKey.CASCADE),
        @ForeignKey(entity = Row.class,
            parentColumns = "row_id",
            childColumns = "current_row_id",
            onDelete = ForeignKey.CASCADE)}
)
public class Pattern {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "pattern_id")
  private long id;

  @ColumnInfo(name = "external_key")
  private UUID key;

  @NonNull
  @ColumnInfo(name = "created")
  private Instant created = Instant.now();

  @NonNull
  @ColumnInfo(name = "modified")
  private Instant modified = Instant.now();

  @ColumnInfo(name = "pattern_name")
  private String patternName;

  @ColumnInfo(name = "pattern_description")
  private String patternDescription;

  @ColumnInfo(name = "image")
  private String image;

  @ColumnInfo(name = "user_id", index = true)
  private Long userId;

  @ColumnInfo(name = "current_row_id", index = true)
  private Long currentRowId;


  public long getId() {
    return id;
  }

  public void setId(long id) {
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

  public void setPatternName(String patternName) {
    this.patternName = patternName;
  }

  public String getPatternDescription() {
    return patternDescription;
  }

  public void setPatternDescription(String patternDescription) {
    this.patternDescription = patternDescription;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Long getCurrentRowId() {
    return currentRowId;
  }

  public void setCurrentRowId(Long currentRowId) {
    this.currentRowId = currentRowId;
  }


  private void generateKey() {
    key = UUID.randomUUID();
  }

}
