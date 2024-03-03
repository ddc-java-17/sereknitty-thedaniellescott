package edu.cnm.deepdive.sereknitty.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(
    tableName = "pattern_manager",
    indices =  ,
    foreignKeys = @ForeignKey(
        entity = User.class,
        childColumns = "user_id",
        parentColumns = "user_id",
        onDelete = ForeignKey.CASCADE
        ),
    @ForeignKey(
        entity = Pattern.class,
        childColumns = "pattern_id",
        parentColumns =
    )

)
public class PatternManager {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "pattern_manager_id")
  private long id;





}
