package com.example.applicationcurriculumvitaev2

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface EducationDAO {
@Insert
fun insert(edu:EducationData)
@Delete
fun delete(edu:EducationData)
@Query(value = "SELECT * FROM educations")
fun getAllEducations():List<EducationData>
}