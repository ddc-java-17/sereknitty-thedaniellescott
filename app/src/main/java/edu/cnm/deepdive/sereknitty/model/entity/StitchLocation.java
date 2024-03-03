package edu.cnm.deepdive.sereknitty.model.entity;

import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity(
    tableName = "stitch_location",
    foreignKeys = {@ForeignKey(
        entity = PatternManager.class,
        childColumns =,
        parentColumns =,
        onDelete = ForeignKey.CASCADE
    ),
        @ForeignKey(
            entity = Pattern.class,
            childColumns = ,
            parentColumns = ,
            onDelete = ForeignKey.CASCADE
        )}
)
public class StitchLocation {

}
