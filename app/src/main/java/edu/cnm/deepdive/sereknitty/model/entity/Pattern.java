package edu.cnm.deepdive.sereknitty.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import java.time.Instant;
import java.util.UUID;

/**
 * This entity class represents a knitting pattern and holds its data structures.
 */
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

  /**
   * This getter gets the {@code id} for a pattern.
   */
  public long getId() {
    return id;
  }

  /**
   * This setter sets the {@code id} for a pattern.
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * This getter gets the {@link UUID} key for a pattern.
   */
  public UUID getKey() {
    return key;
  }

  /**
   * This setter sets the {@link UUID} key for a pattern.
   */
  public void setKey(UUID key) {
    this.key = key;
  }

  /**
   * This getter gets the timestamp for the {@link Instant} the pattern was created.
   */
  @NonNull
  public Instant getCreated() {
    return created;
  }

  /**
   * This setter sets the timestamp for the {@link Instant} the pattern was created.
   */
  public void setCreated(@NonNull Instant created) {
    this.created = created;
  }

  /**
   * This getter gets the timestamp for the {@link Instant} the pattern was modified.
   */
  @NonNull
  public Instant getModified() {
    return modified;
  }

  /**
   * This setter sets the timestamp for the {@link Instant} the pattern was modified.
   */
  public void setModified(@NonNull Instant modified) {
    this.modified = modified;
  }

  /**
   * This getter gets the name of a pattern.
   */
  public String getPatternName() {
    return patternName;
  }

  /**
   * This setter gets the {@link String} name of a pattern.
   */
  public void setPatternName(String patternName) {
    this.patternName = patternName;
  }

  /**
   * This getter gets the description associated with a pattern.
   */
  public String getPatternDescription() {
    return patternDescription;
  }

  /**
   * This setter sets the description associated with a pattern.
   */
  public void setPatternDescription(String patternDescription) {
    this.patternDescription = patternDescription;
  }

  /**
   * This getter gets the image associated with a pattern.
   */
  public String getImage() {
    return image;
  }

  /**
   * This setter sets the image associated with a pattern.
   */
  public void setImage(String image) {
    this.image = image;
  }

  /**
   * This getter gets the {@code userId} that created the pattern.
   */
  public Long getUserId() {
    return userId;
  }

  /**
   * This setter sets the {@code userId} that created the pattern.
   */
  public void setUserId(Long userId) {
    this.userId = userId;
  }

  /**
   * This getter gets the current row id that makes up part of the current stitch location for this
   * pattern.
   */
  public Long getCurrentRowId() {
    return currentRowId;
  }

  /**
   * This setter sets the current row id that makes up part of the current stitch location for this
   * pattern.
   */
  public void setCurrentRowId(Long currentRowId) {
    this.currentRowId = currentRowId;
  }

  /**
   * This method generates a {@link UUID} {@code key} for any pattern instance.
   */
  private void generateKey() {
    key = UUID.randomUUID();
  }

}
