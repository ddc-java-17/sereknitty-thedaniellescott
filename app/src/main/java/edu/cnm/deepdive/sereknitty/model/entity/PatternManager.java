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
    tableName = "pattern_manager_id",
    indices = {
        @Index(value = "user_id", unique = true)
    }
)
public class PatternManager {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "pattern_manager_id")
  private long id;

  @ColumnInfo(name = "user_id", index = true)
  private long userId;




}
