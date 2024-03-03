package edu.cnm.deepdive.sereknitty.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import java.time.Instant;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity(
    tableName = "pattern",
    foreignKeys = @ForeignKey(
        entity = User.class, parentColumns = "user_id", childColumns = "user_id",
        onDelete = ForeignKey.CASCADE
    )
)
public class Pattern {

  private static final int ROW_MAX = 100;
  private static final int STITCH_MAX = 100;

  @NonNull
  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "pattern_id")
  private Long id;

  @NonNull
  @Column(nullable = false, updatable = false)
  @CreationTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  @JsonProperty(access = Access.READ_ONLY)
  private Instant created;

  @NonNull
  @Column(nullable = false)
  @UpdateTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  @ColumnInfo(name = "modified", index = true)
  @JsonProperty(access = Access.READ_ONLY)
  private Instant modified;

  @NonNull
  @Column(nullable = false, updateable = false)
  @Min(1)
  @Max(ROW_MAX)
  private int rowLength;

  @NonNull
  @Column(nullable = false, updateable = false)
  @Min(1)
  @Max(STITCH_MAX)
  private int stitchLength;




  /* todo: add this bit to a project entity class.
  @ColumnInfo(name = "finished")
  private boolean finished;

  todo: Add date_finished to project, too.
 */

  /* todo: when I can figure out how, implement allowances for knitting in the round
  @ColumnInfo(name = "in_the_round")
  private boolean inTheRound;

  @ColumnInfo(name = "is_flat")
  private boolean isFlat;
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

  public int getRowLength() {
    return rowLength;
  }

  public void setRowLength(int rowLength) {
    this.rowLength = rowLength;
  }

  public int getStitchLength() {
    return stitchLength;
  }

  public void setStitchLength(int stitchLength) {
    this.stitchLength = stitchLength;
  }

}
