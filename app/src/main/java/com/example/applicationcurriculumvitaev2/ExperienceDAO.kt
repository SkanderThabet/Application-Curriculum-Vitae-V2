package com.example.applicationcurriculumvitaev2

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ExperienceDAO {
    @Insert
    fun insert(exp: ExperienceData)

    @Delete
    fun delete(exp: ExperienceData)

    @Query(value = "SELECT * FROM experiences")
    fun getAllEducation(): List<ExperienceData>
}