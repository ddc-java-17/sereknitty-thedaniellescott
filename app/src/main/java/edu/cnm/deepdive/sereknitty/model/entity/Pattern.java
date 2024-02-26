package edu.cnm.deepdive.sereknitty.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import java.util.Date;

@Entity(
    tableName = "pattern",
    foreignKeys = @ForeignKey(
        entity = User.class, parentColumns = "user_id", childColumns = "user_id",
        onDelete = ForeignKey.CASCADE
    )
)

public class Pattern {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "pattern_id")
  private long id;

  /* todo: add this bit to a project entity class.
  @ColumnInfo(name = "finished")
  private boolean finished;

  todo: Add date_finished to project, too.
 */

  /* todo: when I can figure out how implement allowances for knitting in the round
  @ColumnInfo(name = "in_the_round")
  private boolean inTheRound;

  @ColumnInfo(name = "is_flat")
  private boolean isFlat;
  */

// TODO: 2/26/2024 Add date_added

  @ColumnInfo(name = "user_id", index = true)
  private long userId;

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
}
