package edu.cnm.deepdive.sereknitty.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import java.time.Instant;

@Entity(
    tableName = "pattern",
    indices = {
        @Index(value = "pattern_id"),
        @Index(value = "created"),
        @Index(value = "modified")
    })
public class Pattern {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "pattern_id")
  private Long id;

  @ColumnInfo(name = "pattern_name")
  private String patternName;

  @NonNull
  @ColumnInfo(name = "created")
  private Instant created;

  @NonNull
  @ColumnInfo(name = "modified")
  private Instant modified;

  @ColumnInfo(name = "knit_this_before")
  private boolean knitThisBefore;


  /* todo: add this bit to a project entity class.
  @ColumnInfo(name = "finished")
  private boolean finished;

  todo: Add date_finished to project, too.
 */

  /* todo: when I can figure out how, implement allowances for knitting in the round,
       and larger works requiring seaming.
  @ColumnInfo(name = "in_the_round")
  private boolean inTheRound;

  @ColumnInfo(name = "is_flat")
  private boolean isFlat;

  @ColumnInfo(name = "is_seamed")
  private boolean isSeamed;

  */

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getPatternName() {
    return patternName;
  }

  public void setPatternName(String patternName) {
    this.patternName = patternName;
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

  public boolean isKnitThisBefore() {
    return knitThisBefore;
  }

  public void setKnitThisBefore(boolean knitThisBefore) {
    this.knitThisBefore = knitThisBefore;
  }

}
